package easy;

public class Easy1108 {
    public String defangIPaddr(String address) {
        String[] subs = address.split("\\.");
        return String.join("[.]", subs);
    }

    public static void main(String[] args) {
        String s = new Easy1108().defangIPaddr("192.168.0.1");
        System.out.println(s);
    }
}
