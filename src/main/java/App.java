import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws Exception
    {
        DriverPoolHolder.getDriver("Chrome").get("https://google.com");
        DriverPoolHolder.getDriver("MF").get ("http://google.com");
        DriverPoolHolder.getDriver("OTHER").get ("http://google.com");

        System.out.println(DriverPoolHolder.getDriver("Chrome").getTitle());
        DriverPoolHolder.resetSession("chrome");
        System.out.println(DriverPoolHolder.getDriver("MF").getTitle());
        DriverPoolHolder.resetSession("MF");
        System.out.println(DriverPoolHolder.getDriver("OTHER").getTitle());
        DriverPoolHolder.resetSession("OTHER");
        System.out.println( "Hello World!" );

    }
}