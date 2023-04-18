package fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class AppManager {

    String browser;
    WebDriver driver;

    Logger logger = LoggerFactory.getLogger(AppManager.class);

    ChooseHelper choose;
    ItemHelper item;

    public AppManager(String browser) {
        this.browser = browser;
    }

    public ChooseHelper getChoose() {
        return choose;
    }

    public ItemHelper getItem() {
        return item;
    }

    public void init() {
        System.err.close();

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("remote-allow-origins=*");
            driver = new ChromeDriver(options);
            logger.info("Test starts in Chrome Browser");

        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            logger.info("Test starts in Firefox Browser");

        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("remote-allow-origins=*");
            driver = new EdgeDriver(options);
            logger.info("Test starts in Edge Browser");
        }

        WebDriverListener listener = new MyListener();
        driver = new EventFiringDecorator<>(listener).decorate(driver);

        driver.get("https://www.ebay.de");
        logger.info("Current url --> " + driver.getCurrentUrl());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        choose = new ChooseHelper(driver);
        item = new ItemHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

}
