package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataUtil {
    private static final String Test_Data_Path = "src/test/resources/TestData/";

    public static String getPropertyValue(String fileName, String key) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(Test_Data_Path + fileName + ".properties"));
        return properties.getProperty(key);

    }
}
