package guru.qa;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

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
    }

}
