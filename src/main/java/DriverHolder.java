import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverHolder {
    // Lazy, ThreadSafe
    private static WebDriver storedDriver;

    public synchronized static WebDriver getDriver() {
        if (storedDriver == null) {
            WebDriverManager.chromedriver().setup();
            storedDriver = new ChromeDriver();

        }
        return storedDriver;
    }

    /* Lazy, not ThreadSafe
    private static WebDriver storedDriver;

    public static WebDriver getDriver() {
        if (storedDriver ==null) {
            WebDriverManager.chromedriver().setup();
            storedDriver = new ChromeDriver();

        }
        return storedDriver;
    }
*/

    /* not Lazy, not ThreadSafe
    private static WebDriver storedDriver =  new ChromeDriver();

    public static WebDriver getDriver() {
        return storedDriver;
    }

    public static void resetSession() {
        storedDriver.quit();
        storedDriver = null;
    }


    private static WebDriver storedDriver = new ChromeDriver() {
        public static WebDriver getDriver() {
            return storedDriver;
        }
*/
        public static void resetSession() {
            storedDriver.quit();
            storedDriver = null;
        }
}

