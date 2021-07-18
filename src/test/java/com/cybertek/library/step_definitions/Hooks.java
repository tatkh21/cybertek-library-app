package com.cybertek.library.step_definitions;

import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.After;

public class Hooks {
    @After
    public void tearDownScenario() {
        BrowserUtils.sleep(3);
        Driver.closeDriver();
    }

}
