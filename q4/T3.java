package q4;

public class T3 extends Thread {
    public void run() {
        while (true) {
            synchronized (Main.lock) {
                while (Main.phase != 2) {
                    try { Main.lock.wait(); } catch (InterruptedException e) {}
                }
                System.out.print("C");
                Main.count++;
                if (Main.count == 2) {
                    Main.count = 0;
                    Main.phase = 3;
                    Main.lock.notifyAll();
                }
            }
        }
    }
}
