import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Singleton.LazySingleton;

public class Main{

    public static void main(String[] args) throws Exception {

        LazySingleton.getInstance().getChromeDriver();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com.ua/");

        Thread.sleep(3000);

        LazySingleton.getInstance().closeBrouser(driver);

    }

}