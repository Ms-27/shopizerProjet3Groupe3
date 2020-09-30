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
	static Logger LOGGER = LoggerFactory.getLogger(TestsPanier.class);
	
	@Before
	public void setUp() throws InterruptedException {
		driver = SocleTechnique.choisirNavigateur(LOGGER, ENavigateur.c);
		driver.manage().window().maximize();
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
		//Instanciation page d'accueil
		PageAccueil page_accueil = PageFactory.initElements(driver, PageAccueil.class);
		
		//Test pour voir si le login s'est bien déroulé
		wait.until(ExpectedConditions.visibilityOf(page_accueil.ajoutpanier_ThaiFlatCussion));
		assertTrue("La page accueil n'est pas affichée", driver.getTitle().equals("Importa"));
		
		
		//STEP2
		//Ajout d'un objet dans le panier
		page_accueil.ajoutpanier_ThaiFlatCussion.click();
		
		//Vérification de l'incrémentation du panier
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
		//Vérification de la présence du tableau
		assertTrue(SocleTechnique.chercherElementEntete(driver, "ARTICLE", "//table[@id='mainCartTable']/thead/tr"));
		assertTrue(SocleTechnique.chercherElementEntete(driver, "QUANTITÉ", "//table[@id='mainCartTable']/thead/tr"));
		assertTrue(SocleTechnique.chercherElementEntete(driver, "PRIX", "//table[@id='mainCartTable']/thead/tr"));
		assertTrue(SocleTechnique.chercherElementEntete(driver, "TOTAL", "//table[@id='mainCartTable']/thead/tr"));
		
		//Vérification de la présence de l'objet sélectionné
		assertTrue(SocleTechnique.chercherElement(driver, "Thai flat cussion", "//table[@id='mainCartTable']/tbody/tr"));
		
		//Vérification de la présence d'une image
		SocleTechnique.isElementPresent(page_panier.image_article, LOGGER);
		
		//Vérification de la quantité
		assertTrue("La quantité indiquée n'est pas correcte", page_panier.quantite_article.getAttribute("value").equals("1"));
		
		//Vérification du prix par article
		SocleTechnique.isElementPresent(page_panier.prix_article, LOGGER);
		
		//Récupère le prix de l'article en String (écarte le US$ de la sélection)
		String prix_article_un = page_panier.prix_article.getText().substring(3, 8);
		
		//Vérification du total par section
		SocleTechnique.isElementPresent(page_panier.total_section, LOGGER);
		
		//Récupère le total de la section en String (écarte le US$ de la sélection)
		String total_section_un = page_panier.total_section.getText().substring(3, 8);
		
		
		//STEP5
		//Doublement de la quantité
		SocleTechnique.renseignerChamps(page_panier.quantite_article, "2");
		
		//Vérification du doublement de la quantité
		assertTrue("La quantité n'a pas été doublée", page_panier.quantite_article.getAttribute("value").equals("2"));
		
		//Vérification que les prix n'ont pas été modifiés
		assertTrue("Le prix de l'article a changé", page_panier.prix_article.getText().substring(3, 8).equals(prix_article_un));
		assertTrue("Le total de section a changé", page_panier.total_section.getText().substring(3, 8).equals(total_section_un));
		
		
		//STEP6
		//Clic sur le bouton Recalculer
		page_panier.btn_recalculer.click();
		Thread.sleep(500);
		
		//Vérification de la mise à jour des totaux
		String total_section_deux = page_panier.total_section.getText().substring(3, 9);
		double prix_article_double = Double.parseDouble(prix_article_un);
		double total_section_double = Double.parseDouble(total_section_deux);
		assertTrue("Le total de section n'a pas été multiplié par deux", total_section_double == prix_article_double*2);
		String total_commande_deux = page_panier.total_commande.getText().substring(3, 9);
		double total_commande_double = Double.parseDouble(total_commande_deux);
		assertTrue("Le total de la commande n'a pas été multiplié par deux", total_commande_double == prix_article_double*2);
		
		
		//STEP7
		//Clic sur le bouton Effectuer le paiement
		page_panier.btn_effectuer_paiement.click();
		
		//Vérification que la page de paiement est affichée
		PagePaiement page_paiement= PageFactory.initElements(driver, PagePaiement.class);	
		assertTrue("La page de paiement n'est pas affichée", page_paiement.titre_paiement.isDisplayed());

	}

}
