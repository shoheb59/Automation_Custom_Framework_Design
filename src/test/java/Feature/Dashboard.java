package Feature;

import LocatorForPages.DashboardLocator;
import ManagerForSystem.ManageFramework;
import org.openqa.selenium.Keys;

public class Dashboard extends ManageFramework implements FeatureHandlerInterface {
    @Override
    public boolean execute() {

        System.out.println("Welcome to dashboard");
        WaitForVisibility(DashboardLocator.btn_project,10);
        System.out.println("item is now visible on the screen");
        Sleep(2);
        Click(DashboardLocator.btn_project);
        System.out.println("Button clicked");
        return true;
    }
}
