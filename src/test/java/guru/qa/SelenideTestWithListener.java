package guru.qa;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTestWithListener {
    @Test
    public void testNameCheck(){
        SelenideLogger.addListener("allure", new AllureSelenide()); //подключает слушателей
        open("https://github.com/");
        $(".header-search-input").sendKeys("VOPdg/MyHomework_12_7");
        $(".header-search-input").submit();
        $(By.linkText("VOPdg/MyHomework_12_7")).click();
        $("#issues-tab").shouldHave(text("Issues"));
    }
}
