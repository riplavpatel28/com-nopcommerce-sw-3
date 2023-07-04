package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";


    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        // 1.1 Mouse Hover on “Electronics”Tab
        WebElement electronics = driver.findElement((By.xpath("//a[@href = '/electronics']/parent::li")));
        WebElement cellPhone = driver.findElement(By.xpath("//a[@href = '/cell-phones']/parent::li"));
        Actions actions = new Actions(driver);
        actions.moveToElement(electronics).moveToElement(cellPhone).click().build().perform();
        String expectedMessage = "Cell phones";
        String actualMessage = driver.findElement(By.xpath("//h1[contains(text(),'Cell phones')]")).getText();
        Assert.assertEquals("Cell phones", expectedMessage, actualMessage);

    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        // 2.1 Mouse Hover on “Electronics” Tab
        WebElement electronics = driver.findElement((By.xpath("//a[@href = '/electronics']/parent::li")));
        WebElement cellPhone = driver.findElement(By.xpath("//a[@href = '/cell-phones']/parent::li"));
        // 2.2 Mouse Hover on “Cell phones” and click
        Actions actions = new Actions(driver);
        actions.moveToElement(electronics).moveToElement(cellPhone).click().build().perform();
        // 2.3 Verify the text “Cell phones”
        String expectedMessage = "Cell phones";
        String actualMessage = driver.findElement(By.xpath("//h1[contains(text(),'Cell phones')]")).getText();
        Assert.assertEquals("Cell phones", expectedMessage, actualMessage);

        // 2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        Thread.sleep(2000);
        // 2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.xpath("//div[@class='product-item']//img[@title='Show details for Nokia Lumia 1020']"));

        //  2.6 Verify the text “Nokia Lumia 1020”
        String actualText="Nokia Lumia 1020";
        String expectedText=driver.findElement(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]")).getText();
        Assert.assertEquals("Text mateched",actualText,expectedText);

        //2.7 Verify the price “$349.00”
        String actualPrice ="$349.00";
        String expectedPrice=driver.findElement(By.xpath("//span[contains(text(),'$349.00')]")).getText();
        Assert.assertEquals("price Match",actualPrice,expectedPrice);
        //2.8 Change quantity to 2
        clearTextToElement(By.id("product_enteredQuantity_20"));
        sendTextToElement(By.id("product_enteredQuantity_20"),"2");

        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.id("add-to-cart-button-20"));

        //2.10 Verify the Message "The product has been added to your shopping cart" on Topgreen Bar
        //After that close the bar clicking on the cross button.
        String expectedMessage1 ="The product has been added to your shopping cart";
        String actualMessage1 =driver.findElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]")).getText();
        Assert.assertEquals("text matched",actualMessage1,expectedMessage1);
       //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));

        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Actions builder = new Actions(driver);//mouse hover action
        builder.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"))).build().perform();
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        //2.12 Verify the message "Shopping cart"
        String actualMessage2="Shopping cart";
        String expectedMessage2=driver.findElement(By.xpath("//h1[contains(text(),'Shopping cart')]")).getText();
        Assert.assertEquals("Text matched",expectedMessage2,actualMessage2);
        //2.13 Verify the quantity is 2

        String actualQuantity="2";
        String expectedQuantity=driver.findElement(By.xpath("//th[contains(text(),'Qty.')]")).getText();
        Assert.assertEquals("Quantity matched",expectedMessage2,actualMessage2);

       // 2.14 Verify the Total $698.00
        String actualTotalValue="$698.00";
        String expectedTotalValue=driver.findElement(By.xpath("//th[contains(text(),'Total')]")).getText();
        Assert.assertEquals("Quantity matched",expectedMessage2,actualMessage2);

       // 2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));

       // 2.16 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
       // 2.17 Verify the Text “Welcome, Please Sign In!”
        String actualText1="Welcome, Please Sign In!";
        String expectedText1=driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]")).getText();
        Assert.assertEquals("Quantity matched",expectedMessage2,actualMessage2);

       // 2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
       // 2.19 Verify the text “Register”
        String actualText2="Register";
        String expectedText2=driver.findElement(By.xpath("//h1[contains(text(),'Register')]")).getText();
        Assert.assertEquals("Quantity matched",expectedMessage2,actualMessage2);

        // 2.20 Fill the mandatory fields
        sendTextToElement(By.id("FirstName"),"Rupal");
        sendTextToElement(By.xpath("//input[@id='LastName']"),"Patel");
        WebElement dropDown = driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[1]"));
        Select select = new Select(dropDown);
        driver.findElement(By.xpath("//select[@name = 'DateOfBirthDay']//option[@value= '15']")).click();
        // Click on Month
        driver.findElement(By.xpath("//select[@name = 'DateOfBirthMonth']//option[@value= '9']")).click();
        // Click on year
        driver.findElement(By.xpath("//select[@name = 'DateOfBirthYear']//option[@value= '1933']")).click();
        sendTextToElement(By.id("Email"),"dd11@yahoo.com");
        sendTextToElement(By.id("Password"),"shivam181");
        sendTextToElement(By.id("ConfirmPassword"),"shivam181");

       // 2.21 Click on “REGISTER” Button
        clickOnElement(By.id("register-button"));
       // 2.22 Verify the message “Your registration completed”
        String actualMessage3="Your registration completed";
        String expectedMessage3=driver.findElement(By.xpath("//div[@class='result']")).getText();
        Assert.assertEquals("text match",expectedMessage2,actualMessage2);

       // 2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

       // 2.24 Verify the text “Shopping cart”
        String actualText3="Shopping cart";
        String expectedText3=driver.findElement(By.xpath("//h1[normalize-space()='Shopping cart']")).getText();
        Assert.assertEquals("text match",expectedMessage2,actualMessage2);
        clickOnElement(By.xpath("//a[@class = 'ico-login']"));
        sendTextToElement(By.xpath("//input[@id='Email']"), "dd11@yahoo.com");
        sendTextToElement(By.xpath("//input[@id = 'Password']"), "shivam181");
        clickOnElement(By.xpath("//button[normalize-space()='Log in']"));


        // 2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

       // 2.26 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));

       // 2.27 Fill the Mandatory fields
        sendTextToElement(By.id("BillingNewAddress_FirstName"),"Rupal");
        sendTextToElement(By.id("BillingNewAddress_LastName"),"Patel");
        sendTextToElement(By.id("BillingNewAddress_Email"),"dd11@yahoo.com");
       selectFromDropDowm(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "1");
       selectFromDropDowm(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"),"47");
        sendTextToElement(By.id("BillingNewAddress_City"),"Boston");
        sendTextToElement(By.id("BillingNewAddress_Address1"),"211 anand society");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"),"380050");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"97234123");



       // 2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
       // 2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_2']"));
       // 2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));
        //2.31 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
       // 2.32 Select “Visa” From Select credit card dropdown
        sendTextToElement(By.id("CardholderName"), "Rupal");

        //Add card number
        sendTextToElement(By.id("CardNumber"), "5555555555554444");

        //Add ExpireYear
        sendTextToElement(By.id("ExpireYear"), "2025");


        //Add card number
        sendTextToElement(By.id("CardCode"), "123");

        // 2.33 Fill all the details

       // 2.34 Click on “CONTINUE”
       // 2.35 Verify “Payment Method” is “Credit Card”
        String expectedPaymentMethod="Credit Card";
        String actualPaymentMethod =driver.findElement(By.xpath("//span[contains(text(),'Credit Card')]")).getText();
        Assert.assertEquals("Method matched",expectedPaymentMethod,actualPaymentMethod);
       // 2.36 Verify “Shipping Method” is “2nd Day Air”
        String actualShippingMethod ="Next Day Air";
        String expectedShippingMethod =driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]")).getText();
        Assert.assertEquals("Method matched",actualShippingMethod,expectedShippingMethod);


        // 2.37 Verify Total is “$698.00”
        String expectedTotalFinal = "$698.00";
        String actualTotalFinal = getTextFromElement(By.xpath("//th[@class='subtotal']"));
        Assert.assertEquals("Text Matched", expectedTotalFinal, actualTotalFinal);


       // 2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
       // 2.39 Verify the Text “Thank You”
        String expectedThanks = "Thank you";
        String actualThanks = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals("Text Matched", expectedThanks, actualThanks);
       // 2.40 Verify the message “Your order has been successfully processed!”
        String expectedOrderMessage3 = "Your order has been successfully processed!";
        String actualOrderMessage3 = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("Text Matched", expectedThanks, actualThanks);

       // 2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));


        //2.42 Verify the text “Welcome to our store”
        String expectedText4 = "Welcome to our store";
        String actualText4 = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("Text Matched", expectedThanks, actualThanks);


        // 2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));

       // 2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl2 = "https://demo.nopcommerce.com/";
        Assert.assertEquals("Url not verified", expectedUrl2, currentUrl);
    }


    @After
    public void ternDown() {
        //closeBrowser();
    }
}

