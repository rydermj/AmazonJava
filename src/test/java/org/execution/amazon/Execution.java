package org.execution.amazon;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.repository.amazon.AddedToCartPage;
import org.repository.amazon.HomePage;
import org.repository.amazon.ProductDetailsPage;
import org.repository.amazon.SearchResultPage;
import org.utility.amazon.BaseClass;

public class Execution extends BaseClass {
	static HomePage h1;
	static SearchResultPage s1;
	static ProductDetailsPage p1;
	static AddedToCartPage a1;
	
	public static void main(String[] args) {
		launchBrowser();
		launchUrl("https://www.amazon.in/");
		impWait();
		h1=new HomePage();
		WebElement search_bar = h1.getSearch_bar();
		search_bar.clear();
		search_bar.sendKeys("pen");
		h1.getClick_searchBtn().click();
		
		s1=new SearchResultPage();
		List<WebElement> search_result = s1.getSearch_result();
		search_result.get(1).click();
		
		switchToWindow(1);
		
		p1=new ProductDetailsPage();
		p1.getClick_addToCartBtn().click();
		
		extracted();
		
		
	}

	public static void extracted() {
		a1=new AddedToCartPage();
		boolean displayed = a1.getAddedToCartText().isDisplayed();
		if (displayed==true) {
			System.out.println("Product has been added to cart");
		} else {
			System.out.println("Product not added to cart");
		}
	}
	
	
}
