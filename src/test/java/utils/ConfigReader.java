package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

public class ConfigReader {
    public static Properties properties;

    public static void initializeProperties(){

        try {
            //we are creating an object of FileReader and passing the path to it.
            //FileReader is a class in java which is used to read info from files
            //it throws and exception which is y we have to surround it with try/catch block
            FileReader fileReader = new FileReader("src/test/resources/config.properties");
            //here we are initializing our Properties object
            properties = new Properties();
            //here we are using the .load(fileReader) method in order to pass the file reader to the properties object
            properties.load(fileReader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getProperty(String key){
        //we are returning the value stored inside of the key passed as an argument to this method
        return properties.getProperty(key);
    }
}
