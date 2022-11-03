package org.shiftworks.mapper;

import java.util.List;

import org.shiftworks.domain.Criteria;
import org.shiftworks.domain.EmployeeVO;

public interface EmployeeMapper {
	public EmployeeVO read(String emp_id);
<<<<<<< HEAD
	
	public List<EmployeeVO> getList();
	public void insert(EmployeeVO empVO);
	public EmployeeVO detail(String emp_id);
	public int delete(String emp_id);
	public int update(EmployeeVO empVO)	;
	public List<EmployeeVO> getEmployeeForSearching(Criteria cri);
	
}
=======
<<<<<<< HEAD
}
=======
}
>>>>>>> 48babc45ad899a002b86d9ea5b08aff601049fa6
>>>>>>> refs/remotes/origin/feature-mgt
