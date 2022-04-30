package com.userlane.UI.step_definitions;

import com.userlane.UI.utilities.ConfigurationReader;
import com.userlane.UI.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class applyStepDefs {

    @Given("the user is on the career page")
    public void the_user_is_on_the_career_page() {

        Driver.get().get(ConfigurationReader.get("url"));

    }


    @When("the user clicks to open position for the Automation Test Engineer")
    public void the_user_clicks_to_open_position_for_the_Automation_Test_Engineer() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the user should able to navigate application page")
    public void the_user_should_able_to_navigate_application_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
