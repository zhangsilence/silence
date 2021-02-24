package com.lemon.silence.utils.Paging;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 分页信息对象
 *
 * @author zhangxueqi
 * @version 1.0
 * @date 2020/9/19 13:37
 */
@ApiModel(value = "Paging", description = "分页信息")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Paging<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "是否可分页")
	@JsonProperty(value = "pageable")
	private boolean pageable = true;

	@ApiModelProperty(value = "当前第几页")
	@JsonProperty(value = "pageNo")
	private long pageNo;

	@ApiModelProperty(value = "每页多少条")
	@JsonProperty(value = "pageSize")
	private long pageSize;

	@ApiModelProperty(value = "总页数")
	@JsonProperty(value = "totalPage")
	private long totalPage;

	@ApiModelProperty(value = "总条数")
	@JsonProperty(value = "total")
	private long total;

	@ApiModelProperty(value = "详细信息")
	@JsonProperty(value = "list")
	private List<T> list;

	public Paging(long pageSize, long pageNo) {
		this.pageSize = pageSize;
		this.pageNo = pageNo;
	}

}
