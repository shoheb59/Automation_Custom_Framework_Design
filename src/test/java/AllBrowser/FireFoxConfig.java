package AllBrowser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FireFoxConfig extends CommonConfig implements BrowserHandlerInterface{

   public static FirefoxOptions FireFoxBrowserOptions(){
       FirefoxOptions options = new FirefoxOptions();
       options.setCapability("moon:options", RemoteDriverCommonCapabilities());
       options.merge(AcceptCertification());
       options.setHeadless(false);
       return options;
   }
    @Override
    public WebDriver invoke() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver(FireFoxBrowserOptions());
    }
}
