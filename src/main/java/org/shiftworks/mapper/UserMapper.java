package org.shiftworks.mapper;

import org.shiftworks.domain.EmployeeVO;
import org.shiftworks.domain.UserDTO;

public interface UserMapper {
	
	public EmployeeVO login(UserDTO userDTO);

}
