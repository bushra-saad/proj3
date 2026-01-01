package q3;
public class CucumberThread extends Thread {

    private final SlicerMachine machine;

    public CucumberThread(SlicerMachine machine) {
        this.machine = machine;
    }

    public void run() {
        try {
            while (machine.getNumOfPreparedSalads() < machine.getTargetSalads()) {
                machine.addOneCucumber();
            }
        } catch (InterruptedException e) {}
    }
}

