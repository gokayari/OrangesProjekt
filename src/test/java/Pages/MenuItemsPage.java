package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class MenuItemsPage extends BasePage{

    By seitentitelLocator = By.cssSelector(".oxd-text--h6");


    public MenuItemsPage(WebDriver driver) {
        super(driver);
    }


    public void einloggenÜberprüfen (String erwarteterSeitenname){
        wait.until(ExpectedConditions.presenceOfElementLocated(seitentitelLocator));
        WebElement Seitentitel = driver.findElement(seitentitelLocator);
        String seitentitelText = Seitentitel.getText();
        System.out.println("Der Überprüfungstext: " + seitentitelText);
        System.out.println("Der Erwartete Seitenname: " + erwarteterSeitenname);
        Assert.assertEquals(seitentitelText, erwarteterSeitenname);
    }

    public void menüpunkteÜberprüfen() {
        wait.until(ExpectedConditions.presenceOfElementLocated(seitentitelLocator));
        int anzahlDerPunkten = 5;

        for (int i = 1; i <= anzahlDerPunkten; i++) {
            // um Dynamischen Locator zu erstellen:
            By menüpunktLocator = By.xpath("//li[@class='oxd-main-menu-item-wrapper']["+i+"]");


            WebElement Menüpunkt = driver.findElement(menüpunktLocator);
            String menüpunktname = Menüpunkt.getText();
            System.out.println("Der Titel-" + i + " ist: " + menüpunktname);
            Menüpunkt.click();
            //wait.until(ExpectedConditions.presenceOfElementLocated(seitentitelLocator));//>>>(1) funktioniert nicht!
            //wait.until(ExpectedConditions.elementToBeSelected(Menüpunkt));//>>>(2) funktioniert nicht!
            //waitForPageToLoad();//>>>(3) funktioniert nicht!
            wait.until(ExpectedConditions.textToBePresentInElementLocated(seitentitelLocator, menüpunktname));


            //(4) Es funktioniert, aber die Verwendung von Thread.sleep() in automatisierten Tests
                //wird allgemein als unprofessionell angesehen,
                //da sie die Effizienz und Zuverlässigkeit der Tests beeinträchtigen kann.
/*
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
 */


            String seitentitelText = driver.findElement(seitentitelLocator).getText();
            System.out.println("Der Titel der Seite-"+i+" ist: " + seitentitelText);

            Assert.assertTrue(seitentitelText.contains(menüpunktname), "Die Titel von Menüpunkten und Seiten stimmen nicht überein!");
        }
    }

    /*
    //(3) die 'waitForPageToLoad' Methode mit JavaScript-Executor:
    public void waitForPageToLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
     */

}
