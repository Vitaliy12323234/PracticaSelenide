package org.example;

import io.qameta.allure.Step;
import java.io.File;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class News {

    @Step("Добавление валидной новости")
    public static void addValidNews() {
        $x("//*[@id='root']/header/div/a/div/img").click();
        $(byText("Добавить новость")).click();
        $x("//input[@placeholder='Название']").setValue("Про что то");
        $x("//input[@placeholder='Описание']").setValue("За чем то");
        $x("//input[@placeholder='Теги']").setValue("так,надо");
        //$x("//html/body/div[2]/div[3]/form/div[4]/div").click();
        File file = $x("/html/body/div[2]/div[3]/form/div[4]/div/input")
                .uploadFile(new File("src/test/resources/e.png"));
        $x("/html/body/div[2]/div[3]/form/button").click();
    }
}
