package com.selenium.framework;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;



public class Base {


    public static WebDriver driver;
    public Properties prop;

    public WebDriver intializeDriver() throws IOException {

        prop = new Properties();
        File fis = new File("./src/main/Resources/data.properties");

        FileInputStream file = new FileInputStream(fis);

        prop.load(file);

        String browserName = prop.getProperty("browser");

        if(browserName.equalsIgnoreCase("chrome")){

            System.setProperty(prop.getProperty("chromeDriver"),prop.getProperty("chromeDriverPath") );

            driver = new ChromeDriver();

            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
        }
        else
            if(browserName.equalsIgnoreCase("firefox")){

            //Fire Fox -- Update
        }
        else
            if(browserName.equalsIgnoreCase("ie")){

            //IE -- Update
        }

        // Wait For Failure to be Happen after 10 Secs*********************

        driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("waitTime")),TimeUnit.SECONDS);



        return driver;

    }


    public  void getScreenShot() throws IOException {

       File  src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(src,new File("./test-output/screenshots/screen"+timestamp()+".png"));
    }

    public String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }
}
