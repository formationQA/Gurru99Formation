package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class GurroPage extends BasePageObject{
    public GurroPage(WebDriver driver) {
        super(driver);
    }

    private By ReadText =
            By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div/div/h2");

    private By ClickMobile =
            By.xpath("/html/body/div[1]/div/header/div/div[3]/nav/ol/li[1]/a\n");
   private By ReadTitle =
           By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div[1]/div[1]/h1\n");

   private By ListeDeroulante =
           By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select\n");

    public void GetTitre (String Titre){
        String TitreOriginal = driver.getTitle();
        Assert.assertEquals("Les deux titre sont pareils",TitreOriginal,Titre);
    }

    public void  GetText ()
    {
      String text1 =  driver.findElement(ReadText).getText().trim();
      StringBuilder text = new StringBuilder(text1);
      text.indexOf("FOR");
      text.delete(text.indexOf("FOR"),text.indexOf("FOR")+"FOR".length());
      System.out.print(text);
      Assert.assertEquals("THIS IS DEMO SITE",text.toString().trim());
    }

    public void CliquerMobile (){
        driver.findElement(ClickMobile).click();
    }


    public void VerifTitle (){
        String TitreOriginal = driver.findElement(ReadTitle).getText();
        System.out.println(TitreOriginal);
        Assert.assertEquals("MOBILE",TitreOriginal);
    }


    public void SelectionnerParNom (String Value){
        Select instance = new Select(driver.findElement(ListeDeroulante));
        instance.selectByVisibleText(Value);


    }








}
