package customTools;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Bullhorn;

public class DBBullhorn {

	public static void insert(Bullhorn bullhorn) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(bullhorn);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void update(Bullhorn bullhorn) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(bullhorn);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void delete(Bullhorn bullhorn) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.remove(em.merge(bullhorn));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static List<Bullhorn> postBullhorn (){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "select b from Bullhorn b";
		
		List<Bullhorn> posts = null;
		try{
			Query query = em.createQuery(qString);
			posts = query.getResultList();

		}catch (Exception e){
			e.printStackTrace();
		}
		finally{
				em.close();
			}
		return posts;
	}
	
	public static List<Bullhorn> postsofUser(long userid)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Bullhorn> userposts = null;
		String qString = "select b from Bullhorn b where b.userid = :userid";
		
		try{
			Query query = em.createQuery(qString);
			query.setParameter("userid", userid);
			userposts = query.getResultList();
		}catch (Exception e){
			e.printStackTrace();
		}
		finally{
				em.close();
			}
		return userposts;
		
	}
	
	public static List<Bullhorn> searchPosts (String search)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Bullhorn> searchposts = null;
		String qString = "select b from Bullhorn b where b.post like :search";
		
		try{
			Query query = em.createQuery(qString);
			query.setParameter("search", "%" + search + "%");
			searchposts = query.getResultList();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			em.close();
		}return searchposts;
	}
	
}
