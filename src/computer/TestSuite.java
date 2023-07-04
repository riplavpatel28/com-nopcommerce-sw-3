package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder(){
         //Click on Computer Menu.
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));

        // Click on Desktop
        clickOnElement(By.xpath("//div[@class='sub-category-item']//h2/a"));

        // Select Sort By position "Name: Z to A"
        WebElement dropDown=driver.findElement(By.id("products-orderby"));
        Select select= new Select(dropDown);
        //select by visible text
        select.selectByVisibleText("Name: Z to A");


        // Verify the Product will arrange in Descending order.
        String expectedText = "Name: Z to A";
        String actualText= driver.findElement(By.xpath("//option[contains(text(),'Name: Z to A')]")).getText();
        Assert.assertEquals(expectedText,actualText);
    }

        @Test
        public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

            // 2.1 Click on Computer Menu.
            clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));

            // 2.2 Click on Desktop
            clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));

            // 2.3 Select Sort By position "Name: A to Z"
            WebElement dropDown = driver.findElement(By.id("products-orderby"));
            Select select = new Select(dropDown);
            //select by visible text
            select.selectByVisibleText("Name: A to Z");
            Thread.sleep(1000);

            // 2.4 Click on "Add To Cart"
            clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));

            // 2.5 Verify the Text "Build your own computer"
            String expectedResult = "Build your own computer";
            String actualResult = driver.findElement(By.xpath("//h1[contains(text(),'Build your own computer')]")).getText();
            Assert.assertEquals("Text matched", actualResult, expectedResult);

            // 2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
            WebElement dropDown1 = driver.findElement(By.name("product_attribute_1"));
            Select select1 = new Select(dropDown1);
            select1.selectByVisibleText("2.2 GHz Intel Pentium Dual-Core E2200");

            // 2.7.Select "8GB [+$60.00]" using Select class.
            WebElement dropDown2 = driver.findElement(By.id("product_attribute_2"));
            Select select2 = new Select(dropDown2);
            select2.selectByVisibleText("8GB [+$60.00]");

            // 2.8 Select HDD radio "400 GB [+$100.00]"
            clickOnElement(By.id("product_attribute_3_7"));


            // 2.9 Select OS radio "Vista Premium [+$60.00]"
            clickOnElement(By.id("product_attribute_4_9"));
            //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander

            driver.findElement(By.xpath("//input[@id='product_attribute_5_12']")).click();
            Thread.sleep(2500);
            // 2.11 Verify the price "$1,475.00"
             String expectedPrice="$1,475.00";
             String actualPrice=getTextFromElement(By.xpath("//*[@id=\"price-value-1\"]"));
             Assert.assertEquals("Text matched",actualPrice,expectedPrice);


            //2.12 Click on "ADD TO CAR
            clickOnElement(By.id("add-to-cart-button-1"));


            // 2.13 Verify the Message "The product has been added to your shopping cart" on Top green bar
            String actualMessage = "The product has been added to your shopping cart";
            String expectedMessage = driver.findElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]")).getText();
            Assert.assertEquals("Text matched", expectedMessage, actualMessage);

            //After that close the bar clicking on the cross button.
            clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));

            // 2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
            Actions builder = new Actions(driver);//mouse hover action
            builder.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"))).perform();
            clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));

            // 2.15 Verify the message "Shopping cart"
            String actualText="Shopping cart";
            String expectedText =driver.findElement(By.xpath("//h1[contains(text(),'Shopping cart')]")).getText();
            Assert.assertEquals("Text matched",actualText,expectedText);


            // 2.16 Change the Qty to "2" and Click on "Update shopping cart"

            // Change the Qty to "2" and Click on "Update shopping cart"
            clearTextToElement(By.className("qty-input"));
            sendTextToElement(By.className("qty-input"),"2");
            clickOnElement(By.id("updatecart"));

           // 2.17 Verify the Total"$2,950.00"
            String actualTotal = "$2,950.00";
            String expectedTotal =driver.findElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[1]/label[1]")).getText();

            //2.18 click on checkbox “I agree with the terms of service”

            clickOnElement(By.id("termsofservice"));
            //2.19 Click on “CHECKOUT”
            clickOnElement(By.id("checkout"));
            //2.20 Verify the Text “Welcome, Please Sign In!”

            String actualText1="Welcome, Please Sign In!";
            String expectedText1 =driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]")).getText();
            Assert.assertEquals("Text matched",expectedText1,actualText1);


            //2.21Click on “CHECKOUT AS GUEST”Tab
            clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));

            //2.22 Fill the all mandatory field
            sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"Rupal");
            sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"),"Patel");
            sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"),"riplav@yahoo.com");
            WebElement dropDown3 = driver.findElement(By.id("BillingNewAddress_CountryId"));
            Select select3 = new Select(dropDown3);
            select3.selectByVisibleText("India");
            sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"Ahmedabad");
            sendTextToElement(By.id("BillingNewAddress_Address1"),"211 Anand society");
            sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"),"380050");
            sendTextToElement(By.id("BillingNewAddress_PhoneNumber"),"0091-97234123");

            //2.23 Click on “CONTINUE”
            clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));
            //2.24 Click on Radio Button “Next Day Air($0.00)”
            clickOnElement(By.xpath("//label[contains(text(),'Next Day Air ($0.00)')]"));
            //2.25 Click on “CONTINUE”
            clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));
            //2.26 Select Radio Button “Credit Card”
            clickOnElement(By.id("paymentmethod_1"));
            //click on continue
            clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
            //2.27 Select “Master card” From Select credit card dropdown
            WebElement dropDown6 = driver.findElement(By.name("CreditCardType"));
            Select select6 = new Select(dropDown6);
            select6.selectByValue("MasterCard");

            //Add card holder name
            sendTextToElement(By.id("CardholderName"), "Anu");

            //Add card number
            sendTextToElement(By.id("CardNumber"), "5555555555554444");

            //Add ExpireYear
            sendTextToElement(By.id("ExpireYear"), "2025");


            //Add card number
            sendTextToElement(By.id("CardCode"), "123");


            //2.29 Click on “CONTINUE”
            clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));

            //2.30 Verify “Payment Method” is “Credit Card”
            String expectedPaymentMethod="Credit Card";
            String actualPaymentMethod =driver.findElement(By.xpath("//span[contains(text(),'Credit Card')]")).getText();
            Assert.assertEquals("Method matched",expectedPaymentMethod,actualPaymentMethod);


            //2.32 Verify “Shipping Method” is “Next Day Air”
            String actualShippingMethod ="Next Day Air";
            String expectedShippingMethod =driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]")).getText();
            Assert.assertEquals("Method matched",actualShippingMethod,expectedShippingMethod);

            //2.33 Verify Total is “$2,950.00”
            String expectedTotalFinal = "$2,950.00";
            String actualTotalFinal = getTextFromElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[3]/div/div/table/tbody/tr[4]/td[2]/span/strong"));
            Assert.assertEquals("Text Matched", expectedTotalFinal, actualTotalFinal);

            //2.34 Click on “CONFIRM”

            clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
            //2.35 Verify the Text “Thank You”
            String expectedThanks = "Thank you";
            String actualThanks = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
            Assert.assertEquals("Text Matched", expectedThanks, actualThanks);

            //2.36 Verify the message “Your order has been successfully processed!”
            String expectedOrderMessage = "Your order has been successfully processed!";
            String actualOrderMessage = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
            Assert.assertEquals("Text Matched", expectedOrderMessage, actualOrderMessage);

            //2.37 Click on “CONTINUE”
            driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
            //2.37 Verify the text “Welcome to our store”
            String expectedWelcomeMessage = "Welcome to our store";
            String actualWelcomeMessage = getTextFromElement(By.xpath("//th[contains(text(),'Total')]"));
            Assert.assertEquals("Text Matched", expectedWelcomeMessage, actualWelcomeMessage);

        }

    @After
    public void tearDown() {
       // closeBrowser();
    }
}


