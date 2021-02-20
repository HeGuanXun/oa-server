package com.hgx.common.entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * evection实体类
 * @author
 */
@ApiModel(value="evection实体类")
@Setter
@Getter
public class Evection {

	private Integer id;

	@ApiModelProperty("出差地点")
	private String local;

	@ApiModelProperty("开始时间")
	@DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private java.util.Date startTime;

	@ApiModelProperty("结束时间")
	@DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private java.util.Date endTime;

	@ApiModelProperty("出差天数")
	private String leaveCount;

	@ApiModelProperty("出差事由")
	private String reason;

	@Override
	public String toString(){
		return "Evection [id=" + id + " , local=" + local + " , startTime=" + startTime + " , endTime=" + endTime + " , leaveCount=" + leaveCount + " , reason=" + reason + "  ]";
	}
}
