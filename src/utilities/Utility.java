package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest{

    /**
     * This Method will click on elements
     */

    public void clickOnElement(By by)
    {
        driver.findElement(by).click();
        //loginLink.click();
    }

    // This Method will get Text from Element
    public String getTextFromElement(By by)
    {
        return driver.findElement(by).getText();
    }

    //This Method will Send Text to elements
    public void sendTextToElement(By by, String text)
    {
        driver.findElement(by).sendKeys(text);
    }


    //Create Alert Methods
    //5 methods //accept //dismiss /switch to Alert // Gettextfrom alert /send text to Alert

    // Select Class Method
    //2 methods from hw / byindex /byvalue
    public void selectFromDropDowm(By by, String value) {
      new Select(driver.findElement(by)).selectByValue(value);

    }
    public void clearTextToElement(By by) {
        driver.findElement(by).clear();
    }

    public void selectByValue(By by, String value)
    {
        //Select select = new Select(driver.findElement(by)).selectByValue(value);
    }
}

