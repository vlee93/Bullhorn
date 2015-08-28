import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import customTools.DBUser;
import customTools.DBUtil;
import model.Bullhorn;
import model.Bulluser;
import customTools.DBBullhorn;

import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/News")
public class News extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public News() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		HttpSession session = request.getSession();
		try{
			List<Bullhorn> posts = DBBullhorn.postBullhorn();
			message += "<div class=\"container\">";
			message += "<table class=\"table table-bordered\"><thead><tr><th>Username</th><th>Post</th><th>Date</th></tr></thead><tbody>";
			for (Bullhorn bpost : posts)
			{
				long userid = bpost.getUserid();
				Bulluser user = DBUser.getUser(userid);
				message += "<tr>";
				message += "<td>" + user.getUsername() + "</td>";
				message += "<td>" + bpost.getPost() + "</td>";
				message += "<td>" + bpost.getPdate() + "</td>";
				message += "</tr>";
			}
			message += "</tbody></table>";
			message += "</div>";
			
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/NewsFeed.jsp").forward(request, response);
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

}
