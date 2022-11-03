package org.shiftworks.domain;

import java.util.List;

import lombok.Data;

@Data
public class FileVO {
	private String uuid;
	private int apr_id;
	private String file_name;
	private String file_src;
	
	private List<FileVO> selectApprovalFile; 
	
}
