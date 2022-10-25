package org.shiftworks.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TaskCriteria {

	private int amount = 10;
	private int pageNum;
	private String type;
	private String keyword;

	public TaskCriteria() {
		pageNum = 1;
	}


	public TaskCriteria(int pageNum, String type, String keyword) {
		super();
		this.pageNum = pageNum;
		this.type = type;
		this.keyword = keyword;
	}
	
	public String[] getTypeArr() {
		
		return type == null ? new String[] {}: type.split("");
		
	}

	
}
