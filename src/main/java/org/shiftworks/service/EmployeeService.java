package org.shiftworks.service;

import java.util.List;

import org.shiftworks.domain.AccountCriteria;
import org.shiftworks.domain.EmployeeVO;

public interface EmployeeService {
	
	//계정관리
	public void register(EmployeeVO empVO);
	public EmployeeVO get(String emp_id);
	public boolean modify(EmployeeVO empVO);
	public boolean remove(String emp_id);
	public List<EmployeeVO> getList();
	//public List<EmployeeVO> getList(Criteria cri);
	//public List<EmployeeVO> empSearch(Criteria cri);
	//public int getTotal(Criteria cri);
	

}
