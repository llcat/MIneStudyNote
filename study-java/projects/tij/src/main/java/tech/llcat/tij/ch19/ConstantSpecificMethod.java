package tech.llcat.tij.ch19;

import java.text.DateFormat;
import java.util.Date;

public enum ConstantSpecificMethod {
    DATE_TIME(0) {
        @Override
        String getInfo() {
            return DateFormat.getDateInstance().format(new Date());
        }
    },

    CLASSPATH(1) {
        @Override
        String getInfo() {
            return System.getenv("Path");
        }
    },
    VERSION(2) {
        @Override
        String getInfo() {
            return System.getProperty("java.version");
        }
    };


    int id;

    ConstantSpecificMethod(int id){
        this.id = id;
    }

    int getId(){
        return id;
    }

    // enum实例可以实现abstract方法
    abstract String getInfo();

    public static void main(String[] args) {
        for(ConstantSpecificMethod csm : values()){
            System.out.println(csm.getId()+":"+csm.getInfo());
        }
    }
}
