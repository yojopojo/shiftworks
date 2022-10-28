package org.shiftworks.domain;

import java.util.List;

import lombok.Data;

@Data
public class DepartmentVO {
	
	private String dept_id;
	private String dept_name;
	private String authority;
	List<EmployeeVO> empList;

}
