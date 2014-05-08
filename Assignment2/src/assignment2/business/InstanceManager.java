package assignment2.business;

import assignment2.data.Instance;
import assignment2.data.InstanceDAO;

public class InstanceManager implements Runnable {

	// The InstanceDAO is a subclass of the DataAccessObject class which handles
	// MySQL connection and related objects.
	private InstanceDAO instanceDAO = new InstanceDAO();
	private static Object idLock = new Object();

	@Override
	public void run() {
		// Do an infinite looping.
		while (true) {
			manageInstanceTask();
		}

	}

	// This method manages instance task.
	public void manageInstanceTask() {
		String threadName = Thread.currentThread().getName();

		long statusInactive = 0;
		long statusActive = 1;

		Instance instance;
		// This part of the method is synchronized in order to assure only a
		// single thread can pick up one of the free tasks from the database.
		synchronized (idLock) {
			instance = instanceDAO.getFreeTask((long) statusInactive,
					threadName);
			if (instance != null) {
				System.out.println(instance.getName() + " instance has '"
						+ instance.getTask() + "' task.");
				// Updates the status of the task to 1=active feature in the
				// memory.
				instance.setStatus(statusActive);
				instanceDAO.updateStatus(instance);

			} else {
				// Prints an error if there are no active tasks are available in
				// the database.
				System.err
						.println("All taks are assigned to active instances, you should WAIT for a wile ;-)");
				return;
			}
		}

		long workingTime = (long) (Math.random() * 2000);
		// Another synchronized code block for releasing the task possessed by
		// the thread and update the return the status field to inactive feature
		// in the database;
		synchronized (idLock) {
			try {
				// Sleeping a thread here for extending task possession time by
				// the instance.
				Thread.sleep(workingTime);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}

			instance.setStatus(0);
			// Updates the status field to 0=inactive feature.
			instanceDAO.updateStatus(instance);
			System.err.println("	Task '" + instance.getTask()
					+ "' is released.");
		}
	}

}
