package org.shiftworks.service;

import java.util.List;

import org.shiftworks.domain.AccountCriteria;
import org.shiftworks.domain.EmployeeVO;
import org.shiftworks.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeMapper mapper;

	@Override
	public void register(EmployeeVO empVO) {
		log.info("register..............."+empVO);
		mapper.insert(empVO);

	}

	@Override
	public EmployeeVO get(String emp_id) {
		log.info("get..........."+ emp_id);
		return mapper.detail(emp_id);
	}

	@Override
	public boolean modify(EmployeeVO empVO) {
		log.info("modify..............." + empVO);
		return mapper.update(empVO) ==1;
	}

	@Override
	public boolean remove(String emp_id) {
		log.info("remove..............." + emp_id);
		return mapper.delete(emp_id) ==1;
	}

	@Override
	public List<EmployeeVO> getList() {
		return mapper.getList();
	}



//	@Override
//	public List<EmployeeVO> getList(Criteria cri) {
//		log.info("get list with criteria..." + cri);
//		
//		return mapper.getListWithPaging(cri);
//	}

//	@Override
//	public List<EmployeeVO> empSearch(Criteria cri) {
//		List<EmployeeVO> list = mapper.getEmployeeForSearching(cri);
//		return list;
//		
//	}
	
//	@Override
//	public int getTotal(Criteria cri) {
//		// TODO Auto-generated method stub
//		return 0;
//	}



}
