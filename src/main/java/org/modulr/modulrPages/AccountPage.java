package org.modulr.modulrPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class AccountPage {

    private  WebDriver driver;

    private By searchBox = By.name("queryInp");
    private By goBtn = By.xpath("//button[@data-qa=\"acc-search-btn\"]");
    private By accountAlias = By.xpath("//td[@data-qa=\"account-external-ref-cell\"]");
    private By appMenuList = By.xpath("//nav[@class='aside-nav-main']/app-menu-customer/app-menu-item[a]/a");




    public AccountPage(WebDriver driver)
    {
        this.driver= driver;
    }

    public List<String> getApplicationMenuList()
    {
        List<String> menuList = new ArrayList<>();
        List<WebElement> menuElementList = driver.findElements(appMenuList);
        for(WebElement eachMenu :menuElementList)
        {
            menuList.add(eachMenu.getText());
        }
        System.out.println("Menu List "+menuList);
        return menuList;
    }

    public void searchUserByAccountName(String uname)
    {
        driver.findElement(searchBox).sendKeys(uname);
    }

    public void clickOnGoButton()
    {
        driver.findElement(goBtn).click();
    }

    public String getAliasNameFromSearchResult()
    {
        return driver.findElement(accountAlias).getText();
    }

    public boolean accountDashboardVisible()
    {
        return driver.findElement(searchBox).isDisplayed();
    }







}
