package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import services.ExcelReader;

public class LoginTest extends TestBase {
	LoginPage LoginObj ;

	@DataProvider(name="invalidData")
	public Object[][] getInvalidData () throws IOException{
		ExcelReader ER = new ExcelReader()  ;
		return ER.getExcelData("loginInvalidData",3);
	}

	@Test(dataProvider = "invalidData" ,priority = 2 , enabled = true)
	public void loginWithInvalidPassword (String email , String password,String errorMessage) {
		LoginObj = new LoginPage(driver);
		LoginObj.LogIn(email, password);
		Assert.assertTrue(LoginObj.errorMessage.getText().contains(errorMessage));
	}


}
