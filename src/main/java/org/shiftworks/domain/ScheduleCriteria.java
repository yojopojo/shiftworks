package org.shiftworks.domain;

import lombok.Data;

@Data
public class ScheduleCriteria {
	
	private String sch_group;
	private String selectedDate;
	private String periodStart, periodEnd;
	private String keyword;
	
	public ScheduleCriteria() {
		
	}

	public ScheduleCriteria(String sch_group, String selectedDate) {
		super();
		this.sch_group = sch_group;
		this.selectedDate = selectedDate;
		
		// selectedDate는 yyyy-MM-dd 형식의 문자열
		String[] arr = selectedDate.split("-");
		int month = Integer.parseInt(arr[1]);
		
		if(month < 9) {
			this.periodStart = arr[0] + "-0" + month + "-01";
			this.periodEnd = arr[0] + "-0" + (month+1) + "-01";
		} else if(month == 9) {
			this.periodStart = arr[0] + "-0" + month + "-01";
			this.periodEnd = arr[0] + "-" + (month+1) + "-01";
		} else if(month > 9) {
			this.periodStart = arr[0] + "-" + month + "-01";
			this.periodEnd = arr[0] + "-" + (month+1) + "-01";
		}
	}

}
