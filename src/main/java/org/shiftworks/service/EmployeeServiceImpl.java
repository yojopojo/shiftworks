package org.shiftworks.service;

import java.util.List;

import org.shiftworks.domain.EmployeeVO;
import org.shiftworks.mapper.EmployeeMapper;

public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeMapper mapper;

	@Override
	public void register(EmployeeVO empVO) {
		// TODO Auto-generated method stub

	}

	@Override
	public EmployeeVO get(String emp_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modify(EmployeeVO empVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(String emp_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<EmployeeVO> getList() {
		// TODO Auto-generated method stub
		return null;
	}

}
