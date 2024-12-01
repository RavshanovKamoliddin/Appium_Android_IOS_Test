package base;

import com.google.common.collect.ImmutableBiMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    public AndroidDriver driver;
    //public AppiumDriverLocalService service;

    @BeforeClass
    public void ConfigureAppium () throws MalformedURLException {

        /* //Correct Appium path local appium server
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:/Users/kamoliddin/AppData/Roaming/npm/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        service.start(); */


        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("SKEAONE6PV9LFYJN"); // Qurilma ID
        //options.setApp("src/main/resources/ApiDemos-debug.apk");
        options.setPlatformName("Android");
        options.setAutomationName("UIAutomator2");
        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity(".ApiDemos");


        /* Driver url local
        driver = new AndroidDriver( new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); */

        // Driver URL Remote
        String remoteAppiumServerURL = "http://127.0.0.1:4723/wd/hub";
        driver = new AndroidDriver(new URL(remoteAppiumServerURL), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public void LongPressAction(WebElement ele) {

        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
                ImmutableBiMap.of("elementId",((RemoteWebElement)ele).getId(),
                        "duration",2000));
    }


    @AfterClass
    public void tearDown () {
        driver.quit();
        //service.stop();
    }
}
