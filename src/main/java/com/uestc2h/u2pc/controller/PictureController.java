package com.uestc2h.u2pc.controller;

import com.uestc2h.u2pc.controller.DTO.PictureDTO;
import com.uestc2h.u2pc.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

    @RequestMapping(value = "/setHeadImg", method = RequestMethod.POST)
    public String setHeadImg(@RequestParam("file") MultipartFile file, @RequestParam("userId") Long userId){
        if (file.isEmpty()) {
            return "upload fail, select the file";
        }

        String fileName = file.getOriginalFilename();
        String filePath = "D:\\uestc2hService\\u2pcService\\src\\main\\resources\\myImg\\headImg\\";

        Long size = file.getSize();

        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);

            PictureDTO pictureDTO = new PictureDTO();
            pictureDTO.setSize(size);
            pictureDTO.setName(fileName);
            pictureDTO.setId(userId);

            int result = pictureService.setHeadImg(pictureDTO);

            if (result > 0)
                return "upload success";
            else
                return "upload fail";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "upload fail！";

    }

    @RequestMapping(value = "/deleteHeadImg", method = RequestMethod.GET)
    public String deleteHeadImg(Long userId){
        PictureDTO pictureDTO = pictureService.getHeadImg(userId);

        String fileName = "D:\\uestc2hService\\u2pcService\\src\\main\\resources\\myImg\\headImg\\" + pictureDTO.getName();

        File file = new File(fileName);
        boolean result;
        if(file.exists() && file.isFile()){
           result  = file.delete();
        }else {
            return "file not exists";
        }

        if (result){
            int num = pictureService.deleteHeadImg(userId);

            if (num > 0){
                return "file delete success";
            }
        }

        return "file delete fail";
    }

}
