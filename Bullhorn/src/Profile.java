
import java.util.List;

import javax.persistence.EntityManager;

import customTools.DBUser;
import customTools.DBUtil;
import model.Bullhorn;
import model.Bulluser;
import customTools.DBBullhorn;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Profile() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		String message2 = "";
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		HttpSession session = request.getSession();
		String test = session.getAttribute("userid").toString();
		System.out.println("Test is " + test);
		long ID = (long) session.getAttribute("userid");
		Bulluser user = DBUser.getUser(ID);
		message += "<h3> User ID: " + user.getUserid() + "</h3>";
		message += "<h3> Username: " + user.getUsername() + "</h3>";
		message += "<h3> Motto: " + user.getMotto() + "</h3>";
		message += "<h3> Join Date: " + user.getJoindate() + "</h3>";
		
		try{
			List<Bullhorn> userposts = DBBullhorn.postsofUser(ID);
			message2 += "<div class=\"container\">";
			message2 += "<table class=\"table table-bordered\"><thead><tr><th>Post</th><th>Date</th></tr></thead><tbody>";
			for (Bullhorn userp : userposts)
			{
				message2 += "<tr>";
				message2 += "<td>" + userp.getPost() + "</td>";
				message2 += "<td>" + userp.getPdate() + "</td>";
				message2 += "</tr>";
			}
			message2 += "</tbody></table>";
			message2 += "</div>";
		}catch (Exception e){
			e.printStackTrace();
		} finally {
			em.close();
		}
		
		request.setAttribute("message", message);
		request.setAttribute("message2", message2);
		getServletContext().getRequestDispatcher("/UserProfile.jsp").forward(request, response);
	}

}
