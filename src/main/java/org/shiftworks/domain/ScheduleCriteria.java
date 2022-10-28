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
		int year = Integer.parseInt(arr[0]);

		// 전월 22일 ~ 익월 6일까지의 일정
		if(month == 1) {
			this.periodStart = (year - 1) + "-" + (month+11) + "-22";
			this.periodEnd = year + "-0" + (month+1) + "-06";
		} else if(month > 1 && month < 9) {
			this.periodStart = year + "-0" + (month-1) + "-22";
			this.periodEnd = year + "-0" + (month+1) + "-06";
		} else if(month == 9) {
			this.periodStart = year + "-0" + (month-1) + "-22";
			this.periodEnd = year + "-" + (month+1) + "-06";
		} else if(month > 9 && month < 12) {
			this.periodStart = year + "-" + (month-1) + "-22";
			this.periodEnd = year + "-" + (month+1) + "-06";
		} else if(month == 12) {
			this.periodStart = year + "-" + (month-1) + "-22";
			this.periodEnd = (year+1) + "-0" + (month-11) + "-06";
		}
	}

}
