import model.Bulluser;
import customTools.DBUtil;
import customTools.DBUser;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customTools.DBUtil;


@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UserLogin() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String username = request.getParameter("username");
		String userpass = request.getParameter("password");
		Bulluser u = new Bulluser();
		u.setUsername(username);
		u.setUserpass(userpass);
		long userid = DBUser.isValidUser(u);
		HttpSession session = request.getSession();
		
		try{
			if ((userid) > 0)
			{
				getServletContext().getRequestDispatcher("/Home.jsp").forward(request, response);
				session.setAttribute("userid", userid);
			}
			//not valid
			else
			{
				//
				getServletContext().getRequestDispatcher("/Createaccount.jsp").forward(request, response);
			}
			
			
		} catch (Exception e)
		{
			System.out.println(e);
		} finally{
			em.close();
		}
	}

}
