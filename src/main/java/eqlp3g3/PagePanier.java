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

	@FindBy (xpath = "//a[text()='Effectuer le paiement']")
	WebElement btn_effectuer_paiement;
	
	@FindBy (xpath = "//h1[@class='entry-title']")
	WebElement titre_page_panier;
	
	@FindBy (xpath = "//div[@class='cart-img']/img")
	WebElement image_article;
	
	@FindBy (xpath = "//input[@class='input-small quantity text-center']")
	WebElement quantite_article;
	
	@FindBy (xpath = "//td[@data-th='Prix']/strong")
	WebElement prix_article;
	
	@FindBy (xpath = "//td[@data-th='Total']/strong")
	WebElement total_section;
	
	@FindBy (xpath = "//th[text()='Total']/following-sibling::td/span[@class='amount']")
	WebElement total_commande;
	
}
