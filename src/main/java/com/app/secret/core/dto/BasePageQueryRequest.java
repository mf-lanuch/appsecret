package com.app.secret.core.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author crsu 2019/12/30
 */
@XmlRootElement(
        name = "pageQueryRequest"
)
@XmlAccessorType(XmlAccessType.FIELD)
public class BasePageQueryRequest {
    @NotNull(
            message = "当前页码不能为空。"
    )
    @Min(
            value = 1L,
            message = "当前页码必须大于0。"
    )
    @XmlElement(
            name = "pageIndex"
    )
    private Integer pageIndex;
    @NotNull(
            message = "每页的数量不能为空。"
    )
    @Min(
            value = 1L,
            message = "每页的数量必须大于0。"
    )
    @XmlElement(
            name = "pageSize"
    )
    private Integer pageSize;

    public BasePageQueryRequest() {
    }

    public Integer getPageIndex() {
        return this.pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
