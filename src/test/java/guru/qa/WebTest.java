package guru.qa;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebTest {

    @Step("Открываем гитхаб")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Ищем репо {repository}")
    public void searchRepo(String repository) {
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }

    @Step("Переходим в репо {repository}")
    public void openRepoPage(String repository) {
        $(By.linkText(repository)).click();
    }

    @Step("Проверяем название Issues в репо {repository}")
    public void checkIssuesName(String repository) {

        $("#issues-tab").shouldHave(text("Issues"));
        attachScreenshot();
    }

    @Attachment(value = "Мой любимый скриншот", type = "image/png", fileExtension = "png")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
