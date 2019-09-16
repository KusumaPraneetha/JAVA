import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","//Users//kusumapraneetha//Documents//Selenium//chromedriver");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com");
		driver.findElement(By.xpath("//a[@title='Translate W3Schools']")).click();
		driver.findElement(By.xpath("//img[@src='https://www.google.com/images/cleardot.gif']")).click();
		driver.findElement(By.xpath("$0")).click();
		driver.close();
	}

}
