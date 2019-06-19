package tech.llcat.tij.ch19;
import static tech.llcat.tij.ch19.Food.*;

public enum Course {
    APPETIZER(Appetizer.class),
    MAINCOURSE(MainCourse.class),
    DESSERT(Dessert.class),
    COFFEE(Coffee.class);

    private Food[] values;
    private Course(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }

    public Food randomSelection(){
        return Enums.random(values);
    }
}
