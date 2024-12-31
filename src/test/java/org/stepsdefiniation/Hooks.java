package org.stepsdefiniation;

import org.bass.Bassclass;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends Bassclass {
	
	@Before
	public static void Beforekayak() {
		browserlaunch("chrome");
		timesout(10);
		maxmize();
		url("https://www.kayak.com/");
	}
	@After
	private void AfterKayak() {
	//	quit();

	}

}
