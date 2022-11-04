package org.shiftworks.domain;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ScrapVO {
	private int scrap_id;
	private String dept_id;
	private String emp_id;
	private int post_id;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date scrap_date;
	private String post_name;
	private String post_content;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date post_regdate;

}
