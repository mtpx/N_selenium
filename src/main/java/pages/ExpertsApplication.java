package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class ExpertsApplication extends _TestBase {
    public ExpertsApplication(WebDriver driver){
        super(driver);
    }
    //form elements

    @FindBy (css="#o0section-15-control≡grid-1-grid≡choose_language-control≡≡e0") WebElement polishLanguageCheckbox;
    @FindBy (css="#o0section-15-control≡grid-1-grid≡choose_language-control≡≡e1") WebElement englishLanguageCheckbox;
    @FindBy (css="#o0section-1-control≡grid-2-grid≡options-control≡≡e0") WebElement interestedInNawaCheckbox;
    @FindBy (css="#o0section-1-control≡grid-2-grid≡options-control≡≡e1") WebElement haveActivationCodeFromNavaCheckbox;
    @FindBy (css="#o0section-1-control≡grid-153-grid≡programs_categories-control≡select1≡≡c⊙1") WebElement nawaProgramsSelect;
    @FindBy (css="#o0section-5-control≡grid-5-grid≡telephone-control≡xforms-input-1") WebElement phoneNumberInput;

    //main form buttons elements

    @FindBy (css="#o0xf-549≡xf-3408≡xf-3414≡≡c⊙3") WebElement submitApplicationButton;

    //validations elements

    @FindBy (css="#o0fr-error-dialog≡xf-3421") WebElement validationErrorDialogBox;
    @FindBy (css="#o0fr-error-dialog≡xf-3421 > label") WebElement validationErrorDialogBoxLabel;
    @FindBy (css="#o0fr-error-dialog≡xf-3426≡≡c") WebElement okOnValidationErrorDialogBox;
    @FindBy (css="#o0error-summary-control-bottom≡body≡≡l") WebElement bottomErrorHeaderText;




    //form functions
    @Step("Polski jezyk formularza")
    public void clickPolishLanguageCheckbox() {
        polishLanguageCheckbox.click();
    }

    @Step("Angielski jezyk formularza")
    public void clickEnglishLanguageCheckbox() {
        englishLanguageCheckbox.click();
    }

    @Step("Zainteresowany wspolpraca z NAWA")
    public void clickInterestedInNawaCheckbox() {
        interestedInNawaCheckbox.click();
    }

    @Step("Mam kod aktywacyjny od NAWA")
    public void clickHaveActivationCodeFromNavaCheckbox() {
        haveActivationCodeFromNavaCheckbox.click();
    }

    @Step("Wybor losowego programu NAWA")
    public void selectRandomNawaProgram(){
        Select dropdown = new Select(nawaProgramsSelect);
        List<WebElement> l = dropdown.getOptions();
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(l.size()-1) + 1;
        System.out.println((randomInt));
        dropdown.selectByIndex(randomInt);
    }

    @Step("Wybor drugiego losowego programu NAWA")
    public void selectSecondRandomNawaProgram(){
        Select dropdown = new Select(nawaProgramsSelect);
        List<WebElement> l = dropdown.getOptions();
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(l.size()-1) + 1;
        System.out.println((randomInt));
        dropdown.selectByIndex(randomInt);
    }

    @Step("Ustawienie numeru telefonu {1}")
    public void setPhoneNumber(String phoneNumberInput){
        this.phoneNumberInput.clear();
        this.phoneNumberInput.sendKeys(phoneNumberInput);
    }

    //main form buttons functions

    @Step("Wyslij aplikacje")
    public void clickSubmitApplicationButton() {
        submitApplicationButton.click();
    }

    //validation functions

    @Step("Pobieranie tresci bledow")
    public String getvalidationErrorDialogBoxLabelText() {
        wait.until(ExpectedConditions.visibilityOf(validationErrorDialogBox));
        return validationErrorDialogBoxLabel.getText();
    }

    @Step("Klikniecie OK na dialog boxie z bledami")
    public void clickOkOnValidationErrorDialogBox() {
        okOnValidationErrorDialogBox.click();
    }

    @Step("Pobranie listy bledów")
    public String getBottomErrorHeaderText() {
        wait.until(ExpectedConditions.visibilityOf(bottomErrorHeaderText));
        return bottomErrorHeaderText.getText();
    }






}
