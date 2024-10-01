import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ThirdTopButton extends BasePage{
    Variables variables;
    public ThirdTopButton(WebDriver driver) {
        super(driver);
        variables = new Variables();
    }
    public void thirdTry(){
        waits("clickxpath",variables.topMenu3);
        click("xpath",variables.topMenu3);
        waits("css","h1[class='lg:text-6xl sm:text-2xl']");
        screenSchot(find("css","h1[class='lg:text-6xl sm:text-2xl']").getText());
        scroll(300);
        for (WebElement sss: driver.findElements(By.cssSelector(variables.sssAll))){
            webDriverWait.until(ExpectedConditions.elementToBeClickable(sss));
            sss.click();
            scroll(100);
             if (!driver.getCurrentUrl().equalsIgnoreCase("https://ajet.com/tr/sikca-sorulan-sorular")) {
                 screenSchot(find("css","div[class='logo'] h1").getText());
                 driver.navigate().back();
            }
            else if (sss.getAttribute("target").equalsIgnoreCase("_blank")){
                changeScreen(1);
                waits("css",variables.title1);
                scroll(100);
                screenSchot(find("css",variables.title1).getText());
                driver.close();
                changeScreen(0);
            }
        }
        waits("css","h1[class='lg:text-6xl sm:text-2xl']");
        int i = 300;
        scroll(i);
        int k = 0;
        for (WebElement btn: driver.findElements(By.cssSelector("div[class='caption'] button"))){
            k += 1;
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btn));
            btn.click();
            scroll(i+=100);//ekran resmi alınacak
            screenSchot(find("xpath","//div[@class='caption']//button["+k+"]").getText());
        }
    }
}
