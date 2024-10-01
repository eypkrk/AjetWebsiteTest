import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    WebDriver driver;
    firstTopButton firstTopButton;
    secondTopButton secondTopButton;
    ThirdTopButton thirdTopButton;
    LoginButton loginButton;

    @BeforeAll
    public static void seTup(){
        WebDriverManager.chromedriver();
    }

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        firstTopButton = new firstTopButton(driver);
        secondTopButton = new secondTopButton(driver);
        thirdTopButton = new ThirdTopButton(driver);
        loginButton = new LoginButton(driver);
    }

    //@AfterEach
    //public void teardown(){
    //    driver.quit();
    //}
}
