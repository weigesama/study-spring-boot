package xyz.yuanwl.service;


import xyz.yuanwl.entity.User;

/**
 *
 * @author Yuanwl
 */
public interface UserService {

	/**
	 * 新增用户
	 * @param user
	 * @author Yuanwl
	 * @date 2018-09-11 16:33:54
	 * @version v1.0.0
	 */
	User saveUser(User user);

	/**
	 * 获取积分
	 * @param userId
	 * @return
	 */
	int getCredit(int userId);

	/**
	 * 更新用户
	 * @param user
	 * @return
	 */
	boolean updateUser(User user);

}
