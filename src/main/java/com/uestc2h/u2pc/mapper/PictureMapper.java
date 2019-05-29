package com.uestc2h.u2pc.mapper;

import com.uestc2h.u2pc.entity.Picture;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PictureMapper {

    @Select("select * from headimg where id=#{userId}")
    Picture getHeadImg(Long userId);

    @Select("select * from commodityimg where id=#{commodityId}")
    List<Picture> getCommodityImgs(Long commodityId);
}
