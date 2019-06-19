package tech.llcat.tij.ch19;
import static tech.llcat.tij.ch19.Food.*;

public class TypeOfFood {
    public static void main(String[] args) {
        Food food = Appetizer.SALAD;
        food = MainCourse.LASAGNE;
        food = Dessert.GELATO;
        food = Coffee.HERB_TEA;
    }
}
