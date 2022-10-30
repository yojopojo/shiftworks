package org.shiftworks.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Dept_DocVO {
	
	private int post_id;
	private String dept_id;
	private Date post_regdate;
	private String post_name;
	private String psot_content;
	
}
