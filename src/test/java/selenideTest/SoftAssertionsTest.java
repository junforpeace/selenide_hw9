package selenideTest;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionsTest {

    @Test
    void shouldHaveSoftAssertionsPage() {
        open("https://github.com");

        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("#wiki-tab").click();
        $(withText("Show 2 more pages…")).click();
        $("#wiki-pages-box").shouldHave(Condition.text("SoftAssertions"));
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $(".markdown-body").$(withText("Using JUnit5")).shouldBe(Condition.visible);

    }
}
