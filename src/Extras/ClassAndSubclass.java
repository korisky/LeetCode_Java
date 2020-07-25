package Extras;

public class ClassAndSubclass {
    public int test() {
        return 5;
    }

    public static void main(String[] args) {
        int t = 80;
        System.out.println(t >>> 3);
        System.out.println(t << 2);
//        System.out.println(t <<< 4);
    }
}

//public class Subclass extends ClassAndSubclass {
//    public float test() { // wrong, incompitable type
//        return 5.5f;
//    }
//}
