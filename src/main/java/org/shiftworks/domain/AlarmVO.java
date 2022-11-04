package org.shiftworks.domain;

import java.util.Date;

import lombok.Data;

@Data
public class AlarmVO {
	private Integer alarm_id;
	private String content;
	private String emp_id;
	private String dept_id;
	private Date date_created;
}
