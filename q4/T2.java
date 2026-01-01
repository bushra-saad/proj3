package q4;

public class T2 extends Thread {
    public void run() {
        while (true) {
            synchronized (Main.lock) {
                while (Main.phase != 1) {
                    try { Main.lock.wait(); } catch (InterruptedException e) {}
                }
                System.out.print("B");
                if (Math.random() < 0.3) {
                    Main.phase = 2;
                    Main.lock.notifyAll();
                }
            }
        }
    }
}

