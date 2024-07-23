import Pages.BasePage;
import Pages.HomePage;
import Pages.MenuItemsPage;
import Pages.RecruitmentPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

public class Tests {

    WebDriver driver;
    BasePage basePage;
    HomePage homePage;
    MenuItemsPage menuItemsPage;
    RecruitmentPage recruitmentPage;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.getProperty("baseUrl"));
        basePage = new BasePage(driver);
        homePage = new HomePage(driver);
        menuItemsPage = new MenuItemsPage(driver);
    }

    @Test(priority = 0)
    public void loginTest() {

        //Benutzername eingeben:
        homePage.benutzernameEingeben(ConfigurationReader.getProperty("Benutzername"));

        //Passwort eingeben:
        homePage.passwortEingeben(ConfigurationReader.getProperty("Passwort"));

        //Einloggen:
        homePage.einloggen();

        //Prüfen, ob Einloggen erfolgreich war:
        menuItemsPage.einloggenÜberprüfen(ConfigurationReader.getProperty("Überprüfungstext"));
    }

    @Test(priority = 1)
    public void menüpunkteTest(){

        //Benutzername eingeben:
        homePage.benutzernameEingeben(ConfigurationReader.getProperty("Benutzername"));

        //Passwort eingeben:
        homePage.passwortEingeben(ConfigurationReader.getProperty("Passwort"));

        //Einloggen:
        homePage.einloggen();

        //Prüfen, ob andere Menüpunkte geöffnet werden können:
        menuItemsPage.menüpunkteÜberprüfen();

    }

    @Test(priority = 2)
    public void funktionTest(){
        recruitmentPage = new RecruitmentPage(driver);

        //Benutzername eingeben:
        homePage.benutzernameEingeben(ConfigurationReader.getProperty("Benutzername"));

        //Passwort eingeben:
        homePage.passwortEingeben(ConfigurationReader.getProperty("Passwort"));

        //Einloggen:
        homePage.einloggen();

        //Eingabe von Kandidatendaten:
        recruitmentPage.eingabeVonKandidatendaten(ConfigurationReader.getProperty("Vorname"),
                ConfigurationReader.getProperty("Nachname"),
                ConfigurationReader.getProperty("Stellenausschreibung"),
                ConfigurationReader.getProperty("E-Mail"),
                ConfigurationReader.getProperty("Telefonnumer"),
                ConfigurationReader.getProperty("Tag"),
                ConfigurationReader.getProperty("Monat"),
                ConfigurationReader.getProperty("Jahr"));

        //Prüfen, ob der/die Kandidat/Kandidatin gespeichert wurde:
        recruitmentPage.kandidatencheck(ConfigurationReader.getProperty("Vorname"),
                ConfigurationReader.getProperty("Nachname"));
    }


    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @AfterClass
    public void tearDownClass() {
        driver.quit();
    }

}
