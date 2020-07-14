package Extras;

public class Comparing {
    public static void main(String[] args) {
        String a = "234";
        String b = "234";
        int c = 10;
        int d = 10;
        Integer e = 20;
        Integer f = 20;
        Character g = new Character('z');
        Character h = new Character('z');
        System.out.println(a == b); // true
        System.out.println(c == d); // true
        System.out.println(e == f); // true
        System.out.println(g == h); // false
        System.out.println(g.equals(h)); // true
    }
}
