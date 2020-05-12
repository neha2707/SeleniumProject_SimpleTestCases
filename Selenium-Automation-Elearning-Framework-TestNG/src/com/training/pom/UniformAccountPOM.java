package com.training.pom;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class UniformAccountPOM {
		private WebDriver driver; 
		
		public UniformAccountPOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(linkText="Change your password")
		private WebElement changePwd; 
				
		@FindBy(id="input-password")
		public WebElement inptPwd;
		
		@FindBy(id="input-confirm")
		private WebElement inputConfirm; 
		
		@FindBy(xpath="//input[@class='btn btn-primary']")
		private WebElement continueBtn; 
		
				
		public void sendPassword(String password) {
		this.inptPwd.clear(); 
		this.inptPwd.sendKeys(password); 
		}
		
		public void sendConfirmPassword(String conpassword) {
			this.inputConfirm.clear(); 
			this.inputConfirm.sendKeys(conpassword); 
			}
		
		public void clickContBtn() {
			this.continueBtn.click(); 
		}
		
		public void clickChangePwd() {
			this.changePwd.click(); 
		}
			
		/*public void clickloginOption() {
				this.loginOption.click(); 
				
		}*/
	}


