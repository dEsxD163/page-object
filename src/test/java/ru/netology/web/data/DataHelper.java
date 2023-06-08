package ru.netology.web.data;

import lombok.Value;

public class DataHelper {
  private DataHelper() {}

  @Value
  public static class AuthInfo {
    private String login;
    private String password;
  }

  public static AuthInfo getAuthInfo() {
    return new AuthInfo("vasya", "qwerty123");
  }

  @Value
  public static class VerificationCode {
    private String code;
  }

  public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
    return new VerificationCode("12345");
  }

  @Value
  public static class CardsFirst {
    private String number;
  }
  public static CardsFirst getCardsFirst() {
    return new CardsFirst("5559 0000 0000 0001");
  }

  @Value
  public static class CardsSecond {
    private String number;
  }
  public static CardsSecond getCardSecond() {
    return new CardsSecond("5559 0000 0000 0002");
  }
}

