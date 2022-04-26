package org.modulr.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.modulr.factory.DriverFactory;
import org.modulr.modulrPages.LoginPage;

public class LoginSteps  {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private String pageTitle=null;
    private String uname, pass =null;

    @Given("the user navigates to login page")
    public void the_user_navigates_to_login_page() throws InterruptedException {
        DriverFactory.getDriver().get("https://secure-sandbox.modulrfinance.com/");
        Thread.sleep(5000);
        pageTitle= loginPage.getLoginPageTitle();
        System.out.println(" pageTitle " +pageTitle);
        Assert.assertEquals("Failed to Navigate to Login page",pageTitle,"Modulr Payments");
        System.out.println("Navigated to login page Successfully");
    }

    @When("user enters username {string} and password {string}")
    public void user_enters_username_and_password(String uname, String pass) {
        
        this.uname=uname;
        this.pass=pass;
        loginPage.enterUsername(uname);
        loginPage.enterPassword(pass);
        System.out.println("Entered Username and Password");
    }

    @When("user clicks on SignIn button")
    public void user_clicks_on_sign_in_button() {
        loginPage.clickSignIn();
        System.out.println("Clicked on sign in button");
    }

    @Then("user is taken to account overview page for user {string}")
    public void userIsTakenToAccountOverviewPageForUser(String uname) {
        Assert.assertEquals("User Failed to Logged in",uname,loginPage.getUserToolBarName());
    }

    @Then("user gets {string} mandatory field error")
    public void userGetsError(String err) {
        Assert.assertTrue("No Error Message is displayed",loginPage.getMandatoryErrMsg().size()>0);
        if(this.uname.equals("") || this.pass.equals(""))
        {
            Assert.assertTrue("User is not getting field is required Error",
                    loginPage.getMandatoryErrMsg().get(0).equals(err));
        }
        else if(this.uname.equals("") && this.pass.equals(""))
        {
            Assert.assertEquals("Getting Field required error for username and password both fields",
                    loginPage.getMandatoryErrMsg().size(),2);
            Assert.assertTrue(loginPage.getMandatoryErrMsg().get(0).equals(err));
            Assert.assertTrue(loginPage.getMandatoryErrMsg().get(1).equals(err));
        }

    }

    @Then("user gets {string} error")
    public void userGetsInvalidError(String err) throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue("User is not getting "+err+" error",
        loginPage.getInvalidLoginErrMsg().contains(err));

    }
    @And("user gets {string} multiple attempt error")
    public void userGetsMultipleAttemptError(String err) {
        String msg=loginPage.getInvalidLoginErrMsg();
        System.out.println(msg+ ". \n"+err );
        Assert.assertTrue("User is getting not "+err+" error",
                loginPage.getInvalidLoginErrMsg().contains(err));

    }

    @Then("Sign In button is disabled after clicking once")
    public void signInButtonIsDisabledAfterClickingItOnce() throws InterruptedException {
        Assert.assertFalse("Sign In button is not disabled", loginPage.isSignInDisabled());
    }


    @When("user clicks on forget Password link")
    public void user_clicks_on_forget_password_link() {
        loginPage.clickForgetPassword();
        System.out.println("Clicked on Forget Password Link");
    }
    @When("user enters username {string}")
    public void user_enters(String uname) {
       loginPage.resetPassword(uname);
        System.out.println("Entered Username Successfully");
    }
    @When("Clicks on Request reset button")
    public void clicks_on_request_reset_button() {
        loginPage.clickResetBtn();
        System.out.println("Clicked on Request Reset Button");
    }
    @Then("Email sent to user to reset a password")
    public void email_sent_to_user_to_reset_a_password() {
        Assert.assertTrue("Failed to sent email to user", loginPage.isEmailSent());
        System.out.println("Email sent to user");

    }
}
