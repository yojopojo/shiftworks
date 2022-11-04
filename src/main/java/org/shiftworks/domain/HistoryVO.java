package org.shiftworks.domain;

import java.util.Date;

import lombok.Data;

@Data
public class HistoryVO {
	
	private String emp_id;
	private String dept_id;
	private int post_id;
	private Date read_date;
}
