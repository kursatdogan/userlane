package com.userlane.UI.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InfoPage extends BasePage {

    @FindBy (xpath = "//input[@name='resume']")
    public WebElement resumeBtn;

@FindBy (xpath = "//input[@name='name']")
    public WebElement inputName;

@FindBy (xpath = "//input[@name='email']")
    public WebElement inputEmail;

@FindBy (xpath = "//input[@name='phone']")
    public WebElement inputPhone;

@FindBy (xpath = "//input[@name='org']")
    public WebElement inputCompany;

@FindBy (xpath = "//input[contains(@name,'url')]")
    public List<WebElement> inputUrl;

@FindBy (xpath = "//input[(@class='card-field-input')]")
    public List<WebElement>  inputAvabilityAndSlary;

@FindBy (xpath = "(//input[@type='radio'])[2]")
    public WebElement placeRadioBtn;

    @FindBy (xpath = "(//input[@type='radio'])[3]")
    public WebElement cypressRadioBtn;

    @FindBy (xpath = "//button[@data-qa]")
    public WebElement submitBtn;


@FindBy (xpath = "//input[@type='checkbox']")
    public WebElement policyCheckBox;

@FindBy (xpath = "//div[@id='checkbox']")
    public WebElement robotCheckBox;

@FindBy (xpath = "//button[@type='submit']")
    public WebElement submitAppBtn;

@FindBy (xpath = "//p[@class='error-message']")
    public WebElement errorMsg;

}
