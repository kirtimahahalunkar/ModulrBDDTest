package org.modulr.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.cucumber.java.en_old.Ac;
import org.junit.Assert;
import org.modulr.factory.DriverFactory;
import org.modulr.modulrPages.AccountPage;
import org.modulr.modulrPages.LoginPage;

import java.util.List;
import java.util.Map;

public class AccountSteps {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private AccountPage accountPage = new AccountPage(DriverFactory.getDriver());
    
    


    @When("user enter account name {string}")
    public void user_enter_account_name(String uname) {
        accountPage.searchUserByAccountName(uname);
    }
    @When("user clicks on Go button")
    public void user_clicks_on_go_button() {
        accountPage.clickOnGoButton();

    }
    @Then("user account details are displayed for user {string}")
    public void user_account_details_are_displayed(String uname) {
            Assert.assertTrue("Not able to Search for User",
                    accountPage.getAliasNameFromSearchResult().contains(uname));
    }

    @Given("user is on account dashboard page")
    public void user_is_on_account_dashboard_page() {
          Assert.assertTrue("Failed to load Account Dashboard Page",
                  accountPage.accountDashboardVisible());
    }
    @Then("user gets app menu")
    public void user_gets_app_menu(DataTable dataTable) {
            List<String> expectedMenuList = dataTable.asList();
            List<String> actualMenuList = accountPage.getApplicationMenuList();
            Assert.assertEquals("Count of Expected and Actual Menu List items does not match",
                    expectedMenuList.size(),actualMenuList.size());
            Assert.assertTrue("Expected Menu list does not match with Dashboard Men List",
                    expectedMenuList.containsAll(actualMenuList));
    }


}
