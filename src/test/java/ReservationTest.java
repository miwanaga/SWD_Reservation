import org.openqa.selenium.WebDriver;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import org.junit.After;

public class ReservationTest {

	private WebDriver driver;

	@Before
	public void setup() {
		//TODO: Replace property with path to your chromedriver.exe
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Silk\\Silk WebDriver\\ng\\WebDriversSWD\\Windows\\Chrome\\2.33\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void myTestCaseName() {
		driver.get("http://example.selenium.jp/reserveApp/");
		driver.findElement(By.id("reserve_year")).clear();
		driver.findElement(By.id("reserve_year")).sendKeys("2018");
		driver.findElement(By.id("reserve_month")).clear();
		driver.findElement(By.id("reserve_month")).sendKeys("1");
		driver.findElement(By.id("reserve_day")).clear();
		driver.findElement(By.id("reserve_day")).sendKeys("27");
		driver.findElement(By.id("headcount")).clear();
		driver.findElement(By.id("headcount")).sendKeys("2");
		driver.findElement(By.id("plan_a")).click();
		driver.findElement(By.id("guestname")).sendKeys("日本 太郎");
		driver.findElement(By.id("goto_next")).click();
		WebElement price2 = driver.findElement(By.id("price"));
		Assert.assertEquals("21500", price2.getText());
		Assert.assertEquals(true, price2.isDisplayed());
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}