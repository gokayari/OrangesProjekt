import Pages.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.ConfigurationReader;

import java.io.File;
import java.io.IOException;

public class Tests {

    private WebDriver driver;
    private HomePage homePage;
    private MenuItemsPage menuItemsPage;

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
        RecruitmentPage recruitmentPage = new RecruitmentPage(driver);

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
        DashboardPage dashboardPage = new DashboardPage(driver);

        //Prüfen, ob die Funktion "Quick Launch" im Dashboard-Bereich funktioniert:
        dashboardPage.quickLaunchÜberprüfen();

    }


    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            // Screenshot bei Fehler erstellen
            takeScreenshot(result.getName());
        }
        driver.quit();
    }

    @AfterClass
    public void tearDownClass() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Methode, um einen Screenshot zu erstellen
    private void takeScreenshot(String testName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("screenshots/" + testName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
