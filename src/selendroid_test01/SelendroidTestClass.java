package selendroid_test01;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;

public class SelendroidTestClass {
	
	private static WebDriver driver = null;
	
@BeforeClass
public static void beforeClass() throws Exception {
	SelendroidCapabilities capa = new SelendroidCapabilities("io.selendroid.testapp:0.17.0");
	driver = new SelendroidDriver(capa);
}

@AfterClass
public static void afterClass() {
	driver.quit();
}

@Test
public void test1() {
	WebElement inputField = driver.findElement(By.id("my_text_field"));
	Assert.assertEquals("true", inputField.getAttribute("enabled"));
	inputField.sendKeys("Selendroid");
	Assert.assertEquals("Selendroid", inputField.getText());
}

@Test
public void test2() {
	WebElement element1 = driver.findElement(By.xpath("//Button[@id='waitingButtonTest']"));
	element1.click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
}
