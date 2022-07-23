package com.iris22a;

import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.iris22a.config.TestBase;
import com.iris22a.uikeywords.UIKeyword;

public class ProductTest extends TestBase {
	@Test
	public void verifySerchResultForPoloMen() {
		UIKeyword.launchUrl("https://www.myntra.com");
		UIKeyword.enterText(By.xpath("//input[@placeholder=\"Search for products, brands and more\"]"),"polo men");
		UIKeyword.hitButton(KeyEvent.VK_ENTER);
		List<String> productTitles =UIKeyword.getTexts(By.xpath("//h3[@class='product-brand']"));
		for(String productTitle:productTitles) {
			Assert.assertTrue(productTitle.contains("polo"),"Product title does't contain s polo"+productTitle );
		}
	}

}
