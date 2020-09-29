package eqlp3g3;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PagePanier extends PageAbstractBandeau {

	@FindBy (id = "mainCartTable")
	WebElement tableau_recap;

	@FindBy (xpath = "//input[@name='quantity']")
	WebElement quantite;

	@FindBy (xpath = "//a[text()='Recalculer']")
	WebElement btn_recalculer;

	@FindBy (xpath = "//div[@class='cart_totals']")
	WebElement tableau_totaux;

	@FindBy (xpath = "//a[text()='Effectuer le paiement']")
	WebElement btn_effectuer_paiement;
	
	@FindBy (xpath = "//h1[@class='entry-title']")
	WebElement titre_page_panier;
	
	@FindBy (xpath = "//div[@class='cart-img']/img")
	WebElement image_article;
	
}
