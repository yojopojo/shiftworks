package org.shiftworks.mapper;

import java.util.List;

import org.shiftworks.domain.AccountCriteria;
import org.shiftworks.domain.EmployeeVO;

public interface EmployeeMapper {
	public EmployeeVO read(String emp_id);
	
	//관리자 계정 메뉴
	public List<EmployeeVO> getList(AccountCriteria cri);//전체 리스트
	public List<EmployeeVO> getRetireeList(AccountCriteria cri);//퇴사자 리스트
	public List<EmployeeVO> getListWithPaging	(AccountCriteria cri);//페이징처리
	public void insert(EmployeeVO empVO);//계정생성
	public EmployeeVO detail(String emp_id);//계정상세정보
	public int delete(String emp_id);//계정삭제
	public int update(EmployeeVO empVO);//계정정보수정
	public int getTotalCount(AccountCriteria cri);//총 계정 개수
	
	//일반 계정 메뉴
	public int updateMyAccount(EmployeeVO empVO);//계정정보수정

	
}