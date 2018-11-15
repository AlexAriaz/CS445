package edu.iit.cs445.vin;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@Suite.SuiteClasses({
		WineTest.class,
		SubscriberTest.class,
		AddSubscriberTest.class,
		AdminTest.class,
		MyResourceTest.class
	})

public class AllTests {

}
