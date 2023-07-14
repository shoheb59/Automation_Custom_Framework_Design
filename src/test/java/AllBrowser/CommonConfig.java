package AllBrowser;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommonConfig {

    /* This Method ensure the certifications of the browser. */
    public static DesiredCapabilities AcceptCertification()
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        return capabilities;
    }

    /* Browser control: and save password disable for login sites. */
    public static Map<String, Object> DisableSaveCredentials()
    {
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service",false);
        prefs.put("profile.password_manager_enabled",false);
        return prefs;

    }
    /* Common Remote WebDriver Capabilities & VM Time-Slot Management. */
    @SuppressWarnings("serial")
    public static Map<String, Object> RemoteDriverCommonCapabilities() {
        return new HashMap<String, Object>() {
            {
                /* How to add test badge */
                put("name", "Test badge...");

                /* How to set session timeout */
                put("sessionTimeout", "15m");

                /* How to set time zone */
                put("env", new ArrayList<String>()
                {{ add("TZ=UTC"); }});

                /* How to add "trash" button */
                put("labels", new HashMap<String, Object>()
                {{ put("manual", "true"); }});

                /* How to enable video recording */
                put("enableVideo", true);
            }
        };
    }

}
