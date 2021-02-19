package com.hgx.common.entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * asset实体类
 * @author
 */
@ApiModel(value="asset实体类")
@Setter
@Getter
public class Asset {

	private Integer id;

	@ApiModelProperty("资产编码")
	private String num;

	@ApiModelProperty("资产名称")
	private String name;

	@ApiModelProperty("资产类型")
	private String assetTypeOne;

	@ApiModelProperty("资产分类")
	private String assetTypeTwo;

	@ApiModelProperty("规格型号")
	private String specification;

	@ApiModelProperty("仓库")
	private String store;

	@ApiModelProperty("单位")
	private String unit;

	@ApiModelProperty("数量")
	private Integer count;

	@ApiModelProperty("采购价格")
	private Double cost;

	@ApiModelProperty("市场估值")
	private Double marketValuation;

	@ApiModelProperty("管理人")
	private String manager;

	@ApiModelProperty("状态")
	private String status;

	@ApiModelProperty("存放位置")
	private String location;

	@ApiModelProperty("备注")
	private String remark;

	@ApiModelProperty("登记时间")
	private String registerTime;

	@Override
	public String toString(){
		return "Asset [id=" + id + " , num=" + num + " , name=" + name + " , assetTypeOne=" + assetTypeOne + " , assetTypeTwo=" + assetTypeTwo + " , specification=" + specification + " , store=" + store + " , unit=" + unit + " , count=" + count + " , cost=" + cost + " , marketValuation=" + marketValuation + " , manager=" + manager + " , status=" + status + " , location=" + location + " , remark=" + remark + " , registerTime=" + registerTime + "  ]";
	}
}
