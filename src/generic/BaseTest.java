package generic;



import java.util.List;																								
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;


@Listeners(Result.class)
abstract public class BaseTest implements IAutoConst {
//	private static final String CONFIG_PATH = null;
	public WebDriver driver;//webdriver should neither be static(we can run only on one specific browser)
	                        //webdriver should not be final because we cannot run parallel execution
	public String url = Utility.getPropertyValue(CONFIG_PATH, "URL");
	String ITO = Utility.getPropertyValue(CONFIG_PATH, "ITO");
	public long duration = Long.parseLong(ITO);
	public static String chrome_key="webdriver.chrome.driver";
	public static String chrome_value="./driver/chromedriver.exe";
	public static String gecko_key="webdriver.gecko.driver";
	public static String gecko_value="./driver/geckodriver.exe";
	static {
		System.setProperty(chrome_key,chrome_value);
		System.setProperty(gecko_key,gecko_value);
	}

	@BeforeMethod
	public void openApplication()
	{
	    driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
		driver.get(url);	
	}
	
	@AfterMethod
	public void CloseApplication()
	{
		driver.close();
	}

}
