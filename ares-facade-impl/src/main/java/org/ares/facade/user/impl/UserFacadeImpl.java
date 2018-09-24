package org.ares.facade.user.impl;

import org.ares.domain.model.user.UserEntity;
import org.ares.domain.user.UserDomain;
import org.ares.facade.user.UserFacade;
import org.ares.view.transfer.data.UserDTO;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

public class UserFacadeImpl implements UserFacade {

    private final UserDomain userDomain;

    public UserFacadeImpl(final UserDomain userDomain) {
	this.userDomain = userDomain;
    }

    @Override
    public UserDTO findUser(String username, String password) {
	UserEntity user = userDomain.findUser(username, password);
	return convertToDto(user);
    }

    private UserDTO convertToDto(UserEntity user) {
	final Mapper mapper = new DozerBeanMapper();
	return mapper.map(user, UserDTO.class);
    }

}
