package ru.netology.web.test;

import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.LoginPageV1;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.awt.SystemColor.info;

class MoneyTransferTest {
  @Test
  void shouldTransferMoneyBetweenOwnCardsV1() {
    open("http://localhost:9999");
    var loginPage = new LoginPageV1();
    var authInfo = DataHelper.getAuthInfo();
    var verificationPage = loginPage.validLogin(authInfo);
    var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
    verificationPage.validVerify(verificationCode);
    var cardsSecond = DataHelper.getCardSecond();

    loginPage
            .validLogin(authInfo)
            .validVerify(verificationCode)
            .validFirstTransfer(cardsSecond);


  }
  @Test
  void shouldTransferMoneyBetweenOwnCardsV1My() {
    open("http://localhost:9999");
    $("[data-test-id=login] input").setValue("vasya");
    $("[data-test-id=password] input").setValue("qwerty123");
    $("[data-test-id=action-login]").click();
    $(byText("Интернет Банк")).shouldBe(visible);


    $("[data-test-id=code] input").setValue("12345");
    $("[data-test-id=action-verify]").click();
    $("[data-test-id=dashboard]").shouldBe(visible);

    $$("[data-test-id=action-deposit]").get(0).click();
    $(byText("Пополнение карты")).shouldBe(visible);

    $("[data-test-id=amount] input").setValue("1000");
    $$("[data-test-id=from] input").get(0).setValue("5559 0000 0000 0002");
    $$("[data-test-id=action-transfer]").get(0).click();
    $("[data-test-id=dashboard]").shouldBe(visible);
  }

}

