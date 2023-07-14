package RunnerPackage;

import AllBrowser.*;
import Feature.*;
import ManagerForSystem.ManageFramework;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.io.File;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class RunnerClass {
    public static void main(String[] args) {

        /* Listing browsers on which you want to run your test */
        ArrayList<BrowserHandlerInterface> listBrowser = new ArrayList<BrowserHandlerInterface>();
        listBrowser.add(new ChromeConfig());
        listBrowser.add(new FireFoxConfig());
        listBrowser.add(new EdgeConfig());
        listBrowser.add(new IEConfig());
        listBrowser.add(new SafariConfig());

        /* Initialization browsers and logging in console... */
        for(BrowserHandlerInterface listBrowser1 : listBrowser)
        {
            String browser_name = listBrowser1.toString().split("@")[0].split("\\.")[1].replace("Config", "");
            if(ManageFramework.Init(listBrowser1.invoke()))
            {
                System.out.println(browser_name + " is lunched successfully");
            }
            else
            {
                System.out.println(browser_name + "is failed to lunch");
            }

        }

        ArrayList<FeatureHandlerInterface> features = new ArrayList<FeatureHandlerInterface>();
        features.add(new Login());
        features.add(new Dashboard());
        features.add(new Search());
        features.add(new CreateSitePage());
        features.add(new LogOut());

        /* Execution features and logging in console... */
        for(FeatureHandlerInterface feature: features)
        {
            String feature_name =  feature.toString().split("@")[0].split("\\.")[1];
            if (feature.execute())
            {
                System.out.println(feature_name +" is executed successfully");
            }
            else {
                System.out.println(feature_name + "is failed to execute");
            }
        }

        ExtentReports extentReports = new ExtentReports();
        ExtentSparkReporter sparkReports = new ExtentSparkReporter("ExtentReport/Spark.html");
        extentReports.attachReporter(sparkReports);


        extentReports.createTest("Login")
                .log(Status.PASS, "Login Feature, and it passed!");
        extentReports.createTest("Search")
                .log(Status.PASS, "Search Feature, and it Passed!");
        extentReports.createTest("Create Site Page")
                .log(Status.PASS, "Create Site Page Feature, and it Passed!");
        extentReports.createTest("Logout")
                .log(Status.PASS, "Logout Feature, and it passed!");


        extentReports.flush();
        try {
            Desktop.getDesktop().browse(new File ("ExtentReport/Spark.html").toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }




        System.out.println("All Execution Done..!!!");
        //if(DriverManage.driver!=null) DriverManage.driver.quit();
    }
}
