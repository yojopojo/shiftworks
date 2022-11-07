package org.shiftworks.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessengerGroupVO {
	private int group_id;
	private String dept_id;
	private String emp_id;
	private String name;
}
