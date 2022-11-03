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
<<<<<<< HEAD
}
=======
}
>>>>>>> 48babc45ad899a002b86d9ea5b08aff601049fa6
