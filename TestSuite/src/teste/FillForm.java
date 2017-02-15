package teste;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FillForm {

	private RemoteWebDriver driver;
	private String testResult;
	private String urlForSavedForm = "http://clicq.paripassu.com.br/#/main/aplicacao_questionarios";
	private int totalTestCases;
	private int successfulTestCases;
	
	public FillForm(RemoteWebDriver driver) {
		this.driver = driver;
		testResult = new String();
		totalTestCases = 0;
		successfulTestCases = 0;
	}
	
	// 3.1 Salvar com campos vazios
	protected void saveWithEmptyFields(){
		totalTestCases++;
		goToForm();
		driver.findElement(By.xpath(".//*[@id='webBody']/div[1]/div[1]/div[3]/div/div/div/div[2]/form/div[1]/div/div/a[2]")).click();
		wait(1000);
		driver.findElement(By.xpath(".//*[@id='alertify-ok']")).click();
		wait(5000);
		String url = driver.getCurrentUrl();
		if(url.equals(urlForSavedForm.toString())){
			testResult += "\n 2.1 - salvar com campos vazios - OK";
			successfulTestCases++;
		}else{
			testResult += "\n 2.1 - salvar com campos vazios - Fail ";
		}
	}
	
	//3.2 validação de e-mail
	protected void validateEmailFormat() {
		totalTestCases++;
		if (driver.getCurrentUrl().equals(urlForSavedForm.toString())){
			returnToForm();
			wait(3000);
		}
		driver.findElement(By.xpath(".//*[@id='webBody']/div[1]/div[1]/div[3]/div/div/div/div[2]/form/div[3]/div/div[1]/div[3]/div/div[1]/field-directive/textarea")).sendKeys("e-mail inválido");
		driver.findElement(By.xpath(".//*[@id='webBody']/div[1]/div[1]/div[3]/div/div/div/div[2]/form/div[1]/div/div/a[2]")).click();
		wait(1000);
		driver.findElement(By.xpath(".//*[@id='alertify-ok']")).click();
		wait(5000);
		String url = driver.getCurrentUrl();
		if(!url.equals(urlForSavedForm.toString())){
			testResult += "\n 2.2 - Validar formato do e-mail - OK";
			successfulTestCases++;
		}else{
			testResult += "\n 2.2 - validar formato do e-mail - Fail ";
		}
	}
	
	// 3.3 Salvar e finalizar com campos vazios
	protected void saveAndFinhshWithEmptyFields(){
		totalTestCases++;
		if (driver.getCurrentUrl().equals(urlForSavedForm.toString())){
			returnToForm();
			wait(3000);
		}
		driver.findElement(By.xpath(".//*[@id='webBody']/div[1]/div[1]/div[3]/div/div/div/div[2]/form/div[1]/div/div/a[3]")).click();
		wait(5000);
		String url = driver.getCurrentUrl();
		if(!url.equals(urlForSavedForm.toString())){
			testResult += "\n 2.3 - salvar e finalizar com campos vazios - OK";
			successfulTestCases++;
		}else{
			testResult += "\n 2.3 - salvar e finalizar com campos vazios - Fail ";
		}
	}
		
	//3.4 Salvar e finalizar
	protected void saveAndFinhsh(){
		totalTestCases++;
		if (driver.getCurrentUrl().equals(urlForSavedForm.toString())){
			returnToForm();
			wait(3000);
		}
		driver.findElement(By.xpath(".//*[@id='webBody']/div[1]/div[1]/div[3]/div/div/div/div[2]/form/div[3]/div/div[1]/div[2]/div/div[1]/field-directive/textarea")).sendKeys("Luciano Lemos");
		driver.findElement(By.xpath(".//*[@id='webBody']/div[1]/div[1]/div[3]/div/div/div/div[2]/form/div[3]/div/div[1]/div[3]/div/div[1]/field-directive/textarea")).clear();
		driver.findElement(By.xpath(".//*[@id='webBody']/div[1]/div[1]/div[3]/div/div/div/div[2]/form/div[3]/div/div[1]/div[3]/div/div[1]/field-directive/textarea")).sendKeys("luciano.eno@gmail.com");
		driver.findElement(By.xpath(".//*[@id='webBody']/div[1]/div[1]/div[3]/div/div/div/div[2]/form/div[2]/div/div/a[2]/i")).click();
		wait(1000);
		driver.findElement(By.xpath(".//*[@id='webBody']/div[1]/div[1]/div[3]/div/div/div/div[2]/form/div[3]/div/div[1]/div[2]/div/div[1]/field-directive/textarea")).sendKeys(
				"Não conhecia sobre a área de atuação da PariPassu, então busquei informações e acabei, de certa forma, me identificando: sou graduado em enologia e trabalhei na primeira "
				+ "industria de vinhos do Brasil a implementar um sistema de rastreablidade produtiva. Conheço a importância e a necessidade deste trabalho e quero fazer parte disso");
		driver.findElement(By.xpath(".//*[@id='webBody']/div[1]/div[1]/div[3]/div/div/div/div[2]/form/div[3]/div/div[1]/div[3]/div/div[1]/field-directive/textarea")).sendKeys(
				"Eu gosto das coisas funcionando corretamente, pois, como usuário, me sinto muito frustrado utilizando um software que não funciona como deveria ou não cobre minha expectativas."
				+ "Na área de qualidade de software vejo a oportunidade de garantir que outros usuários não se sintam assim ao utilizar \"meu\" software.");
		driver.findElement(By.xpath(".//*[@id='webBody']/div[1]/div[1]/div[3]/div/div/div/div[2]/form/div[3]/div/div[1]/div[4]/div/div[1]/field-directive/textarea")).sendKeys(
				"Em geral, sou uma pessoa bastante calma, e costumo manter a calma nesse tipo de situação, buscando diferentes pontos de vistas e opiniões para encontrar a melhor alternativa de solução");
		driver.findElement(By.xpath(".//*[@id='webBody']/div[1]/div[1]/div[3]/div/div/div/div[2]/form/div[1]/div/div/a[3]")).click();
		wait(5000);
		String url = driver.getCurrentUrl();
		if(url.equals(urlForSavedForm.toString())){
			testResult += "\n 2.4 - salvar e finalizar - OK";
			successfulTestCases++;
		}else{
			testResult += "\n 2.4 - salvar e finalizar - Fail ";
		}
	}
	
	
	protected void goToForm(){
		driver.findElement(By.xpath(".//*[@id='navigation']/ul/li[2]/a")).click();
		wait(2000);
		driver.findElement(By.xpath(".//*[@id='navigation']/ul/li[2]/ul/li[3]/a")).click();
		wait(2000);
		driver.findElement(By.xpath(".//*[@id='webBody']/div[1]/div[1]/div[3]/div/div/div/div/div[1]/div/div[3]/ul/li/a")).click();
		wait(2000);
		driver.findElement(By.xpath(".//*[@id='webBody']/div[1]/div[1]/div[3]/div/div/div/div/div/div/div[3]/ul/li/a")).click();
		wait(2000);
	}

	protected void returnToForm () {
		driver.findElement(By.xpath(".//*[@id='webBody']/div[1]/div[1]/div[3]/div/div/div/div[4]/div/table/tbody/tr/td[9]/button[2]")).click();
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
