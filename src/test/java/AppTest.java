import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

public class AppTest {

    public static void main( String[] args ) throws Exception
    {
        WebDriverManager.chromedriver().setup();

        DriverPoolHolder.getDriver("chrome").get("https://google.com");

        DriverPoolHolder.getDriver("OTHER").get("https://ua.fm");

        String title = DriverPoolHolder.getDriver("OTHER").getTitle();
        DriverPoolHolder.getDriver("OTHER").findElement(By.xpath("/html/body/div/div[5]/center/a/font")).click();

        System.out.println(title);

        DriverPoolHolder.resetSession("chrome");

        System.out.println( "Hello World!" );
    }

}
