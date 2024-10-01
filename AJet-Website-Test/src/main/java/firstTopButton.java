import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class firstTopButton extends BasePage{
    Variables variables;

    public firstTopButton(WebDriver driver) {
        super(driver);
        variables = new Variables();
    }

    public void firstTry(){
        for (WebElement result: driver.findElements(By.cssSelector(variables.allTopMenu))){
            waits("xpath", variables.topmenu1);
            onButton(find("xpath",variables.topmenu1));
            webDriverWait.until(ExpectedConditions.elementToBeClickable(result));
            result.click();
            waits("css", variables.title1);
            scroll(450);
            screenSchot(result.getAttribute("text"));
            scroll(0);
        }
    }
}
