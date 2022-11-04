package org.shiftworks.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class TaskVO {
	
	private Integer task_id;
	private String dept_id;
	private String dept_name;
	private String task_title;
	private String task_content;
	private String emp_id;
	private String name;
	private Character t_private;
	private Character notification;
	private Date date_created;
	
	private List<TaskFileVO> fileList;
	private List<TaskChargeVO> chargeList;
	
}
