package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class _TestBase {
    public WebDriver driver;
    public WebDriverWait wait;
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

    @Step("Przejscie na podstrone 'programy'")
    public void clickPrograms(){
        applicationsMenu.get(0).click();
    }


    public void clickMyApplications(){
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




    public boolean verifyAndClick(WebElement element) {
        boolean result = false;
        int attempts = 0;
        while(attempts < 2) {
            try {
                element.click();
                result = true;
                break;
            } catch(StaleElementReferenceException e) {
                System.out.println("StaleElementReferenceException occured , retrying in 100 ms ");
            } catch (NoSuchElementException e){
                System.out.println("NoSuchElementException occured, retrying in 100 ms ");
            } catch (ElementClickInterceptedException e){
                System.out.println("ElementClickInterceptedException occured, retrying in 100 ms ");
        }
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            attempts++;
        }
        return result;
    }

}