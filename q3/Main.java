package q3;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please Type How Many Salads To Prepare:");
        int n = sc.nextInt();

        System.out.println("Preparing " + n + " Salads...");

        SlicerMachine machine = new SlicerMachine(n);

        new CucumberThread(machine).start();
        new TomatoesThread(machine).start();
        new OnionThread(machine).start();
        new SlicerThread(machine).start();
    }
}

