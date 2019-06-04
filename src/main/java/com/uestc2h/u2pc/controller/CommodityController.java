package com.uestc2h.u2pc.controller;

import com.uestc2h.u2pc.controller.DTO.CommodityDTO;
import com.uestc2h.u2pc.controller.DTO.PictureDTO;
import com.uestc2h.u2pc.service.CommodityService;
import com.uestc2h.u2pc.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CommodityController {

    @Autowired
    private CommodityService commodityService;
    @Autowired
    private PictureService pictureService;

    @RequestMapping(value = "/pub", method = RequestMethod.POST)
    public Long pub(CommodityDTO commodityDTO){
        Long commodityId = commodityService.pub(commodityDTO);

        return commodityId;
    };

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(CommodityDTO commodityDTO){
        int result = commodityService.delete(commodityDTO);

        if (result <= 0)
            return "删除失败";

        Long commodityId = commodityDTO.getId();

        List<PictureDTO> pictureDTOS = pictureService.getCommodityImgs(commodityId);

        int num = 0;
        for (PictureDTO pictureDTO : pictureDTOS){
            String[] tmp = pictureDTO.getName().split("/");
            String fileName = "D:\\uestc2hService\\u2pcService\\src\\main\\resources\\myImg\\commodityImg\\" + tmp[tmp.length-1];
            File file = new File(fileName);

            if (file.exists() && file.isFile()){
                if (file.delete()){
                    num++;
                }
            }else {
                return "file not exits";
            }
        }

        if (num == pictureDTOS.size())
            if(pictureService.deleteCommodity(commodityId) > 0)
                return "file delete success";

        return "file delete fail";

    };

    @RequestMapping(value = "/sell", method = RequestMethod.POST)
    public boolean sell(CommodityDTO commodityDTO){
        int result = commodityService.sell(commodityDTO);

        if (result > 0)
            return true;
        else
            return false;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<CommodityDTO> getAll(){
        List<CommodityDTO> list = commodityService.getAll();

        for (CommodityDTO commodityDTO:list){
            List<PictureDTO> pictureList = pictureService.getCommodityImgs(commodityDTO.getId());
            commodityDTO.setPictures(pictureList);
        }

        return list;
    }

    @RequestMapping(value = "/kind", method = RequestMethod.GET)
    public List<CommodityDTO> getCommoditiesByKind(String kind){
        List<CommodityDTO> list = commodityService.getCommoditiesByKind(kind);

        for (CommodityDTO commodityDTO:list){
            List<PictureDTO> pictureList = pictureService.getCommodityImgs(commodityDTO.getId());
            commodityDTO.setPictures(pictureList);
        }

        return list;
    }

    @RequestMapping(value = "/usersell", method = RequestMethod.GET)
    public List<CommodityDTO> getUserSell(Long userId, boolean sell){
        List<CommodityDTO> list = commodityService.getUserSell(userId, sell);

        for (CommodityDTO obj:list){
            Long commodityId = obj.getId();
            List<PictureDTO> pictures = pictureService.getCommodityImgs(commodityId);
            obj.setPictures(pictures);
        }

        return list;
    }
}
