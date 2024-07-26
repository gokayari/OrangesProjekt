import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utilities.ConfigurationReader;

public class Tests {

    WebDriver driver;
    HomePage homePage;
    MenuItemsPage menuItemsPage;
    RecruitmentPage recruitmentPage;
    DashboardPage dashboardPage;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.getProperty("baseUrl"));
        homePage = new HomePage(driver);
        menuItemsPage = new MenuItemsPage(driver);
        login();
    }
    public void login(){
        //Benutzername eingeben:
        homePage.benutzernameEingeben(ConfigurationReader.getProperty("Benutzername"));
        //Passwort eingeben:
        homePage.passwortEingeben(ConfigurationReader.getProperty("Passwort"));
        //Einloggen:
        homePage.einloggen();
    }

    @Test(priority = 0)
    public void loginTest() {

        //Prüfen, ob Einloggen erfolgreich war:
        menuItemsPage.einloggenÜberprüfen(ConfigurationReader.getProperty("Überprüfungstext"));
    }

    @Test(priority = 1)
    public void menüpunkteTest(){

        //Prüfen, ob andere Menüpunkte geöffnet werden können:
        menuItemsPage.menüpunkteÜberprüfen();

    }

    @Test(priority = 2)
    public void funktionTest1(){
        recruitmentPage = new RecruitmentPage(driver);

        //Erstellen eines neuen Kandidaten im Recruitment-Bereich
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

    @Test (priority = 2)
    public void funktionTest2(){
        dashboardPage = new DashboardPage(driver);

        //Prüfen, ob die Funktion "Quick Launch" im Dashboard-Bereich funktioniert:
        dashboardPage.quickLaunchÜberprüfen();

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
