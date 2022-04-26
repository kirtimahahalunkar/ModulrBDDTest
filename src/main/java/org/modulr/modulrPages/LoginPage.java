package org.modulr.modulrPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class LoginPage {

    private  WebDriver driver;

    private By userName = By.id("username-inp");
    private By password = By.id("password-inp");
    private By signInBtn = By.id("signInSubmitButton");
    private By forgotPassword = By.id("forgotPasswordHref");
    private By resetUsername = By.id("usernameInput");
    private By resetRequestBtn = By.id("signInSubmitButton");
    private By emailSentLable = By.id("emailSentHeading");
    private By cancelResetRequestBtn = By.id("cancelHref");
    private By userToolBarName = By.xpath("//span[@data-qa=\"toolbar-name-txt\"]");
    private By invalidLoginMsg = By.xpath("//div[@data-qa=\"signin-div-error-display\"]");
    private By mandatoryFieldErr = By.xpath("//div[@data-qa=\"error-message-div-display\"]");




    public LoginPage(WebDriver driver)
    {
        this.driver= driver;
    }

    public String getLoginPageTitle()
    {
      return driver.getTitle();
    }

    public void enterUsername(String uname)
    {
      driver.findElement(userName).sendKeys(uname);
    }

    public void enterPassword(String pass)
    {
        driver.findElement(password).sendKeys(pass);
    }

    public void clickSignIn()
    {

       driver.findElement(signInBtn).click();
    }
    public void clickForgetPassword()
    {

        driver.findElement(forgotPassword).click();
    }
    public void resetPassword(String uname)
    {

        driver.findElement(resetUsername).sendKeys(uname);
    }
    public void clickResetBtn() {
        try {
            driver.findElement(resetRequestBtn).click();
            Thread.sleep(5000);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public boolean isSignInDisabled()
    {
        return driver.findElement(signInBtn).isEnabled();
    }
    public boolean isEmailSent()
    {
        return driver.findElement(emailSentLable).isDisplayed();
    }

    public String getUserToolBarName()
    {
       return driver.findElement(userToolBarName).getText();
    }

    public String getInvalidLoginErrMsg()
    {
        return driver.findElement(invalidLoginMsg).getText();
    }

    public List<String> getMandatoryErrMsg()
    {
        List<WebElement> errorMsgs = driver.findElements(mandatoryFieldErr);
        List<String> errMsgList= new ArrayList<String>();
        for(WebElement errorMsg : errorMsgs)
            errMsgList.add(errorMsg.getText());

        return errMsgList;

    }




}
