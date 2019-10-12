package org.zhuzhenxi.test;

import org.junit.Test;

import java.util.Calendar;


public class TestApplicationTests {

	@Test
	public void contextLoads() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2000,2,29);
		System.out.println(calendar.getTime());
	}

}
