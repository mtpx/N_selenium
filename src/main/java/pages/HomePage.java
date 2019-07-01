package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Log;

import static utils.Utils.*;
public class HomePage extends _TestBase {
    public HomePage(WebDriver driver){
        super(driver);
    }

    @FindBy (xpath="//button[@id='j_idt123:j_idt128:0:j_idt139']") WebElement fillExpertsApplicationButton;
    @FindBy (xpath="//button[@id='j_idt122:applicationTable:0:j_idt162']") WebElement deleteFirstApplicationButton;
    @FindBy (xpath="//button[@id='j_idt122:j_idt143']") WebElement confirmDeleteApplicationButton;

    @Step("Wypelnij aplikacje ekspercka")
    public void clickFillExpertsApplication() {
        fillExpertsApplicationButton.click();
    }

    @Step("Usun pierwszy wniosek")
    public void clickDeleteFirstApplication() {
        wait.until(ExpectedConditions.visibilityOf(deleteFirstApplicationButton));
        safeClick(deleteFirstApplicationButton);
    }

    @Step("Potwierdzenie usuniecia wniosku")
    public void clickConfirmDeleteApplication() {
        wait.until(ExpectedConditions.visibilityOf(confirmDeleteApplicationButton));
        safeClick(confirmDeleteApplicationButton);
    }

    @Step("Usun istniejace wnioski")
    public void deleteExistingApplications() {
        try{
            deleteFirstApplicationButton.click();
            wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteApplicationButton));
            confirmDeleteApplicationButton.click();
        }catch(Exception e){
            Log.info("brak wnioskow do edycji");
        }
    }

}