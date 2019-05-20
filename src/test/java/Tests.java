import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.*;
import utils.Constant;


import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Tests {
    public WebDriver driver;
    Faker faker = new Faker();


    @BeforeClass
    public void setUp() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=BlockCredentialedSubresources");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        WebDriverManager.chromedriver().setup();
    //    System.setProperty("webdriver.chrome.driver", Constant.driverPath);
        driver  = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();

        // BasicConfigurator.configure();


    }
    @BeforeMethod
    public void beforeTest() {
//        driver.manage().deleteAllCookies();
        //      driver.get(Constant.testurl);

    }

    @Test (enabled=true, priority=1, description="Logowanie")
    @Description("Logowanie: bez danych/logowanie poprawne")
    //@Parameters({ "name", "phone", "password", "001regFeedback", "blankValidationError" })
    public void test001_logowanie(/*String name, String password, String password*/) throws Exception {


        driver.get(Constant.testurl);

        _TestBase obj_TestBase = new _TestBase(driver);
        obj_TestBase.clickLogin();

        // 2. Logowanie bez danych
        Login objLogin = new Login(driver);

        objLogin.login("","");
    //    Assert.assertEquals(objLogin.getErrorMessage(), "Pole Email jest wymagane.");
    //    Assert.assertEquals(objLogin.getSecondErrorMessage(), "Pole Hasło jest wymagane.");

        // 3. Poprawne logowanie

        objLogin.login("matpanx@gmail.com","Bmxheni@1");

        Thread.sleep(4000);


    }

    @Test (enabled=true, priority=1)
    //@Parameters({ "name", "phone", "password", "001regFeedback", "blankValidationError" })
    public void test002_fillExpertsApplication(/*String name, String password, String password*/) throws Exception {

        // 1. Przejście do programow
        HomePage objHomePage = new HomePage(driver);
      //  objHomePage.clickPrograms();

        Applications objApplications = new Applications(driver);
        objApplications.clickFillExpertsApplication();

        ExpertsApplication objExpertsApplication = new ExpertsApplication(driver);
        objExpertsApplication.clickPolishLanguageCheckbox();
        objExpertsApplication.clickSubmitApplicationButton();
        objExpertsApplication.clickSavingDraftTitleCloseButton();
        Assert.assertEquals(objExpertsApplication.getvalidationErrorDialogBoxLabelText(),"Występują błędy walidacji. Proszę sprawdzić, czy wszystkie pola zostały wypełnione poprawnie.");
        objExpertsApplication.clickOkOnValidationErrorDialogBox();

        Assert.assertEquals(objExpertsApplication.getBottomErrorHeaderText(),"Twój formularz zawiera 1 lub więcej błędów");
        objExpertsApplication.clickInterestedInNawaCheckbox();
        objExpertsApplication.selectRandomNawaProgram();
        objExpertsApplication.selectSecondRandomNawaProgram();

        objExpertsApplication.setAcademicTitle(faker.streetSuffix());
        objExpertsApplication.setPhoneNumber("123456987");
        objExpertsApplication.selectRandomThematicScopeProgram();
        objExpertsApplication.selectRandomEnglishLevel();
        objExpertsApplication.clickRequiredCheckboxes();



        objExpertsApplication.clickSaveAsCopyButton();
        Thread.sleep(3000);
        objExpertsApplication.waitForDraftSavedTitleToDisappear();
        objExpertsApplication.clickMyApplications();
        objHomePage.clickDeleteFirstApplication();
        objHomePage.clickConfirmDeleteApplication();

        Thread.sleep(4000);

    }



    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
