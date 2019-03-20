package Singleton;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import static io.github.bonigarcia.wdm.DriverManagerType.*;

public class LazySingleton {

    private static LazySingleton webDriver;
    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (webDriver == null) {
            webDriver = new LazySingleton();
        }
        return webDriver;
    }

    public void getChromeDriver() {
        WebDriverManager.getInstance(CHROME).setup();
    }


    public void closeBrouser(WebDriver webDriver) {
        if (webDriver != null) webDriver.quit();
    }
}
