package teste;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import config.DriverConfig;
import config.Report;
import view.TestsConfigWindow;

public class Main {

	static TestsConfigWindow window;
	
	public static void main(String[] args) {
		
		ActionListener listener = new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				window.getButton().setEnabled(false);
				start();
				System.exit(0);
//				window.getWindow().setVisible(false);
			}
		};
		window = new TestsConfigWindow(listener);
		
	}

	public static void start(){
		DriverConfig driverConfig = new DriverConfig(window.getSelectedBrowser());
		RemoteWebDriver driver =  driverConfig.getDriver();
		Report report = new Report();
		TestCases testCases = new TestCases(driver);
		
		try{
			driver.get("http://clicq.paripassu.com.br");
			System.out.println("Navegador iniciado e site aberto");
			String url = driver.getCurrentUrl();
			System.out.println(url);
			Thread.sleep(5);
			
			testCases.init();
			
			
			
		}catch (Exception d) {
			System.out.println(d.getMessage());
			JOptionPane.showMessageDialog(null, "Teste encerrado por conta de comportamento inesperado"
					+ "\n" + d);
			System.exit(0);
		}
		
		try
	      {
	         PdfWriter writer = PdfWriter.getInstance(report.getDocument(), new FileOutputStream("TestResult.pdf"));
	         report.getDocument().open();
	         report.getDocument().add(new Paragraph("Resultado dos testes automatizados\n"));
	         report.getDocument().add(new Paragraph(testCases.getLoginTestResult()));
	         report.getDocument().add(new Paragraph(testCases.getFillFormTestResult()));
	         
	         report.getDocument().add(new Paragraph("Índice de sucesso - " + testCases.getSuccessfulTestCases() + " de " + testCases.getTotalTestCases()));
	         
	         report.getDocument().close();
	         writer.close();
	         
	         try {
				Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler TestResult.pdf");
			} catch (Exception e) {
				e.printStackTrace();
			}
	         //driver.navigate().to("file:///" + System.getProperty("user.dir").replace("\\", "/") + "/TestResult.pdf");
	         
	      } catch (Exception f)
	      {
	         f.printStackTrace();
	      }
		
		driver.close();
		
	}
}
