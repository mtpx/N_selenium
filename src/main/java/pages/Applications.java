package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.Utils.*;

public class Applications extends _TestBase {
    public Applications(WebDriver driver){
        super(driver);
    }

    @FindBy (xpath="//button[@id='j_idt123:j_idt128:0:j_idt139']") WebElement fillExpertsApplication;
    @FindBy (xpath="//button[@id='j_idt208:j_idt213:0:j_idt224']") WebElement fillPolishLanguagePromotion;


    @Step("Wypelnij wniosek: Promocja Jezyka Polskiego")
    public void clickFillPolishLanguagePromotion() {

        safeClick(fillPolishLanguagePromotion);
    }

    @Step("Wypelnij wniosek: Experci")
    public void clickFillExpertsApplication() {

        safeClick(fillExpertsApplication);
    }



}
