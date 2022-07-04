import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CallbackTest {
    @Test
    void shouldSubmitRequest() {
        open("http://localhost:9999/");
        SelenideElement from = $("[data-test-id=callback-form");
        from.$("data-test-id=name] input").setValue("Василий");
        from.$("data-test-id=phone] input").setValue("+79678765645");
        from.$("data-test-id=agreement]").click();
        from.$("data-test-id=button]").click();
        $(".order-success").shouldHave(exactText("Ваша заявка успешно отправлена!Наш менеджер свяжется с вамив ближайшее время."));
    }
}
