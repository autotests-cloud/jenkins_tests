package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;


class GoogleTests extends TestBase {

    @Test
    void positiveSelenideSearchTest() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

        // Открыть google
        open("https://google.com");

        // Ввести Selenide в поиск
        $(byName("q")).setValue("Selenide").pressEnter(); // кнопка логина

        // Проверить, что Selenide появился в результатах поиска
        $("#rso").shouldHave(text("selenide.org"));
    }

    @Test
    void negativeSelenideSearchTest() {

        // Открыть google
        open("https://google.com");

        // Ввести Selenide в поиск
        $(byName("q")).setValue("Selenide").pressEnter(); // кнопка логина

        // Проверить, что Selenide появился в результатах поиска
        $(".search-results").shouldHave(text("selenide.org"));
    }

    @Test
    void negativeJenkinsTest() {
        // Открыть google
        open("https://jenkins.autotests.cloud/view/QA.GURU%20examples/job/jenkins_tests/ws/build/");
    }


}
