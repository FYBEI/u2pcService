package com.uestc2h.u2pc.service;

import com.uestc2h.u2pc.controller.DTO.CommodityDTO;

import java.util.List;

public interface CommodityService {

    public Long pub(CommodityDTO commodityDTO);

    public int delete(CommodityDTO commodityDTO);

    public int sell(CommodityDTO commodityDTO);

    public List<CommodityDTO> getAll();

    List<CommodityDTO> getCommoditiesByKind(String kind);

    List<CommodityDTO> getUserSell(Long userId, boolean sell);
}
