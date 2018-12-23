package pageobject;

import environment.RunEnvironment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private static final String PageURL = "https://gearbest.com";

    private static final String newUserCouponLocator = "siteNewUser_coupon-bg";
    private static final String closeNewUserCouponLocator = "layui-layer-close2";
    private static final String siteLogoLocator = "siteLogo_adver";

    private WebDriver driver = RunEnvironment.getDriver();

    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = newUserCouponLocator)
    private WebElement newUserCoupon;

    @FindBy(className=closeNewUserCouponLocator)
    private WebElement closeNewUserCoupon;

    @FindBy(className=siteLogoLocator)
    private WebElement siteLogo;

    public void navigateToHomePage(){
        driver.get(PageURL);
    }

    public boolean newUserCouponPopupIsDisplayed(){
        return isElementPresent(By.className(newUserCouponLocator)) && newUserCoupon.isDisplayed();
    }

    public void closeUserCouponPopup(){
        closeNewUserCoupon.click();
        WebDriverWait wait = new WebDriverWait(driver, 5000); // 5 seconds timeout
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(newUserCouponLocator)));
    }

    public boolean siteLogoIsDisplayed(){
        return isElementPresent(By.className(siteLogoLocator)) && siteLogo.isDisplayed();
    }

    // TODO: Move to somewhere...
    private boolean isElementPresent(By selector){
        return driver.findElements(selector).size()>0;
    }
}