package com.newsparser.core.parser.phantom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;

@Configuration
public class PhantomParserConfig {
    public void selenPars() throws Exception{
      /*  WebDriver driver = googledriverInit();
        // System.out.println(parserRepository);
        List<ParseLinkEnt> linkList = parserRepository.getLinkAndMail();
        // System.out.println(linkList);

        for (ParseLinkEnt parseLinkEnt : linkList) {
            driver.get(parseLinkEnt.getLink());

            //  driver.get(linkList);
            // System.out.println(driver.getPageSource());
            Elements elementJsoup = Jsoup.parse(driver.getPageSource()).select("script");
            // System.out.println(elementJsoup.html());
            for (int i = 0; i < elementJsoup.size()-1; i++) {
                if(elementJsoup.get(i).html().contains("loadDataLayer")){
                    String s =  elementJsoup.get(i).html();
                    System.out.println(s);
                    String s1 = s.substring(s.indexOf("ecommerce"), s.indexOf("personalizable")-2)+" } ] } } }\";\"";
                    System.out.println(s1);
                }

            }*/

            // WebElement element = driver.findElement(By.className("product-prices-sale"));
            // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //   System.out.println(element.getText());
            //    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            // System.out.println(element.findElement(By.className("product-info-name")).getText()+" size = "+parseLinkEnt.getNeedsize());
            // String item = element.findElement(By.className("product-info-name")).getText();
            //  System.out.println(item);
            //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            // String[] elem = element.findElement(By.className("sg-p-sel")).getText().split("\n");
            // System.out.println(element.findElement(By.className("sg-p-sel")).getText());

           /* for (int i = 0; i < elem.length - 1; i++) {
                if (elem[i].startsWith(parseLinkEnt.getNeedsize()) && !elem[i].contains("Нет в наличии")) {
                    String msg = "Size - "+parseLinkEnt.getNeedsize() + " of item [" +
                            new String(item.getBytes(), "CP1252") + "] available! \r\n"+
                            "Link "+parseLinkEnt.getLink();

                    mailService.sendMail(parseLinkEnt.getUsername(), msg, 3);
                    parserRepository.completeParse(parseLinkEnt.getUsername(), parseLinkEnt.getLink());
                    break;

                }

            }*/
        }

      //  driver.quit();
   // }

    @Bean
    protected WebDriver googledriverInit() throws FileNotFoundException {

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
