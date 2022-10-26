package org.shiftworks.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ApprovalVO {

	private int apr_id;
	private int af_id;
	private String emp_id;
	private Date apr_date;
	private String apr_title;
	private String apr_content;
	private int apr_check;
	private Character apr_status;
	
}
