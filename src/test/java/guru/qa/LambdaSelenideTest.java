package guru.qa;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaSelenideTest {
    public static final String REPOSITORY = "VOPdg/MyHomework_12_7";
    @Test
    public void lambdaTestNameCheck() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем гитхаб", () -> {
            open("https://github.com/");
        });
        step("Ищем репо " + REPOSITORY, () -> {
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Переходим в репо " + REPOSITORY, () -> {
            $(By.linkText("VOPdg/MyHomework_12_7")).click();
        });
        step(" Проверяем название Issues в репозитории " + REPOSITORY, () -> {
            $("#issues-tab").shouldHave(text("Issues"));
        });
    }
}
