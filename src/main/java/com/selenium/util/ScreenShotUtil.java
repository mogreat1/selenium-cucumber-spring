package com.selenium.util;

import com.github.javafaker.Faker;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

@Lazy
@Service
public class ScreenShotUtil {

    @Autowired
    private TakesScreenshot screenshot;

    @Value("${screenshot.path}/img.png")
    private Path path;

    @Autowired
    private Faker faker;

    public void takeScreeenShot() throws IOException {
        File sourceFile = this.screenshot.getScreenshotAs(OutputType.FILE);
        FileCopyUtils.copy(sourceFile, this.path.toFile());
    }

}
