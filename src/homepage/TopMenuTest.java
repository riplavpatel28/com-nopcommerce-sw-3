package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";
   String menu;
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    //Click on Menu
    public void selectMenu(String menu)
    {

        //This method should click on the menu whatever name is passed as parameter.
        clickOnElement(By.xpath(menu));
    }

    @Test
    public void verifyPageNavigation(){
        selectMenu("//body/div[6]/div[2]/ul[1]/li[1]/a[1]");
        String expectedText ="Computers";
        String actualText =driver.findElement(By.xpath("//h1[contains(text(),'Computers')]")).getText();
        Assert.assertEquals( actualText,expectedText);
    }



    @After
    public void tearDown() {
        closeBrowser();
    }
}


