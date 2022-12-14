package lotto.domain;

public enum LottoStatus {
    START(1),
    END(45),
    SIZE(6),
    DUPLICATION_LIMIT(1),
    PRICE(1000),
    PERCENT(100);

    private final int value;

    LottoStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public int getDigitsSize() {
        return Integer.toString(value).length();
    }
}
