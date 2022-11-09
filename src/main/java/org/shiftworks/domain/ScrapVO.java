package org.shiftworks.domain;


import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ScrapVO {
	private int scrap_id;
	private String dept_id;
	private String emp_id;
	private int post_id;
	private String scrap_date;
	private String post_name;
	private String post_content;
	private String post_regdate;
	private List<FileVO> fileList;

}
