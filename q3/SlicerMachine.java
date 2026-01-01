package q3;

public class SlicerMachine {
    private int cucumbers = 0;
	    private int tomatoes = 0;
	    private int onions = 0;

	    private int preparedSalads = 0;
	    private final int targetSalads;

	    public SlicerMachine(int targetSalads) {
	        this.targetSalads = targetSalads;
	    }

	    public synchronized void addOneCucumber() throws InterruptedException {
	        while (cucumbers == 5 && preparedSalads < targetSalads) {
	            wait();
	        }
	        if (preparedSalads >= targetSalads) return;

	        cucumbers++;
	        System.out.println("adding one cucumber to the machine");
	        notifyAll();
	    }

	    public synchronized void addOneTomato() throws InterruptedException {
	        while (tomatoes == 3 && preparedSalads < targetSalads) {
	            wait();
	        }
	        if (preparedSalads >= targetSalads) return;

	        tomatoes++;
	        System.out.println("adding one tomato to the machine");
	        notifyAll();
	    }

	    public synchronized void addOneOnion() throws InterruptedException {
	        while (onions == 1 && preparedSalads < targetSalads) {
	            wait();
	        }
	        if (preparedSalads >= targetSalads) return;

	        onions++;
	        System.out.println("adding one onion to the machine");
	        notifyAll();
	    }

	    public synchronized void sliceVegetables() throws InterruptedException {
	        while (!(cucumbers == 5 && tomatoes == 3 && onions == 1)
	                && preparedSalads < targetSalads) {
	            wait();
	        }
	        if (preparedSalads >= targetSalads) return;

	        cucumbers = 0;
	        tomatoes = 0;
	        onions = 0;
	        preparedSalads++;

	        System.out.println("== preparing one more salad ==");
	        notifyAll();
	    }

	    public synchronized int getNumOfPreparedSalads() {
	        return preparedSalads;
	    }

	    public int getTargetSalads() {
	        return targetSalads;
	    }
	}

