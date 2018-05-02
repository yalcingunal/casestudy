package com.trend.core.driver;

import org.openqa.selenium.support.events.EventFiringWebDriver;

public class TrendWebDriver extends EventFiringWebDriver {

    public TrendWebDriver() {
        super(DriverFactory.getDriver(true));
    }

}
