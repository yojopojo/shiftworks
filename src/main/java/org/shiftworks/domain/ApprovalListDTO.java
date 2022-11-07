package org.shiftworks.domain;

import java.util.List;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ApprovalListDTO {

  private int startPage;
  private int endPage;
  private boolean prev, next;
  private List<ApprovalVO> list;
  
  private int total;
  private ApprovalCriteria cri;

  public ApprovalListDTO(ApprovalCriteria cri, int total, List<ApprovalVO> list) {

    this.cri = cri;
    this.total = total;
    this.list = list;

    this.endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10;

    this.startPage = this.endPage - 9;

    int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));

    if (realEnd <= this.endPage) {
      this.endPage = realEnd;
    }

    this.prev = this.startPage > 1;

    this.next = this.endPage < realEnd;
  }
  
}
