import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Autotest {
    public static void main(String[] args) throws InterruptedException {

        File gecko = new File("G:\\seleniumLab\\chromedriver.exe");
        System.setProperty("driver.gecko.driver", gecko.getAbsolutePath());
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/gmail/");

        //login
        driver.findElement(By.id("identifierId")).sendKeys("boscodilla@gmail.com");
        driver.findElement(By.id("identifierNext")).click();
        driver.findElement(By.name("password")).sendKeys("clickdb@123GOD");
        driver.findElement(By.id("passwordNext")).click();




        
        List<WebElement> unreademail = driver.findElements(By.xpath("//*[@class='zF']"));

        System.out.println("You have "+unreademail.size()+ " unread emails!!!");

        for (int i = 0; i < unreademail.size(); i++) {
            if (unreademail.get(i).isDisplayed()) {
                
                if (unreademail.get(i).getText()!=null) {
                    System.out.println("you have got email form " + unreademail.get(i).getText());
                    
                } else {
                    System.out.println("Soorrryyyyy No mail :) ");
                }
            }



        }

    }
}

