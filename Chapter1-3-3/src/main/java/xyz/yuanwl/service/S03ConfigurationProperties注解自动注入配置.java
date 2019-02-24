package xyz.yuanwl.service;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author Yuanwl
 * @date 2018-09-08 18:06:29
 * @version v1.0.0
 */
@Component
@ConfigurationProperties(prefix = "xyz.yuanwl") // 通过这种方式，属性必须定义get、set方法，而且属性名要和配置文件里的对应
@Data
public class S03ConfigurationProperties注解自动注入配置 {

	private String dp; // null


	private String str;

	private Boolean b;

	private Integer i;

	private Float f;

	private Double n; // .yaml可以注入空值！

//	private LocalTime t; // 报错

//	private Date d; // 报错


	private String value;

	private Integer number;

	private Long bignumber;

	private Integer test1;

	private Integer test2;

	private List<Integer> list;

	private Map<String, Integer> map;


	private String refstr; // 引用字符串没有问题
//	private List<Integer> reflist; // 引用list出错
//	private Map<String, Integer> refmap; // 引用map出错

}
