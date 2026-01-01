package q2;
import java.util.Random;

public class GamePlay {

    // Indicates if the coin can be used now
    private boolean coin_available = false;

    // Counts how many flips were done in total
    private int rounds_counter = 0;

    // Sets coin availability
    public synchronized void makeCoinAvail(boolean val) {
        coin_available = val;

        // If coin becomes available, wake up waiting players
        if (val) {
            notifyAll();
        }
    }

    // Tries to flip the coin
    public synchronized int flipCoin() {
        try {
            // Wait until the coin is available
            while (!coin_available) {
                System.out.println(Thread.currentThread().getName()
                        + " is waiting for coin");
                wait();
            }

            System.out.println(Thread.currentThread().getName()
                    + " is flipping coin");

            // Lock the coin for this player
            coin_available = false;

            // Update total number of flips
            rounds_counter++;

            // Random result: 0 or 1
            int result = new Random().nextInt(2);

            // Release the coin
            coin_available = true;
            notifyAll();

            return result;

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return 0;
        }
    }

    // Returns total number of flips
    public synchronized int getNumOfRounds() {
        return rounds_counter;
    }
}