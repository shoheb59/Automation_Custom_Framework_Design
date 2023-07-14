package Feature;

import LocatorForPages.LoginLocator;
import ManagerForSystem.ManageFramework;
import org.openqa.selenium.Keys;

public class Login extends ManageFramework implements FeatureHandlerInterface {

    @Override
    public boolean execute() {
        Browse("http://clm.seliselocal.com");
        Sleep(4);

        Click(LoginLocator.dd_LanguageChange);
        Click(LoginLocator.dd_EnglishLanguage);
        Sleep(2);
        Write(LoginLocator.textField_email,"automateProjectManager@yopmail.com");
        WaitForVisibility(LoginLocator.btn_Next,10);
        Click(LoginLocator.btn_Next);
        Sleep(1);
        Write(LoginLocator.textField_pass, "CLMTestPass2023");
        WaitForVisibility(LoginLocator.btn_Login,10);
        Click(LoginLocator.btn_Login);

        return true;
    }
}
