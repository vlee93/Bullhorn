package test;

import static org.junit.Assert.*;

import java.util.List;

import model.Bullhorn;
import model.Bulluser;

import org.junit.Test;

import customTools.DBBullhorn;
import customTools.DBUser;

public class DBBullhornTest {

//	@Test
	public void testPostBullhorn() {
		List<Bullhorn> posts = DBBullhorn.postBullhorn();
		System.out.println("size = " + posts.size());
		
		for (Bullhorn post : posts)
		{
			System.out.println(post.getPost());
		}
	}
	
	//@Test
	public void testLogin()
	{
		Bulluser user = new Bulluser();
		user.setUsername("Bob");
		user.setUserpass("passwasdsadasdord");
		
		assertTrue(DBUser.isValidUser(user) == 0);
	}

	@Test
	public void testNews ()
	{
		Bulluser user = DBUser.getUser(1);
		System.out.println("User: " + user.getUsername());
		
	}
	
}
