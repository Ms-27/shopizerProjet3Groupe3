package eqlp3g3;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestsPanier {
	
	WebDriver driver;
	protected static final Logger LOGGER = LoggerFactory.getLogger(TestsPanier.class);
	
	@Before
	public void setUp() throws InterruptedException {
		driver = SocleTechnique.choisirNavigateur(LOGGER, ENavigateur.f);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://grp3automobo.ddns.net:8090/shop/");
	}
	
	@After
	public void tearDown() {
		
		driver.quit();	
	}
	
	@Test
	public void testPanier() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		//STEP 1
		//instanciation page accueil
		PageAccueil page_accueil = PageFactory.initElements(driver, PageAccueil.class);
		
		//Test pour voir si le login s'est bien déroulé
//		wait.until(ExpectedConditions.visibilityOf(page_Accueil.));
//		assertTrue("La page accueil n'est pas affichée", page_accueil..isDisplayed());
		
		//STEP2
		//Ajout d'un objet dans le panier
		page_accueil.ajoutpanier_ThaiFlatCussion.click();
		
		//Vérification de l'incrémentation du panier
		System.out.println(page_accueil.nb_elem_panier.getText());
		assertTrue("Le panier n'est pas incrémenté", page_accueil.nb_elem_panier.getText().equals("(1)"));
		
		//STEP3
		//Clic sur paiement après mouse over sur le panier
		Actions a = new Actions(driver);
		a.moveToElement(page_accueil.panier_achat).build().perform();
		a.moveToElement(page_accueil.panier_achat).click().build().perform();
		wait.until(ExpectedConditions.visibilityOf(page_accueil.paiement));
		page_accueil.paiement.click();
		PagePanier page_panier = PageFactory.initElements(driver, PagePanier.class);
		
		//Vérification que la page Revoir votre commande est affichée
		assertTrue("La page Revoir votre commande n'est pas affichée", page_panier.titre_page_panier.isDisplayed());
		
		//STEP4
		//Vérification de la présence de l'objet sélectionné
		assertTrue(SocleTechnique.chercherElement(driver, "Thai flat cussion", "//table[@id='mainCartTable']/tbody/tr"));
		//Vérification de la présence d'une image
		SocleTechnique.isElementPresent(page_panier.image_article, LOGGER);
		//Vérification de la présence d'un tableau
		assertTrue(SocleTechnique.chercherElementEntete(driver, "Article", "//table[@id='mainCartTable']/thead/tr"));
		assertTrue(SocleTechnique.chercherElementEntete(driver, "Quantité", "//table[@id='mainCartTable']/thead/tr"));
		assertTrue(SocleTechnique.chercherElementEntete(driver, "Prix", "//table[@id='mainCartTable']/thead/tr"));
		assertTrue(SocleTechnique.chercherElementEntete(driver, "Total", "//table[@id='mainCartTable']/thead/tr"));
		
	}

}
