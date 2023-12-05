package php.comdemoindex.tutorialsninja.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import php.comdemoindex.tutorialsninja.utilities.Utility;

import java.util.List;

public class DesktopsPage extends Utility {

    // * 1.3	Select Sort By position "Name: Z to A"
    By allProductOnPage = By.tagName("h4");

    public List<WebElement> getAllProductTitleOnPage() {
        List<WebElement> products = findElementsList(allProductOnPage);
        return products;
    }

    By sortByFilter = By.xpath("//select[@id='input-sort']");

    public void sortByFilterOption(String options) {
        selectVisibleTextFromDropDown(sortByFilter, options);
    }

    //****************************************   DesktopsTest   ********************************************************
    // * 2.6	Select product “HP LP3065”
    By HPLP3065ProductName = By.xpath("//a[normalize-space()='HP LP3065']");

    public void clickOnHPLP3065Product() {
        clickOnElement(HPLP3065ProductName);
    }

    By welcomeText = By.tagName("h2");

    public String getWelcomeText() {
        return getTextFromElement(welcomeText);
    }
}
