package q4;
public class Main {

    static final Object lock = new Object();
    static int phase = 0; // 0=A, 1=B, 2=C, 3=D
    static int count = 0;

    public static void main(String[] args) {
        new T1().start();
        new T2().start();
        new T3().start();
        new T4().start();
    }
}
