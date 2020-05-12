package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UniformAddCart {
	

		private WebDriver driver; 
		
		public UniformAddCart(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(className="hidden-xs hidden-sm hidden-md")
		private WebElement addToCart; 
		
				
		@FindBy(className="//div[@class='product-items first_item_tm']//img[@class='img-responsive']")
		private WebElement YellowTS;
		
		@FindBy(id="input-option382")
		public WebElement sizeDropDown;
		
		@FindBy(id="button-cart")
		private WebElement AddCart;
				
		@FindBy(className="alert alert-success")
		private WebElement AddCartSuccess;
		
		@FindBy(xpath="//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
		private WebElement CartInfo;
		
		@FindBy(linkText="REGULAR T-SHIRTS (YELLOW)")
		private WebElement CartItem;
		
		@FindBy(xpath="//strong[contains(text(),'View Cart')]")
		private WebElement ViewCart;
				
		public void clickAddCart() {
			this.addToCart.click(); 
		}
		
		public void clickAddToCart() {
			this.AddCart.click(); 
		}
		
		public String AddedSuccessMessage() {
			return this.AddCartSuccess.getText();
		}
		
		public void CartInformation() {
			this.CartInfo.click();
		}
		
		public String VerifyCart() {
			return this.CartItem.getText();
		}
		
		public void viewCart() {
			this.ViewCart.click();
		}
}
