package com.selenium.config;

import com.selenium.annotation.LazyConfiguration;
import com.selenium.annotation.ThreadScopeBean;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.*;

import java.net.URL;

@Profile("remote")
@LazyConfiguration
public class RemoteWebDriverConfig {
    //For remote Selenium Grid

    @Value("${selenium.grid.url}")
    private URL url;

    @ThreadScopeBean
    @ConditionalOnMissingBean
    public WebDriver remoteChromeDriver(){
        return new RemoteWebDriver(this.url, DesiredCapabilities.chrome());
    }

    @ThreadScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver remoteFirefoxDriver(){
        return new RemoteWebDriver(this.url, DesiredCapabilities.firefox());
    }
}
