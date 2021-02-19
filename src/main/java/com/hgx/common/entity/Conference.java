package com.hgx.common.entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * conference实体类
 * @author
 */
@ApiModel(value="conference实体类")
@Setter
@Getter
public class Conference {

	private Integer id;

	@ApiModelProperty("会议编号")
	private String num;

	@ApiModelProperty("组织")
	private String organization;

	@ApiModelProperty("主题")
	private String theme;

	@ApiModelProperty("会议名称")
	private String name;

	@ApiModelProperty("会议路径")
	private String location;

	@ApiModelProperty("会议状态")
	private String status;

	@ApiModelProperty("参考容量")
	private String ckContainer;

	@ApiModelProperty("会议室信息")
	private String info;

	@Override
	public String toString(){
		return "Conference [id=" + id + " , num=" + num + " , organization=" + organization + " , theme=" + theme + " , name=" + name + " , location=" + location + " , status=" + status + " , ckContainer=" + ckContainer + " , info=" + info + "  ]";
	}
}
