package config;

import javax.swing.JOptionPane;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverConfig {

	RemoteWebDriver driver;
	int browser;

	public DriverConfig(int browser) {
		this.browser = browser;
		setDriver();
	}	

	public void setDriver (){
		String pathDriver;

		try {

			switch (browser) {
			case 0:
				/*Teste with Firefox*/
 				pathDriver = "drivers/geckodriver.exe";
				System.setProperty("webdriver.gecko.driver", pathDriver);
				driver = new FirefoxDriver();
				break;
			default:
				/*Test with Chrome*/
				pathDriver = "drivers/chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", pathDriver);
				driver = new ChromeDriver();
				break;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}

	public RemoteWebDriver getDriver(){
		return driver;
	}

}
