package main;

public enum CategoryCoefficientEnum {
    YATZY(50),
    LARGESTRAIGHT(20),
    SMALLSTRAIGHT(15);
    public final int coefficient;
    CategoryCoefficientEnum(int coefficient) {
        this.coefficient = coefficient;
    }
}
