package PageObject

import PageObject.Modules.SampleModules
import io.appium.java_client.AppiumSetting
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.remote.MobileCapabilityType
import org.junit.AfterClass
import org.junit.BeforeClass
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.LocalFileDetector

import java.util.concurrent.TimeUnit


/**
 * Created by latifah on 6/10/2015.
 */
class Initializations {
    static def WebDriver driver

    static WebDriver createAppiumInstance() {
        DesiredCapabilities capabilities = new DesiredCapabilities()
            capabilities.setCapability(MobileCapabilityType.PLATFORM, SampleModules.PLATFORM)
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, SampleModules.DEVICEVERSION)
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, SampleModules.DEVICENAME)
            capabilities.setCapability(MobileCapabilityType.APP, SampleModules.APPPATH)
            driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), capabilities)

            driver.setFileDetector(new LocalFileDetector())
            wait(8000)
            return driver
    }

    @BeforeClass
    static void initServer() {
        Initializations.createAppiumInstance()
    }

    @AfterClass
    public static void closeSession(){
        driver.quit()
    }

}
