package com.uestc2h.u2pc.mapper;

import com.uestc2h.u2pc.mapper.DO.PictureDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface PictureMapper {

    @Select("select * from headimg where id=#{userId};")
    PictureDO getHeadImg(Long userId);

    @Select("select * from commodityimg where id=#{commodityId};")
    List<PictureDO> getCommodityImgs(Long commodityId);

    @Insert("insert into headimg (name, size, id) values (#{name}, #{size}, #{id});")
    int register(PictureDO pictureDO);

    @Update("update headimg set name=#{name}, size=#{size} where id=#{id};")
    int setHeadImg(PictureDO pictureDO);

    @Insert("isert into commodityimg (name, size, id) values (#{name}, #{size}, #{id});")
    int pubCommodityImg(PictureDO pictureDO);

    @Update("delete from headimg where id=#{userId};")
    int deleteHeadImg(Long userId);

    @Update("delete from commodityimg where id=#{commodityId};")
    int deleteCommodity(Long commodityId);
}
