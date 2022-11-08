package org.shiftworks.mapper;

import java.util.List;

import org.shiftworks.domain.AccountCriteria;
import org.shiftworks.domain.EmployeeVO;

public interface EmployeeMapper {
	public EmployeeVO read(String emp_id);
	
	//������ ���� �޴�
	public List<EmployeeVO> getList(AccountCriteria cri);//��ü ����Ʈ
	public List<EmployeeVO> getRetireeList(AccountCriteria cri);//����� ����Ʈ
	public List<EmployeeVO> getListWithPaging	(AccountCriteria cri);//����¡ó��
	public void insert(EmployeeVO empVO);//��������
	public EmployeeVO detail(String emp_id);//����������
	public int delete(String emp_id);//��������
	public int update(EmployeeVO empVO);//������������
	public int getTotalCount(AccountCriteria cri);//�� ���� ����
	
	//�Ϲ� ���� �޴�
	public int updateMyAccount(EmployeeVO empVO);//������������

	
}