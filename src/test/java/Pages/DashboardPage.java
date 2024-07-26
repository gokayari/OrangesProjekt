package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class DashboardPage extends BasePage{

    By dashboardTitel = By.cssSelector(".oxd-text--h6");
    By assignLeaveQuickLaunch = By.cssSelector(".oxd-icon-button[title='Assign Leave'] > .oxd-icon");
    By assignLeaveButton = By.xpath("//a[.='Assign Leave']");


    public DashboardPage(WebDriver driver) {
        super(driver);
    }


    public void quickLaunchÜberprüfen (){
        wait.until(ExpectedConditions.presenceOfElementLocated(dashboardTitel));
        driver.findElement(assignLeaveQuickLaunch).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(assignLeaveButton));
        Assert.assertTrue(driver.findElement(assignLeaveButton).isSelected(), "Assign Leave ist nicht ausgewählt!");
    }
}
