package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.Utils.*;

public class PolishLanguagePromotion extends _TestBase {
    public PolishLanguagePromotion(WebDriver driver){
        super(driver);
    }

    //navigation buttons

    @FindBy (css="#o0fr-view-component≡fr-wizard-next≡≡c") WebElement nextPageOfApplicationButton;

    //0. Metryka

    @FindBy (css="#o0fr-view-component≡section-508-section≡grid-1-grid≡textarea-0-control≡field≡≡c") WebElement projectRealizationPlaceInput;


    //1. Informacje o wnioskodawcy

    @FindBy (css="#o0fr-view-component≡section-614-section≡grid-614-grid≡select1-0-control≡select1≡≡c") WebElement unitStatusSelect;        //1.2
    @FindBy (css="#o0fr-view-component≡section-614-section≡grid-614-grid≡select1-1-control≡select1≡select1≡≡c") WebElement unitFullNameSelect;   //1.3
    @FindBy (css="#o0fr-view-component≡section-614-section≡grid-614-grid≡input-5-control≡xforms-input-1") WebElement nipInput;   //1.4.8
    @FindBy (css="#o0fr-view-component≡section-614-section≡grid-614-grid≡input-7-control≡xforms-input-1") WebElement unitFormInput;   //1.4.10

    @FindBy (css="#o0fr-view-component≡section-614-section≡grid-614-grid≡select1-3-control≡select1≡≡c") WebElement formOfCourtesySelect;    //1.6
    @FindBy (css="#o0fr-view-component≡section-614-section≡grid-614-grid≡input-14-control≡xforms-input-1") WebElement positionInput;        //1.10
    @FindBy (css="#o0fr-view-component≡section-614-section≡grid-614-grid≡input-16-control≡xforms-input-1") WebElement phoneNumberInput;     //1.12

    @FindBy (css="#o0fr-view-component≡section-614-section≡grid-614-grid≡select1-4-control≡select1≡≡c") WebElement authorizationToSendApplicationSelect;    //1.14
    @FindBy (css="#o0fr-view-component≡section-614-section≡grid-2-grid≡select1-5-control≡select1≡≡c") WebElement formOfCourtesy2Select;    //1.17
    @FindBy (css="#o0fr-view-component≡section-614-section≡grid-2-grid≡input-17-control≡xforms-input-1") WebElement nameInput;    //1.18
    @FindBy (css="#o0fr-view-component≡section-614-section≡grid-2-grid≡input-18-control≡xforms-input-1") WebElement surnameInput;    //1.19
    @FindBy (css="#o0fr-view-component≡section-614-section≡grid-2-grid≡input-19-control≡xforms-input-1") WebElement position2Input;    //1.20
    @FindBy (css="#o0fr-view-component≡section-614-section≡grid-2-grid≡input-20-control≡xforms-input-1") WebElement mailInput;    //1.21
    @FindBy (css="#o0fr-view-component≡section-614-section≡grid-2-grid≡input-21-control≡xforms-input-1") WebElement phoneNumber2Input;    //1.22
    @FindBy (css="#o0fr-view-component≡section-614-section≡grid-2-grid≡select1-6-control≡select1≡≡c") WebElement formOfCourtesy3Select;    //1.25
    @FindBy (css="#o0fr-view-component≡section-614-section≡grid-2-grid≡input-23-control≡xforms-input-1") WebElement name2Input;    //1.26
    @FindBy (css="#o0fr-view-component≡section-614-section≡grid-2-grid≡input-24-control≡xforms-input-1") WebElement surname2Input;    //1.27
    @FindBy (css="#o0fr-view-component≡section-614-section≡grid-2-grid≡input-25-control≡xforms-input-1") WebElement position3Input;    //1.28
    @FindBy (css="#o0fr-view-component≡section-614-section≡grid-2-grid≡input-26-control≡xforms-input-1") WebElement mail2Input;    //1.29
    @FindBy (css="#o0fr-view-component≡section-614-section≡grid-2-grid≡input-27-control≡xforms-input-1") WebElement phoneNumber3Input;    //1.30
    @FindBy (css="#o0fr-view-component≡section-614-section≡grid-3-grid≡textarea-1-control≡field≡≡c") WebElement descriptionOfApplicantInput;    //1.34
    @FindBy (css="#o0fr-view-component≡section-614-section≡grid-3-grid≡textarea-2-control≡field≡≡c") WebElement experienceOfApplicantInput;    //1.35


    //3. Informacja o projekcie


    @FindBy (css="#o0fr-view-component≡section-1057-section≡grid-1057-grid≡textarea-6-control≡field≡≡c") WebElement projectTitleInput;    //3.1
    @FindBy (css="#o0fr-view-component≡section-1057-section≡grid-1057-grid≡input-48-control≡xforms-input-1") WebElement projectStartDateInput;    //3.3
    @FindBy (css="#o0fr-view-component≡section-1057-section≡grid-1057-grid≡input-49-control≡xforms-input-1") WebElement projectEndDateInput;    //3.4
    @FindBy (css="#o0fr-view-component≡section-1057-section≡grid-1057-grid≡textarea-8-control≡field≡≡c") WebElement shortProjectDescriptionInput;    //3.5
    @FindBy (css="#o0fr-view-component≡section-1057-section≡grid-1057-grid≡textarea-9-control≡field≡≡c") WebElement projectAnalysisInput;    //3.6
    @FindBy (css="#o0fr-view-component≡section-1057-section≡grid-1057-grid≡textarea-10-control≡field≡≡c") WebElement projectInnovationInput;    //3.7
    @FindBy (css="#o0fr-view-component≡section-1057-section≡grid-1057-grid≡textarea-11-control≡field≡≡c") WebElement targetGroupDescriptionInput;    //3.8
    @FindBy (css="#o0fr-view-component≡section-1057-section≡grid-1057-grid≡textarea-12-control≡field≡≡c") WebElement projectResultsInput;    //3.9
    @FindBy (css="#o0fr-view-component≡section-1057-section≡grid-1057-grid≡textarea-13-control≡field≡≡c") WebElement projectScheduleInput;    //3.10
    @FindBy (css="#o0fr-view-component≡section-1057-section≡grid-1057-grid≡textarea-14-control≡field≡≡c") WebElement projectManagementInput;    //3.11
    @FindBy (css="#o0fr-view-component≡section-1057-section≡grid-1057-grid≡textarea-15-control≡field≡≡c") WebElement projectEqualityInput;    //3.12
    @FindBy (css="#o0fr-view-component≡section-1057-section≡grid-1057-grid≡textarea-16-control≡field≡≡c") WebElement projectMonitoringInput;    //3.13
    @FindBy (css="#o0fr-view-component≡section-1057-section≡grid-1057-grid≡textarea-17-control≡field≡≡c") WebElement projectEvaluationInput;    //3.14

    @FindBy (css="#o0fr-view-component≡section-1057-section≡repeat-1194-repeat≡textarea-18-control≡field≡≡c⊙1") WebElement riskDescriptionInput;    //3.15
    @FindBy (css="#o0fr-view-component≡section-1057-section≡repeat-1194-repeat≡select1-13-control≡select1≡≡c⊙1") WebElement riskProbabilitySelect;    //3.16
    @FindBy (css="#o0fr-view-component≡section-1057-section≡repeat-1194-repeat≡select1-14-control≡select1≡≡c⊙1") WebElement riskImpactSelect;    //3.17
    @FindBy (css="#o0fr-view-component≡section-1057-section≡repeat-1194-repeat≡textarea-19-control≡field≡≡c⊙1") WebElement riskPreventionInput;    //3.18
    @FindBy (css="#o0fr-view-component≡section-1057-section≡repeat-1194-repeat≡textarea-20-control≡field≡≡c⊙1") WebElement riskImpactMinimalizationInput;    //3.19



    @FindBy (css="#o0section-79-control≡grid-19-grid≡statement3-control .xforms-deselected") WebElement dataConfidentialityCheckbox;
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


    // navigation
    @Step("Nastepna strona wniosku")
    public void clickNextPageOfApplication(){
        safeClick(nextPageOfApplicationButton);
    }


    //0. Metryka
    @Step("Ustawienie miejsca realizacji projektu")
    public void setProjectRealizationPlace(String projectRealizationPlaceInput){
        safeSendKeys(this.projectRealizationPlaceInput, projectRealizationPlaceInput);
    }

    //1. Informacje o wnioskodawcy

    @Step("Wybor losowego statusu jednostki")
    public void selectRandomUnitStatus(){
        wait.until(ExpectedConditions.visibilityOf(unitStatusSelect));
        safeSelectRandomValueFromDropdown(unitStatusSelect);
    }

    @Step("Wybor losowej pelnej nazwy")
    public void selectRandomUnitFullName(){
        safeSelectRandomValueFromDropdown(unitFullNameSelect);
    }

    @Step("Uzupelenie nipu")
    public void setNip(String nipInput){
        safeSendKeys(this.nipInput, nipInput);
    }

    @Step("Uzupelenie formy prawnej")
    public void setUnitForm(String unitFormInput){
        safeSendKeys(this.unitFormInput, unitFormInput);
    }



    @Step("Uzupelnienie danych na temat osoby skladajacej wniosek")
    public void setDetailsOfPersonSubmittingApplication(String positionInput, String phoneNumberInput){
        safeSelectRandomValueFromDropdown(formOfCourtesySelect);
        safeSendKeys(this.positionInput, positionInput);
        safeSendKeys(this.phoneNumberInput, phoneNumberInput);
    }

    @Step("Wybor upowaznienia do zlozenia wniosku")
    public void selectRandomAuthorizationToSendApplication(){
        safeSelectRandomValueFromDropdown(authorizationToSendApplicationSelect);
    }


    @Step("Uzupelenie danych osoby do kontaktu w sprawach zwiazanych z projektem")
    public void setContactPerson(String nameInput, String surnameInput, String position2Input, String mailInput, String phoneNumber2Input){
        safeSelectRandomValueFromDropdown(formOfCourtesy2Select);
        safeSendKeys(this.nameInput, nameInput);
        safeSendKeys(this.surnameInput, surnameInput);
        safeSendKeys(this.position2Input, position2Input);
        safeSendKeys(this.mailInput, mailInput);
        safeSendKeys(this.phoneNumber2Input, phoneNumber2Input);

    }

    @Step("Uzupelenie danych osoby do kontaktu w sprawach zwiazanych z finansami")
    public void setFinanceContactPerson(String name2Input, String surname2Input, String position3Input, String mail2Input, String phoneNumber3Input){
        safeSelectRandomValueFromDropdown(formOfCourtesy3Select);
        safeSendKeys(this.name2Input, name2Input);
        safeSendKeys(this.surname2Input, surname2Input);
        safeSendKeys(this.position3Input, position3Input);
        safeSendKeys(this.mail2Input, mail2Input);
        safeSendKeys(this.phoneNumber3Input, phoneNumber3Input);

    }


    @Step("Uzupelenie opisu wnioskodawcy")
    public void setDescriptionOfApplicant(String descriptionOfApplicantInput){
        safeSendKeys(this.descriptionOfApplicantInput, descriptionOfApplicantInput);
    }

    @Step("Uzupelenie doswiadczenia wnioskodawcy")
    public void setExperienceOfApplicant(String experienceOfApplicantInput){
        safeSendKeys(this.experienceOfApplicantInput, experienceOfApplicantInput);
    }




    //3. Informacje o projekcie

    @Step("Uzupelnienie tytulu projektu")
    public void setProjectTitle(String projectTitleInput){
        safeSendKeys(this.projectTitleInput,projectTitleInput);
    }

    @Step("Wybor daty startowej projektu")
    public void setProjectStartDate(String projectStartDateInput){
        safeSendKeys(this.projectStartDateInput,projectStartDateInput);
    }

    @Step("Wybor daty koncowej projektu")
    public void setProjectEndDate(String projectEndDateInput){
        safeSendKeys(this.projectEndDateInput,projectEndDateInput);
    }

    @Step("Uzupelenie krotkiego opisu projektu")
    public void setShortProjectDescription(String shortProjectDescriptionInput ){
        safeSendKeys(this.shortProjectDescriptionInput, shortProjectDescriptionInput);
    }



    @Step("Uzupelnienie analizy projektu")
    public void setProjectAnalysis(String projectAnalysisInput){
        safeSendKeys(this.projectAnalysisInput, projectAnalysisInput);
    }

    @Step("Uzupelnienie innowacyjnosci dzialan projektowych")
    public void setProjectInnovation(String projectInnovationInput){
        safeSendKeys(this.projectInnovationInput, projectInnovationInput);
    }


    @Step("Uzupelnienie opisu grup docelowych")
    public void setTargetGroupDescription(String targetGroupDescriptionInput){
        safeSendKeys(this.targetGroupDescriptionInput, targetGroupDescriptionInput);
    }



    @Step("Uzupelenie planowanych rezultatow")
    public void setProjectResults(String projectResultsInput){
        safeSendKeys(this.projectResultsInput, projectResultsInput);
    }

    @Step("Uzupelenie harmonogramu dzialan")
    public void setProjectSchedule(String projectScheduleInput){
        safeSendKeys(this.projectScheduleInput, projectScheduleInput);
    }

    @Step("Uzupelenie zarzadzania projektem")
    public void setProjectManagement(String projectManagementInput){
        safeSendKeys(this.projectManagementInput, projectManagementInput);
    }

    @Step("Uzupelenie rownosci szans w projekcie")
    public void setProjectEquality(String projectEqualityInput){
        safeSendKeys(this.projectEqualityInput, projectEqualityInput);
    }

    @Step("Uzupelenie monitorowania dzialan w projekcie")
    public void setProjectMonitoring(String projectMonitoringInput){
        safeSendKeys(this.projectMonitoringInput, projectMonitoringInput);
    }

    @Step("Uzupelenie ewaluacji dzialan projektowych")
    public void setProjectEvaluation(String projectEvaluationInput){
        safeSendKeys(this.projectEvaluationInput, projectEvaluationInput);
    }

    @Step("Uzupelenie opisu ryzyka")
    public void setRiskDescription(String riskDescriptionInput){
        safeSendKeys(this.riskDescriptionInput, riskDescriptionInput);
    }

    @Step("Wybor losowego prawdopodobienstwa wystawpienia ryzyka")
    public void selectRandomRiskProbability(){
        safeSelectRandomValueFromDropdown(riskProbabilitySelect);
    }

    @Step("Wybor losowego wplywu ryzyka ")
    public void selectRandomRiskImpact(){
        safeSelectRandomValueFromDropdown(riskImpactSelect);
    }

    @Step("Uzupelenie spospobu zapiegania wystapieniu ryzyka")
    public void setRiskPrevention(String riskPreventionInput){
        safeSendKeys(this.riskPreventionInput, riskPreventionInput);
    }

    @Step("Uzupelenie sposobu minimalizacji skutkow wystapienia ryzyka")
    public void setRiskImpactMinimalization(String riskImpactMinimalizationInput){
        safeSendKeys(this.riskImpactMinimalizationInput, riskImpactMinimalizationInput);
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
