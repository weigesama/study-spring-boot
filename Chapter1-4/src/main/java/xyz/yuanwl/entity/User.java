package xyz.yuanwl.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Yuanwl
 */
@Data
@Entity
public class User {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "name")
	private String name;
}
