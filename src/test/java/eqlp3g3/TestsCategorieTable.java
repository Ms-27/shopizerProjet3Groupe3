package eqlp3g3;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
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

		driver = SocleTechnique.choisirNavigateur(logger, ENavigateur.f);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 7000);
		action = new Actions(driver);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

	
	@Test
	public void test() throws InterruptedException {
		driver.get("http://grp3automobo.ddns.net:8090/shop/");
		
		//Pas1 Intanciation page accueil  
		PageAccueil page_accueil = PageFactory.initElements(driver, PageAccueil.class);
	}
	
}
