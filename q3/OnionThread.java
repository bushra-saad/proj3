package q3;
	public class OnionThread extends Thread {

	    private final SlicerMachine machine;

	    public OnionThread(SlicerMachine machine) {
	        this.machine = machine;
	    }

	    public void run() {
	        try {
	            while (machine.getNumOfPreparedSalads() < machine.getTargetSalads()) {
	                machine.addOneOnion();
	            }
	        } catch (InterruptedException e) {}
	    }
	}