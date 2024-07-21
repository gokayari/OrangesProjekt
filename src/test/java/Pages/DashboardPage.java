package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class DashboardPage extends BasePage{

    By dashboardLocator = By.cssSelector(".oxd-text--h6");


    public DashboardPage(WebDriver driver) {
        super(driver);
    }


    public void einloggenÜberprüfen (String dashboard){
        wait.until(ExpectedConditions.presenceOfElementLocated(dashboardLocator));
        WebElement Erfolgsnachricht = driver.findElement(dashboardLocator);
        String dashboardText = Erfolgsnachricht.getText();
        System.out.println(dashboardText);
        Assert.assertEquals(dashboardText, dashboard);
    }
}
