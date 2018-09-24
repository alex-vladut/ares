package org.ares.controller.login;

import org.ares.facade.user.UserFacade;
import org.ares.view.transfer.data.UserDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UserController {

	private final UserFacade userFacade;

	public UserController(final UserFacade userFacade) {
		this.userFacade = userFacade;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public UserDTO login(
			@RequestParam("username") final String username, 
			@RequestParam("password") final String password){
		final UserDTO user = userFacade.findUser(username, password);
		if(user == null){
			throw new IllegalArgumentException();
		}else{
			return user;
		}
	}
	
}
