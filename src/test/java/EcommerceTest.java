import base.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class EcommerceTest extends BaseTest {


    @Test
    public void FillFrom() throws MalformedURLException, InterruptedException {


        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Kamoliddin");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.RadioButton[@text= 'Female']")).click();
        driver.findElement(By.id("android:id/text1")).click();
        /* country Uzbekistan */
//        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Uzbekistan\"));"));
//        driver.findElement(By.xpath("//android.widget.TextView[@text= 'Uzbekistan']")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text= 'Argentina']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(3000);

        /* Validation no send keys name
        String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast) [1]")).getAttribute("name");
        Assert.assertEquals(toastMessage,"Please enter your name"); */

    }
}
