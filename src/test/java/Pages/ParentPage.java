package Pages;

import Utilities.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ParentPage {
    public WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(5));

    public void mySendKeys(WebElement element, String input) {
        wait.until(ExpectedConditions.visibilityOf(element));
        scrollToElement(element);
        element.clear();
        element.sendKeys(input);
    }

    public void myClick(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollToElement(element);
        element.click();
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void smartClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        Actions actions = new Actions(GWD.getDriver());
        actions.moveToElement(element).perform();

        try {
            Thread.sleep(3000);
            element.click();
        } catch (Exception e) {

        }
    }


    public String getTextOfElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        scrollToElement(element);
        System.out.println(element.getText().trim());
        return element.getText().trim();
    }

    public void validationWithMsg(WebElement element,String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(element.getText().toLowerCase().contains(text.toLowerCase()));
        System.out.println(element.getText());
    }

    public void mySelectByText(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        scrollToElement(element);

        Select select = new Select(element);
        select.selectByVisibleText(text);
    }


}