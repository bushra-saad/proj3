package q2;

public class Judge implements Runnable {

    // Shared game object
    private GamePlay game;

    public Judge(GamePlay game) {
        this.game = game;
    }

    @Override
    public void run() {
        try {
            // Controls when players can flip the coin
            while (!Thread.currentThread().isInterrupted()) {

                // Coin is not available
                game.makeCoinAvail(false);
                Thread.sleep(1000);

                // Coin is available
                game.makeCoinAvail(true);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}