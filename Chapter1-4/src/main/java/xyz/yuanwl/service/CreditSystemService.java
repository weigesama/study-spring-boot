package xyz.yuanwl.service;

public interface CreditSystemService {

	int getUserCredit(int userId);

	boolean addCedit(int userId, int score);
}
