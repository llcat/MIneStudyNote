package tech.llcat.tij.ch19;

public enum Meal2 {

    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);

    private Food[] values;
    Meal2(Class<? extends Food> kind){
        values = kind.getEnumConstants();
    }

    interface Food {
        // 使用接口对enum分类，这样你可以理解为某种东西是某个类型的Food
        enum Appetizer implements Food {
            SALAD, SOUP, SPRING_ROOLS;
        }
        enum MainCourse implements Food {
            LASAGNE, BURRITO, PAD_THAI, LENTILS, HUMMUS, VINDALOO;
        }

        enum Dessert implements Food {
            TIRAMISU, GELATO, BLACK_FOREST_CAKE, FRUIT, CREME_CARAMEL;
        }

        enum Coffee implements Food {
            BLACK_COFFEE, DECAF_COFFEE, ESPRESSO, LATTE, CAPPUCCINO, TEA, HERB_TEA;
        }
    }

    public Food randomSelection(){
        return Enums.random(values);
    }

    public static void main(String[] args) {
        for(int i=0; i<10; i++){
            for(Meal2 meal : Meal2.values()){
                Food food = meal.randomSelection();
                System.out.println(food);
            }
            System.out.println("---");
        }
    }
}
