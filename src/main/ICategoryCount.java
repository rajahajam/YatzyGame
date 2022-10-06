package main;

import java.util.List;

public interface ICategoryCount {

    int getDicesSum();

    int getOccuranceOfADice(int dice);

    boolean isYatzy();

    boolean isSmallStraight();

    boolean isLargeStraight();

    List<Integer> getDicesListHavingOccurance(int count);

    List<Integer> getPairsList();

    boolean isFullHouse();
}
