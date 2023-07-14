package ManagerForSystem;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ManageFramework {
    public static WebDriver driver = null;
    public static JavascriptExecutor js;

    public static boolean Init(WebDriver paraDriver)
    {
        driver = paraDriver;
        js = (JavascriptExecutor) paraDriver;
        driver.manage().window().maximize();
        SetTimeOut();
        return driver !=null;
    }

    private static Duration SetTimeOut() {
        return SetTimeOut(30);
    }
    public static Duration SetTimeOut(int element_timeout)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(element_timeout));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(2*element_timeout));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3*element_timeout));
        return driver.manage().timeouts().getImplicitWaitTimeout();
    }
    public static boolean Browse(String url)
    {
        driver.get(url);
        return true;
    }
    public static By GetLocator(String locator)
    {
        if(locator.startsWith("//")|| locator.startsWith("(//)"))
            return By.xpath(locator);
        else
            return By.cssSelector(locator);
    }
    public static List<WebElement> GetListElemets (String locator)
    {
        return driver.findElements(GetLocator(locator));

    }

    public static boolean Click(String locator)
    {
        return Click(locator,1);
    }
    public static boolean Click(String locator, int index)
    {
        GetListElemets(locator).get(index-1).click();
        return true;
    }

    public static boolean Write(String locator, String message) {
        return Write(locator, message, 1);
    }
    public static boolean Write(String locator, String message, int index) {
        GetListElemets(locator).get(index-1).sendKeys(message);
        return true;
    }
    public static boolean IsPresent(String locator)
    {
        try{
            return GetListElemets(locator).size() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    public static boolean Scroll (String locator)
    {
        if (!IsPresent(locator))
        return false;
        else
        return Scroll(GetListElemets(locator).get(0));
    }

    public static boolean Scroll(WebElement webElement) {
        js.executeScript("arguments[0].scrollIntoView()",webElement);
        return true;
    }
    public static boolean Sleep (double time_in_second) {
        try {
            Thread.sleep((long) (1000 * time_in_second));
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;

        }
    }
        public static boolean WaitForVisibility(String locator, int time_out) {
        int polling_time = time_out/5>1 ? time_out/5 : 1;
        SetTimeOut(polling_time);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time_out));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(GetLocator(locator)));
            return true;
        } catch (Exception ex) {
            return false;
        } finally {
            SetTimeOut();
        }
    }

    }

