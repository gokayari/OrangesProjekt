package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static final Properties properties = new Properties();

    static {

        try {
            FileInputStream file = new FileInputStream("configuration.properties");
            properties.load(file);
            file.close();

        } catch (IOException e) {
            System.out.println("Die Datei wurde in der Klasse ConfigurationReader nicht gefunden!");
            e.printStackTrace();
        }
    }

    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }

}
