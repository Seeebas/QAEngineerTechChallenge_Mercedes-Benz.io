package com.core;

import com.helpers.constants.Constants;
import com.helpers.constants.ConstantsUIElements;
import com.helpers.utils.FilesUtils;
import com.helpers.utils.StringUtils;
import com.helpers.write.Report;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Browser {

    private final static Logger logger = Logger.getLogger(Report.class.getName());

    private WebDriver driver;
    private WebDriverWait wait;

    public Browser(String browserName){
        whichBrowser(browserName, System.getProperty("user.dir"));
    }

    private void whichBrowser(String browserName, String mainPath){

        switch (browserName){
            case Constants.DRIVER_CHROME:
                initChromeOptions(mainPath);
                break;
            case Constants.DRIVER_FIREFOX:
                break;
            default:
                break;
        }
    }

    public void openUrl(String urlName){
        this.driver.get(urlName);
        this.driver.manage().window().maximize();
    }

    private void defaultWaitByID(String id) {
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
    }

    public void waitUntilByID(String byValue) {
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(byValue)));
    }

    public void waitUntilBy(By by) {
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void defaultAcceptCookies(){

        WebElement element = driver.findElement(By.tagName(ConstantsUIElements.SHADOWROOT_TAGNAME_ACCEPTCOOKIES));
        WebElement ele = (WebElement) ((JavascriptExecutor) driver)
                .executeScript(Constants.JAVAEXECUTOR_SHADOWROOT,element);

        waitUntilBy(By.linkText(ConstantsUIElements.TOPMENU_OURCARS_VALUE));

        ele.findElement(By.cssSelector(ConstantsUIElements.CSSSELECTOR_FOR_ACCEPTALLCOOKIES)).click();

    }

    public WebDriver getDriver() {
        return driver;
    }

    public void initChromeOptions(String mainPath) {
        System.setProperty(Constants.DRIVER_CHROME_SYS, StringUtils.concatenate( mainPath + Constants.DRIVER_CHROME_PATH));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        this.driver = new ChromeDriver(options);
    }

    public WebElement findElementById(String id){

        return  driver.findElement(By.id(id));

    }
    public void close(){
        driver.close();
    }

    public void switchToFrame(String frameID){
        driver.switchTo().frame(ConstantsUIElements.MAIN_FRAME_ID);
    }

    public void scrollToTextSpan(String xpath){

        WebElement elem = driver.findElement(By.xpath(xpath));

        ((JavascriptExecutor) driver).executeScript(Constants.JAVAEXECUTOR_SCROLLVIEW, elem);

    }

    public void mouseHoverValue(String xpathValue){
        Actions actions = new Actions(driver);
        WebElement e = driver.findElement(By.xpath(ConstantsUIElements.MOUSE_HOVER_CARTYPE_BY_SPAN.replace("{value}",xpathValue)));
        actions.moveToElement(e).perform();
    }

    public void javaExecutorClick(String xpath){

        WebElement element = driver.findElement(By.xpath(xpath));
        JavascriptExecutor executor = (JavascriptExecutor)driver;

        executor.executeScript(Constants.JAVAEXECUTOR_CLICK, element);
    }

    public List<Double> getAllPaginationCarAmount(){

        String initValue = driver.findElement(By.xpath(ConstantsUIElements.DIV_TOTAL_CAR_STATIC)).getText();

        List<WebElement> listElem = driver.findElements(By.xpath(ConstantsUIElements.TOTAL_CAR_PAGINATION_STATIC));
        List<Double> listAmount = new ArrayList<>();

        for(WebElement ele : listElem) {
            listAmount.add(
                    Double.parseDouble(ele.getAttribute(ConstantsUIElements.INNER_TEXT)
                            .replace(ConstantsUIElements.POUNDS_SIGN,"")
                            .replace(",",".")));
        }

        return initValue.contains(String.valueOf(listAmount.size())) ? listAmount : null;
    }

    public boolean takeScreenshot(String screenshotName) {

        TakesScreenshot screenshot = (TakesScreenshot) driver;

        try{
            File sourceScreenshot = screenshot.getScreenshotAs(OutputType.FILE);

            FilesUtils.createFolderIfNotExist();

            String path = StringUtils.concatenate(
                    System.getProperty(Constants.USER_DIR),
                    Constants.DASH,
                    Constants.FOLDER_REPORT,
                    Constants.DASH,
                    screenshotName,
                    Constants.PNG);

            File destinationPath = new File(path);

            Files.copy(sourceScreenshot.toPath(),destinationPath.toPath(),StandardCopyOption.REPLACE_EXISTING);

            return true;
        }catch (IOException e){
            logger.warning("ERROR: " + e.getMessage());
        }

        return false;

    }
}
