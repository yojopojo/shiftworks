package org.shiftworks.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
public class ReceiverVO {
	
	private int msg_id;
	private String emp_id;
	private String dept_id;
	private char checking;
	
	public ReceiverVO(int msg_id, String emp_id, String dept_id) {
		this.msg_id = msg_id;
		this.emp_id = emp_id;
		this.dept_id = dept_id;
	}
	
}
