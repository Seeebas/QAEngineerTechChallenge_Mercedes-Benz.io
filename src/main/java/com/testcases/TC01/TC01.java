package com.testcases.TC01;

import com.helpers.constants.Constants;
import com.helpers.constants.ConstantsUIElements;
import com.core.*;
import com.helpers.utils.StringUtils;
import com.helpers.write.Report;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;

public class TC01 {

    private Browser browser;
    private Double maxUIValue,minUIValue;
    private Double maxValueToValidate,minValueToValidate;

    @Given("The url and the browserName")
    public void theUrl(DataTable dataTable)
    {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        browser =  new Browser(data.get("browserName"));
        //Open Mercedes-benz United Kingdom market
        browser.openUrl(data.get("url"));
        browser.defaultAcceptCookies();
    }

    @When("I select the model, mouse over, click build car and select fuel")
    public void selectModelMouseOverClickBuildCarAndSelectFuel(DataTable dataTable)
    {
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        browser.switchToFrame(ConstantsUIElements.MAIN_FRAME_ID);

        //Under “Our Models” - Select “Model: Hatchbacks”;
        browser.scrollToTextSpan(ConstantsUIElements.SPAN_TEXT_EQUAL_TO.replace("{value}",data.get("selectModel")));
        if(!browser.isChrome()){ browser.switchToDefaultFrame();}
        browser.javaExecutorClick(ConstantsUIElements.SPAN_LEFT_CAR_TYPES.replace("{value}","Hatchbacks"));

        if(!browser.isChrome()){ browser.switchToFrame(ConstantsUIElements.MAIN_FRAME_ID); }

        //Mouse over the “A Class” model available and proceed to “Build your car”
        browser.mouseHoverValue(data.get("mouseOver"));
        browser.getDriver().findElement(By.xpath(ConstantsUIElements.CONTAINS_A_VALUE.replace("{value}",data.get("click")))).click();

        //Filter by Fuel type “Diesel”
        if(!browser.isChrome()){ browser.switchToDefaultFrame(); }
        browser.waitUntilBy(By.xpath(ConstantsUIElements.CONTAINS_LEGEND_VALUE.replace("{value}",data.get("scrollTo"))));
        browser.scrollToTextSpan(ConstantsUIElements.CONTAINS_LEGEND_VALUE.replace("{value}",data.get("scrollTo")));
        browser.javaExecutorClick(ConstantsUIElements.LABEL_CONTAINS_AND_INPUT.replace("{value}",data.get("selectFuel")));

        //Take and save a screenshot of the results
        browser.takeScreenshot("screenshotTC001");

        //Save the value “£” of the highest and lowest price results in a text file
        List<Double> amountList = browser.getAllPaginationCarAmount();
        maxUIValue = amountList.stream().mapToDouble(Double::doubleValue).max().getAsDouble();
        minUIValue = amountList.stream().mapToDouble(Double::doubleValue).min().getAsDouble();

    }

    @Then("Save the value £ of the highest and lowest price results in a text file")
    public void saveTheMaxAndMindValue(DataTable dataTable)
    {
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        maxValueToValidate = Double.parseDouble(data.get("maxValueToValidate"));
        minValueToValidate = Double.parseDouble(data.get("minValueToValidate"));

        String finalResult = Constants.FAILED;

        if(minUIValue >= minValueToValidate && maxUIValue <= maxValueToValidate){
            finalResult = Constants.PASSED;
        }

        Report.write("TC001",
                StringUtils.getDateAndTime(),
                browser.getBrowserType(),
                StringUtils.concatenate(
                        "Values between ",
                        String.valueOf(minValueToValidate),
                        " and ",
                        String.valueOf(maxValueToValidate)),

                StringUtils.concatenate(
                        "Min value from UI ",
                        String.valueOf(minUIValue),
                        " and  max value ",
                        String.valueOf(maxUIValue)),
                finalResult);

        browser.close();
    }


}
