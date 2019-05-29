package com.uestc2h.u2pc.mapper;

import com.uestc2h.u2pc.mapper.DO.CommodityDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CommodityMapper {

    @Insert("insert into commodity (name,price,intro,kind,userId) values (#{name},#{price},#{intro},#{kind},#{userId})")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int pub(CommodityDO commodity);

    @Update("delete from commodity where id=#{id}")
    int delete(CommodityDO commodity);

    @Update("update commodity set sell=1 where id=#{id}")
    int sell(CommodityDO commodity);
}
