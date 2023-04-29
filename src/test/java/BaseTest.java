
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
public class BaseTest {
    public static void main(String[] args) throws MalformedURLException {

        ChromeOptions options = new ChromeOptions();

        options.setCapability("browserVersion", "93.0");

        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.2.133:5555."), options);
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
    }
    protected WebDriver driver;

    public BaseTest() throws MalformedURLException {
    }

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
