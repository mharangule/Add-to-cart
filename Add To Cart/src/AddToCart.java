import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		int count=0;
		List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
		String[] itemsNeeded= {"Cucumber","Brocolli","Beetroot"};
		List al = Arrays.asList(itemsNeeded);
		for(int i=0;i<products.size();i++)
		{
			String[] name=products.get(i).getText().split("-");
			String formattedString=name[0].trim();
			if(al.contains(formattedString))
			{
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				count++;
				if(count==itemsNeeded.length)
					break;
				
			}
		}
		
		

	}

}
