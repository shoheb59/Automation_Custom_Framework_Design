package AllBrowser;

import ManagerForSystem.ManageFramework;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import static AllBrowser.CommonConfig.AcceptCertification;
import static AllBrowser.CommonConfig.RemoteDriverCommonCapabilities;

public class SafariConfig extends ManageFramework implements BrowserHandlerInterface {
    public static SafariOptions SafariBrowserOptions() {
        SafariOptions options = new SafariOptions();
        options.setCapability("moon:options", RemoteDriverCommonCapabilities());
        options.merge(AcceptCertification());
        return options;
    }

    public WebDriver invoke() {
        // WebDriverManager.phantomjs().setup();
        return new SafariDriver(SafariBrowserOptions());
    }
}
