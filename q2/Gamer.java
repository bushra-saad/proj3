package q2;


public class Gamer implements Runnable {

    // Counts successful flips (result == 1)
    private int goodFlipsCounter = 0;

    // Shared game object
    private GamePlay game;

    public Gamer(GamePlay game) {
        this.game = game;
    }

    @Override
    public void run() {
        try {
            // Keep playing until game ends or thread is interrupted
            while (!Thread.currentThread().isInterrupted()
                    && game.getNumOfRounds() < 10) {

                int res = game.flipCoin();

                // Count successful flip
                if (res == 1) {
                    goodFlipsCounter++;
                }

                // Pause between flips
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Returns player's score
    public int getScore() {
        return goodFlipsCounter;
    }
}

