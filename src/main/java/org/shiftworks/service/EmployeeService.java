package org.shiftworks.service;

import java.util.List;

import org.shiftworks.domain.AccountCriteria;
import org.shiftworks.domain.EmployeeVO;

public interface EmployeeService {
	
	//관리자 계정 메뉴
	public void register(EmployeeVO empVO);//계정등록
	public EmployeeVO get(String emp_id);//게정상세보기
	public boolean modify(EmployeeVO empVO);//계정수정
	public boolean remove(String emp_id);//계정삭제
	public List<EmployeeVO> getList(AccountCriteria cri);//전체리스트
	public int getTotal(AccountCriteria cri);//총 계정 개수
	public List<EmployeeVO> getRetireeList(AccountCriteria cri);//퇴사자리스트
	
	
	//일반 계정 메뉴
	public boolean modifyMyAccount(EmployeeVO empVO);
	
}
