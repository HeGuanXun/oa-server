package com.hgx.common.entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * company_type实体类
 * @author
 */
@ApiModel(value="company_type实体类")
@Setter
@Getter
public class CompanyType {

	private Integer id;

	@ApiModelProperty("会议室名称")
	private String name;

	@ApiModelProperty("会议室分类")
	private String type;

	@ApiModelProperty("允许使用时长")
	private String useTime;

	@ApiModelProperty("是否最小分类")
	private String ifMinType;

	@ApiModelProperty("备注")
	private String remark;

	@Override
	public String toString(){
		return "CompanyType [id=" + id + " , name=" + name + " , type=" + type + " , useTime=" + useTime + " , ifMinType=" + ifMinType + " , remark=" + remark + "  ]";
	}
}
