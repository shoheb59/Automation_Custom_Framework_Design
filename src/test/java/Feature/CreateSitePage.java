package Feature;

import LocatorForPages.CreatePageLocator;
import ManagerForSystem.ManageFramework;
import Utils.UtilsClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreateSitePage extends ManageFramework implements FeatureHandlerInterface {


    @Override
    public boolean execute() {

        String projectName = "Hasnat"+UtilsClass.generateRandomID(10,1000);
        Sleep(5);
        System.out.println("Project Name: "+projectName);
        Write(CreatePageLocator.name,projectName);
        Sleep(2);
        WaitForVisibility(CreatePageLocator.address,10);
        Write(CreatePageLocator.address,"Dhaka");
        Sleep(3);
        driver.findElement(By.cssSelector("[data-placeholder='Address']")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.cssSelector("[data-placeholder='Address']")).sendKeys(Keys.ARROW_DOWN);
        Sleep(4);
        driver.findElement(By.cssSelector("[data-placeholder='Address']")).sendKeys(Keys.ENTER);
        Sleep(6);
        WaitForVisibility(CreatePageLocator.btn_SAVE,10);
        Scroll(CreatePageLocator.btn_SAVE);
        Write(CreatePageLocator.textF_ContactName,"SHOHEB");
        Write(CreatePageLocator.textF_ContactEmail,"hasnat@selise.ch");
        Write(CreatePageLocator.textF_ContactPhone,"+8801813559963");
        Sleep(2);
        js.executeScript("document.querySelector('#container-3').scrollBy(0,500)");
        Sleep(1);
        Click(CreatePageLocator.textF_StartDate);
        Sleep(3);
        Click(CreatePageLocator.select_startDate);
        Sleep(2);
        Click(CreatePageLocator.textF_EndDate);
        Sleep(3);


        //Select birthdate
        for(int i =1; i<1000; i++) {

            WebElement e = driver.findElement(By.cssSelector("[aria-label ='Choose month and year']"));
            String all_month = e.getText();

            System.out.println("month name:" +e.getText());

            if ((!all_month.equals("NOV 2023"))) {
                Sleep(1);
                Click(CreatePageLocator.arrow_Next);
                i++;
            }
            else {


                Click(CreatePageLocator.birth_Date);
                Sleep(3);
               //System.out.println("item number:" +i +"month name: "+e.getText());
                Sleep(3);
                System.out.println("Time to BREAK");
                break;


            }


        }

        System.out.println("It is time to Uncheck the radio button");
        Sleep(3);
        Click(CreatePageLocator.checkBox_Notification);
        System.out.println("Unchecked done");
        Sleep(2);
        Click(CreatePageLocator.btn_SAVE);
        return true;
    }
}
