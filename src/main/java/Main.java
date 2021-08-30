import com.helpers.constants.Constants;

public class Main {

    public static void main(String... args){

        Browser browser =  new Browser(Constants.DRIVER_CHROME);
        browser.getDriver().get("https://www.google.com/");
    }
}
