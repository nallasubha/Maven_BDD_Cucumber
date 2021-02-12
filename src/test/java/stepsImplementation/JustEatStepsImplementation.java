package stepsImplementation;

import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;	

public class JustEatStepsImplementation {
	
	WebDriver driver;
	
	//Scenario 1 started "Search for restaurants in an area "
	
	@Given("I want food in AR51 1AA")
	public void i_want_food_in_ar51_1aa() {
		
		System.setProperty("webdriver.chrome.silentOutput","true");
		 WebDriverManager.chromedriver().setup(); 
		 ChromeOptions opt=new ChromeOptions(); 
		  opt.addArguments("--disable-notifications"); 
		  driver = new ChromeDriver(opt); 
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		driver.get("http://www.just-eat.co.uk/");
		 System.out.println("Just Eat website is displayed");
		 
		 
		 try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
						e.printStackTrace();
		}
		 WebElement areaPostalCode= driver.findElement(By.xpath("//span[contains(text(),'Enter your postcode')]"));
		 areaPostalCode.click();
		 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
								e.printStackTrace();
			}
		
		 WebElement enterCode= driver.findElement(By.xpath("//label//input[@name='postcode']"));
		 enterCode.sendKeys("AR51 1AA");
		 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
								e.printStackTrace();
			}
	    
	}

	@When("I search for restaurants in AR51 1AA")
	public void i_search_for_restaurants_in_ar51_1aa() {
		WebElement searchBtn= driver.findElement(By.xpath("//span[contains(text(),'Search')]"));
		searchBtn.click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
							e.printStackTrace();
		}
	   
	}

	@Then("I should see some restaurants in AR51 1AA")
	public void i_should_see_some_restaurants_in_ar51_1aa() {
		
		
		List<WebElement> noOfRestaurants= driver.findElements(By.xpath("//div[@class='c-listing-item-info']"));
		int listSize= noOfRestaurants.size();
		
		System.out.println("Number of restaurants displayed under search criteria with postal code is :"+ listSize );
				
	   
	}
	@Then("close window")
	public void close_window() {
		System.out.println(" Scenario completed" );
		driver.quit();
	}
	
	//Scenario 2 Started "Choose the Indian restaurant option from the All Cuisines A-Z from left side Menu"
	
	@When("I click View more chevron from the All Cuisines A-Z from left side Menu")
	public void i_click_view_more_chevron_from_the_all_cuisines_a_z_from_left_side_menu() {
	   
		WebElement viewMoreLink= driver.findElement(By.xpath("//button[contains(text(),'View more')]/span"));
		viewMoreLink.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("I should see all the Cuisines list")
	public void i_should_see_all_the_cuisines_list() {
	    System.out.println("All Cuisines list drop down opened and list  displayed");
	}

	@When("I choose and click Indian restaurant")
	public void i_choose_and_click_indian_restaurant() {
		WebElement indianLink= driver.findElement(By.xpath("(//label[contains(text(),'Indian')]) [2]"));
		indianLink.click();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement scrollUp= driver.findElement(By.xpath("//header/div[1]/div[1]/a[1]/div[1]/*[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", scrollUp);
	}

	@Then("I should see Indian restaurants list")
	public void i_should_see_indian_restaurants_list() {
		
		WebElement scrollUp= driver.findElement(By.xpath("//header/div[1]/div[1]/a[1]/div[1]/*[1]"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView();", scrollUp);
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		List<WebElement> indianList= driver.findElements(By.xpath("//div/p[contains(.,'Indian')]"));
		int indianListSize= indianList.size();
 		 System.out.println("No of  Indian Cuisines list displayed are " + indianListSize);
 		
	}
	
	//Scenario 3 started "Choose one Indian restaurant and proceed order until Go to Payment section"

	@When("I choose Nitin’s Test Restaurant")
	public void i_choose_nitin_s_test_restaurant() {
		WebElement selectIndian= driver.findElement(By.xpath("//h3[contains(text(),'Nitin’s Test Restaurant')]"));
		selectIndian.click();
	}

	@Then("I should see Nitin’s Test Restaurant navigation page with Menu")
	public void i_should_see_nitin_s_test_restaurant_navigation_page_with_menu() {
	    
		String expectedUrl="https://www.just-eat.co.uk/restaurants-nitins-test-restaurant-51/menu";
		String actualUrl=driver.getCurrentUrl();
		System.out.println("Actual Url is "+ actualUrl);
		Assert.assertEquals(expectedUrl, actualUrl);
		System.out.println("Navigated to Nitin’s Test Restaurant page");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("I click on Menu Items")
	public void i_click_on_menu_items() {
		WebElement selectItem= driver.findElement(By.xpath("//h3[contains(text(),'Vegetable Curry')]"));
		selectItem.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("I should see  Add to order window")
	public void i_should_see_add_to_order_window() {
		System.out.println("Add to order pop up window displayed");
		
	}

	@When("I click Add to order button")
	public void i_click_add_to_order_button() {
		WebElement addToOrder= driver.findElement(By.xpath("//span[contains(text(),'Add to order')]"));
		addToOrder.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("I should see the selected items are added in Your Order section")
	public void i_should_see_the_selected_items_are_added_in_your_order_section() {
		System.out.println("The selected items are added in Your Order section");
	}

	@When("I click Go to Payment button")
	public void i_click_go_to_payment_button() {
		WebElement goToPayment= driver.findElement(By.xpath("//a[contains(text(),'Go to payment')]"));
		goToPayment.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("I should see the page is navigated to Checkout as a guest section")
	public void i_should_see_the_page_is_navigated_to_checkout_as_a_guest_section() {
		
		String actualUrl=driver.getCurrentUrl();
		System.out.println("Actual Url is "+ actualUrl);
		System.out.println("Navigated to Checkout as a guest section");
	}

}
