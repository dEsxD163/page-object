package ru.netology.web.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
  private SelenideElement heading = $("[data-test-id=dashboard]");
  private ElementsCollection cards = $$(".list__item div"); //tyt
  private final String balanceStart = "баланс: ";
  private final String balanceFinish = " р.";

  public DashboardPage() {
    heading.shouldBe(visible);
  }
  private int extractBalance(String text) {
    val start = text.indexOf(balanceStart);
    val finish = text.indexOf(balanceFinish);
    val value = text.substring(start + balanceStart.length(), finish);
    return Integer.parseInt(value);
  }

  public int getFirstCardBalance() {
    val text = cards.get(0).text();
    return extractBalance(text);
  }

  public int getSecondCardBalance() {
    val text = cards.get(1).text();
    int balance = extractBalance(text);
    return balance;
  }
  public DashboardPage validFirstTransfer(DataHelper.CardsSecond cardsSecond) {
    $$("[data-test-id=action-deposit]").get(0).click();
    $("[data-test-id=amount] input").setValue("1000");
    $$("[data-test-id=from] input").get(1).setValue(cardsSecond.getNumber());
    $$("[data-test-id=action-transfer]").get(0).click();
    return new DashboardPage();
  }

}