package org.shiftworks.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class ScheduleVO {
	private Integer sch_id;
	private String dept_id;
	private Integer book_id;
	private String sch_title;
	private String sch_content;
	private Date start_date;
	private Date end_date;
	private String group;
	private String sch_writer;
	
	private List<String> participant;
}
