package org.training.wikia.reader;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class contains methods to read the values from properties file.
 * Created by Ganesh on 8/23/15.
 */
public class Reader {


    public static String getValueOfKey(String key) {
        FileInputStream fileInputStream;
        Properties properties = null;

        try {
            fileInputStream = new FileInputStream(System.getProperty("user.dir") + "//config.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties.getProperty(key);

    }

}


