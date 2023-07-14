package AllBrowser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;

public class ChromeConfig extends CommonConfig implements BrowserHandlerInterface{

    public static ChromeOptions ChromeBrowserOptions()
    {
        ChromeOptions options = new ChromeOptions();
        //options.setCapability("browserVersion","90.0");
        options.setCapability("moon:options",RemoteDriverCommonCapabilities());
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("start-maximized");
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.merge(AcceptCertification());
        options.setExperimentalOption("prefs", DisableSaveCredentials());
        options.setHeadless(false);
        return  options;
    }
    @Override
    public WebDriver invoke() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(ChromeBrowserOptions());
    }
}
