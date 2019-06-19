package tech.llcat.tij.ch19;

public enum OverrideConstantSpecfic {
    BUT, BOLT,
    WASHER{
        // 实例可以复写一般的方法
        @Override
        void f(){
            System.out.println("Overridden method");
        }
    };
    void f(){
        System.out.println("default behavior");
    }

    public static void main(String[] args) {
        for(OverrideConstantSpecfic ocs:values()){
            System.out.println(ocs+":");
            ocs.f();
        }
    }
}
