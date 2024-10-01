import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {
    WebDriver driver;
    WebElement result;
    Actions actions;
    WebDriverWait webDriverWait;
    JavascriptExecutor js;
    TakesScreenshot takesScreenshot;

    public BasePage(WebDriver driver){
        this.driver=driver;
        driver.get("https://ajet.com/tr");
    }

    public WebElement find(String type,String txt){
        if (type.equalsIgnoreCase("css")){
            result = driver.findElement(By.cssSelector(txt));
        } else if (type.equalsIgnoreCase("xpath")) {
            result = driver.findElement(By.xpath(txt));
        }
        return result;
    }

    public void click(String type,String txt){
        find(type,txt).click();
    }

    public void onButton(WebElement element){
        actions =  new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void waits(String type, String txt){
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20L));
        if (type.equalsIgnoreCase("css")){
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(txt)));
        } else if (type.equalsIgnoreCase("xpath")) {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(txt)));
        } else if (type.equalsIgnoreCase("clickcss")) {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(txt)));
        } else if (type.equalsIgnoreCase("clickxpath")) {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(txt)));
        }
    }

    public void scroll(int number){
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + number + ")");
    }

    public void screenSchot(String name){
        takesScreenshot = (TakesScreenshot) driver;
        File image = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            Files.move(image,new File("image/"+name+".png"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void sendText(String type,String txt,String city){
        find(type,txt).sendKeys(city);
    }
    public void sendAndKeys(String type,String txt,String city,Keys key){
        find(type,txt).sendKeys(city,key);
    }
    public void changeScreen(int number){
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(number));
        System.out.println(driver.getCurrentUrl());
    }
}
