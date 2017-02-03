package org.cripac.isee.entity;

public class Resource {
	private String used_cores;
	private String total_cores;
	private String uesed_memory;
	private String total_memory;
	private String executors;
	private String memory_per_executor;
	private String cores_per_executor;
	public String getUsed_cores() {
		return used_cores;
	}
	public void setUsed_cores(String used_cores) {
		this.used_cores = used_cores;
	}
	public String getTotal_cores() {
		return total_cores;
	}
	public void setTotal_cores(String total_cores) {
		this.total_cores = total_cores;
	}
	public String getUesed_memory() {
		return uesed_memory;
	}
	public void setUesed_memory(String uesed_memory) {
		this.uesed_memory = uesed_memory;
	}
	public String getTotal_memory() {
		return total_memory;
	}
	public void setTotal_memory(String total_memory) {
		this.total_memory = total_memory;
	}
	public String getExecutors() {
		return executors;
	}
	public void setExecutors(String executors) {
		this.executors = executors;
	}
	public String getMemory_per_executor() {
		return memory_per_executor;
	}
	public void setMemory_per_executor(String memory_per_executor) {
		this.memory_per_executor = memory_per_executor;
	}
	public String getCores_per_executor() {
		return cores_per_executor;
	}
	public void setCores_per_executor(String cores_per_executor) {
		this.cores_per_executor = cores_per_executor;
	}
	
	

}
