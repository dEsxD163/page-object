package ru.netology.web.page;

import ru.netology.web.data.DataHelper;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ValidTransfer {
    public DashboardPage validFirstTransfer(DataHelper.CardsSecond cardsSecond) {
        $$("[data-test-id=action-deposit]").get(0).click();
        $("[data-test-id=amount] input").setValue("1000");
        $$("[data-test-id=from] input").get(1).setValue(cardsSecond.getNumber());
        $$("[data-test-id=action-transfer]").get(0).click();
        return new DashboardPage();
    }

}
