package assignment2.data;

public class Instance {
	
	private String name;
	private long status;
	private String task;
	
	// This is a default constructor. 
	public Instance() {
		
	}
	
	public Instance(String name, long status, String task) {
		this.name = name;
		this.status = status;
		this.task = task;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String Name) {
		this.name = Name;
	}
	public long getStatus() {
		return status;
	}
	public void setStatus(long status) {
		this.status = status;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
		
}
