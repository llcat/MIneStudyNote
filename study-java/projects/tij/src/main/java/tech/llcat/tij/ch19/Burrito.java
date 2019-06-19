package tech.llcat.tij.ch19;
import static tech.llcat.tij.ch19.Spiciness.*;

public class Burrito {
    Spiciness degree;

    public Burrito(Spiciness degree){
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Burrito is " + degree;
    }

    public static void main(String[] args) {
        // 支持从不同的文件中静态导入enum
        System.out.println(new Burrito(NOT));
        System.out.println(new Burrito(HOT));
        System.out.println(new Burrito(MEDIUM));
    }
}
