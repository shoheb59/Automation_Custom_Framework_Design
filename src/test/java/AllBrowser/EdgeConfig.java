package AllBrowser;

import ManagerForSystem.ManageFramework;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import static AllBrowser.CommonConfig.AcceptCertification;
import static AllBrowser.CommonConfig.RemoteDriverCommonCapabilities;

public class EdgeConfig extends ManageFramework implements BrowserHandlerInterface {

    public static EdgeOptions EdgeBrowserOptions() {
        EdgeOptions options = new EdgeOptions();
        options.setCapability("moon:options", RemoteDriverCommonCapabilities());
        options.merge(AcceptCertification());
        return options;
    }

    @Override
    public WebDriver invoke() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver(EdgeBrowserOptions());
    }
}
