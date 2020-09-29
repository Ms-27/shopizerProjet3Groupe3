package eqlp3g3;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class PageAbstractBandeau {

	@FindBy (xpath = "//span[@class='lnr lnr-cart']")
	WebElement panier_achat;

	@FindBy (xpath = "//a[@onclick='viewShoppingCartPage();']")
	WebElement paiement;

	@FindBy (xpath = "//div [@class='mainmenu hidden-xs']//a[text()='Tables']")
	WebElement tables_category;
}
