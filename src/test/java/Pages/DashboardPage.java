package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class DashboardPage extends BasePage{

    By dashboardTitel = By.cssSelector(".oxd-text--h6");
    By assignLeaveQLTaste = By.cssSelector(".oxd-icon-button[title='Assign Leave'] > .oxd-icon");
    By assignLeaveQuickLaunch = By.xpath("//p[.='Assign Leave']");
    By assignLeaveTitel = By.cssSelector(".orangehrm-main-title");



    public DashboardPage(WebDriver driver) {
        super(driver);
    }


    public void quickLaunchÜberprüfen (){
        wait.until(ExpectedConditions.presenceOfElementLocated(dashboardTitel));
        String assignLeaveQLText = driver.findElement(assignLeaveQuickLaunch).getText();
        System.out.println(assignLeaveQLText);
        driver.findElement(assignLeaveQLTaste).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(assignLeaveTitel));
        String assignLeaveTitelText = driver.findElement(assignLeaveTitel).getText();
        System.out.println(assignLeaveTitelText);

        Assert.assertEquals(assignLeaveQLText, assignLeaveTitelText);
    }
}
