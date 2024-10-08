package com.ruoyi.panorama.service;

import java.util.List;
import com.ruoyi.panorama.domain.PanoJ2;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

/**
 * 全景Service接口
 * 
 * @author qqw
 * @date 2024-08-27
 */
public interface IPanoJ2Service 
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
     * 批量删除全景
     * 
     * @param ids 需要删除的全景主键集合
     * @return 结果
     */
    public int deletePanoJ2ByIds(Long[] ids);

    /**
     * 删除全景信息
     * 
     * @param id 全景主键
     * @return 结果
     */
    public int deletePanoJ2ById(Long id);

    /**
     * 获取全部坐标
     */
    public List<PanoJ2> getLocation(PanoJ2 panoJ2);

    /**
     * 预览全景
     */
    public ResponseEntity<Resource> getImage(Long id);
}
