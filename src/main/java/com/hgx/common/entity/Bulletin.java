package com.hgx.common.entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * bulletin实体类
 * @author
 */
@ApiModel(value="bulletin实体类")
@Setter
@Getter
public class Bulletin {

	private Integer id;

	@ApiModelProperty("简报编号")
	private String num;

	@ApiModelProperty("类型")
	private String type;

	@ApiModelProperty("简报周期")
	private String bulletinPeriod;

	@ApiModelProperty("创建人")
	private String createMan;

	@ApiModelProperty("提交时间")
	@DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private java.util.Date submitTime;

	@ApiModelProperty("状态")
	private String status;

	@Override
	public String toString(){
		return "Bulletin [id=" + id + " , num=" + num + " , type=" + type + " , bulletinPeriod=" + bulletinPeriod + " , createMan=" + createMan + " , submitTime=" + submitTime + " , status=" + status + "  ]";
	}
}
