package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import java.io.File;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class NoNews {
        @Step("Добавление новости с пустыми полями")
        public static void noaddNews() {
            try {
                $x("//*[@id='root']/header/div/a/div/img").click();
                $(byText("Добавить новость")).click();
                $x("//input[@placeholder='Название']").setValue("");
                $x("//input[@placeholder='Описание']").setValue("");
                $x("//input[@placeholder='Теги']").setValue("");
                File file = $x("/html/body/div[2]/div[3]/form/div[4]/div/input")
                        .uploadFile(new File("/home/dunice/Downloads/e.png"));
                if (!$x("/html/body/div[2]/div[3]/form/button").isEnabled()) {
                    System.out.println("Кнопка 'ОТПРАВИТЬ' отключена.");
                } else {
                    $x("/html/body/div[2]/div[3]/form/button").click();
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Произошла ошибка при добавлении новости");
            }
        }
    }
