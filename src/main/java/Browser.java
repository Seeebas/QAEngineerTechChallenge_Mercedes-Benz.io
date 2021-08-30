import com.helpers.constants.Constants;
import com.helpers.utils.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser {

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
/*
    public Select initSelect(String id) {
        defaultWaitByID(id);
        return new Select(driver.findElement(By.id(id)));
    }
*/
    private void defaultWaitByID(String id) {
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
    }

    public void waitUntilByID(String byValue) {
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(byValue)));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void initChromeOptions(String mainPath) {
        System.setProperty(Constants.DRIVER_CHROME_SYS, StringUtils.concatenate( mainPath + Constants.DRIVER_CHROME_PATH));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        this.driver = new ChromeDriver(options);
    }

    public WebElement findElementById(String id){

        return  driver.findElement(By.id(id));

    }
    public void close(){
        driver.close();
    }
}
