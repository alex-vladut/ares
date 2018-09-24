package org.ares.facade.user;

import org.ares.view.transfer.data.UserDTO;

public interface UserFacade {

	public UserDTO findUser(String username, String password);
	
}
