package teste;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Login {
	
	private RemoteWebDriver driver;
	private String testResult;
	private String urlForValidLogin = "http://clicq.paripassu.com.br/#/main/inicio";
	private int totalTestCases;
	private int successfulTestCases;
	
	public Login(RemoteWebDriver driver) {
		this.driver = driver;
		testResult = new String();
		totalTestCases = 0;
		successfulTestCases = 0;
	}
	
	// 1.1 Teste de login com o campo usuário e o campo senha vazios
	protected void loginWithEmptyFields(){
		totalTestCases++;
		wait(10000);
		driver.findElement(By.xpath(".//*[@id='submit-login']")).click();
		wait(3000);
		String url = driver.getCurrentUrl();
		if(!url.equals(urlForValidLogin.toString())){
			testResult += "\n 1.1 - Login com campos vazios - OK";
			successfulTestCases++;
		}else{
			testResult += "\n 1.1 - Login com campos vazios - Fail ";
		}
	}

	//1.2 Teste de login com o campo usuário vazio
	protected void loginWithEmptyUserField(){
		totalTestCases++;
		driver.findElement(By.xpath(".//*[@id='usuario']")).clear();
		driver.findElement(By.xpath(".//*[@id='password']")).clear();
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("wdvGY753");
		driver.findElement(By.xpath(".//*[@id='submit-login']")).click();
		wait(3000);
		String url = driver.getCurrentUrl();
		if(!url.equals(urlForValidLogin.toString())){
			testResult += "\n 1.2 - Login com camp usuário vazio - OK";
			successfulTestCases++;
		}else{
			testResult += "\n 1.2 - Login com camp usuário vazio - Fail ";
		}
	}
	
	//1.3 Teste de login com o campo senha vazio
	protected void loginWithEmptyPasswordrField(){
		totalTestCases++;
		driver.findElement(By.xpath(".//*[@id='usuario']")).clear();
		driver.findElement(By.xpath(".//*[@id='usuario']")).sendKeys("luciano.eno@gmail.com");
		driver.findElement(By.xpath(".//*[@id='password']")).clear();
		driver.findElement(By.xpath(".//*[@id='submit-login']")).click();
		wait(3000);
		String url = driver.getCurrentUrl();
		if(!url.equals(urlForValidLogin.toString())){
			testResult += "\n 1.3 - Login com campo senha vazio - OK";
			successfulTestCases++;
		}else{
			testResult += "\n 1.3 - Login com campo senha vazio - Fail ";
		}
	}
	
	//1.4 Teste de login com usuáio invalido e senha correta
	protected void loginWithInvalidUserFieldValue(){
		totalTestCases++;
		driver.findElement(By.xpath(".//*[@id='usuario']")).clear();
		driver.findElement(By.xpath(".//*[@id='usuario']")).sendKeys("usuário invalido");
		driver.findElement(By.xpath(".//*[@id='password']")).clear();
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("wdvGY753");
		driver.findElement(By.xpath(".//*[@id='submit-login']")).click();
		wait(3000);
		String url = driver.getCurrentUrl();
		if(!url.equals(urlForValidLogin.toString())){
			testResult += "\n 1.4 - Login com usuário inválido - OK";
			successfulTestCases++;
		}else{
			testResult += "\n 1.4 - Login com usuário inválido - Fail ";
		}
	}
	
	//1.5 Teste de login com usuário correto e senha inválida
	protected void loginWithInvalidPasswordFieldValue(){
		totalTestCases++;
		driver.findElement(By.xpath(".//*[@id='usuario']")).clear();
		driver.findElement(By.xpath(".//*[@id='usuario']")).sendKeys("luciano.eno@gmail.com");
		driver.findElement(By.xpath(".//*[@id='password']")).clear();
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("senhainvalida");
		driver.findElement(By.xpath(".//*[@id='submit-login']")).click();
		wait(3000);
		String url = driver.getCurrentUrl();
		if(!url.equals(urlForValidLogin.toString())){
			testResult += "\n 1.5 - Login com senha inválida - OK";
			successfulTestCases++;
		}else{
			testResult += "\n 1.5 - Login com senha inválida - Fail ";
		}
	}
	
	//1.6 Teste com login válido
	protected void validLogin(){
		totalTestCases++;
		driver.findElement(By.xpath(".//*[@id='usuario']")).clear();
		driver.findElement(By.xpath(".//*[@id='usuario']")).sendKeys("luciano.eno@gmail.com");
		driver.findElement(By.xpath(".//*[@id='password']")).clear();
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("wdvGY753");
		driver.findElement(By.xpath(".//*[@id='submit-login']")).click();
		wait(10000);
		String url = driver.getCurrentUrl();
		if(url.equals(urlForValidLogin.toString())){
			testResult += "\n 1.6 - Login válido - OK";
			successfulTestCases++;
		}else{
			testResult += "\n 1.6 - Login válido - Fail ";
		}
	}
	
	public String getTestResult() {
		return testResult;
	}
	
	public int getTotalTestCases() {
		return totalTestCases;
	}
	
	public int getSuccessfulTestCases() {
		return successfulTestCases;
	}
	
	private void wait(int time){
		try{
			Thread.sleep(time);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
