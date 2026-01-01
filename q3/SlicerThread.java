package q3;
public class SlicerThread extends Thread {

    private final SlicerMachine machine;

    public SlicerThread(SlicerMachine machine) {
        this.machine = machine;
    }

    public void run() {
        try {
            while (machine.getNumOfPreparedSalads() < machine.getTargetSalads()) {
                machine.sliceVegetables();
            }
        } catch (InterruptedException e) {}
    }
}

