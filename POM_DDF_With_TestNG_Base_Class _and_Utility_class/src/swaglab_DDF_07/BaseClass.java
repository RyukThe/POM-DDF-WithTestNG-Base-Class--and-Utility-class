package swaglab_DDF_07;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass 
{
	WebDriver m ;
	public void OpenBrowser()
	{
		m =new ChromeDriver();
		m.manage().window().maximize();
		m.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		m.navigate().to("https://www.saucedemo.com/");
	}

}
