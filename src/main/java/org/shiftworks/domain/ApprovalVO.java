package org.shiftworks.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ApprovalVO {

	private int apr_id;
	private int af_id;
	private String emp_id;
	private Date apr_receivedate;
	private String apr_title;
	private String apr_content;
	private Character apr_status;
	private String apr_comment;
	private Date apr_signdate;
	
}
