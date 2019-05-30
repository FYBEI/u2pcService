package com.uestc2h.u2pc.controller;

import com.uestc2h.u2pc.controller.DTO.PictureDTO;
import com.uestc2h.u2pc.entity.Picture;
import com.uestc2h.u2pc.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PictureController {

    @Autowired
    PictureService pictureService;

    @RequestMapping(value = "/getHeadImg", method = RequestMethod.GET)
    public PictureDTO getHeadImg(Long userId){
        PictureDTO pictureDTO = pictureService.getHeadImg(userId);

        return pictureDTO;
    }

    @RequestMapping(value = "/getCommodityImgs", method = RequestMethod.GET)
    public List<PictureDTO> getCommodityImgs(Long commodityId){
        List<PictureDTO> list = pictureService.getCommodityImgs(commodityId);

        return list;
    }

    @RequestMapping(value = "/register/pic", method = RequestMethod.GET)
    public Long register(Long userId){
        Long result = pictureService.register(userId);
        return result;
    }

    @RequestMapping(value = "/setHeadImg", method = RequestMethod.POST)
    public int setHeadImg(PictureDTO pictureDTO){
        return 0;
    }
}
