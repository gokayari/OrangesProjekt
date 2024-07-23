package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class RecruitmentPage extends BasePage{

    By addTaste = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
    By firstNameBar = By.name("firstName");
    By lastNameBar = By.name("lastName");
    By vacancyLocator = By.cssSelector(".oxd-select-text-input");
    By eMailBar = By.xpath("//form[@class='oxd-form']/div[3]/div[@class='oxd-grid-3 orangehrm-full-width-grid']/div[1]//input[@class='oxd-input oxd-input--active']");
    By contactNumberBar = By.xpath("//form[@class='oxd-form']//div[2]//div[2]/input[@class='oxd-input oxd-input--active']");
    By dateOfAppBar = By.cssSelector("[placeholder='yyyy-dd-mm']");
    By kalenderLocator = By.cssSelector(".oxd-calendar-wrapper");
    By monatLocator = By.xpath("//div[@class='oxd-calendar-selector-month-selected']");
    By jahrLocator = By.cssSelector(".oxd-calendar-selector-year .oxd-text");
    By saveTaste = By.cssSelector(".oxd-button--secondary");
    By applicationStageText = By.xpath("//h6[.='Application Stage']");
    By candidatesTaste = By.xpath("//a[.='Candidates']");
    By tableLocator = By.cssSelector(".orangehrm-container");
    By alleNamenLocator = By.xpath("//div[@class='oxd-table-body']//div[@class='oxd-table-row oxd-table-row--with-border']/div[3]");

    public RecruitmentPage(WebDriver driver) {
        super(driver);
    }


    public void eingabeVonKandidatendaten(String vorname, String nachname,
                                               String stellenausschreibung, String eMail,
                                               String telefonnumer, String tag, String monat, String jahr){
        wait.until(ExpectedConditions.presenceOfElementLocated(addTaste));
        driver.findElement(addTaste).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(firstNameBar));
        driver.findElement(firstNameBar).sendKeys(vorname);
        driver.findElement(lastNameBar).sendKeys(nachname);
        driver.findElement(vacancyLocator).click();
        By gewünschteStelle = By.xpath(".//div[.='"+stellenausschreibung+"']");
        driver.findElement(gewünschteStelle).click();

        driver.findElement(eMailBar).sendKeys(eMail);
        driver.findElement(contactNumberBar).sendKeys(telefonnumer);

        driver.findElement(dateOfAppBar).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(kalenderLocator));
        driver.findElement(monatLocator).click();
        By gewünschterMonat = By.cssSelector(".oxd-calendar-dropdown > li:nth-of-type("+monat+")");
        driver.findElement(gewünschterMonat).click();
        driver.findElement(jahrLocator).click();
        By gewünschtesJahr = By.xpath("//li[.='"+jahr+"']");
        driver.findElement(gewünschtesJahr).click();
        By gewünschterTag = By.xpath("//div["+tag+"]/div[@class='oxd-calendar-date']");
        driver.findElement(gewünschterTag).click();

        driver.findElement(saveTaste).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(applicationStageText));
    }

    public void kandidatencheck(String vorname, String nachname){

        driver.findElement(candidatesTaste).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(tableLocator));

        //um nach unten zur Tabelle zu blättern:
        WebElement KandidatenInfoTabelle = driver.findElement(tableLocator);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView()", KandidatenInfoTabelle);

        wait.until(ExpectedConditions.presenceOfElementLocated(alleNamenLocator));

        //um alle Kandidaten nacheinander in der Tabelle zu überprüfen:
        List<WebElement> dieNamen = driver.findElements(alleNamenLocator);
        String vollständigerName = vorname +" "+nachname;
        boolean nameGefunden = false;
        int index = 0;
        while(index < dieNamen.size() && !nameGefunden){
            WebElement derName = dieNamen.get(index);
            if (derName.getText().equals(vollständigerName)){
                nameGefunden = true;
                System.out.println(derName.getText());
            }
            index++;
        }

        // Überprüfen, ob der Name gefunden wurde:
        Assert.assertTrue(nameGefunden, "Der Name wurde in der Tabelle nicht gefunden!");

    }
}
