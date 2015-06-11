package PageObject

import PageObject.Modules.SampleModules
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.LocalFileDetector
import org.openqa.selenium.support.PageFactory

/**
 * Created by latifah on 6/10/2015.
 */
class Initializations {
    static def WebDriver driver

    static WebDriver createAppiumInstance() {
        DesiredCapabilities capabilities = new DesiredCapabilities()
        capabilities.setCapability("platformName", SampleModules.PLATFORM)

        if (capabilities.getCapability("platformName") == SampleModules.PLATFORM){
            capabilities.setCapability(MobileCapabilityType.PLATFORM, SampleModules.PLATFORM)
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, SampleModules.DEVICEVERSION)
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, SampleModules.DEVICENAME)
            capabilities.setCapability(MobileCapabilityType.APP, SampleModules.APPPATH)
            driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities)

        }
        driver.setFileDetector(new LocalFileDetector())
        wait(8000)
        driver
    }


}
