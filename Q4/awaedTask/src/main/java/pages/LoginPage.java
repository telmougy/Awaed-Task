package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id ="ctl00_CPHContainer_txtUserLogin")
    WebElement emailTxtBox;

    @FindBy(id ="ctl00_CPHContainer_txtUserLogin")
    WebElement passWordTxtBox;

    @FindBy(id ="ctl00_CPHContainer_btnLoginn")
    WebElement loginBtn;

    @FindBy(id ="ctl00_CPHContainer_lblOutput")
    public WebElement errorMessage;

    public void LogIn (String username ,String password) {
        setText(emailTxtBox, username);
        setText(passWordTxtBox, password);
        clickButton(loginBtn);
    }

}
