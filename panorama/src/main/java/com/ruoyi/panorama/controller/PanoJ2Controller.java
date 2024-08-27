package com.ruoyi.panorama.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.panorama.domain.PanoJ2;
import com.ruoyi.panorama.service.IPanoJ2Service;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 全景Controller
 * 
 * @author qqw
 * @date 2024-08-27
 */
@RestController
@RequestMapping("/panorama/pano")
public class PanoJ2Controller extends BaseController
{
    @Autowired
    private IPanoJ2Service panoJ2Service;

    /**
     * 查询全景列表
     */
    @PreAuthorize("@ss.hasPermi('system:pano:list')")
    @GetMapping("/list")
    public TableDataInfo list(PanoJ2 panoJ2)
    {
        startPage();
        List<PanoJ2> list = panoJ2Service.selectPanoJ2List(panoJ2);
        return getDataTable(list);
    }

    /**
     * 导出全景列表
     */
    @PreAuthorize("@ss.hasPermi('system:pano:export')")
    @Log(title = "全景", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PanoJ2 panoJ2)
    {
        List<PanoJ2> list = panoJ2Service.selectPanoJ2List(panoJ2);
        ExcelUtil<PanoJ2> util = new ExcelUtil<PanoJ2>(PanoJ2.class);
        util.exportExcel(response, list, "全景数据");
    }

    /**
     * 获取全景详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:pano:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(panoJ2Service.selectPanoJ2ById(id));
    }

    /**
     * 新增全景
     */
    @PreAuthorize("@ss.hasPermi('system:pano:add')")
    @Log(title = "全景", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PanoJ2 panoJ2)
    {
        return toAjax(panoJ2Service.insertPanoJ2(panoJ2));
    }

    /**
     * 修改全景
     */
    @PreAuthorize("@ss.hasPermi('system:pano:edit')")
    @Log(title = "全景", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PanoJ2 panoJ2)
    {
        return toAjax(panoJ2Service.updatePanoJ2(panoJ2));
    }

    /**
     * 删除全景
     */
    @PreAuthorize("@ss.hasPermi('system:pano:remove')")
    @Log(title = "全景", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(panoJ2Service.deletePanoJ2ByIds(ids));
    }

    /**
     * 获取全部坐标
     */
    @PreAuthorize("@ss.hasPermi('system:pano:list')")
    @GetMapping("/getLocation")
    public List<PanoJ2> getLocation(PanoJ2 panoJ2)
    {
        List<PanoJ2> list = panoJ2Service.getLocation(panoJ2);
        return list;
    }

    @GetMapping("/getPano")
    public ResponseEntity<Resource> getImage(Long id) {
        return panoJ2Service.getImage(id);
    }

}
