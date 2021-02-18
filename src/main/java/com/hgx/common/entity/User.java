package com.hgx.common.entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * user实体类
 * @author
 */
@ApiModel(value="user实体类")
@Setter
@Getter
public class User {

	private Integer id;

	@ApiModelProperty("用户名称")
	private String realName;

	@ApiModelProperty("账号")
	private String username;

	@ApiModelProperty("密码")
	private String password;

	@ApiModelProperty("手机号码")
	private String phoneNumber;

	@ApiModelProperty("性别")
	private String sex;

	@ApiModelProperty("部门id")
	private String department;

	@ApiModelProperty("创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private java.util.Date createTime;

	public User() {
	}

	public User(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [id=" + id + " , realName=" + realName + " , username=" + username + " , password=" + password + " , phoneNumber=" + phoneNumber + " , sex=" + sex + " , department=" + department + " , createTime=" + createTime + "  ]";
	}
}
