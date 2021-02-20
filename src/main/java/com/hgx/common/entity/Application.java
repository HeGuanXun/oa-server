package com.hgx.common.entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * application实体类
 * @author
 */
@ApiModel(value="application实体类")
@Setter
@Getter
public class Application {

	private Integer id;

	@ApiModelProperty("编号")
	private String num;

	@ApiModelProperty("名称")
	private String name;

	@ApiModelProperty("部门")
	private String department;

	@ApiModelProperty("类型")
	private String type;

	@ApiModelProperty("日期")
	@DateTimeFormat( pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	private java.util.Date date;

	@ApiModelProperty("相关人员 || 申请人")
	private String relatedMan;

	@ApiModelProperty("金额")
	private Double money;

	@ApiModelProperty("描述 || 相关内容")
	private String described;

	@ApiModelProperty("备注")
	private String remark;

	@ApiModelProperty("状态")
	private String status;

	@ApiModelProperty("申请时间")
	@DateTimeFormat( pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	private java.util.Date applyDate;

	@Override
	public String toString(){
		return "Application [id=" + id + " , num=" + num + " , name=" + name + " , department=" + department + " , type=" + type + " , date=" + date + " , relatedMan=" + relatedMan + " , money=" + money + " , described=" + described + " , remark=" + remark + " , status=" + status + " , applyDate=" + applyDate + "  ]";
	}
}
