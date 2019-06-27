import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import jdk.internal.org.jline.utils.Log;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.*;
import utils.Constant;


import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static utils.Utils.*;

public class Tests {
    public WebDriver driver;
    Faker faker = new Faker();
    private static final Logger log = LogManager.getLogger(Tests.class);

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

    @BeforeClass
    public void setUp() throws Exception {
       // WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=BlockCredentialedSubresources");
        options.addArguments("--disable-notifications");
        options.addArguments("--no-sandbox");
        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        options.addArguments("window-size=1920,1080");
        WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver", Constant.driverPath);
        driver  = new ChromeDriver(options);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        //driver.manage().window().setSize(new Dimension(1024, 768))
        System.out.println("Window height: " + driver.manage().window().getSize().getHeight());
        System.out.println("Window width: " + driver.manage().window().getSize().getWidth());
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

        log.info("1. Przejscie na strone logowania");
        _TestBase obj_TestBase = new _TestBase(driver);
        obj_TestBase.clickLogin();

        log.info("2. Logowanie bez danych");
        Login objLogin = new Login(driver);
        objLogin.login("","");
        Assert.assertEquals(objLogin.getErrorMessage(), "Pole Email jest wymagane.");
        Assert.assertEquals(objLogin.getSecondErrorMessage(), "Pole Hasło jest wymagane.");

        log.info("3. Poprawne logowanie");

        objLogin.login("matpanx@gmail.com","Bmxheni@1");

        Thread.sleep(2500);


    }

    @Test (enabled=true, priority=1)
    //@Parameters({ "name", "phone", "password", "001regFeedback", "blankValidationError" })
    public void test002_fillExpertsApplication(/*String name, String password, String password*/) throws Exception {

        log.info("1. Przejscie do programow");
        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickPrograms();

        log.info("2. przejscie do expert application");
        Applications objApplications = new Applications(driver);
        objApplications.clickFillExpertsApplication();

        ExpertsApplication objExpertsApplication = new ExpertsApplication(driver);
        objExpertsApplication.clickPolishLanguageCheckbox();
        objExpertsApplication.clickSubmitApplicationButton();
        objExpertsApplication.clickSavingDraftTitleCloseButton();
        System.out.println("driver=" + driver);
        objExpertsApplication.getValidationErrorDialogBoxLabelText();
        Assert.assertEquals(objExpertsApplication.getValidationErrorDialogBoxLabelText(),"Występują błędy walidacji. Proszę sprawdzić, czy wszystkie pola zostały wypełnione poprawnie.");
        objExpertsApplication.clickOkOnValidationErrorDialogBox();

        Assert.assertEquals(objExpertsApplication.getBottomErrorHeaderText(),"Twój formularz zawiera 1 lub więcej błędów");
        objExpertsApplication.clickInterestedInNawaCheckbox();
        objExpertsApplication.selectRandomNawaProgram();
        //objExpertsApplication.selectSecondRandomNawaProgram();

        objExpertsApplication.setAcademicTitle(faker.streetSuffix());
        objExpertsApplication.setPhoneNumber("123456987");
        objExpertsApplication.selectRandomThematicScopeProgram();
        objExpertsApplication.selectRandomEnglishLevel();
        objExpertsApplication.clickRequiredCheckboxes();


        log.info("3. Zapisywanie kopii roboczej");
        objExpertsApplication.clickSaveAsCopyButton();
        //objExpertsApplication.waitForDraftSavedTitleToDisappear();
        Thread.sleep(3000);

        log.info("4. Usuwanie formularza");
        objExpertsApplication.clickMyApplications();
        objHomePage.clickDeleteFirstApplication();
        objHomePage.clickConfirmDeleteApplication();


    }


    @Test (enabled=true, priority=1)
    //@Parameters({ "name", "phone", "password", "001regFeedback", "blankValidationError" })
    public void test003_fillPolishLanguagePromotion(/*String name, String password, String password*/) throws Exception {

        log.info("1. Przejście do programow");
        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickPrograms();
        objHomePage.acceptAlertIfPresent();

        log.info("2. Wypełanie wniosku promocja jezyka polskiego");
        Applications objApplications = new Applications(driver);
        objApplications.clickFillPolishLanguagePromotion();

        log.info("3. Wypełanie pierwszej strony wniosku");
        PolishLanguagePromotion objPolishLanguagePromotion = new PolishLanguagePromotion(driver);
        objPolishLanguagePromotion.setProjectRealizationPlace(faker.streetSuffix());
        objPolishLanguagePromotion.clickNextPageOfApplication();

        log.info("4. Wypełanie drugiej strony wniosku");
        objPolishLanguagePromotion.selectRandomUnitStatus();
        objPolishLanguagePromotion.selectRandomUnitFullName();
        objPolishLanguagePromotion.setNip("1165830299");
        objPolishLanguagePromotion.setUnitForm(faker.streetSuffix());
        objPolishLanguagePromotion.setDetailsOfPersonSubmittingApplication(faker.country(), "794350654");
        objPolishLanguagePromotion.selectRandomAuthorizationToSendApplication();
        objPolishLanguagePromotion.setContactPerson(faker.firstName(), faker.lastName(), faker.country(),"xxx@asd.pl","794350654");
        objPolishLanguagePromotion.setFinanceContactPerson(faker.firstName(), faker.lastName(), faker.country(),"xxx@asd.pl","794350654");
        objPolishLanguagePromotion.setDescriptionOfApplicant(getLongDescription());
        objPolishLanguagePromotion.setExperienceOfApplicant(generateRandomString(1010));

        log.info("5. Wypełanie trzeciej strony wniosku");
        objPolishLanguagePromotion.clickNextPageOfApplication();

        log.info("5. Wypełanie czwartej strony wniosku");
        objPolishLanguagePromotion.clickNextPageOfApplication();
        objPolishLanguagePromotion.setProjectTitle(generateRandomString(15));
        objPolishLanguagePromotion.setProjectStartDate("2019-10-09");
        objPolishLanguagePromotion.setProjectEndDate("2020-02-09");
        objPolishLanguagePromotion.setShortProjectDescription(generateRandomString(1010));
        objPolishLanguagePromotion.setProjectAnalysis(generateRandomString(1010));
        objPolishLanguagePromotion.setProjectInnovation(generateRandomString(1010));
        objPolishLanguagePromotion.setTargetGroupDescription(generateRandomString(1010));
        objPolishLanguagePromotion.setProjectResults(generateRandomString(1010));
        objPolishLanguagePromotion.setProjectSchedule(generateRandomString(1010));
        objPolishLanguagePromotion.setProjectManagement(generateRandomString(15));
        objPolishLanguagePromotion.setProjectEquality(generateRandomString(15));
        objPolishLanguagePromotion.setProjectMonitoring(generateRandomString(15));
        objPolishLanguagePromotion.setProjectEvaluation(generateRandomString(15));
        objPolishLanguagePromotion.setRiskDescription(generateRandomString(15));
        objPolishLanguagePromotion.selectRandomRiskProbability();
        objPolishLanguagePromotion.selectRandomRiskImpact();
        objPolishLanguagePromotion.setRiskPrevention(generateRandomString(15));
        objPolishLanguagePromotion.setRiskImpactMinimalization(generateRandomString(15));




        Thread.sleep(4000);

    }


    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
