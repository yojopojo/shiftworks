package org.shiftworks.domain;

public class ScheduleCriteria {
	
	private String selectedDate;
	private String group;
	
	public ScheduleCriteria() {
		
	}

	public ScheduleCriteria(String selectedDate, String group) {
		super();
		this.selectedDate = selectedDate;
		this.group = group;
	}
	
	public String[] getTime(String selectedDate) {
		return selectedDate == null ? new String[] {}: selectedDate.split("-");
	}
}
