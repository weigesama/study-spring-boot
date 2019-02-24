package xyz.yuanwl.service;

import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * @author Yuanwl
 * @date 2018/9/12 15:59
 */
@Service
public class HelloService {

	public HelloService(){
		new Thread(){
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
					int i = 1/0; // 这个异常无法被 @ControllerAdvice 捕获
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

	public void test(){
		int i = 1/0;
	}
}
