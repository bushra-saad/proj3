package q4;

public class T4 extends Thread {
    public void run() {
        while (true) {
            synchronized (Main.lock) {
                while (Main.phase != 3) {
                    try { Main.lock.wait(); } catch (InterruptedException e) {}
                }
                System.out.print("D");
                if (Math.random() < 0.3) {
                    Main.phase = 1;
                    Main.lock.notifyAll();
                }
            }
        }
    }
}
