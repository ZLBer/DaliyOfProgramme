package Tread;

/**
 * Created by libin on 2018/6/29.
 */

import java.util.Random;

public class InitTest {

    public static Random rand = new Random(47);

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> i1 = Initable1.class;
        System.out.println("After create Initable1 ref");
        // Does not trigger initialization
        System.out.println(Initable1.staticFinal1);
        // Does trigger initialization
        System.out.println(Initable1.staticFinal2);
        // Does trigger initialization
        System.out.println(Initable2.staticNonFinal);

        Class<?> i3 = Class.forName("Tread.Initable3");
        System.out.println("After create Initable3 ref");
        System.out.println(Initable3.staticNonFinal);
    }

}

class Initable1 {
    static final int staticFinal1 = 47;
    static final int staticFinal2 = InitTest.rand.nextInt(1000);
    static {
        System.out.println("Initializing Initable1");
        System.out.println("===========");
    }
}

class Initable2 {
    static final int staticNonFinal = 147;
    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    static final int staticNonFinal = 74;
    static {
        System.out.println("Initializing Initable3");
    }

}
