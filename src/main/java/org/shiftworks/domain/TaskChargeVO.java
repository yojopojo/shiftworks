package org.shiftworks.domain;

import lombok.Data;

@Data
public class TaskChargeVO {

	private String emp_id;
	private String dept_id;
	private Integer task_id;
	private Character charge;
	private Character fav;
	
}
