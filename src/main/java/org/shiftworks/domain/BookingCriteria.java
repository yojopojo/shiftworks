package org.shiftworks.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookingCriteria {
	
	private int pageNum;
	private int amount;
	
	public BookingCriteria() {
		this(1,10);
	}
	
	public BookingCriteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
}
