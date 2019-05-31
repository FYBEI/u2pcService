package com.uestc2h.u2pc.service.impl;

import com.uestc2h.u2pc.controller.DTO.PictureDTO;
import com.uestc2h.u2pc.mapper.DO.PictureDO;
import com.uestc2h.u2pc.mapper.PictureMapper;
import com.uestc2h.u2pc.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureMapper pictureMapper;

    PictureDTO changeDO(PictureDO pictureDO){
        PictureDTO pictureDTO = new PictureDTO();

        pictureDTO.setId(pictureDO.getId());
        pictureDTO.setImgId(pictureDO.getImgId());
        pictureDTO.setName(pictureDO.getName());
        pictureDTO.setSize(pictureDO.getSize());

        return pictureDTO;
    }

    PictureDO changeDTO(PictureDTO pictureDTO){
        PictureDO pictureDO = new PictureDO();

        pictureDO.setId(pictureDTO.getId());
        pictureDO.setImgId(pictureDTO.getImgId());
        pictureDO.setName(pictureDTO.getName());
        pictureDO.setSize(pictureDTO.getSize());

        return pictureDO;
    }

    @Override
    public PictureDTO getHeadImg(Long userId) {
        PictureDO pictureDO = pictureMapper.getHeadImg(userId);
        PictureDTO pictureDTO = changeDO(pictureDO);

        return pictureDTO;
    }

    @Override
    public List<PictureDTO> getCommodityImgs(Long commodityId) {
        List<PictureDO> doList = pictureMapper.getCommodityImgs(commodityId);
        List<PictureDTO> dtoList = new ArrayList<>();

        for (PictureDO obj : doList){
            PictureDTO pictureDTO = changeDO(obj);
            String name = "http://localhost:8070/myImg/commodityImg/" + pictureDTO.getName();
            pictureDTO.setName(name);
            dtoList.add(pictureDTO);
        }

        return dtoList;
    }

    @Override
    public Long register(Long userId) {
        PictureDO pictureDO = new PictureDO();

        String defaultname = "../assets/head.jpg";
        Long size = Long.valueOf(0);

        pictureDO.setId(userId);
        pictureDO.setName(defaultname);
        pictureDO.setSize(size);

        int result = pictureMapper.register(pictureDO);

        if (result > 0) {
            Long imgId = pictureDO.getImgId();
            return imgId;
        }else {
            return Long.valueOf(0);
        }

    }

    @Override
    public int setHeadImg(PictureDTO pictureDTO) {
        PictureDO pictureDO = changeDTO(pictureDTO);

        int result = pictureMapper.setHeadImg(pictureDO);

        return result;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    public int pubCommodityImg(List<PictureDTO> pictureDTOS) {
        int num = 0;

        for (PictureDTO obj : pictureDTOS){
            PictureDO pictureDO = changeDTO(obj);
            num += pictureMapper.pubCommodityImg(pictureDO);
        }
        if (num == pictureDTOS.size()){
            return num;
        }else {
            return 0;
        }
    }

    @Override
    public int deleteHeadImg(Long userId) {
        int result = pictureMapper.deleteHeadImg(userId);

        return result;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    public int deleteCommodity(Long commodityId) {
        int result = pictureMapper.deleteCommodity(commodityId);

        return result;
    }
}
