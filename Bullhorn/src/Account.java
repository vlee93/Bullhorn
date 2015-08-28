import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.persistence.EntityManager;

import customTools.DBUtil;
import model.Bulluser;
import customTools.DBUser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Account")
public class Account extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Account() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Date date = new Date();
		String Username = request.getParameter("username");
		String Password = request.getParameter("userpass");
		String Motto = request.getParameter("motto");
		
		try{
			Bulluser user = new Bulluser();
			user.setJoindate(date);
			user.setMotto(Motto);
			user.setUserpass(Password);
			user.setUsername(Username);
			DBUser.insert(user);
			getServletContext().getRequestDispatcher("/Home.jsp").forward(request, response);
		}catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
		}
	}

}
