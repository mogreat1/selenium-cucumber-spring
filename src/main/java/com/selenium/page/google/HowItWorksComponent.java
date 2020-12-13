package com.selenium.page.google;

import com.selenium.annotation.PageFragment;
import com.selenium.page.Base;

@PageFragment
public class HowItWorksComponent extends Base {

    @Override
    public boolean isAt() {
        return false;
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
