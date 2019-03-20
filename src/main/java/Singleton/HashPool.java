package Singleton;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

        public class HashPool {
        private static WebDriver chromeInstance;
        private static WebDriver mfInstance;
        private static HashMap<String, WebDriver> Session = new HashMap<String, WebDriver>();

        public synchronized static WebDriver getDriver(String expectedDriverName) throws Exception {
            WebDriver result = null;

            if (expectedDriverName.equalsIgnoreCase("CHROME")) {
                if (chromeInstance == null) {
                    WebDriverManager.chromedriver().version("73").setup();
                    chromeInstance = new ChromeDriver();
                }
                result = chromeInstance;
            } else if (expectedDriverName.equalsIgnoreCase("MF")) {
                if (mfInstance == null) {
                    WebDriverManager.firefoxdriver().arch32().setup();
                    mfInstance = new FirefoxDriver();
                }
                result = mfInstance;
            } else if (expectedDriverName.equalsIgnoreCase("OTHER")) {
                if (Session.get(expectedDriverName) == null) {


                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("start-maximized");
                    result = new ChromeDriver(options);
                }

                if (expectedDriverName.contains("slow")) {
                    result.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                    result.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
                    result.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
                }
                Session.put(expectedDriverName, result);
                result = Session.get(expectedDriverName);
            }
            else {
                throw new Exception("Unable to recognize expectedDriver's name " + expectedDriverName);
            }
            return result;
        }

        public static void resetSession (String expectedDriverName) throws Exception {
            if (expectedDriverName.equalsIgnoreCase("CHROME")) {
                if (chromeInstance != null) {
                    chromeInstance.quit();
                }

            } else if (expectedDriverName.equalsIgnoreCase("MF")) {
                if (mfInstance != null) {
                    mfInstance.quit();
                }
            } else {
                throw new Exception("Unable to recognize expectedDriver's name " + expectedDriverName);
            }
        }
    }
