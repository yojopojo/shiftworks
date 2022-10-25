package org.shiftworks.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceiverVO {
	private int msg_id;
	private String emp_id;
	private String dept_id;
	private char checking;
}
