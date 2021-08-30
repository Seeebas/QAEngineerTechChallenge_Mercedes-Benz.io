import com.helpers.constants.Constants;
import com.helpers.constants.ConstantsUIElements;
import com.helpers.core.Browser;
import org.openqa.selenium.By;

public class Main {

    public static void main(String... args){

        Browser browser =  new Browser(Constants.DRIVER_CHROME);

        browser.openUrl(Constants.URL_BENZ_UK);

        browser.defaultAcceptCookies();

        browser.switchToFrame(ConstantsUIElements.MAIN_FRAME_ID);

        browser.scrollToTextSpan(ConstantsUIElements.SPAN_TEXT_EQUAL_TO.replace("{value}",ConstantsUIElements.HATCHBACKS));

        browser.mouseHoverValue("A-Class");

        browser.getDriver().findElement(By.xpath(ConstantsUIElements.CONTAINS_A_VALUE.replace("{value}","Build your car"))).click();

        browser.waitUntilBy(By.xpath(ConstantsUIElements.CONTAINS_LEGEND_VALUE.replace("{value}","Fuel")));

        browser.scrollToTextSpan(ConstantsUIElements.CONTAINS_LEGEND_VALUE.replace("{value}","Fuel"));

        browser.javaExecutorClick(ConstantsUIElements.LABEL_CONTAINS_AND_INPUT.replace("{value}","Diesel"));
    }
}
