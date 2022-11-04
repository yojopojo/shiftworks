package org.shiftworks.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardCriteria {
	
	private int pageNum;
	private int amount;
	private int b_id;
	
	private String type;
	private String keyword;
	

	
	public BoardCriteria() {
		this(1,10,1);
	}
	
	public BoardCriteria(int pageNum, int amount,int b_id) {
		this.pageNum = pageNum;
		this.amount = amount;
		this.b_id= b_id;
	}
	
	public String[] getTypeArr() {
	
	return type == null? new String[] {}: type.split("");
}

}
