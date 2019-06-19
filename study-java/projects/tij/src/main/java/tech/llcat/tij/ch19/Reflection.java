package tech.llcat.tij.ch19;

import util.OSExecute;

import java.io.BufferedInputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

enum Explore {
    HRER, THERE
}

public class Reflection {
    public static Set<String> analyze(Class<?> enumClass){
        System.out.println("---Analyzing "+ enumClass + "---");
        System.out.println("Interfaces:");
        for(Type t : enumClass.getGenericInterfaces())
            System.out.println(t);
        System.out.println("Base: "+enumClass.getSuperclass());
        System.out.println("Methods:");
        Set<String> methods = new TreeSet<>();
        for(Method m : enumClass.getMethods())
            methods.add(m.getName());
        System.out.println(methods);
        return methods;
    }
    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);
        System.out.println("Explore containAll(Enum):"+exploreMethods.containsAll(enumMethods));
        System.out.println("Explore removeAll(enum):");
        exploreMethods.removeAll(enumMethods);
        System.out.println(exploreMethods);
        String path = System.getProperty("user.dir");
        String cmd = "javap -classpath "+path+"\\target\\classes\\tech\\llcat\\tij\\ch19"+ " Explore";
        Process p = OSExecute.command(cmd);
        BufferedInputStream bis = new BufferedInputStream(p.getInputStream());
        BufferedInputStream bes = new BufferedInputStream(p.getErrorStream());
        byte[] b = new byte[8];
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        try{
            p.waitFor();
            byte[] s = new byte[4096];
            bis.read(s);
            System.out.println(new String(s, "UTF-8"));

            byte[] s1 = new byte[1024];
            bes.read(s1);
            System.out.println(new String(s1,"GBK"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
