package com.hgx.common.entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * leaves实体类
 * @author
 */
@ApiModel(value="leaves实体类")
@Setter
@Getter
public class Leaves {

	private Integer id;

	@ApiModelProperty("请假类型")
	private String type;

	@ApiModelProperty("开始时间")
	@DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private java.util.Date startTime;

	@ApiModelProperty("结束时间")
	@DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private java.util.Date endTime;

	@ApiModelProperty("请假天数")
	private String leaveCount;

	@ApiModelProperty("请假事由")
	private String reason;

	@Override
	public String toString(){
		return "Leaves [id=" + id + " , type=" + type + " , startTime=" + startTime + " , endTime=" + endTime + " , leaveCount=" + leaveCount + " , reason=" + reason + "  ]";
	}
}
