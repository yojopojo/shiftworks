package org.shiftworks.domain;

import lombok.Data;

@Data
public class TempApprovalVO {

	private int temp_id;
	private int af_no;
	private String emp_id;
	private String dept_id;
	private String temp_title;
	private String temp_content;
}
