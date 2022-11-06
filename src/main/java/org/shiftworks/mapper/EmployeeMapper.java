package org.shiftworks.mapper;

import java.util.List;

import org.shiftworks.domain.AccountCriteria;
import org.shiftworks.domain.EmployeeVO;

public interface EmployeeMapper {
	public EmployeeVO read(String emp_id);
	
	
	public List<EmployeeVO> getList();
	//public List<EmployeeVO> getListWithPaging	(Criteria cri);
	public void insert(EmployeeVO empVO);
	public EmployeeVO detail(String emp_id);
	public int delete(String emp_id);
	public int update(EmployeeVO empVO)	;
	//public int getTotalCount(Criteria cri);
	
	
	//public List<EmployeeVO> getEmployeeForSearching(Criteria cri);
	
}