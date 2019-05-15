package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class _TestBase {
    WebDriver driver;
    WebDriverWait wait;
    public _TestBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 15);
        // Actions actions = new Actions(driver);
        // JavascriptExecutor jse = (JavascriptExecutor) driver;
    }


    //lokalizatory

    @FindBy (css=".c-programs > a") WebElement login;
    @FindBy (xpath="//div[@class='grid__item -inline-flex']//a")  List<WebElement> applicationsMenu;

    @Step("Przejście na stronę logowania")
    public void clickLogin(){
        login.click();
    }
    public void clickPrograms(){
        applicationsMenu.get(0).click();
    }
    public void clickApplications(){
        applicationsMenu.get(1).click();
    }
    public void clickDocuments(){
        applicationsMenu.get(2).click();
    }
    public void clickProfile(){
        applicationsMenu.get(3).click();
    }
    public void clickNotification(){
        applicationsMenu.get(4).click();
    }

}