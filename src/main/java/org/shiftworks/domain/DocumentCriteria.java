package org.shiftworks.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
@Setter
@Getter
public class DocumentCriteria {

  private int pageNum;
  private int amount;
  private String emp_id;
  private String dept_id;
  
  private String type;
  private String keyword;

  public DocumentCriteria() {
    this(1, 10,"user1");
  }

  public DocumentCriteria(int pageNum, int amount,String emp_id) {
    this.pageNum = pageNum;
    this.amount = amount;
    this.emp_id = emp_id;
  }
  
  public String[] getTypeArr() {
    
    return type == null? new String[] {}: type.split("");
  }
}
