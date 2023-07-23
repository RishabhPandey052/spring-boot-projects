package org.pm.service;

import org.pm.entites.User;
import org.pm.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IUserServiceImpl implements IUserService {
	
	@Autowired
	IUserRepository repoUser;
	
	@Override
	public User addUser(User user) {
		User u = repoUser.save(user);
		return u;
	}

	@Override
	public User updateUser(User user) {
		User u = repoUser.save(user);
		return u;
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean logOut() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
