package com.helpers.constants;

import java.util.ArrayList;
import java.util.List;

public final class Constants {

    public static final String DRIVER_CHROME_SYS = "webdriver.chrome.driver";
    public static final String DRIVER_CHROME_PATH = "/webdrivers/chrome/chromedriver";
    public static final String DRIVER_CHROME = "Chrome";

    public static final String DRIVER_FIREFOX = "Firefox";
    public static final String DRIVER_FIREFOX_PATH = "/webdrivers/firefox/geckodriver";
    public static final String DRIVER_FIREFOX_SYS = "webdriver.gecko.driver";

    public static final String URL_BENZ_UK = "https://www.mercedes-benz.co.uk";

    public static final String JAVAEXECUTOR_SHADOWROOT = "return arguments[0].shadowRoot.children";
    public static final String JAVAEXECUTOR_SCROLLVIEW = "arguments[0].scrollIntoView(true)";
    public static final String JAVAEXECUTOR_CLICK = "arguments[0].click();";

    public static final String USER_DIR = "user.dir";
    public static final String PNG = ".png";
    public static final String FOLDER_REPORT = "report";
    public static final String REPORT_EXEL_NAME = "ResultReport.xlsx";
    public static final String DASH = "/";

    public static final String PASSED = "Passed";
    public static final String FAILED = "Failed";

    public static final List<String> getExcelHeaders(){

        List<String> list = new ArrayList<>();
        list.add("TestID");
        list.add("Execution Date");
        list.add("Expected Result");
        list.add("Actual Result");
        list.add("Final Result");

        return list;
    }
    
}
