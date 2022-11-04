package org.shiftworks.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	private int reply_id;
	private int post_id;
	private String r_writer;
	private Date r_regdate;
	private String r_content;
}
