package src.test.java.steps;

import cucumber.api.java.ru.И;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.core.context.RetryerContext;
import io.qameta.atlas.core.internal.DefaultRetryer;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import io.qameta.atlas.webdriver.WebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import src.main.java.utils.AuthReader;
import src.main.java.utils.Element;
import src.main.java.utils.SaveCache;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.Collections;



public class Auth_Steps {
    protected WebDriver driver;
    protected Atlas atlas;
    public static Auth_Steps INSTANCE = new Auth_Steps();
    SaveCache saveCache = new SaveCache(4);

    public Auth_Steps() {

    }

    public static Auth_Steps getInstance() { // #3
        return INSTANCE;        // вернуть ранее созданный объект
    }

    @И("открыта главная страница Интернет-банк")
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://idemo.bspb.ru/");
        atlas = new Atlas(new WebDriverConfiguration(driver))
                .context(new RetryerContext(new DefaultRetryer(3000L, 1000L, Collections.singletonList(Throwable.class))));
    }

    @И("авторизоваться в системе, заполнив поля {string}, {string}")
    public void newAuth(String login, String pass) throws IOException {
        AuthReader reader = new AuthReader();
        pageElement().logPassField(login).sendKeys(reader.Testread(login));
        pageElement().logPassField(pass).sendKeys(reader.Testread(pass));
        System.out.println("Config " + reader.Testread(login));
    }

    @И("подождать {int} секунд")
    public void waiting(int login) throws IOException {
        driver.manage().timeouts().implicitlyWait(login, TimeUnit.SECONDS);
    }


    protected Element pageElement() {
        return elem(Element.class);
    }

    protected <T extends WebPage> T elem(Class<T> page) {
        return atlas.create(driver, page);
    }

}
