package org.shiftworks.domain;

import java.util.List;

import lombok.Data;

@Data
public class EmployeeVO {
	private String emp_id;
	private String dept_id;
	private String password;
	private String name;
	// private boolean enabled;
	
	private List<DepartmentVO> authList;
}
