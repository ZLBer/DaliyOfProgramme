package NIO;

public class StaticDispatch {
    static  abstract class Human{

    }
    static  class Man extends Human{}
    static  class Woman extends Human{}

    public void sayhello(Human guy){
        System.out.println("human");
    }
    public void sayhello(Man guy){
        System.out.println("man");
    }
    public void sayhello(Woman guy){
        System.out.println("woman");
    }

    public static void main(String[] args) {
        Human man=new Man();
        Human woman=new Woman();
        StaticDispatch sr=new StaticDispatch();
      sr.sayhello(man);
    }
}
