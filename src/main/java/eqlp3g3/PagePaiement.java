package eqlp3g3;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PagePaiement extends PageAbstractBandeau {

	@FindBy (xpath = "//h1[@class='entry-title']")
	WebElement titre_paiement;
}
