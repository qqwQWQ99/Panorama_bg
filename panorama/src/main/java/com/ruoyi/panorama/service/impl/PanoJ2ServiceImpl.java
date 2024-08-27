package com.ruoyi.panorama.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.panorama.mapper.PanoJ2Mapper;
import com.ruoyi.panorama.domain.PanoJ2;
import com.ruoyi.panorama.service.IPanoJ2Service;

/**
 * 全景Service业务层处理
 * 
 * @author qqw
 * @date 2024-08-27
 */
@Service
public class PanoJ2ServiceImpl implements IPanoJ2Service 
{
    @Autowired
    private PanoJ2Mapper panoJ2Mapper;

    /**
     * 查询全景
     * 
     * @param id 全景主键
     * @return 全景
     */
    @Override
    public PanoJ2 selectPanoJ2ById(Long id)
    {
        return panoJ2Mapper.selectPanoJ2ById(id);
    }

    /**
     * 查询全景列表
     * 
     * @param panoJ2 全景
     * @return 全景
     */
    @Override
    public List<PanoJ2> selectPanoJ2List(PanoJ2 panoJ2)
    {
        return panoJ2Mapper.selectPanoJ2List(panoJ2);
    }

    /**
     * 新增全景
     * 
     * @param panoJ2 全景
     * @return 结果
     */
    @Override
    public int insertPanoJ2(PanoJ2 panoJ2)
    {
        return panoJ2Mapper.insertPanoJ2(panoJ2);
    }

    /**
     * 修改全景
     * 
     * @param panoJ2 全景
     * @return 结果
     */
    @Override
    public int updatePanoJ2(PanoJ2 panoJ2)
    {
        return panoJ2Mapper.updatePanoJ2(panoJ2);
    }

    /**
     * 批量删除全景
     * 
     * @param ids 需要删除的全景主键
     * @return 结果
     */
    @Override
    public int deletePanoJ2ByIds(Long[] ids)
    {
        return panoJ2Mapper.deletePanoJ2ByIds(ids);
    }

    /**
     * 删除全景信息
     * 
     * @param id 全景主键
     * @return 结果
     */
    @Override
    public int deletePanoJ2ById(Long id)
    {
        return panoJ2Mapper.deletePanoJ2ById(id);
    }


    /**
     * 获取全部坐标
     */
    @Override
    public List<PanoJ2> getLocation(PanoJ2 panoJ2)
    {
        return panoJ2Mapper.getLocation(panoJ2);
    }


}
