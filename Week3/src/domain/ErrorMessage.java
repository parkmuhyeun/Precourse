package lotto.domain;

import static lotto.domain.LottoStatus.*;

public enum ErrorMessage {
    HEADER("[ERROR] "),
    LOTTO_INCORRECT_SIZE("로또 번호 개수는 " + SIZE.getValue() + "개여야 합니다."),
    LOTTO_OUT_OF_RANGE(HEADER + "로또 번호는 " + START.getValue() +
            "부터 " + END.getValue() + " 사이의 숫자여야 합니다."),
    LOTTO_DUPLICATION(HEADER + "로또 번호는 중복되지 않아야 합니다."),
    INCORRECT_PURCHASING_AMOUNT(HEADER + "" + PRICE.getValue() + "원 단위의 숫자여야 합니다."),
    INCORRECT_LUCKY_NUMBER_SIZE(HEADER + "당첨 번호는 ,로 구분하여 " + SIZE.getValue() +
            "개의 번호(" + START.getValue() + "~" + END.getValue() + ")를 입력하여야 합니다."),
    INCORRECT_LUCKY_NUMBER_DIGIT(HEADER + "당첨 번호는 숫자를 입력하여야 합니다."),
    INCORRECT_LUCKY_NUMBER_RANGE(HEADER + "당첨 번호는 " + START.getValue()
            + "부터 " + END.getValue() + "사이의 숫자여야 합니다."),
    LUCKY_NUMBER_DUPLICATION(HEADER + "로또 번호는 중복되지 않아야 합니다."),
    INCORRECT_BONUS_NUMBER_SIZE(HEADER + "보너스 번호는 "+ START.getValue()
            + "~" + END.getValue() +" 사이의 번호여야 합니다."),
    INCORRECT_BONUS_NUMBER_DIGIT(HEADER + "당첨 번호는 숫자를 입력하여야 합니다."),
    INCORRECT_BONUS_NUMBER_RANGE(HEADER + "보너스 번호는 " + START.getValue() +
            "부터 " + END.getValue() + "사이의 숫자여야 합니다."),
    BONUS_NUMBER_DUPLICATION(HEADER + "보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}