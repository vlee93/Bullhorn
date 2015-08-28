import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import customTools.DBUtil;
import model.Bullhorn;
import customTools.DBBullhorn;

import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PostServ")
public class PostServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PostServ() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Date date = new Date();
		String post = request.getParameter("post");
		String message = "";
		HttpSession session = request.getSession();
		long userid = (long) session.getAttribute("userid");
		
		try{
			Bullhorn submit = new Bullhorn();
			submit.setPdate(date);
			submit.setPost(post);
			submit.setUserid(userid);
			DBBullhorn.insert(submit);
		} catch (Exception e){
			e.printStackTrace();;
		} finally {
			em.close();
		}
		getServletContext().getRequestDispatcher("/News").forward(request, response);

		
	}

}
