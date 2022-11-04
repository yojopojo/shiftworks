package org.shiftworks.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class EmployeeVO {
	private String emp_id;
	private String dept_id;
	private String dept_name;
	private String password;
	private String name;
	private String address;
	private String birthday;
	private String position;
	private String mobile;
	private String internal;
	private String email;
	private Date entry_date;
	private Date resignation_date;
	private String digital_sign;
	private String profile_photo;
	private int failures_num;
	private String memo;
	private String emp_id2;
	private String dept_id2;

	private List<DepartmentVO> authList;
}