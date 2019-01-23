package com.iimjobs.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iimjobs.qa.base.Testbase;
import com.iimjobs.qa.pages.JobFeed;
import com.iimjobs.qa.pages.LoginPage;

public class LoginPageTest extends Testbase {

	LoginPage loginpage;
	JobFeed jobfeedpage;

	public LoginPageTest() throws IOException {
		super();

	}

	@BeforeMethod

	public void setuploginpage() throws IOException {
		initilization();
		loginpage = new LoginPage();

	}

	@Test(priority = 1)
	public void loginpagetitletest() {

		String title = loginpage.validateloginpage();
		Assert.assertEquals(title, "Jobseekers login - iimjobs.com");
	}

	@Test(priority = 2)

	public void loginheadertext() {

		boolean flag = loginpage.validateloginheadertext();
		Assert.assertTrue(flag);
		
	}

	@Test(priority = 3)
	public void logintest() throws IOException {

		jobfeedpage = loginpage.login(prop.getProperty("EmailID"), prop.getProperty("Password"));
	}

	@AfterMethod()

	public void close() {

		driver.quit();
	}
}
