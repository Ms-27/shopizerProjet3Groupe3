package eqlp3g3;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageDetail extends PageAbstractBandeau {

	@FindBy (xpath = "//span[@itemprop='price']")
	WebElement prix_initial;
	
	@FindBy (xpath ="//button[@class='btn addToCart addToCartButton btn-buy']")
	WebElement bouton_ajoutpanier;
	
	@FindBy (xpath = "//h3[contains(text(),'Coffee table Accacia')]")
	WebElement nom_produit;
}
