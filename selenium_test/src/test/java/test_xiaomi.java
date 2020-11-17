import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test_xiaomi {
    public   WebDriver driver;
    @Before
    public void browserSetup(){
        System.setProperty("webdriver.chrome.driver", "C:/q/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void test(){


        driver.get("https://xistore.by/");

        WebElement searchInput =  new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='title-search-input']")));
        searchInput.sendKeys("Redmi note 9 pro");
        WebElement btn = driver.findElement(By.xpath("//button[@class='input-search-button']"));
        btn.click();
        WebElement searchRezault= new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='search__page_item-name' and @href='/catalog/telefony/smartfon_xiaomi_redmi_note_9_pro/?offer=39907']")));
        searchRezault.click();
        WebElement gb= new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-type='128 Gb']")));
        gb.click();
        WebElement order=driver.findElement(By.xpath("//a[text()='КУПИТЬ']"));
        order.click();
        WebElement orderBuy= new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='ОФОРМИТЬ ЗАКАЗ']")));
        orderBuy.click();
        WebElement name= new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='ORDER_PROP_1']")));
        name.sendKeys("Ковтун Андрей Николаевич");
        WebElement mail=driver.findElement(By.xpath("//*[@id='ORDER_PROP_2']"));
        mail.sendKeys("kovtyn7@gmail.com");
        WebElement phone=driver.findElement(By.xpath("//*[@id='ORDER_PROP_3']"));
        phone.sendKeys("445427822");
        WebElement addres=driver.findElement(By.xpath("//*[@id='ORDER_PROP_7']"));
        addres.sendKeys("Рафиева 8");
        WebElement money=driver.findElement(By.xpath("//a[@class='ordersPayment--button js-click-radio active' and @data-block='Оплатить при получении']"));
        money.click();
        WebElement buy=driver.findElement(By.xpath("//*[@id='ORDER_CONFIRM_BUTTON']"));
        buy.click();
        WebElement finaL=new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Заказ сформирован']")));
        System.out.print(finaL.getText());
        Assert.assertTrue("lol", finaL.getText().equals("ЗАКАЗ СФОРМИРОВАН"));

    }
    @After
    public void browserKill(){
        driver.quit();
    }
}
