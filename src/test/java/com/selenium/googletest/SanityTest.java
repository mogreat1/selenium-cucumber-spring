package com.selenium.googletest;

import com.selenium.SpringBaseTestNGTest;
import com.selenium.annotation.LazyAutowired;
import com.selenium.page.google.HowItWorksComponent;
import com.selenium.page.google.MainPage;
import com.selenium.util.ScreenShotUtil;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class SanityTest extends SpringBaseTestNGTest {

    @LazyAutowired
    private MainPage mainPage;

    @LazyAutowired
    HowItWorksComponent howItWorksComponent;

    @LazyAutowired
    private ScreenShotUtil screenShotUtil;

    @Test
    public void shouldLoadLaunchPage() throws IOException {
        //when
        this.mainPage.goTo();

        //then
        Assert.assertTrue(this.mainPage.isAt());

        this.screenShotUtil.takeScreeenShot();

        //and when
        this.mainPage.getLaunchComponent().clickHowItWorksTab();

        //then
        Assert.assertEquals(this.howItWorksComponent.getTitle(), "How It Works | Zelle");
    }

    @AfterTest
    public void tearDown() {
        this.mainPage.tearDown();
    }
}
