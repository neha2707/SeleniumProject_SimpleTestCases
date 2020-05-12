package com.training.pom;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class UniformLoginPOM {
		private WebDriver driver; 
		
		public UniformLoginPOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="/html[1]/body[1]/nav[1]/header[1]/div[1]/div[3]/div[1]/ul[1]/li[3]/a[1]/span[2]")
		private WebElement accountDropdown; 
				
		@FindBy(xpath="//a[contains(text(),'Login')]")
		public WebElement loginOption;
		
		@FindBy(id="input-email")
		private WebElement inputEmail; 
		
		@FindBy(id="input-password")
		private WebElement inputPassword; 
		
		@FindBy(xpath="//input[@class='btn btn-primary']")
		private WebElement loginBtn; 
		
		/*-------------------------------*/
		
		@FindBy(linkText="Change your password")
		private WebElement changePwd; 
				
		@FindBy(id="input-password")
		public WebElement inptPwd;
		
		@FindBy(id="input-confirm")
		private WebElement inputConfirm; 
		
		@FindBy(xpath="//input[@class='btn btn-primary']")
		private WebElement continueBtn; 
		
				
		public void sendPasswrd(String password) {
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
		
		/*--------------------------------------*/
		
		public void sendUserName(String userName) {
			this.inputEmail.clear();
			this.inputEmail.sendKeys(userName);
		}
		
		public void sendPassword(String password) {
			this.inputPassword.clear(); 
			this.inputPassword.sendKeys(password); 
		}
		
		public void clickLoginBtn() {
			this.loginBtn.click(); 
		}
		
		public void clickaccountDropdown() {
			this.accountDropdown.click(); 
		}
			
		public void clickloginOption() {
				this.loginOption.click(); 
				
		}
	}


