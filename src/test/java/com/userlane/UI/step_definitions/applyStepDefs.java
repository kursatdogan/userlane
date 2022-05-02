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
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;

public class applyStepDefs {

    CareerPage careerPage = new CareerPage();
    DescriptionPage descriptionPage = new DescriptionPage();
    InfoPage infoPage = new InfoPage();
    VerifyPage verifyPage = new VerifyPage();
    Faker faker = new Faker();

    @Given("the user is on the career page")
    public void the_user_is_on_the_career_page() {

        Driver.get().get(ConfigurationReader.get("url"));

    }


    @When("the user clicks to open position for the Automation Test Engineer")
    public void the_user_clicks_to_open_position_for_the_Automation_Test_Engineer() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("window.scrollBy(0,4000)");
//        js.executeScript("arguments[0].scrollIntoView();", careerPage.applicationBtn);
//        Thread.sleep(5000);
       // careerPage.positionBtn.click();
        careerPage.applicationBtn.click();
        String parentWindow = Driver.get().getWindowHandle();
        for(String subWindow : Driver.get().getWindowHandles()){
            Driver.get().switchTo().window(subWindow);
        }

        descriptionPage.appyPositionBtn.click();
        for(String subWindow : Driver.get().getWindowHandles()){
            Driver.get().switchTo().window(subWindow);
        }

        infoPage.resumeBtn.sendKeys("C:\\Users\\vdw-Kursat\\Desktop\\Kursat Dogan - Resume.pdf");
        infoPage.inputName.sendKeys(faker.name().fullName());
        infoPage.inputEmail.sendKeys(faker.internet().emailAddress());
        infoPage.inputPhone.sendKeys(faker.phoneNumber().cellPhone());
        infoPage.inputCompany.sendKeys(faker.company().name());
        infoPage.inputUrl.get(0).sendKeys(faker.internet().url());
        infoPage.inputUrl.get(1).sendKeys(faker.internet().url());
        infoPage.inputUrl.get(2).sendKeys(faker.internet().url());
        infoPage.inputUrl.get(3).sendKeys(faker.internet().url());
        infoPage.inputAvabilityAndSlary.get(0).sendKeys("4 weeks");
        infoPage.inputAvabilityAndSlary.get(1).sendKeys("**** Euro/Year Gross");
        WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(infoPage.placeRadioBtn));
        wait.until(ExpectedConditions.elementToBeClickable(infoPage.cypressRadioBtn));
        infoPage.placeRadioBtn.click();
        infoPage.cypressRadioBtn.click();
        Thread.sleep(30000);
        infoPage.submitBtn.click();

    }
    @Then("the user should able to navigate application page")
    public void the_user_should_able_to_navigate_application_page() {
        System.out.println("then completed");
    }


}
