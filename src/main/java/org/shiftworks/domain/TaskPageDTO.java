package org.shiftworks.domain;

import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TaskPageDTO {

	private TaskCriteria cri;
	
	private List<TaskVO> list;
	
	private int startPage, endPage, totalTask;
	private boolean prev, next;
	
	public TaskPageDTO() {}
	
	public TaskPageDTO(TaskCriteria cri, int totalTask) {
		this.cri = cri;
		this.totalTask = totalTask;
		
		// 하단 출력 페이지번호 - 끝번호
		this.endPage = (int) (Math.ceil((cri.getPageNum() * 1.0) / cri.getAmount())) * 10;
		
		// 하단 출력 페이지번호 - 시작번호
		this.startPage = this.endPage - 9;
		
		// 실제 마지막 페이지 번호보다 출력 페이지 번호가 클 경우 조정
		int realEnd = (int) (Math.ceil((totalTask * 1.0) / cri.getAmount()));
		if(endPage > realEnd) {
			endPage = realEnd;
		}
		
		// 페이지 시작번호가 1보다 크면 '이전' 버튼 출력
		this.prev = this.startPage > 1;
		
		// 페이지 끝번호가 마지막 페이지번호보다 작으면 '다음' 버튼 출력
		this.next = this.endPage < realEnd;
	}
	
}
