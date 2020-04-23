package com.weborders.step_definitions;

import com.weborders.utilities.Driver;
import io.cucumber.java.Scenario;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setup(Scenario scenario) {
        System.out.println("Starting test automation");
        System.out.println("Test scenario :: " + scenario.getName());
        Driver.getDriver().manage().window().maximize();

    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
            byte[] image = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            scenario.embed(image,"image/png",scenario.getName());
        }

        Driver.closeDriver();
    }
}
