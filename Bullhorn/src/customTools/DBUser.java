package customTools;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Bulluser;

public class DBUser {

	public static Bulluser getUser(long userID)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Bulluser user = em.find(Bulluser.class, userID);
		return user;		
	}
	
	public static void insert(Bulluser bulluser) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(bulluser);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void update(Bulluser bulluser) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(bulluser);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void delete(Bulluser bulluser) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.remove(em.merge(bulluser));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}


	
	public static long isValidUser(Bulluser user)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select b.userid from Bulluser b where b.username = :username and b.userpass = :userpass";
		Query q = em.createQuery(qString);
		q.setParameter("username", user.getUsername());
		q.setParameter("userpass", user.getUserpass());
		
		
		
		try{
			long userId = (long) q.getSingleResult();
			System.out.println("userId =" + userId);
			if (userId > 0)
			{
				return userId;
			}
			else
			{
				return 0;
			}
			
		}catch (Exception e){
			
			return 0;
		}
		finally{
				em.close();		
		}	
			
	}
	
}
