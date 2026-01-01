package q4;
public class T1 extends Thread {
    public void run() {
        synchronized (Main.lock) {
            while (Main.count < 3) {
                System.out.print("A");
                Main.count++;
            }
            Main.count = 0;
            Main.phase = 1;
            Main.lock.notifyAll();
        }
    }
}
