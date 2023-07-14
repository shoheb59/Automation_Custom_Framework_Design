package Feature;

import LocatorForPages.LogOutLocator;
import ManagerForSystem.ManageFramework;

import java.sql.SQLOutput;

public class LogOut extends ManageFramework implements FeatureHandlerInterface {
    @Override
    public boolean execute() {
        Sleep(3);
        System.out.println("Logout Now!");
        Click(LogOutLocator.btn_DownArrow);
        Click(LogOutLocator.btn_logOut);
        return true;
    }
}
