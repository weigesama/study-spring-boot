package xyz.yuanwl.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author Yuanwl
 * @date 2018-09-08 18:06:19
 * @version v1.0.0
 */
@Component
@Data
public class S02Value注解注入默认配置文件的配置 {

	@Value("${xyz.yuanwl.database-platform}")
//	@Value("${xyz.yuanwl.databaseplatform}")
//	@Value("${xyz.yuanwl.database_platform}")
// 	@Value("${xyz.Yuanwl.databasePlatform}") // 总结：上面三种方式是等价的，下面这个不是，只能读取配置文件里的 xyz.Yuanwl.databasePlatform 属性，不解...
	private String dp;


	@Value("${xyz.yuanwl.str}")
	private String str;

	@Value("${xyz.yuanwl.b}")
	private Boolean b;

	@Value("${xyz.yuanwl.i}")
	private Integer i;

	@Value("${xyz.yuanwl.f}")
	private Float f;

//	@Value("${xyz.yuanwl.n}") // 注入空值失败
//	private Double n;

//	@Value("${xyz.yuanwl.t}") // 注入时间失败
//	private LocalTime t;

//	@Value("${xyz.yuanwl.d}") // 注入日期失败
//	private Date d;


	@Value("${xyz.yuanwl.value}")
	private String value;

	@Value("${xyz.yuanwl.number}")
	private Integer number;

	@Value("${xyz.yuanwl.bignumber}")
	private Long bignumber;

	@Value("${xyz.yuanwl.test1}")
	private Integer test1;

	@Value("${xyz.yuanwl.test2}")
	private Integer test2;

//	@Value("${xyz.yuanwl.list}") // 注入失败。关于注入List、Map等复杂类型配置，可以参考Application类下面的手动绑定配置代码。
//	private List<Integer> list;

//	@Value("${xyz.yuanwl.map}") // 注入失败
//	private Map<String, Integer> map;

//	@Value("${xyz.yuanwl.list}") // 注入失败，把 1,2,3 识别为字符串 "1,2,3" 了！
//	private List<Integer> list;

//	@Value("${xyz.yuanwl.map}") // 注入失败！
//	private Map<String, Integer> map;
}
