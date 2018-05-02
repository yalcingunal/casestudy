package com.trend.steps;

import com.trend.core.driver.TrendWebDriver;
import com.trend.core.managers.ScreenshotManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;

import java.io.IOException;

public class StepHooks {

    private TrendWebDriver webDriver;

    public StepHooks(TrendWebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            ScreenshotManager.saveFailScenarioScreenshot(webDriver, scenario);
        }
        webDriver.manage().deleteAllCookies();
    }
}
