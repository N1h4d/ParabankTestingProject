package StepDefinitions;

import Utilities.GWD;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @After
    public void after(Scenario scenario)
    {

        if (scenario.isFailed()){
            TakesScreenshot ts = (TakesScreenshot) GWD.getDriver();
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", "Failure Screenshot");
        }



        GWD.quitDriver();
    }

    @Before
    public void before(){
        String browser = System.getProperty("browser","chrome");
        GWD.setBrowser(browser);
    }
}
