package assignment2.business;

public class Main {

	// Creates an InstanceManager object as instance variable of this class.
	private static InstanceManager instanceManager = new InstanceManager();

	public static void main(String[] args) {
		Thread one = new Thread(instanceManager);
		Thread two = new Thread(instanceManager);
		Thread three = new Thread(instanceManager);
		Thread four = new Thread(instanceManager);
		Thread fifth = new Thread(instanceManager);
		one.setName("First");
		two.setName("Second");
		three.setName("Third");
		four.setName("Fourth");
		fifth.setName("Fifth");
		one.start();
		two.start();
		three.start();
		four.start();
		fifth.start();

	}

}
