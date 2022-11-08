package org.shiftworks.domain;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ApprovalDTO {

	private int apr_id;
	private String af_id;
	private String emp_id;
	private Date apr_receivedate;
	private String apr_title;
	private String apr_content;
	private String apr_status;
	private String apr_comment;
	private Date apr_signdate;
	
	private List<FileVO> fileList;

}
