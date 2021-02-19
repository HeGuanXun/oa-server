package com.hgx.common.entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * zc_type实体类
 * @author
 */
@ApiModel(value="zc_type实体类")
@Setter
@Getter
public class ZcType {

	private Integer id;

	@ApiModelProperty("分类名称")
	private String name;

	@ApiModelProperty("上级分类")
	private String upType;

	@ApiModelProperty("摊销时长")
	private String useTime;

	@ApiModelProperty("是否最小分类")
	private String ifMinType;

	@ApiModelProperty("备注")
	private String remark;

	@Override
	public String toString(){
		return "ZcType [id=" + id + " , name=" + name + " , upType=" + upType + " , useTime=" + useTime + " , ifMinType=" + ifMinType + " , remark=" + remark + "  ]";
	}
}
