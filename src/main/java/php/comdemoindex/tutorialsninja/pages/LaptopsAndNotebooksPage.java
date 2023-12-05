package php.comdemoindex.tutorialsninja.pages;

import org.openqa.selenium.By;
import php.comdemoindex.tutorialsninja.utilities.Utility;

public class LaptopsAndNotebooksPage extends Utility {

    // * 1.3	Select Sort By "Price (High > Low)"
    By sortByPriceHighToLow = By.xpath("(//select[@id='input-sort'])[1]");
    By arrayListOfProducts = By.xpath("//p[@class ='price']");

    public void selectSortByPriceHighToLow(String options) {
        selectVisibleTextFromDropDown(sortByPriceHighToLow, options);
        getArrayListOfProductsInChoice(arrayListOfProducts);

    }

    // * 1.4	Verify the Product price will arrange in High to Low order.
    public String verifyProductPriceArrangeInHighToLow() {
        return verifyTheProductArrangementInArrayList(arrayListOfProducts);
        // System.out.println("Product List after sortBy: " + getTextFromElement(arrayListOfProducts));
        //return getTextFromElement(arrayListOfProducts);
    }

    // * 2.4	Select Product “MacBook”
    By macBookSelection = By.xpath("//a[normalize-space()='MacBook']");

    public void selectMacBookProduct() {
        clickOnElement(macBookSelection);
    }
}
