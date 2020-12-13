package com.selenium.page.google;

import com.selenium.annotation.Page;
import com.selenium.page.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


@Page
public class MainPage extends Base {

    @Override
    public boolean isAt() {
        return this.launchComponent.isAt();
    }

    @Autowired
    private LaunchComponent launchComponent;

    @Autowired
    HowItWorksComponent howItWorksComponent;


    @Value("${application.url}")
    private String url;

    public LaunchComponent getLaunchComponent() {
        return launchComponent;
    }

    public HowItWorksComponent getHowItWorksComponent() {
        return howItWorksComponent;
    }

    public void goTo() {
      //  this.driver.manage().window().maximize();
        this.driver.get(url);
    }

    public void tearDown(){
        this.driver.quit();
    }
}
