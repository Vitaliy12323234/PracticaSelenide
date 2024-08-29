package org.example;

import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Selenide.$x;

public class CreateInfo {
    @Step("Добавить значение в профиль")
    public static void create() {
        $x("//*[@id='root']/header/div/a/div/img").click();
        $x("//input[@placeholder='Имя']").setValue("Вет");
        $x("//input[@placeholder='Фамилия']").setValue("Рут");
        File file = $x("/html/body/div/div/div/div[1]/div/div/form/div[5]/div/input")
                .uploadFile(new File("src/test/resources/e.png"));
        $x("/html/body/div/div/div/div[1]/div/div/form/button").click();

    }
}