package org.shiftworks.domain;

<<<<<<< HEAD:src/main/java/org/shiftworks/domain/TaskVO.java
import java.util.Date;
import java.util.List;
=======
public class ChatUserStatusVO {
>>>>>>> feature-msg:src/main/java/org/shiftworks/domain/ChatUserStatusVO.java

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
