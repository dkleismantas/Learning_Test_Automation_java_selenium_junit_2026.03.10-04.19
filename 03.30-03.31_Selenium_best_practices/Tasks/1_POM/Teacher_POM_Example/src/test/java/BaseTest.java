import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v143.network.Network;
import org.openqa.selenium.devtools.v143.network.model.ConnectionType;

import java.util.Optional;

public class BaseTest {
    WebDriver driver;

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless=new", "--window-size=1920,1080");
        options.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(options);


        DevTools devTools = ((HasDevTools) driver).getDevTools();
        devTools.createSession();

        devTools.send(Network.emulateNetworkConditions(
                false,                              // offline
                50,                                 // latency ms
                100_000,                            // download bytes/sec
                50_000,                             // upload bytes/sec
                Optional.of(ConnectionType.CELLULAR2G),  // connectionType
                Optional.empty(),                   // packetLoss
                Optional.empty(),                   // packetQueueLength
                Optional.empty()                    // packetReordering
        ));


        driver.get("https://opencart.abstracta.us/");
        System.out.println("");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
