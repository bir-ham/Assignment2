package assignment2.business;

public class InstancesRole implements Runnable {

	// Array for substituting the database purpose. The index of this array represents the status field
	// whereas the values represent the the active feature.   
	private String instanceRoles[] = { "inacitve", "active", "disabled" };
	private String currentThread = "";
	private Object idLock = new Object();
	
	@Override
	public void run() {
		// Do an infinite looping.  
		while(true) {
			changeStatus();
		}
	}

	public void changeStatus() {
		currentThread = Thread.currentThread().getName();		
	
		if (currentThread.equalsIgnoreCase(Thread.currentThread().getName())) {
			// This part of the method is synchronized in order to assure execution of a single thread through the block.
			synchronized (idLock) {
				for (int i = 0; i < instanceRoles.length; i++) {
					System.out.println(Thread.currentThread().getName() + " is "
							+ instanceRoles[i]);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
				}
				System.out
						.println(Thread.currentThread().getName() + " is " + instanceRoles[0]);
			}			
		
		} else {
			System.out.println("Sorry, not available roles for "
					+ Thread.currentThread().getName());
		}
	}

}
