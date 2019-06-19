package tech.llcat.tij.ch19;

import java.util.EnumSet;

public interface Food {
    // 使用接口对enum分类，这样你可以理解为某种东西是某个类型的Food
    enum Appetizer implements Food {
        SALAD, SOUP, SPRING_ROOLS;
    }
    enum MainCourse implements Food {
        LASAGNE, BURRITO, PAD_THAI, LENTILS, HUMMUS, VINDALOO;
    }

    enum Dessert implements Food{
        TIRAMISU, GELATO, BLACK_FOREST_CAKE, FRUIT, CREME_CARAMEL;
    }
    enum Coffee implements Food{
        BLACK_COFFEE, DECAF_COFFEE, ESPRESSO, LATTE, CAPPUCCINO, TEA, HERB_TEA;
    }
}
