package TestNGFrameWork;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnotaionsDemo01 {
	@BeforeMethod
	void Login() {
		System.out.println("Login Successfully");
	}
	@Test(priority = 1)
	void Search() {
		System.out.println("Searching........");
	}
	@Test(priority = 2)
	void AdvSearch() {
		System.out.println("Adv Searching........");
	}
	@AfterMethod
	void LogOut() {
		System.out.println("Logout............");
	}

}
