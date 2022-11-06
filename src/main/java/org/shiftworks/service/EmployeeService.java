package org.shiftworks.service;

import java.util.List;

import org.shiftworks.domain.AccountCriteria;
import org.shiftworks.domain.EmployeeVO;

public interface EmployeeService {
	public List<EmployeeVO> getList();//전체계정리스트출력
	public void register(EmployeeVO empVO);//계정등록
	public EmployeeVO get(String emp_id);//계정상세정보
	public boolean modify(EmployeeVO empVO);//계정정보수정
	public boolean remove(String emp_id);//계정삭제
	//public List<EmployeeVO> getList(Criteria cri);
	//public List<EmployeeVO> empSearch(Criteria cri);
	//public int getTotal(Criteria cri);
	

}
