package edu.iit.cs445.vin;

import java.util.List;
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;

public class AddSubscriberTest {

	@Test
	public void test_optimal_addSubscriber(){
		AddSubscriber as=new AddSubscriber();
		int i=as.addSubscriber("street", "city", "state", "zip", "email", "name", "phone","twitter", "facebook" );
		assertEquals(9, i);//consistently runs this test last when there are 8 other instances of add subscriber, hence the 9
	}
	
	@Test
	public void test_bad_state_addSubscriber(){
		AddSubscriber as=new AddSubscriber();
		int i=as.addSubscriber("street", "city", "KY", "zip", "email", "name", "phone","twitter", "facebook" );
		assertEquals(i, 0);
	}
	
	@Test
	public void test_has_account_addSubscriber(){
		AddSubscriber as1=new AddSubscriber();
		AddSubscriber as2=new AddSubscriber();
		int i=as1.addSubscriber("street", "city", "State", "zip", "email", "name", "phone","twitter", "facebook" );
		int j=as2.addSubscriber("street", "city", "State", "zip", "email", "name", "phone","twitter", "facebook" );
		assertEquals(j,0);
	}
	
	@Test
	public void test_userHasAccount(){
		AddSubscriber as1=new AddSubscriber();
		Address add=new Address("st", "cty", "state","zip");
		Subscriber su=new Subscriber("em","n","p",add, "fb","tw");
		Subscriber s=new Subscriber("e","n","p",add, "fb","tw");
		List<Subscriber> li=new ArrayList<Subscriber>();
		li.add(s);
		assertTrue(true==as1.userHasAccount(li,su));
	}
	
	
	
}
