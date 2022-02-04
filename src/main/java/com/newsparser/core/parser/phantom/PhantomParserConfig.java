package com.newsparser.core.parser.phantom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;

@Configuration
public class PhantomParserConfig {

    @Bean
    protected WebDriver googledriverInit() throws FileNotFoundException {
     /*   ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(ResourceUtils.getFile("classpath:phantomjs.exe"))
                .usingAnyFreePort().build();
        ChromeOptions options = new ChromeOptions().addArguments("--incognito");
        ChromeDriver driver = new ChromeDriver(service, options);*/
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true);
        //  caps.setCapability("takesScreenshot", true);
        caps.setCapability("locationContextEnabled", true);
        caps.setCapability("applicationCacheEnabled", true);
        caps.setCapability("browserConnectionEnabled", true);
        caps.setCapability("localToRemoteUrlAccessEnabled", true);
        caps.setCapability("locationContextEnabled", true);
        caps.setCapability("takesScreenshot", true);
        String [] phantomJsArgs = {"--webdriver-loglevel=NONE"};
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomJsArgs);
        caps.setCapability(
                PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                ResourceUtils.getFile("classpath:phantomjs.exe").getAbsolutePath()
        );
        WebDriver driver = new PhantomJSDriver(caps);

        return driver;
    }
}
