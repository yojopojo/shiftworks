package org.shiftworks.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class TaskVO {
	
	private Integer task_id;
	private String dept_id;
	private String task_title;
	private String task_content;
	private String task_writer;
	private Date start_date;
	private Date end_date;
	private String category;
	private Character t_priavte;
	private Character notification;
	private Date date_created;
	
	private List<TaskFileVO> fileList;
	private List<TaskChargeVO> chargeList;
	
}
