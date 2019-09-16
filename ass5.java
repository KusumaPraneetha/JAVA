import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ass5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","//Users//kusumapraneetha//Documents//Selenium//chromedriver");
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		List<WebElement> Count = driver.findElements(By.tagName("a"));
		System.out.println(Count.size());
		driver.findElement(By.cssSelector("a[href='/nested_frames']")).click();
		//System.out.println(driver.findElement(By.tagName("frame")).getSize());
		
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
         System.out.println(driver.findElement(By.xpath("//div[contains(text(),'MIDDLE')]")).getText());
         
         driver.switchTo().defaultContent();
         driver.navigate().back();
	}
	

}
