package q3;
	public class TomatoesThread extends Thread {

	    private final SlicerMachine machine;

	    public TomatoesThread(SlicerMachine machine) {
	        this.machine = machine;
	    }

	    public void run() {
	        try {
	            while (machine.getNumOfPreparedSalads() < machine.getTargetSalads()) {
	                machine.addOneTomato();
	            }
	        } catch (InterruptedException e) {}
	    }
	}
