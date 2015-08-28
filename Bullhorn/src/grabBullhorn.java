import java.util.Date;

import javax.persistence.EntityManager;

import customTools.DBUtil;
import model.Bullhorn;
import customTools.DBBullhorn;


public class grabBullhorn {
// This was a test to make sure connection ran
	public static void main(String[] args) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Date date = new Date();
		try {
			Bullhorn post2 = new Bullhorn();
			post2.setPost("Hello World!");
			post2.setPostsid(1);
			post2.setPdate(date);
			DBBullhorn.insert(post2);
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
			System.out.println("Goodbye!");
		}

	}

}
