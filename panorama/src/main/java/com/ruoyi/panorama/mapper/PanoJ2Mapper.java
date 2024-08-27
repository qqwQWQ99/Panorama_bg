package com.ruoyi.panorama.mapper;

import java.util.List;
import com.ruoyi.panorama.domain.PanoJ2;
import org.apache.ibatis.annotations.Select;

/**
 * 全景Mapper接口
 * 
 * @author qqw
 * @date 2024-08-27
 */
public interface PanoJ2Mapper 
{
    /**
     * 查询全景
     * 
     * @param id 全景主键
     * @return 全景
     */
    public PanoJ2 selectPanoJ2ById(Long id);

    /**
     * 查询全景列表
     * 
     * @param panoJ2 全景
     * @return 全景集合
     */
    public List<PanoJ2> selectPanoJ2List(PanoJ2 panoJ2);

    /**
     * 新增全景
     * 
     * @param panoJ2 全景
     * @return 结果
     */
    public int insertPanoJ2(PanoJ2 panoJ2);

    /**
     * 修改全景
     * 
     * @param panoJ2 全景
     * @return 结果
     */
    public int updatePanoJ2(PanoJ2 panoJ2);

    /**
     * 删除全景
     * 
     * @param id 全景主键
     * @return 结果
     */
    public int deletePanoJ2ById(Long id);

    /**
     * 批量删除全景
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePanoJ2ByIds(Long[] ids);

    /**
     * 获取全部坐标
     */
    @Select("select id,latitude,longitude from pano_j2")
    public List<PanoJ2> getLocation(PanoJ2 panoJ2);
}
