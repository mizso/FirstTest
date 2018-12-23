package seleniumtest;

import environment.EnvironmentManager;
import org.junit.*;
import pageobject.HomePage;

public class HomePageTests {
    @Before
    public void startBrowser() {
        EnvironmentManager.initDriver();
    }

    @Test
    public void demo() {
        HomePage homePage = new HomePage();
        homePage.navigateToHomePage();

        if(homePage.newUserCouponPopupIsDisplayed()){
            System.out.println("New user popup is opened");
            homePage.closeUserCouponPopup();
        }

        Assert.assertTrue(homePage.siteLogoIsDisplayed());
    }

    @After
    public void tearDown() {
        EnvironmentManager.shutDownDriver();
    }
}
