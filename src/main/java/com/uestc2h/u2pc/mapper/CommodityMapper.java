package com.uestc2h.u2pc.mapper;

import com.uestc2h.u2pc.mapper.DO.CommodityDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommodityMapper {

    @Insert("insert into commodity (name,price,intro,kind,userId) values (#{name},#{price},#{intro},#{kind},#{userId});")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int pub(CommodityDO commodity);

    @Update("delete from commodity where id=#{id};")
    int delete(CommodityDO commodity);

    @Update("update commodity set sell=1 where id=#{id};")
    int sell(CommodityDO commodity);

    @Select("select * from commodity")
    List<CommodityDO> getAll();

    @Select("select * from commodity where kind=#{kind};")
    List<CommodityDO> getCommoditiesByKind(String kind);

    @Select("select * from commodity where userId=#{userId} and sell=#{sell};")
    List<CommodityDO> getUserSell(Long userId, boolean sell);


}
