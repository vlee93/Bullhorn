import java.util.Date;
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


@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Search() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message2 = "";
		String search = request.getParameter("search");
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try{
			List<Bullhorn> searchposts = DBBullhorn.searchPosts(search);
			message2 += "<div class=\"container\">";
			message2 += "<table class=\"table table-bordered\"><thead><tr><th>Username</th><th>Post</th><th>Date</th></tr></thead><tbody>";
			for (Bullhorn spost : searchposts)
			{
				long userid = spost.getUserid();
				Bulluser user = DBUser.getUser(userid);
				message2 += "<tr>";
				message2 += "<td>" + user.getUsername() + "</td>";
				message2 += "<td>" + spost.getPost() + "</td>";
				message2 += "<td>" + spost.getPdate() + "</td>";
				message2 += "</tr>";
			}
			message2 += "</tbody></table>";
			message2 += "</div>";
			
			request.setAttribute("message2", message2);
			getServletContext().getRequestDispatcher("/NewsFeed.jsp").forward(request, response);
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

}
