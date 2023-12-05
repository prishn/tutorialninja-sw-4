package php.comdemoindex.tutorialsninja.testbase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import php.comdemoindex.tutorialsninja.propertyreader.PropertyReader;
import php.comdemoindex.tutorialsninja.utilities.Utility;

public class BaseTest extends Utility {
    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod
    public void setUp() {
        selectBrowser(browser);

    }

    @AfterMethod
    public void tearDown() {

        closeBrowser();
    }

}
