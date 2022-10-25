package org.shiftworks.domain;

import lombok.Data;

@Data
public class UserVO {
	
	private String emp_id;
	private String dept_id;
	private String password;
	private String authority;

}
