package guru.qa;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {
    @Test
    @Owner("Veronika Podgol")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Задачи в репозитории")
    @Story("Просмотр созданных задач в репозитории")
    @DisplayName("Проверка названия Issues в репо")
    @Link(value = "Тестинг", url = "https://github.com")
    @Description("Тест проверяет название Issues в репо")
    public void testAnnotated() {
    }
    @Test
    public void testCode() {
        Allure.label("owner", "eroshenkoam");
        Allure.label("severity", SeverityLevel.CRITICAL.value());
        Allure.feature("Задачи в репозитории");
        Allure.story("Просмотр созданных задач в репозитории");
        Allure.link("Тестинг", "https://github.com");
    }

}
