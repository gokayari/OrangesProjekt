# OrangesProjekt

Bei diesem Projekt handelt es sich um ein Java Selenium TestNG Automatisierungsframework, das für das Testen von Login und Funktionalitäten auf der OrangeHRM Open Source Website entwickelt wurde.

## Einleitung
Das **OrangesProjekt** ist eine Testautomatisierungssuite, die entwickelt wurde, um die Funktionalität und Zuverlässigkeit einiger Funktionen auf der OrangeHRM Open Source Website sicherzustellen. Das Projekt nutzt Java, Selenium WebDriver und TestNG, um Testszenarien zu automatisieren, die verschiedene Aspekte des Logins, der Auswahl von Menüpunkten, der Dateneingabe und der Ergebnisüberprüfung abdecken, und folgt dem Page Object Model (POM) Designmuster, um die Lesbarkeit, Wiederverwendbarkeit und Wartbarkeit des Codes zu verbessern.

### Schlüsselkomponenten:
- **Selenium WebDriver:** Ermöglicht automatische Interaktionen mit Webbrowsern, um Benutzeraktionen zu simulieren.
- **TestNG:** Ein Test-Framework für die Organisation und Ausführung von Testfällen, das Funktionen wie parallele Testausführung, datengesteuerte Tests und Berichterstellung bietet.
- **Page Object Model (POM):** Ein Entwurfsmuster, das verwendet wird, um Webseiten als Objekte darzustellen und ihr Verhalten und ihre Interaktionen in separaten Klassen zu kapseln.

### Ziele:
- Automatisierung des Testprozesses, um die Zuverlässigkeit und Stabilität der Funktionen der Open-Source-Website OrangeHRM zu gewährleisten.
- Bereitstellung eines skalierbaren und wartbaren Test-Frameworks, das zukünftige Änderungen und Ergänzungen aufnehmen kann.
- Verbesserung der Effizienz des Testprozesses durch parallele Ausführung und umfassende Berichterstattung.
- Förderung der Zusammenarbeit zwischen den Teammitgliedern durch Standardisierung der Organisation und Ausführung von Testfällen.


## Eigenschaften
- Einloggen und überprüfen, ob der Benutzer eingeloggt ist.
- Menüpunkte auswählen und überprüfen, ob sie ausgewählt wurden.
- Beispielkandidatendaten für die Rekrutierungsfunktion eingeben und speichern, und überprüfen, ob sie gespeichert wurden.
- Paginierung dynamisch handhaben, um die Ergebnisse über mehrere Seiten hinweg zu überprüfen.
- Assertions durchführen, um die Genauigkeit und Zuverlässigkeit von Testergebnissen zu gewährleisten.


## Installation
Um dieses Projekt lokal zu verwenden und die automatisierten Tests auszuführen, gehen Sie folgendermaßen vor:
### 1. Klonen des Repositorys
```bash
git clone https://github.com/gokayari/OrangesProjekt.git
```
### 2. Dependencies einrichten
- **Java Development Kit (JDK):** Installieren Sie JDK 8 oder höher von der offiziellen Oracle-Website oder Ihrem Paketmanager.
- **Maven:** Installieren Sie Maven zur Verwaltung von Projektabhängigkeiten und zur Build-Automatisierung. Sie können Maven von der offiziellen Apache Maven-Website herunterladen oder über einen Paketmanager installieren.
### 3. WebDriver konfigurieren
Laden Sie die entsprechende ausführbare WebDriver-Datei für Ihren bevorzugten Browser herunter (z. B. ChromeDriver für Google Chrome) und stellen Sie sicher, dass sie zu Ihrem Systempfad hinzugefügt wird.
### 4. Das Projekt erstellen
Navigieren Sie zum Projektverzeichnis und erstellen Sie das Projekt mit Maven:
```bash
cd OrangesProjekt
mvn clean install
```
### 5. Tests durchführen
Sie können nun die automatisierten Tests mit dem TestNG Test Runner ausführen. Führen Sie den folgenden Befehl aus, um alle Tests auszuführen:
```bash
mvn test
```

## Verwendung
Um die Testsuite auszuführen, gehen Sie wie folgt vor:
1. Öffnen Sie das Projekt in Ihrer bevorzugten Java-IDE.
2. Suchen Sie die Klasse **Tests** im Verzeichnis src/test/java.
3. Klicken Sie mit der rechten Maustaste auf die Klasse und wählen Sie „Run As“ > „TestNG Test“, um alle Testfälle auszuführen.
4. Alternativ können Sie auch einzelne Testmethoden ausführen, indem Sie mit der rechten Maustaste auf die Methode klicken und „Run“ wählen.

## License
_Dieses Projekt ist unter der **MIT-Lizenz** lizenziert. Sie sind berechtigt, diese Software zu verwenden, zu kopieren, zu ändern, zusammenzuführen, zu veröffentlichen, zu verbreiten und zu unterlizenzieren, vorausgesetzt, dass der ursprüngliche Urheberrechtshinweis und dieser Lizenzhinweis in allen Kopien oder wesentlichen Teilen der Software enthalten bleiben._
