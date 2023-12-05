package php.comdemoindex.tutorialsninja.testsuite;

import org.testng.Assert;
import org.testng.annotations.Test;
import php.comdemoindex.tutorialsninja.pages.*;
import php.comdemoindex.tutorialsninja.testbase.BaseTest;

/**
 * Create the class LaptopsAndNotebooksTest Write the following test
 * 1. Test name verifyProductsPriceDisplayHighToLowSuccessfully()
 * 1.1	Mouse hover on Laptops & Notebooks Tab.and click
 * 1.2	Click on “Show All Laptops & Notebooks”
 * 1.3	Select Sort By "Price (High > Low)"
 * 1.4	Verify the Product price will arrange in High to Low order.
 * 2. Test name verifyThatUserPlaceOrderSuccessfully()
 * 2.1	Mouse hover on Laptops & Notebooks Tab and click
 * 2.2	Click on “Show All Laptops & Notebooks”
 * 2.3	Select Sort By "Price (High > Low)"
 * 2.4	Select Product “MacBook”
 * 2.5	Verify the text “MacBook”
 * 2.6	Click on ‘Add To Cart’ button
 * 2.7	Verify the message “Success: You have added MacBook to your shopping cart!”
 * 2.8	Click on link “shopping cart” display into success message
 * 2.9	Verify the text "Shopping Cart"
 * 2.10	Verify the Product name "MacBook"
 * 2.11	Change Quantity "2"
 * 2.12	Click on “Update” Tab
 * Success: You have modified your shopping cart!
 * 2.13	Verify the message “”
 * 2.14	Verify the Total £737.45
 * 2.15	Click on “Checkout” button
 * 2.16	Verify the text “Checkout”
 * 2.17	Verify the Text “New Customer”
 * 2.18	Click on “Guest Checkout” radio button
 * 2.19	Click on “Continue” tab
 * 2.20	Fill the mandatory fields
 * 2.21	Click on “Continue” Button
 * 2.22	Add Comments About your order into text area
 * 2.23	Check the Terms & Conditions check box
 * 2.24	Click on “Continue” button
 * 2.25	Verify the message “Warning: Payment method required!”
 */
public class LaptopsAndNoteBooksTest extends BaseTest {
    Homepage homepage = new Homepage();
    LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    MacBookPage macBookPage = new MacBookPage();
    CheckOutPage checkOutPage = new CheckOutPage();

    //* 1. Test name verifyProductsPriceDisplayHighToLowSuccessfully()
    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {

        // * 1.1	Mouse hover on Laptops & Notebooks Tab.and click
        homepage.mouseHoverOnLaptopsAndNotebooksMenu();

        // * 1.2	Click on “Show All Laptops & Notebooks”
        homepage.selectMenu("Show AllLaptops & Notebooks");

        // * 1.3	Select Sort By "Price (High > Low)"
        laptopsAndNotebooksPage.selectSortByPriceHighToLow("Price (High > Low)");

        // * 1.4	Verify the Product price will arrange in High to Low order.
        String actualPrice = laptopsAndNotebooksPage.verifyProductPriceArrangeInHighToLow();
        String expectedPrice = "$2,000.00";
        String expectedMessage = expectedPrice + "\n" +
                "Ex Tax:" + expectedPrice;
        Assert.assertEquals(actualPrice, expectedMessage, "Incorrect price  order!");
    }

    @Test
    // * 2. Test name verifyThatUserPlaceOrderSuccessfully()
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        // 	Mouse hover on Currency Dropdown and click
        Thread.sleep(2000);
        homepage.mouseHoverAndClickOnCurrencyDroDownMenu();

        // 	Mouse hover on £Pound Sterling and click
        Thread.sleep(3000);
        homepage.selectOnSterlingPoundCurrency();

        // * 2.1	Mouse hover on Laptops & Notebooks Tab and click
        homepage.mouseHoverOnLaptopsAndNotebooksMenu();

        // * 2.2	Click on “Show All Laptops & Notebooks”
        homepage.selectMenu("Show AllLaptops & Notebooks");

        // * 2.3	Select Sort By "Price (High > Low)"
        laptopsAndNotebooksPage.selectSortByPriceHighToLow("Price (High > Low)");

        // * 2.4	Select Product “MacBook”
        laptopsAndNotebooksPage.selectMacBookProduct();

        // * 2.5	Verify the text “MacBook”
        String actualText = macBookPage.verifyTheTextMacBook();
        String expectedText = "MacBook";
        Assert.assertEquals(actualText, expectedText, "Incorrect Product Text displayed!");

        // * 2.6	Click on ‘Add To Cart’ button
        macBookPage.clickOnAddToCart();

        // * 2.7	Verify the message “Success: You have added MacBook to your shopping cart!”
        String actualSuccessMessage = macBookPage.verifySuccessMessageForAddingProductToShoppingCart();
        String expectedSuccessMessage = "Success: You have added MacBook to your shopping cart!\n×";
        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage, "Invalid Success Message!");

        // * 2.8	Click on link “shopping cart” display into success message
        macBookPage.clickOnLinkToShoppingCartMessage();


        // * 2.9	Verify the text "Shopping Cart"
        Thread.sleep(2000);
        String actualCartText = shoppingCartPage.verifyTextForShoppingCart();
        String expectedCartText = "Shopping Cart  (0.00kg)";
        Assert.assertEquals(actualCartText, expectedCartText, "Incorrect Shopping Cart Message displayed!");

        // * 2.10	Verify the Product name "MacBook"
        String actualProductName = shoppingCartPage.verifyProductNameIsMacBook();
        String expectedProductName = "MacBook";
        Assert.assertEquals(actualProductName, expectedProductName, "Incorrect product Name displayed!");

        // * 2.11	Change Quantity "2"
        Thread.sleep(2000);
        shoppingCartPage.clearTheQtyBox();
        Thread.sleep(2000);
        shoppingCartPage.enterQuantityIntoTheBox("2");

        // * 2.12	Click on “Update” Tab
        shoppingCartPage.clickOnUpdateTheQuantityBox();
        Thread.sleep(2000);
        // * 2.13	Verify the message “Success: You have modified your shopping cart!”
        String actualUpdatedMessage = shoppingCartPage.verifyUpdatedSuccessMessage();
        String expectedUpdatedMessage = "Success: You have modified your shopping cart!\n×";
        Assert.assertEquals(actualUpdatedMessage, expectedUpdatedMessage, "Incorrect updated message displayed!");

        // * 2.14	Verify the Total £737.45
        Thread.sleep(2000);
        String actualTotalPrice = shoppingCartPage.verifyTotalPrice();
        String expectedTotalPrice = "£737.45";
        Assert.assertEquals(actualTotalPrice, expectedTotalPrice, "Incorrect total price displayed!");

        // * 2.15	Click on “Checkout” button
        Thread.sleep(2000);
        shoppingCartPage.clickOnCheckOutButton();

        // * 2.16	Verify the text “Checkout”
        Thread.sleep(2000);
        String actualCheckOutText = checkOutPage.verifyCheckOutText();
        String expectedCheckOutText = "Checkout";
        Assert.assertEquals(actualCheckOutText, expectedCheckOutText, "Incorrect checkout text displayed!");


        // * 2.17	Verify the Text “New Customer”
        Thread.sleep(2000);
        String actualNewCustomerText = checkOutPage.verifyTextNewCustomer();
        String expectedNewCustomerText = "New Customer";
        Assert.assertEquals(actualNewCustomerText, expectedNewCustomerText, "Incorrect new customer text displayed!");
        // * 2.18	Click on “Guest Checkout” radio button
        checkOutPage.clickOnGuestCheckOutButton();

        // * 2.19	Click on “Continue” tab
        checkOutPage.clickOnContinueButtonTab();

        // * 2.20	Fill the mandatory fields
        checkOutPage.enterFirstNameIntoTheFirstNameField("Robert");
        checkOutPage.enterLastNameIntoTheLastNameField("Jackson");
        checkOutPage.enterEmailIntoTheEmailField("robert_jackson@gmail.com");
        checkOutPage.enterTelephoneIntoTheTelephoneField("07865325614");
        checkOutPage.enterAddressIntoTheAddress1Field("Harry Porter Road");
        checkOutPage.enterCityIntoTheCityField("London");
        checkOutPage.enterPostcodeIntoThePostCodeField("HP4 2PH");
        checkOutPage.enterCountryIntoTheCountryField("United Kingdom");
        checkOutPage.enterZoneIntoTheZoneField("Derbyshire");


        // * 2.21	Click on “Continue” Button
        checkOutPage.clickOnContinueButtonForGuest();

        // * 2.22	Add Comments About your order into text area
        checkOutPage.addCommentsAboutYourOrderIntoTheTextArea("Leave it by door please");

        // * 2.23	Check the Terms & Conditions check box
        checkOutPage.clickOnCheckBoxForTermsAndConditions();

        // * 2.24	Click on “Continue” button
        checkOutPage.clickOnContinueButtonForPaymentMethod();

        // * 2.25	Verify the message “Warning: Payment method required!”
        String actualWarningText = checkOutPage.verifyWarningMessageForPaymentMethod();
        String expectedWarningText = "Warning: Payment method required!\n×";
        Assert.assertEquals(actualWarningText, expectedWarningText, "Incorrect warning message displayed!");
    }
}
