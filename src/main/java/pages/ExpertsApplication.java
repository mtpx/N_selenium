package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static utils.Utils.*;


public class ExpertsApplication extends _TestBase {
    public ExpertsApplication(WebDriver driver){
        super(driver);
    }
    //0.

    @FindBy (css="#o0section-15-control≡grid-1-grid≡choose_language-control≡≡e0 + span") WebElement polishLanguageCheckbox;
    @FindBy (css="#o0section-15-control≡grid-1-grid≡choose_language-control≡≡e0 + span") WebElement englishLanguageCheckbox;
    @FindBy (xpath="//input[@name='section-15-control≡grid-1-grid≡choose_language-control']")  List<WebElement> languages;

    @FindBy (css="#o0o0section-1-control≡grid-2-grid≡options-control≡≡e0 + span") WebElement interestedInNawaCheckbox;
    @FindBy (css="#o0section-1-control≡grid-2-grid≡options-control≡≡e1") WebElement haveActivationCodeFromNavaCheckbox;

    @FindBy (css="#o0section-1-control≡grid-153-grid≡programs_categories-control≡select1≡≡c⊙1") WebElement nawaProgramsSelect;
    @FindBy (css="#o0section-1-control≡grid-153-grid≡programs_categories-control≡select1≡≡c⊙2") WebElement nawaSecondProgramsSelect;
    @FindBy (css="#o0section-1-control≡grid-153-grid≡fr-grid-add≡≡c") WebElement addNextNawaProgramButton;

    //1. Informacje o kandydacie

    @FindBy (css="#o0section-5-control≡grid-5-grid≡telephone-control≡xforms-input-1") WebElement phoneNumberInput;
    @FindBy (css="#o0section-5-control≡grid-5-grid≡academic_title-control≡xforms-input-1") WebElement academicTitleInput;

    //2. Okreslenie specjalizacji, zakresu tematycznego

    @FindBy (css="#o0section-5-control≡grid-156-grid≡thematic_scope1-control≡select1≡≡c⊙1") WebElement thematicScopeSelect;

    //8. Znajomosc jezykow obcych

    @FindBy (css="#o0section-5-control≡grid-65-grid≡foreign_language_level-control≡select1≡≡c⊙1") WebElement englishLevelSelect;

    //8. Oswiadczenia

    @FindBy (css="#o0section-13-control≡grid-18-grid≡statement1-control .xforms-deselected .checkbox") WebElement dataProcessingCheckbox;
    @FindBy (css="#o0section-79-control≡grid-19-grid≡statement2-control .xforms-deselected .checkbox") WebElement trueInformationCheckbox;
    @FindBy (css="#o0section-79-control≡grid-19-grid≡statement3-control .xforms-deselected .checkbox") WebElement dataConfidentialityCheckbox;
    @FindBy (xpath="//span[@class='xforms-deselected']") WebElement deselect;



    //main form buttons elements

    @FindBy (css="#o0xf-549≡xf-3408≡xf-3414≡≡c⊙3") WebElement submitApplicationButton;
    @FindBy (css="#o0xf-549≡xf-3408≡xf-3414≡≡c⊙2") WebElement saveAsCopyButton;

    //validations elements

    @FindBy (css="#o0fr-error-dialog≡xf-3421") WebElement validationErrorDialogBox;
    @FindBy (css="#o0fr-error-dialog≡xf-3421 > label") WebElement validationErrorDialogBoxLabel;
    @FindBy (css="#o0fr-error-dialog≡xf-3426≡≡c") WebElement okOnValidationErrorDialogBox;
    @FindBy (css="#o0error-summary-control-bottom≡body≡≡l") WebElement bottomErrorHeaderText;
    @FindBy (xpath="//span[@class='ui-growl-title']") WebElement savingDraftTitle;
    @FindBy (xpath="//div[@class='ui-growl-icon-close ui-icon ui-icon-closethick']") WebElement savingDraftTitleCloseButton;




    //form functions
    @Step("Polski jezyk formularza")
    public void clickPolishLanguageCheckbox() throws InterruptedException {
       // driver.findElement(By.id("o0section-15-control≡grid-1-grid≡choose_language-control≡≡e0")).click();
        safeClick(polishLanguageCheckbox);
        //languages.get(1).click();
    }

    @Step("Angielski jezyk formularza")
    public void clickEnglishLanguageCheckbox() {
        englishLanguageCheckbox.click();
    }

    @Step("Zainteresowany wspolpraca z NAWA")
    public void clickInterestedInNawaCheckbox() {
        safeClick(interestedInNawaCheckbox);
    }

    @Step("Mam kod aktywacyjny od NAWA")
    public void clickHaveActivationCodeFromNavaCheckbox() {
        haveActivationCodeFromNavaCheckbox.click();
    }

    @Step("Wybor losowego programu NAWA")
    public void selectRandomNawaProgram(){
        safeSelectRandomValueFromDropdown(nawaProgramsSelect);
    }

    @Step("Wybor drugiego losowego programu NAWA")
    public void selectSecondRandomNawaProgram(){
        safeClick(addNextNawaProgramButton);
        safeSelectRandomValueFromDropdown(nawaSecondProgramsSelect);
    }

    @Step("Ustawienie numeru telefonu {1}")
    public void setPhoneNumber(String phoneNumberInput){
        this.phoneNumberInput.clear();
        this.phoneNumberInput.sendKeys(phoneNumberInput);
    }

    @Step("Czekanie na znikniecie komunikatu")
    public void waitForDraftSavedTitleToDisappear(){
        wait.until(ExpectedConditions.visibilityOf(savingDraftTitle));
        wait.until(ExpectedConditions.invisibilityOf(savingDraftTitle));

    }

    @Step("Ustawienie tytulu akademickiego {1}")
    public void setAcademicTitle(String academicTitleInput){
     /*   this.academicTitleInput.clear();
        this.academicTitleInput.sendKeys(academicTitleInput);*/
     safeSendKeys(this.academicTitleInput, academicTitleInput );

    }


    @Step("Wybor losowego zakresu tematycznego")
    public void selectRandomThematicScopeProgram(){
        safeSelectRandomValueFromDropdown(thematicScopeSelect);
    }

    @Step("Wybor losowego poziomu jezyka")
    public void selectRandomEnglishLevel(){
        safeSelectRandomValueFromDropdown(englishLevelSelect);
    }

    @Step("Zaznaczenie wymaganych checkboxow")
    public void clickRequiredCheckboxes() throws InterruptedException {
        safeClick(dataProcessingCheckbox);
        safeClick(trueInformationCheckbox);
        safeClick(dataConfidentialityCheckbox);
    }


    //main form buttons functions

    @Step("Wyslij aplikacje")
    public void clickSubmitApplicationButton() {
        safeClick(submitApplicationButton);
    }

    @Step("Zapisz kopie robocza")
    public void clickSaveAsCopyButton() {
        safeClick(saveAsCopyButton);
    }

    @Step("Szkic zostal zapisany - zamkniecie boxa")
    public void clickSavingDraftTitleCloseButton() {
        safeClick(savingDraftTitleCloseButton);
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
