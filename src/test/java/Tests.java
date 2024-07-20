import Pages.BasePage;
import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

public class Tests {

    WebDriver driver;
    BasePage basePage;
    HomePage homePage;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.getProperty("baseUrl"));
        basePage = new BasePage(driver);
        homePage = new HomePage(driver);
    }

    @Test
    public void loginTest(){

        //Benutzername eingeben:
        homePage.benutzernameEingeben(ConfigurationReader.getProperty("Benutzername"));

        //Passwort eingeben:
        homePage.passwortEingeben(ConfigurationReader.getProperty("Passwort"));

        //Einloggen:
        homePage.einloggen();
    }

}
