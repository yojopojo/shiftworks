package org.shiftworks.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
@Setter
@Getter
public class ApprovalCriteria {

  private int pageNum;
  private int amount;
  
  private String type;
  private String keyword;

  public ApprovalCriteria() {
    this(1, 10);
  }

  public ApprovalCriteria(int pageNum, int amount) {
    this.pageNum = pageNum;
    this.amount = amount;
  }
  
//  public String[] getTypeArr() {
//    
//    return type == null? new String[] {}: type.split("");
//  }
}
