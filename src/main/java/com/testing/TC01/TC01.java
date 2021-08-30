package com.testing.TC01;

import com.helpers.constants.Constants;
import com.helpers.core.Browser;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class TC01 {

    private Browser browser;

    @Given("The url {string}")
    public void theUrl(String url)
    {
        browser =  new Browser(Constants.DRIVER_CHROME);
        browser.openUrl(Constants.URL_BENZ_UK);
        browser.defaultAcceptCookies();
    }

    @When("I select the model, mouse over, click build car and select fuel")
    public void selectModelMouseOverClickBuildCarAndSelectFuel(DataTable dataTable)
    {
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        //Step 1 Select
        browser.scrollToTextSpan("lol");
        /*
        Select selectType = browser.initSelect("type");
        selectType.selectByVisibleText(data.get("type"));

        Select selectSupport = browser.initSelect("support");
        selectSupport.selectByVisibleText(data.get("support"));
        */
        //browser.getDriver().findElement(By.id(ConstantsXpath.INPUT_MONTH_DURATION_ID)).sendKeys(data.get("duration"));

        //browser.getDriver().findElement(By.id(ConstantsXpath.BTN_CALCULATION_ID)).click();

    }
}
