package com.ruoyi.panorama.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 全景对象 pano_j2
 * 
 * @author qqw
 * @date 2024-08-27
 */
public class PanoJ2 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 全景ID */
    @Excel(name = "全景ID")
    private String panoramaId;

    /** 大区代码 */
    @Excel(name = "大区代码")
    private String regionCode;

    /** 小区代码 */
    @Excel(name = "小区代码")
    private String subregionCode;

    /** 全景日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "全景日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date date;

    /** 纬度 */
    @Excel(name = "纬度")
    private String latitude;

    /** 经度 */
    @Excel(name = "经度")
    private String longitude;

    /** 海拔 */
    @Excel(name = "海拔")
    private Long elevation;

    /** 北旋转 */
    @Excel(name = "北旋转")
    private Long northRotation;

    /** 相邻id1 */
    private Long nextId1;

    /** 相邻大区代码1 */
    private Float northRotation1;

    /** 相邻id2 */
    private Long nextId2;

    /** 相邻大区代码2 */
    private Float northRotation2;

    /** 空间数据 */
    private String geom;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPanoramaId(String panoramaId) 
    {
        this.panoramaId = panoramaId;
    }

    public String getPanoramaId() 
    {
        return panoramaId;
    }
    public void setRegionCode(String regionCode) 
    {
        this.regionCode = regionCode;
    }

    public String getRegionCode() 
    {
        return regionCode;
    }
    public void setSubregionCode(String subregionCode) 
    {
        this.subregionCode = subregionCode;
    }

    public String getSubregionCode() 
    {
        return subregionCode;
    }
    public void setDate(Date date) 
    {
        this.date = date;
    }

    public Date getDate() 
    {
        return date;
    }
    public void setLatitude(String latitude)
    {
        this.latitude = latitude;
    }

    public String getLatitude()
    {
        return latitude;
    }
    public void setLongitude(String longitude)
    {
        this.longitude = longitude;
    }

    public String getLongitude()
    {
        return longitude;
    }
    public void setElevation(Long elevation) 
    {
        this.elevation = elevation;
    }

    public Long getElevation() 
    {
        return elevation;
    }
    public void setNorthRotation(Long northRotation) 
    {
        this.northRotation = northRotation;
    }

    public Long getNorthRotation() 
    {
        return northRotation;
    }
    public void setNextId1(Long nextId1) 
    {
        this.nextId1 = nextId1;
    }

    public Long getNextId1() 
    {
        return nextId1;
    }
    public void setNorthRotation1(Float northRotation1)
    {
        this.northRotation1 = northRotation1;
    }

    public Float getNorthRotation1()
    {
        return northRotation1;
    }
    public void setNextId2(Long nextId2) 
    {
        this.nextId2 = nextId2;
    }

    public Long getNextId2() 
    {
        return nextId2;
    }
    public void setNorthRotation2(Float northRotation2)
    {
        this.northRotation2 = northRotation2;
    }

    public Float getNorthRotation2()
    {
        return northRotation2;
    }
    public void setGeom(String geom) 
    {
        this.geom = geom;
    }

    public String getGeom() 
    {
        return geom;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("panoramaId", getPanoramaId())
            .append("regionCode", getRegionCode())
            .append("subregionCode", getSubregionCode())
            .append("date", getDate())
            .append("latitude", getLatitude())
            .append("longitude", getLongitude())
            .append("elevation", getElevation())
            .append("northRotation", getNorthRotation())
            .append("nextId1", getNextId1())
            .append("nextRegionCode1", getNorthRotation1())
            .append("nextId2", getNextId2())
            .append("nextRegionCode2", getNorthRotation2())
            .append("geom", getGeom())
            .toString();
    }
}
