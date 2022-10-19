package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties prop;

   /*This method is used to load the properties from the config.properties file
   * @return It returns Properties prop Object
   * */

    public Properties init_prop()
    {
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("src/test/java/config/config.properties");
            prop.load(ip);
        }
        catch (FileNotFoundException fileNotFoundException)
        {
            fileNotFoundException.printStackTrace();
        }

        catch (IOException ioException)
        {
            ioException.printStackTrace();
        }

        return prop;
    }
}
