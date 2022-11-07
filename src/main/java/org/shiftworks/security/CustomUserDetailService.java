package org.shiftworks.security;

import org.shiftworks.domain.EmployeeVO;
import org.shiftworks.mapper.EmployeeMapper;
import org.shiftworks.security.domain.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private EmployeeMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		log.warn("Load User By UserName: " + username);
		
		EmployeeVO vo = mapper.read(username);
		
		log.warn("queried by emp mapper: " +  vo);
		
		return vo == null ? null : new CustomUser(vo);
	}

}