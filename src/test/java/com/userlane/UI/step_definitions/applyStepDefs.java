package com.userlane.UI.step_definitions;

import com.userlane.UI.pages.CareerPage;
import com.userlane.UI.utilities.ConfigurationReader;
import com.userlane.UI.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.sql.SQLOutput;

public class applyStepDefs {

    CareerPage careerPage = new CareerPage();

    @Given("the user is on the career page")
    public void the_user_is_on_the_career_page() {

        Driver.get().get(ConfigurationReader.get("url"));

    }


    @When("the user clicks to open position for the Automation Test Engineer")
    public void the_user_clicks_to_open_position_for_the_Automation_Test_Engineer() throws InterruptedException {
//        JavascriptExecutor js = (JavascriptExecutor) Driver.get();
//        js.executeScript("arguments[0].scrollIntoView();", careerPage.applicationBtn);
//        Thread.sleep(5000);
       // careerPage.positionBtn.click();
        careerPage.applicationBtn.click();
        String parentWindow = Driver.get().getWindowHandle();
        for(String subWindow : Driver.get().getWindowHandles()){
            Driver.get().switchTo().window(subWindow);
        }
    }
    @Then("the user should able to navigate application page")
    public void the_user_should_able_to_navigate_application_page() {
        System.out.println("then completed");
    }


}
