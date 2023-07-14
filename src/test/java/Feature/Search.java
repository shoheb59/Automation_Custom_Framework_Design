package Feature;

import LocatorForPages.SearchLocator;
import ManagerForSystem.ManageFramework;
import org.openqa.selenium.Keys;

public class Search extends ManageFramework implements FeatureHandlerInterface {
    @Override
    public boolean execute() {
        WaitForVisibility(SearchLocator.textField_Searchbox,8);
        Write(SearchLocator.textField_Searchbox,"PAA Training by AutoMATE");
        Sleep(3);
        Click(SearchLocator.pAACardSelection);
        WaitForVisibility(SearchLocator.btn_ADD,8);
        Click(SearchLocator.btn_ADD);
        return true;
    }
}
