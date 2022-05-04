package com.userlane.UI.step_definitions;

import com.userlane.UI.pages.CareerPage;
import com.userlane.UI.pages.DescriptionPage;
import com.userlane.UI.pages.InfoPage;
import com.userlane.UI.pages.VerifyPage;
import com.userlane.UI.utilities.ConfigurationReader;
import com.userlane.UI.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class applyStepDefs {
    // I have created the object from pages to reach the webelements and some other functionalities of them
    CareerPage careerPage = new CareerPage();
    DescriptionPage descriptionPage = new DescriptionPage();
    InfoPage infoPage = new InfoPage();
    VerifyPage verifyPage = new VerifyPage();

    // faker object invoked from Faker class to create fake informations such as name, phone number or address
    Faker faker = new Faker();

    @Given("the user is on the career page")
    public void the_user_is_on_the_career_page() {

    // Navigating to Userlane career page
        Driver.get().get(ConfigurationReader.get("url"));

    }

    @When("the user clicks to open position for the Automation Test Engineer")
    public void the_user_clicks_to_open_position_for_the_Automation_Test_Engineer(){

    // Scroll down with JavascriptExecutor to see the Webelement
        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("window.scrollBy(0,4000)");

    // Click the web element and navigate to new opening window by WindowHandle
        careerPage.applicationBtn.click();
        String parentWindow = Driver.get().getWindowHandle();
        for(String subWindow : Driver.get().getWindowHandles()){
            Driver.get().switchTo().window(subWindow);
        }

    // Click to apply for this job button
        descriptionPage.appyPositionBtn.click();

    }

    @When("the user enters the necessary information on the info page")
    public void the_user_enters_the_necessary_information_on_the_info_page() throws InterruptedException {

    // Upload the resume dynamically from PC
        String projectPath = System.getProperty("user.dir");
        String filePath ="src/test/resources/kursatDoganResume.pdf";
        String fullPath = projectPath + "/" + filePath;

        infoPage.resumeBtn.sendKeys(fullPath);

    // Enter other fake information with the help of javaFaker class
        infoPage.inputName.sendKeys(faker.name().fullName());
        infoPage.inputEmail.sendKeys(faker.internet().emailAddress());
        infoPage.inputPhone.sendKeys(faker.phoneNumber().cellPhone());
        infoPage.inputCompany.sendKeys(faker.company().name());
        infoPage.inputUrl.get(0).sendKeys(faker.internet().url());
        infoPage.inputUrl.get(1).sendKeys(faker.internet().url());
        infoPage.inputUrl.get(2).sendKeys(faker.internet().url());
        infoPage.inputUrl.get(3).sendKeys(faker.internet().url());
        infoPage.inputUrl.get(4).sendKeys(faker.internet().url());
        infoPage.inputAvabilityAndSlary.get(0).sendKeys("4 weeks");
        infoPage.inputAvabilityAndSlary.get(1).sendKeys("**** Euro/Year Gross");

    // I put some explicit wait here to  click the radio buttons
        WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(infoPage.placeRadioBtn));
        wait.until(ExpectedConditions.elementToBeClickable(infoPage.cypressRadioBtn));
        infoPage.placeRadioBtn.click();
        infoPage.cypressRadioBtn.click();

    // I have put here some Thread to handle Capthcha manually
        Thread.sleep(30000);
        infoPage.submitBtn.click();
    }

    @Then("the user should able to navigate application page")
    public void the_user_should_able_to_navigate_application_page() {

    // Verifying the test with Junit assertion
        String actualMsg = verifyPage.applicationMsg.getText();
        String expectedMsg = "Application submitted!";
        Assert.assertEquals(expectedMsg,actualMsg);
    }


}
