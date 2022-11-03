package org.shiftworks.controller;

<<<<<<< HEAD
=======
<<<<<<< HEAD

=======
>>>>>>> 48babc45ad899a002b86d9ea5b08aff601049fa6
>>>>>>> refs/remotes/origin/feature-mgt
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
=======
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PostMapping;
>>>>>>> refs/remotes/origin/feature-mgt

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class CommonController {
	
	// ·Î±×ÀÎ ÇÊ¿ä ½Ã Ä¿½ºÅÒ ·Î±×ÀÎ ÆäÀÌÁö·Î ÀÌµ¿
	@GetMapping("/customLogin")
	public void loginInput(String error, String logout, Model model) {
		log.info("error: " + error + ", logout:" + logout);
		
		// ¿¡·¯ ¹ß»ı ½Ã view¿¡ ¸Ş½ÃÁö Àü´Ş
		if(error != null) {
			model.addAttribute("error", "Login Error");
		}
		
		// ·Î±×¾Æ¿ô ½Ã view¿¡ ¸Ş½ÃÁö Àü´Ş
		if(logout != null) {
			model.addAttribute("logout", "Logout");
		}
	}
	
	// ·Î±×¾Æ¿ô ½Ã ÄíÅ°, ¼¼¼Ç »èÁ¦ À¯µµ(½ÇÁ¦ ÀÛ¾÷Àº ½ºÇÁ¸µ ³»ºÎ¿¡¼­!)
	@GetMapping("/customLogout")
	public void logoutGET() {
		log.info("custom Logout");
	}
	
	
	// Á¢±Ù ±ÇÇÑÀÌ ¾ø´Â ÆäÀÌÁö¿¡ Á¢±Ù ½Ã Á¢±Ù ºÒ°¡ ÆäÀÌÁö Ãâ·Â
	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		log.info("access Denied: " + auth);
		
		// view¿¡ Á¢±Ù ºÒ°¡ ¸Ş½ÃÁö Àü´Ş
		model.addAttribute("message", "Access Denied");
	}

<<<<<<< HEAD
}
=======
	
=======

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class CommonController {
	
	// ë¡œê·¸ì¸ í•„ìš” ì‹œ ì»¤ìŠ¤í…€ ë¡œê·¸ì¸ í˜ì´ì§€ë¡œ ì´ë™
	@GetMapping("/customLogin")
	public void loginInput(String error, String logout, Model model) {
		log.info("error: " + error + ", logout:" + logout);
		
		// ì—ëŸ¬ ë°œìƒ ì‹œ viewì— ë©”ì‹œì§€ ì „ë‹¬
		if(error != null) {
			model.addAttribute("error", "Login Error");
		}
		
		// ë¡œê·¸ì•„ì›ƒ ì‹œ viewì— ë©”ì‹œì§€ ì „ë‹¬
		if(logout != null) {
			model.addAttribute("logout", "Logout");
		}
	}
	
	// ë¡œê·¸ì•„ì›ƒ ì‹œ ì¿ í‚¤, ì„¸ì…˜ ì‚­ì œ ìœ ë„(ì‹¤ì œ ì‘ì—…ì€ ìŠ¤í”„ë§ ë‚´ë¶€ì—ì„œ!)
	@GetMapping("/customLogout")
	public void logoutGET() {
		log.info("custom Logout");
	}
	
	
	// ì ‘ê·¼ ê¶Œí•œì´ ì—†ëŠ” í˜ì´ì§€ì— ì ‘ê·¼ ì‹œ ì ‘ê·¼ ë¶ˆê°€ í˜ì´ì§€ ì¶œë ¥
	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		log.info("access Denied: " + auth);
		
		// viewì— ì ‘ê·¼ ë¶ˆê°€ ë©”ì‹œì§€ ì „ë‹¬
		model.addAttribute("message", "Access Denied");
	}

>>>>>>> 48babc45ad899a002b86d9ea5b08aff601049fa6
}
>>>>>>> refs/remotes/origin/feature-mgt
