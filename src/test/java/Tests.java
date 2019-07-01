import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.*;
import utils.Constant;
import utils.Log;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static utils.Utils.*;

public class Tests {
    public WebDriver driver;
    Faker faker = new Faker();

    @BeforeClass
    public void setUp() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=BlockCredentialedSubresources");
        options.addArguments("--disable-notifications");
        options.addArguments("--no-sandbox");
        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        options.addArguments("window-size=1600,900");
        WebDriverManager.chromedriver().setup();
        driver  = new ChromeDriver(options);
    //    WebDriverManager.firefoxdriver().setup();
     //   driver  = new FirefoxDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Window height: " + driver.manage().window().getSize().getHeight());
        System.out.println("Window width: " + driver.manage().window().getSize().getWidth());
        BasicConfigurator.configure();
        driver.manage().deleteAllCookies();




    }
    @BeforeMethod
    public void beforeTest() {

    }

    @Test (enabled=true, priority=1, description="Logowanie")
    @Description("Logowanie: bez danych/logowanie poprawne")
    public void test001_logowanie() throws Exception {


        driver.get(Constant.testurl);

        Log.error("1. Przejscie na strone logowania");
        System.out.println("1. Przejscie na strone logowania");
        _TestBase obj_TestBase = new _TestBase(driver);
        obj_TestBase.clickLogin();

        Log.error("2. Logowanie bez danych");
        Login objLogin = new Login(driver);
        objLogin.login("","");
        Assert.assertEquals(objLogin.getErrorMessage(), "Pole Email jest wymagane.");
        Assert.assertEquals(objLogin.getSecondErrorMessage(), "Pole Hasło jest wymagane.");

        Log.info("3. Poprawne logowanie");
        objLogin.login("matpanx@gmail.com","Bmxheni@1");

        Thread.sleep(2500);


    }

    @Test (enabled=true, priority=1)
    public void test002_fillExpertsApplication() throws Exception {

        Log.info("1. Przejscie do programow");
        HomePage objHomePage = new HomePage(driver);
        objHomePage.deleteExistingApplications();
        objHomePage.clickPrograms();

        Log.info("2. przejscie do expert application");
        Applications objApplications = new Applications(driver);
        objApplications.clickFillExpertsApplication();

        ExpertsApplication objExpertsApplication = new ExpertsApplication(driver);
        objExpertsApplication.clickPolishLanguageCheckbox();
        objExpertsApplication.clickSubmitApplicationButton();
        objExpertsApplication.clickSavingDraftTitleCloseButton();
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


        Log.info("3. Zapisywanie kopii roboczej");
        objExpertsApplication.clickSaveAsCopyButton();
        //objExpertsApplication.waitForDraftSavedTitleToDisappear();
        Thread.sleep(4000);

        Log.info("4. Usuwanie formularza");
        objExpertsApplication.clickMyApplications();
        objHomePage.clickDeleteFirstApplication();
        objHomePage.clickConfirmDeleteApplication();


    }


    @Test (enabled=true, priority=1)
    public void test003_fillPolishLanguagePromotion() throws Exception {

        Log.info("1. Przejście do programow");
        HomePage objHomePage = new HomePage(driver);
        objHomePage.deleteExistingApplications();
        objHomePage.clickPrograms();
        objHomePage.acceptAlertIfPresent();

        Log.info("2. Wypełanie wniosku promocja jezyka polskiego");
        Applications objApplications = new Applications(driver);
        objApplications.clickFillPolishLanguagePromotion();

        Log.info("3. Wypełanie pierwszej strony wniosku");
        PolishLanguagePromotion objPolishLanguagePromotion = new PolishLanguagePromotion(driver);
        objPolishLanguagePromotion.setProjectRealizationPlace(faker.streetSuffix());
        objPolishLanguagePromotion.clickNextPageOfApplication();

        Log.info("4. Wypełanie drugiej strony wniosku");
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

        Log.info("5. Wypełanie trzeciej strony wniosku");
        objPolishLanguagePromotion.clickNextPageOfApplication();

        Log.info("5. Wypełanie czwartej strony wniosku");
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

    @AfterMethod
    public void TearDown(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE ){
            TakesScreenshot ts = (TakesScreenshot)driver;
            String timeStamp = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
            String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
            File srcFile = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File("./failureScreenShots/"+date+"/"+result.getName()+"_"+timeStamp+".jpg"));
        }
    }


    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
