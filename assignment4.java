import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignment4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","//Users//kusumapraneetha//Documents//Selenium//chromedriver");
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.cssSelector("a[href='/windows']")).click();
		driver.findElement(By.cssSelector("a[href='/windows/new']")).click();
		
		Set<String> id= driver.getWindowHandles();
		Iterator<String> it= id.iterator();
		String w1 = it.next();
		String w2 = it.next();
		//String w3 = it.next();
		
		driver.switchTo().window(w2);
		System.out.println(driver.findElement(By.cssSelector("div[class='example']")).getText());
		
		driver.switchTo().window(w1);
		System.out.println(driver.findElement(By.xpath("//*[@id='content']/div/h3")).getText());
		
	}

}
