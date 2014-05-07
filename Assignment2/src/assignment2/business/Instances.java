package assignment2.business;

import assignment2.data.Role;
import assignment2.data.RoleDAO;

public class Instances implements Runnable {

	// The RoleDAO is a subclass of the DataAccessObject class which handles MySQL connection and related objects. 
	private RoleDAO roleDAO = new RoleDAO();
	private String currentThread = "";
	private Object idLock = new Object();
	
	@Override
	public void run() {
		// Do an infinite looping.  
		while(true) {
			changeStatus();
		}
	}

	// Contains the synchronized code block which retrieves the status name of the instance in the current thread. 	
	public void changeStatus() {
		currentThread = Thread.currentThread().getName();		
		Role role;
		
		if (currentThread.equalsIgnoreCase(Thread.currentThread().getName())) {
			// This part of the method is synchronized in order to assure execution of a single thread through the block.
			synchronized (idLock) {
				for (int i = 1; i < 4; i++) {
					role = roleDAO.getRole((long) i);
					System.out.println(Thread.currentThread().getName() + " is "
							+ role.getName());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
					if(i == 3) {
						role = roleDAO.getRole((long) 1);
						System.out
						.println(Thread.currentThread().getName() + " is " + role.getName());
					}	
				}
				
			}			
		
		} else {
			System.out.println("Sorry, not available roles for "
					+ Thread.currentThread().getName());
		}
	}

}
