package org.shiftworks.domain;

import java.util.List;

import lombok.Data;

@Data
public class ScheduleVO {
	private Integer sch_id;
	private String dept_id;
	private Integer book_id;
	private String sch_title;
	private String sch_content;
	private String start_date;
	private String end_date;
	private String sch_group;
	private String sch_writer;
	private String emp_id;
	private String sch_date;
	
	private String[] participant;
}
