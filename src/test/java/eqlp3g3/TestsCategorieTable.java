package eqlp3g3;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eqlp3g3.TestsCategorieTable;
import eqlp3g3.ENavigateur;
import eqlp3g3.SocleTechnique;

public class TestsCategorieTable {
	static Logger logger = LoggerFactory.getLogger(TestsCategorieTable.class);
	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	
	@Before
	public void setUp() throws Exception {

		driver = SocleTechnique.choisirNavigateur(logger, ENavigateur.c);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
		action = new Actions(driver);
	}
	
	@After
	public void tearDown() {
	driver.quit();
	}

	
	@Test
	public void test() throws InterruptedException {
		driver.get("http://grp3automobo.ddns.net:8090/shop/");
		
		//PAS 1 Instanciation page accueil  
		PageAccueil page_accueil = PageFactory.initElements(driver, PageAccueil.class);
		
		//PAS 2 Instanciation page catégorie Table et vérification présence articles
		PageTable page_table = page_accueil.clicCategorieTable(driver);
		assertTrue(page_table.titre_pagetable.isDisplayed()
				&&page_table.produit_natural.isDisplayed()
				&&page_table.produit_asian.isDisplayed()
				&&page_table.produit_edge.isDisplayed()
				&&page_table.produit_coffee.isDisplayed());
		
		
		//PAS 3 Vérification présence éléments
		SocleTechnique.isElementPresent(page_table.image_pagetable,logger);
		assertTrue(page_table.bouton_ajoutpanier.isDisplayed());
		assertTrue(page_table.prix_initial.getText().substring(0,3).equals("US$"));
		assertTrue(page_table.produit_natural.getText().equals("Natural Root Console"));
		
		//PAS 4 Filtre Asian Woods
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("hideTemplateLoading();");
		wait.until(ExpectedConditions.visibilityOf(page_table.filtre_AsianWood));
		page_table.filtre_AsianWood.click();
		SocleTechnique.isElementPresent(page_table.produit_coffee, logger);
		
		//Stockage prix élément page table
		String prix_page_table = page_table.prix_initial.getText();
		
		//PAS 5 Instanciation page detail 
		 page_table.produit_coffee.click();
		 PageDetail page_detail = PageFactory.initElements(driver, PageDetail.class);
		 
		 //PAS 6 verification des éléments présents dand page detail
		 //stockage prix élément page detail et verification prix identique d'une page à l'autre
		 String prix_page_detail = page_detail.prix_initial.getText();
		 assertTrue(prix_page_table.equals(prix_page_detail));
		 
		 //trouve elements étoiles et les comptes
		 int myCount = driver.findElements(By.xpath("//div[@id='productRating']/img")).size();
		 
		 //verification nombre etoiles
		 assertEquals(5, myCount);
		 
		 //verification présence devise et bouton ajput panier
		 assertTrue(page_table.prix_initial.getText().substring(0,3).equals("US$"));
		 assertTrue(page_detail.bouton_ajoutpanier.isDisplayed());
		 assertTrue(page_detail.nom_produit.isDisplayed());
		 
		 
	}
	
}
