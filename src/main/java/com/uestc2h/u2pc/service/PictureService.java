package com.uestc2h.u2pc.service;

import com.uestc2h.u2pc.controller.DTO.PictureDTO;
import com.uestc2h.u2pc.mapper.DO.PictureDO;

import java.util.List;

public interface PictureService {
    PictureDTO getHeadImg(Long userId);

    List<PictureDTO> getCommodityImgs(Long commodityId);

    Long register(Long userId);

    int setHeadImg(PictureDTO pictureDTO);

    int pubCommodityImg(List<PictureDTO> pictureDTOS);

    int deleteHeadImg(Long userId);

    int deleteCommodity(Long commodityId);
}
