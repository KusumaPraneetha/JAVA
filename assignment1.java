import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","//Users//kusumapraneetha//Documents//Selenium//chromedriver");
		WebDriver driver=new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		driver.findElement(By.cssSelector("input[value='option1']")).click();;
		System.out.println(driver.findElement(By.xpath("//input[@type='checkbox']")).getSize());
		driver.close();
	}

}
