package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Applications extends _TestBase {
    public Applications(WebDriver driver){
        super(driver);
    }

    @FindBy (xpath="//button[@id='j_idt123:j_idt128:0:j_idt139']") WebElement fillExpertsApplication;


    @Step("Wypelnij aplikacje ekspercka")
    public void clickFillExpertsApplication() {
        fillExpertsApplication.click();
    }



}
