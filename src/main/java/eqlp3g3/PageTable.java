package eqlp3g3;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageTable extends PageAbstractBandeau {
	
	@FindBy (xpath="//h2[@class='shop-banner-title lead' and contains(.,'Tables')]")
	WebElement titre_pagetable;
	
	@FindBy (xpath="//h3[@itemprop='name' and contains(.,'Natural root')]")
	WebElement produit_natural;
	
	@FindBy (xpath="//h3[@itemprop='name' and contains(.,'Asian rosewood')]")
	WebElement produit_asian;
	
	@FindBy (xpath="//h3[@itemprop='name' and contains(.,'Edge')]")
	WebElement produit_edge;
	
	@FindBy (xpath="//h3[@itemprop='name' and contains(.,'Coffee')]")
	WebElement produit_coffee;
	
	@FindBy (xpath = "//ul[@class='nav nav-list']/li[3]")
	WebElement filtre_AsianWood;
	
	@FindBy (xpath ="//div [@id='productsContainer']//div[@item-name='Natural root console']//img")
    WebElement image_pagetable;
	
	@FindBy (xpath ="//a[@productid='200']")
	WebElement bouton_ajoutpanier;
	
	@FindBy (xpath = "//span[@itemprop='price']")
	WebElement prix_initial;
}
