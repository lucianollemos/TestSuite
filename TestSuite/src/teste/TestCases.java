package teste;

import org.openqa.selenium.remote.RemoteWebDriver;

public class TestCases {

	private RemoteWebDriver driver;
	private int totalTestCases;
	private int successfulTestCases;
	private Login login;
	private FillForm fillForm;
	
	public TestCases(RemoteWebDriver driver) {
		setDriver(driver);
		login = new Login(driver);
		fillForm = new FillForm(driver);
		totalTestCases = 0;
		successfulTestCases = 0;
	}
	
	protected void init(){
		login();
		searchForm();
		fillForm();
	}
	
	private void login(){
		login.loginWithEmptyFields();
		login.loginWithEmptyUserField();
		login.loginWithEmptyPasswordrField();
		login.loginWithInvalidUserFieldValue();
		login.loginWithInvalidPasswordFieldValue();
		login.validLogin();
		totalTestCases += login.getTotalTestCases();
		successfulTestCases += login.getSuccessfulTestCases();
	}
	
	private void searchForm (){
		
	}
	
	private void fillForm(){
		fillForm.saveWithEmptyFields();
		fillForm.validateEmailFormat();
		fillForm.saveAndFinhshWithEmptyFields();
		fillForm.saveAndFinhsh();
		totalTestCases += fillForm.getTotalTestCases();
		successfulTestCases += fillForm.getSuccessfulTestCases();
	}
	
	protected void setDriver(RemoteWebDriver driver){
		this.driver = driver;
	}
	
	protected void setTotalTestCases(int total){
		this.totalTestCases = total;
	}
	
	protected void setSuccessfulTestCases (int successful) {
		this.successfulTestCases = successful;
	}
	
	protected int getTotalTestCases (){
		return totalTestCases;
	}
	
	protected int getSuccessfulTestCases () {
		return successfulTestCases;
	}
	
	protected String getLoginTestResult (){
		return login.getTestResult();
	}
	
	protected String getFillFormTestResult (){
		return fillForm.getTestResult();
	}
}
