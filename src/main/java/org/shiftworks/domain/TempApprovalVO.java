package org.shiftworks.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TempApprovalVO {

	private int temp_id;
	private int af_id;
	private String emp_id;
	private String dept_id;
	private String temp_title;
	private String temp_content;
}
