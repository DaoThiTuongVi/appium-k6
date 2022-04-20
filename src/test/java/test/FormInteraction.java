package test;

import driver.DriverFactory;
import driver.Platform;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormInteraction {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.android);

        try{
            MobileElement navButtonLogin = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navButtonLogin.click();

            MobileElement textboxEmail = appiumDriver.findElement(MobileBy.AccessibilityId("input-email"));
            textboxEmail.sendKeys("vi@gmail.com");
            MobileElement textboxPassword = appiumDriver.findElement(MobileBy.AccessibilityId("input-password"));
            textboxPassword.sendKeys("12345678");

            MobileElement btnLogin = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));
            btnLogin.click();

            WebDriverWait wait = new WebDriverWait(appiumDriver, 5L);
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MobileBy.id("android:id/alertTitle")));
            MobileElement titleLoginSuccess = appiumDriver.findElement(MobileBy.id("android:id/alertTitle"));
            System.out.println(titleLoginSuccess.getText());


        }catch (Exception e){

        }finally {
            appiumDriver.quit();
        }
    }
}
