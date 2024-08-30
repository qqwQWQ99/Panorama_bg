package com.ruoyi.panorama.result;

import com.ruoyi.panorama.domain.PanoJ2;
import lombok.Data;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

@Data
public class PanoImageResult {
    private PanoJ2 pano;
    private ResponseEntity<Resource> image;
}
