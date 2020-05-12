package com.training.sanity.tests;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.UniformAddCart;
import com.training.pom.UniformRemoveCartPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Uniform_TC09_RemoveCart {

			private WebDriver driver;
			private String baseUrl;
			private UniformRemoveCartPOM RemoveCart;
			private static Properties properties;
			private ScreenShot screenShot;
			
		

			@BeforeClass
			public static void setUpBeforeClass() throws IOException {
				properties = new Properties();
				FileInputStream inStream = new FileInputStream("./resources/others.properties");
				properties.load(inStream);
			}

			@BeforeMethod
			public void setUp() throws Exception {
				driver = DriverFactory.getDriver(DriverNames.CHROME);
				RemoveCart = new UniformRemoveCartPOM(driver); 
				baseUrl = properties.getProperty("baseURL");
				screenShot = new ScreenShot(driver); 
				// open the browser 
				driver.get(baseUrl);
			}
			
			@AfterMethod
			public void tearDown() throws Exception {
				Thread.sleep(1000);
				driver.quit();
			}
			@Test
			public void RemoveFromCart() throws InterruptedException {
				
				
				WebElement YellowTS= driver.findElement(By.xpath("//div[@class='product-items first_item_tm']//img[@class='img-responsive']"));
				WebElement AddCartBtn=driver.findElement(By.xpath("//div[@class='product-items first_item_tm']//span[@class='hidden-xs hidden-sm hidden-md'][contains(text(),'Add to Cart')]"));
				
				Actions act = new Actions(driver);
				act.moveToElement(YellowTS).click(AddCartBtn).build().perform();
				
				Select Size_DropDown= new Select(RemoveCart.sizeDropDown); //size drop down is made public
				Size_DropDown.selectByValue("981");
				Thread.sleep(1000);
				RemoveCart.clickAddToCart();
				Thread.sleep(1000);
				//String mess = addCart.AddedSuccessMessage(); // how to verify the success message
				//assertTrue(mess.contains("Success"));
				
				RemoveCart.CartInformation();
				//addCart.VerifyCart();
									
				screenShot.captureScreenShot("First");
				String validateCart = RemoveCart.VerifyCart();
				//System.out.println(validateCart);
				assertTrue(validateCart.contains("REGULAR T-SHIRTS"));
				
				RemoveCart.viewCart(); 
				
				Thread.sleep(1000);
				RemoveCart.RemoveCart();
				
				Thread.sleep(1000);
				String RemoveCartMess = RemoveCart.RemoveMessage();
				//System.out.println(RemoveCartMess);
				assertTrue(RemoveCartMess.contains("empty"));
				screenShot.captureScreenShot("First");
				
			}
		
	
}
