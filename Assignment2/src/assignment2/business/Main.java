package assignment2.business;

public class Main {

	public static void main(String[] args) {
		InstancesRole instanceRole = new InstancesRole();
		Thread one = new Thread(instanceRole);
		Thread two = new Thread(instanceRole);
		Thread three = new Thread(instanceRole);
		Thread four = new Thread(instanceRole);
		one.setName("First Instance");
		two.setName("Second Instance");
		three.setName("Third Instance");
		four.setName("Fourth Instance");
		one.start();
		two.start();
		three.start();
		four.start();
	}

}
