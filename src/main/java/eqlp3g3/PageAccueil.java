package eqlp3g3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageAccueil extends PageAbstractBandeau {

	@FindBy (xpath = "//a[@productid='150']")
	WebElement ajoutpanier_ThaiFlatCussion;
	
	public PageTable clicCategorieTable (WebDriver driver) {
		tables_category.click();
		return PageFactory.initElements(driver, PageTable.class);
		
	}
}
