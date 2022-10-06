package main;

public class Yatzy {
    public static int getChanceCategoryScore(ICategoryCount categoryCount) {
        return categoryCount.getDicesSum();
    }

    public static int getYatzyCategoryScore(ICategoryCount categoryCount) {
        return categoryCount.isYatzy() ? CategoryCoefficientEnum.YATZY.coefficient:0;
    }

    public static int getOnesCategoryScore(ICategoryCount categoryCount) {
        return categoryCount.getOccuranceOfADice(1);
    }

    public static int getTwosCategoryScore(ICategoryCount categoryCount) {
        return categoryCount.getOccuranceOfADice(2)*2;
    }

    public static int getThreesCategoryScore(ICategoryCount categoryCount) {
        return categoryCount.getOccuranceOfADice(3)*3;
    }
    public static int getFoursCategoryScore(ICategoryCount categoryCount) {
        return categoryCount.getOccuranceOfADice(4)*4;
    }
    public static int getFivesCategoryScore(ICategoryCount categoryCount) {
        return categoryCount.getOccuranceOfADice(5)*5;
    }
    public static int getSixesCategoryScore(ICategoryCount categoryCount) {
        return categoryCount.getOccuranceOfADice(6)*6;
    }

    public static int getOnePairCategoryScore(ICategoryCount categoryCount) {
         if(!categoryCount.getPairsList().isEmpty()){
             return categoryCount.getPairsList().get(0)*2;
         }
         else return 0;
    }

    public static int getTwoPairCategoryScore(ICategoryCount categoryCount) {
        if(!categoryCount.getPairsList().isEmpty() && categoryCount.getPairsList().size()>=2){
            return (categoryCount.getPairsList().get(0)*2)+(categoryCount.getPairsList().get(1)*2);
        }
        else return 0;
    }

    public static int getThreeOfAKindCategoryScore(ICategoryCount categoryCount) {
       return categoryCount.getDicesListHavingOccurance(3).stream().findFirst().orElse(0)*3;
    }

    public static int getFourOfAKindCategoryScore(ICategoryCount categoryCount) {
        return categoryCount.getDicesListHavingOccurance(4).stream().findFirst().orElse(0)*4;
    }

    public static int getSmallStraightCategoryScore(ICategoryCount categoryCount) {
        return categoryCount.isSmallStraight()? CategoryCoefficientEnum.SMALLSTRAIGHT.coefficient:0;
    }

    public static int getLargeStraightCategoryScore(ICategoryCount categoryCount) {
        return categoryCount.isLargeStraight()? CategoryCoefficientEnum.LARGESTRAIGHT.coefficient:0;
    }

    public static int getFullHouseCategoryScore(ICategoryCount categoryCount) {
        return categoryCount.isFullHouse()? categoryCount.getDicesSum():0;
    }

}
