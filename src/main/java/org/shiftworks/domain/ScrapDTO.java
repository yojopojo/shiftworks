package org.shiftworks.domain;

import java.util.List;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ScrapDTO {

  private int startPage;
  private int endPage;
  private boolean prev, next;

  private int total;
  private DocumentCriteria cri;
  private List<ScrapVO> list;

  public ScrapDTO(DocumentCriteria cri, int total, List<ScrapVO> list) {

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

