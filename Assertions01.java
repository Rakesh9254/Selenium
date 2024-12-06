package TestNGFrameWork;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertions01 {
	@Test
	void testTitle() {
		String ActTitle = "Opencart";
		String ExpTitle = "opencart";
		
		Assert.assertEquals(ActTitle, ExpTitle);
	}

}
