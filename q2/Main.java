package q2;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        GamePlay game = new GamePlay();

        Gamer g1 = new Gamer(game);
        Gamer g2 = new Gamer(game);

        Thread t1 = new Thread(g1, "player-1");
        Thread t2 = new Thread(g2, "player-2");

        Judge judge = new Judge(game);
        Thread tj = new Thread(judge, "judge");

        // Start all threads
        tj.start();
        t1.start();
        t2.start();

        // Wait for players to finish
        t1.join();
        t2.join();

        // Stop the judge
        tj.interrupt();

        // Print result
        if (g1.getScore() > g2.getScore())
            System.out.println("player 1 wins");
        else if (g2.getScore() > g1.getScore())
            System.out.println("player 2 wins");
        else
            System.out.println("tie");
    }
}

