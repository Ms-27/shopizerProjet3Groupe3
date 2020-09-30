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
	
	@FindBy (xpath ="//li/a[contains(text(),'Asian Wood')]")
	WebElement filtre_asianwood;
	

}
