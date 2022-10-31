package org.shiftworks.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TaskCriteria {

	private int amount = 10;
	private int pageNum;
	private String type, keyword, selectedDept;

	public TaskCriteria() {
		pageNum = 1;
	}

	public TaskCriteria(int pageNum, String type, String keyword, String selectedDept) {
		super();
		this.pageNum = pageNum;
		this.type = type;
		this.keyword = keyword;
		this.selectedDept = selectedDept;
	}
	
	public String[] getTypeArr() {
		
		return type == null ? new String[] {}: type.split("");
		
	}

	
}
