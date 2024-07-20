package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    By benutzernameBar = By.name("username");
    By passwortBar = By.name("password");
    By loginTaste = By.cssSelector(".oxd-button");


    public HomePage(WebDriver driver) {
        super(driver);
    }


    public void benutzernameEingeben (String benutzername){
        wait.until(ExpectedConditions.presenceOfElementLocated(benutzernameBar));
        driver.findElement(benutzernameBar).sendKeys(benutzername);
    }

    public void passwortEingeben (String passwort){
        driver.findElement(passwortBar).sendKeys(passwort);
    }

    public void einloggen (){
        driver.findElement(loginTaste).click();
    }

}
