package com.selenium.page.google;

import com.selenium.annotation.PageFragment;
import com.selenium.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageFragment
public class LaunchComponent extends Base {

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.howItWorksTab.isDisplayed());
    }

    @FindBy(xpath = "//*[text()='HOW IT WORKS']")
    private WebElement howItWorksTab;

    public void clickHowItWorksTab() {
        this.howItWorksTab.click();
    }

}
