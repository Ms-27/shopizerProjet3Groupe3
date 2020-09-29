package eqlp3g3;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageAccueil extends PageAbstractBandeau {

	@FindBy (xpath = "//a[@productid='150']")
	WebElement ajoutpanier_ThaiFlatCussion;
}
