package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Login extends _TestBase {
    public Login(WebDriver driver){
        super(driver);
    }

    @FindBy (css="#email") WebElement email;
    @FindBy (css="#password") WebElement password;
    @FindBy (css="#loginButton") WebElement loginButton;
    @FindBy (css="#j_idt60") WebElement registerButton;
    @FindBy (css="#remember-me") WebElement rememberMeCheckbox;
    @FindBy (xpath="//div[@id='messages_container']//span[@class='ui-growl-title']")  List<WebElement> errorMessages;

    @Step("Logowanie za pomoca: user: {1}, pass: {2}")
    public void login(String login, String password) {
        this.email.clear();
        this.password.clear();
        this.email.sendKeys(login);
        this.password.sendKeys(password);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loginButton);
        loginButton.click();
    }

    @Step("Pobieranie wiadomosci z bledem logowania")
    public String getErrorMessage(){
        System.out.println(errorMessages.get(0).getText());
        return errorMessages.get(0).getText();
    }

    @Step("Pobieranie drugiej wiadomosci z bledem logowania")
    public String getSecondErrorMessage(){
        System.out.println(errorMessages.get(1).getText());
        return errorMessages.get(1).getText();
    }

}
