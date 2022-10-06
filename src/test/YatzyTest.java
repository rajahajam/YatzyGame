package test;

import main.CategoryCount;
import main.Yatzy;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class YatzyTest {

    @Test
    public void get_chance_category_score() {
        int expected = 15;
        int actual = Yatzy.getChanceCategoryScore(new CategoryCount(2,3,4,5,1));
        assertEquals(expected, actual);
        assertEquals(16, Yatzy.getChanceCategoryScore(new CategoryCount(3,3,4,5,1)));
    }

    @Test public void get_yatzy_category_score() {
        int expected = 50;
        int actual = Yatzy.getYatzyCategoryScore(new CategoryCount(4,4,4,4,4));
        assertEquals(expected, actual);
        assertEquals(50, Yatzy.getYatzyCategoryScore(new CategoryCount(6,6,6,6,6)));
        assertEquals(0, Yatzy.getYatzyCategoryScore(new CategoryCount(6,6,6,6,3)));
    }

    @Test public void get_ones_category_score() {
        assertTrue(Yatzy.getOnesCategoryScore(new CategoryCount(1,2,3,4,5)) == 1);
        assertEquals(2, Yatzy.getOnesCategoryScore(new CategoryCount(1,2,1,4,5)));
        assertEquals(0, Yatzy.getOnesCategoryScore(new CategoryCount(6,2,2,4,5)));
        assertEquals(4, Yatzy.getOnesCategoryScore(new CategoryCount(1,2,1,1,1)));
    }

    @Test
    public void get_twos_category_score() {
        assertEquals(4, Yatzy.getTwosCategoryScore(new CategoryCount(1,2,3,2,6)));
        assertEquals(10, Yatzy.getTwosCategoryScore(new CategoryCount(2,2,2,2,2)));
    }

    @Test
    public void get_threes_category_score() {
        assertEquals(6, Yatzy.getThreesCategoryScore(new CategoryCount(1,2,3,2,3)));
        assertEquals(12, Yatzy.getThreesCategoryScore(new CategoryCount(2,3,3,3,3)));
    }

    @Test
    public void get_fours_category()
    {
        assertEquals(12, Yatzy.getFoursCategoryScore(new CategoryCount(4,4,4,5,5)));
        assertEquals(8, Yatzy.getFoursCategoryScore(new CategoryCount(4,4,5,5,5)));
        assertEquals(4, Yatzy.getFoursCategoryScore(new CategoryCount(4,5,5,5,5)));
    }

    @Test
    public void get_fives_category_score() {
        assertEquals(10, Yatzy.getFivesCategoryScore(new CategoryCount(4,4,4,5,5)));
        assertEquals(15, Yatzy.getFivesCategoryScore(new CategoryCount(4,4,5,5,5)));
        assertEquals(20, Yatzy.getFivesCategoryScore(new CategoryCount(4,5,5,5,5)));
    }

    @Test
    public void get_sixes_score() {
        assertEquals(0, Yatzy.getSixesCategoryScore(new CategoryCount(4,4,4,5,5)));
        assertEquals(6,Yatzy.getSixesCategoryScore(new CategoryCount(4,4,6,5,5)));
        assertEquals(18, Yatzy.getSixesCategoryScore(new CategoryCount(6,5,6,6,5)));
    }

    @Test
    public void get_one_pair_score() {
        assertEquals(6, Yatzy.getOnePairCategoryScore(new CategoryCount(3,4,3,5,6)));
        assertEquals(10, Yatzy.getOnePairCategoryScore(new CategoryCount(5,3,3,3,5)));
        assertEquals(12, Yatzy.getOnePairCategoryScore(new CategoryCount(5,3,6,6,5)));
    }

    @Test
    public void get_two_Pair_score() {
        assertEquals(16, Yatzy.getTwoPairCategoryScore(new CategoryCount(3,3,5,4,5)));
        assertEquals(16, Yatzy.getTwoPairCategoryScore(new CategoryCount(3,3,5,5,5)));
    }

    @Test
    public void get_three_of_a_kind_score()
    {
        assertEquals(9, Yatzy.getThreeOfAKindCategoryScore(new CategoryCount(3,3,3,4,5)));
        assertEquals(15, Yatzy.getThreeOfAKindCategoryScore(new CategoryCount(5,3,5,4,5)));
        assertEquals(9, Yatzy.getThreeOfAKindCategoryScore(new CategoryCount(3,3,3,3,5)));
    }

    @Test
    public void get_four_of_a_knd_score() {
        assertEquals(12, Yatzy.getFourOfAKindCategoryScore(new CategoryCount(3,3,3,3,5)));
        assertEquals(20, Yatzy.getFourOfAKindCategoryScore(new CategoryCount(5,5,5,4,5)));
        assertEquals(12, Yatzy.getFourOfAKindCategoryScore(new CategoryCount(3,3,3,3,3)));
    }

    @Test
    public void get_small_Straight_score() {
        assertEquals(15, Yatzy.getSmallStraightCategoryScore(new CategoryCount(1,2,3,4,5)));
        assertEquals(15, Yatzy.getSmallStraightCategoryScore(new CategoryCount(2,3,4,5,1)));
        assertEquals(0, Yatzy.getSmallStraightCategoryScore(new CategoryCount(1,2,2,4,5)));
    }

    @Test
    public void get_large_Straight_score() {
        assertEquals(20, Yatzy.getLargeStraightCategoryScore(new CategoryCount(6,2,3,4,5)));
        assertEquals(20, Yatzy.getLargeStraightCategoryScore(new CategoryCount(2,3,4,5,6)));
        assertEquals(0, Yatzy.getLargeStraightCategoryScore(new CategoryCount(1,2,2,4,5)));
    }

    @Test
    public void get_full_House_score() {
        assertEquals(18, Yatzy.getFullHouseCategoryScore(new CategoryCount(6,2,2,2,6)));
        assertEquals(0, Yatzy.getFullHouseCategoryScore(new CategoryCount(2,3,4,5,6)));
    }
}