package php.comdemoindex.tutorialsninja.testsuite;

import org.testng.Assert;
import org.testng.annotations.Test;
import php.comdemoindex.tutorialsninja.pages.Homepage;
import php.comdemoindex.tutorialsninja.testbase.BaseTest;

/**
 * 1.	create class "TopMenuTest"
 * 1.1	create method with name "selectMenu" it has one parameter name "menu" of type string
 * 1.2	This method should click on the menu whatever name is passed as parameter.
 * Write the following Test:
 * 1. verifyUserShouldNavigateToDesktopsPageSuccessfully()
 * 1.1	Mouse hover on “Desktops” Tab and click
 * 1.2	call selectMenu method and pass the menu = “Show All Desktops”
 * 1.3	Verify the text ‘Desktops’
 * 2.	verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()
 * 2.1	Mouse hover on “Laptops & Notebooks” Tab and click
 * 2.2	call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
 * 2.3	Verify the text ‘Laptops & Notebooks’
 * 3.	verifyUserShouldNavigateToComponentsPageSuccessfully()
 * 3.1	Mouse hover on “Components” Tab and click
 * 3.2	call selectMenu method and pass the menu = “Show All Components”
 * 3.3	Verify the text ‘Components’
 */
public class TopMenuTest extends BaseTest {
    Homepage homepage = new Homepage();


    @Test
    // * 1. verifyUserShouldNavigateToDesktopsPageSuccessfully()
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {

        // * 1.1	Mouse hover on “Desktops” Tab and click
        Thread.sleep(2000);
        homepage.mouseHoverOnDesktopMenu();

        // * 1.2	call selectMenu method and pass the menu = “Show All Desktops”
        homepage.selectMenu("Show AllDesktops");
        Thread.sleep(2000);

        // * 1.3	Verify the text ‘Desktops’
        String actualDesktopsText = homepage.verifyTheTextDesktops();
        String expectedDesktopsText = "Show AllDesktops";
        Assert.assertEquals(actualDesktopsText, expectedDesktopsText, "Invalid Desktops text displayed!");
    }

    @Test
    // 2. verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() throws InterruptedException {

        // * 2.1	Mouse hover on “Laptops & Notebooks” Tab and click
        Thread.sleep(2000);
        homepage.mouseHoverOnLaptopsAndNotebooksMenu();

        // * 2.2	call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        Thread.sleep(2000);
        homepage.selectMenu("Show AllLaptops & Notebooks");

        // * 2.3	Verify the text ‘Laptops & Notebooks’
        String actualLaptopsAndNotebooksText = homepage.verifyTextForLaptopsAndNotebooks();
        String expectedLaptopsAndNotebooksText = "Show AllLaptops & Notebooks";
        Assert.assertEquals(actualLaptopsAndNotebooksText, expectedLaptopsAndNotebooksText,
                "Invalid laptops and notebooks text displayed!");
    }

    @Test
    //3.	verifyUserShouldNavigateToComponentsPageSuccessfully()
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() throws InterruptedException {
        // * 3.1	Mouse hover on “Components” Tab and click
        Thread.sleep(2000);
        homepage.mouseHoverOnComponentsMenu();

        // * 3.2	call selectMenu method and pass the menu = “Show All Components”
        Thread.sleep(2000);
        homepage.selectMenu("Show AllComponents");

        // * 3.3	Verify the text ‘Components’
        String actualComponentsText = homepage.verifyTextForComponents();
        String expectedComponentsText = "Components";
        Assert.assertEquals(actualComponentsText, expectedComponentsText, "Invalid components text displayed!");
    }
}
