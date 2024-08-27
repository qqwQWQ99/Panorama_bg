package com.ruoyi.panorama.service.impl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@ConfigurationProperties(prefix = "pano")    // 前缀
@PropertySource(value = {"classpath:panorama.yml"})   // 指定配置文件
public class PanoJ2ServiceImpl implements IPanoJ2Service 
{
    @Autowired
    private PanoJ2Mapper panoJ2Mapper;

    @Value("${profile}")
    private String profile;

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

    /**
     * 获取全部坐标
     */
    @Override
    public ResponseEntity<Resource> getImage(PanoJ2 panoJ2){
        PanoJ2 param = panoJ2Mapper.selectPanoJ2ById(panoJ2.getId());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // 使用 SimpleDateFormat 将 Date 对象格式化为字符串
        String date = sdf.format(param.getDate());
        if (date != null && date.length() >= 2 && date.substring(date.length() - 2).equals("01")) {
            date = date.substring(0, date.length() - 2) + "00";
        }
        date = date.replace('-', '_');
        String filename = date + "_"+ param.getLatitude()+"_"+param.getLongitude() +"_"+param.getElevation() + "_"+param.getNorthRotation()+
            "_" + param.getPanoramaId() + ".jpg";

        try {
            // 获取图片的文件路径
            Path filePath = Paths.get(profile+"/"+ param.getRegionCode()+param.getSubregionCode(),filename).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists() && resource.isReadable()) {
                // 设置响应头，指定内容类型
                HttpHeaders headers = new HttpHeaders();
                headers.add(HttpHeaders.CONTENT_TYPE, Files.probeContentType(filePath));

                // 返回图片资源
                return new ResponseEntity<>(resource, headers, HttpStatus.OK);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
