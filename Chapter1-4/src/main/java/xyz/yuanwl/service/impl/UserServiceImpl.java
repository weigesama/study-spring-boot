package xyz.yuanwl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.yuanwl.dao.UserDao;
import xyz.yuanwl.entity.User;
import xyz.yuanwl.service.CreditSystemService;
import xyz.yuanwl.service.UserService;

/**
 *
 * @author Yuanwl
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Autowired
	CreditSystemService creditSystemService;

	@Override
	public User saveUser(User user) {
		return userDao.save(user);
	}

	@Override
	public int getCredit(int userId) {
	
		return creditSystemService.getUserCredit(userId);
		
	}

	@Override
	public boolean updateUser(User user) {
		return userDao.save(user) != null;
	}

}
