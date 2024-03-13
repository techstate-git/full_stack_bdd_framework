package pages;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class BaseClass {

	public WebDriver driver;
	public LoginPage lp;
	public AddcustomerPage addCust;
	public SearchCustomerPage searchCust;
	public static Logger logger;
	public static Properties configProp;


	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	//Created for generating random string for Unique email
	public static String randomestring(){
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}
	
	
	
}
