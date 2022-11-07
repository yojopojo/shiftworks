package org.shiftworks.domain;

import lombok.Data;

@Data
public class WorkScheduleVO {

	private String emp_id;
	private String dept_id;
	private String name;
	private String start_time;
	private String end_time;

}
