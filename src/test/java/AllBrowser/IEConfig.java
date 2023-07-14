package AllBrowser;

import ManagerForSystem.ManageFramework;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import static AllBrowser.CommonConfig.AcceptCertification;
import static AllBrowser.CommonConfig.RemoteDriverCommonCapabilities;

public class IEConfig extends ManageFramework implements BrowserHandlerInterface {
    public static InternetExplorerOptions IEBrowserOptions() {
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.setCapability("moon:options", RemoteDriverCommonCapabilities());
        options.merge(AcceptCertification());
        return options;
    }

    public WebDriver invoke() {
        WebDriverManager.iedriver().setup();
        return new InternetExplorerDriver(IEBrowserOptions());
    }
}
