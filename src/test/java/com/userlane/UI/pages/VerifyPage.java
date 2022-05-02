package com.userlane.UI.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VerifyPage extends BasePage {

@FindBy (xpath = "//h3[@data-qa]")
    public WebElement applicationMsg;

}
