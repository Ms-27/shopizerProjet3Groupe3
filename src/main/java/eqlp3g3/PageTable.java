package eqlp3g3;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageTable extends PageAbstractBandeau {
	
	@FindBy (xpath="//li[@class='active']/a[@href='http://localhost:8080/shop/shop/category/tables.html/ref=c:1,1']")
	private WebElement titre_pagetable;
	

}
