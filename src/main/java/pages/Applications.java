package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Log;

import static utils.Utils.*;

public class Applications extends _TestBase {
    public Applications(WebDriver driver){
        super(driver);
    }
    Actions actions = new Actions(driver);

    @FindBy (xpath="//button[@id='j_idt123:j_idt128:0:j_idt139']") WebElement fillExpertsApplication;
    @FindBy (xpath="//button[@id='j_idt208:j_idt213:0:j_idt224']") WebElement fillPolishLanguagePromotion;


    @Step("Wypelnij wniosek: Promocja Jezyka Polskiego")
    public void clickFillPolishLanguagePromotion() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(fillPolishLanguagePromotion));
        safeClick(fillPolishLanguagePromotion);
      //  Thread.sleep(2000);
       // if (fillPolishLanguagePromotion.isDisplayed()){
        //    Log.info("retry fill polish click");
         //   fillPolishLanguagePromotion.click();
        //}
    }

    @Step("Wypelnij wniosek: Experci")
    public void clickFillExpertsApplication() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(fillExpertsApplication));
        safeClick(fillExpertsApplication);
        //Thread.sleep(2000);
        //if (fillExpertsApplication.isDisplayed()){
         //   Log.info("retry fill experts click");
          //  safeClick(fillExpertsApplication);
        //}

    }

}
