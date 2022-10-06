package main;

import main.ICategoryCount;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.toList;

public class CategoryCount implements ICategoryCount {
    private static final List<Integer> SMALL_STRAIGTH = Arrays.asList(1, 2, 3, 4, 5);
    private static final List<Integer> LARGE_STRAIGHT = Arrays.asList(2, 3, 4, 5, 6);
    private final List<Integer> dicesList;

    public CategoryCount(int dice1, int dice2, int dice3, int dice4, int dice5) {
        this.dicesList= Arrays.asList(dice1, dice2, dice3, dice4, dice5);
    }
    @Override
    public int getDicesSum() {
        return dicesList.stream().reduce(0,Integer::sum);
    }
    private Map<Integer,Integer> getDicesOccuranceMap(){
        return dicesList.stream()
                .collect(Collectors.groupingBy(d -> d, reducing(0, e -> 1, Integer::sum)));
    }
    @Override
    public int getOccuranceOfADice(int dice){
       return getDicesOccuranceMap().getOrDefault(dice,0);
    }
    @Override
    public boolean isYatzy() {
        return getDicesOccuranceMap()
                .values()
                .stream()
                .anyMatch(value -> value == 5);
    }
    @Override
    public boolean isSmallStraight() {
        return (dicesList.stream().sorted().collect(toList())).equals(SMALL_STRAIGTH);
    }
    @Override
    public boolean isLargeStraight() {
        return (dicesList.stream().sorted().collect(toList())).equals(LARGE_STRAIGHT);
    }
    @Override
    public List<Integer> getDicesListHavingOccurance(int count) {
        return getDicesOccuranceMap().entrySet().stream()
                .filter(entry -> entry.getValue() >= count)
                .map(Map.Entry::getKey).collect(Collectors.toList());
    }
    @Override
    public List<Integer> getPairsList() {
        return getDicesListHavingOccurance(2).stream()
                .sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }
    @Override
    public boolean isFullHouse() {
        int threeOfAKindValue = getDicesListHavingOccurance(3).stream().findFirst().orElse(0);
        int pairValue = getPairsList().stream().findFirst().orElse(0);
        return threeOfAKindValue != 0 && pairValue != 0;
    }
}
