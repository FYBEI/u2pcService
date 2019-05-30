package com.uestc2h.u2pc.service.impl;

import com.uestc2h.u2pc.controller.DTO.CommodityDTO;
import com.uestc2h.u2pc.mapper.CommodityMapper;
import com.uestc2h.u2pc.mapper.DO.CommodityDO;
import com.uestc2h.u2pc.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    CommodityMapper commodityMapper;

    CommodityDTO changDO(CommodityDO commodityDO){
        CommodityDTO commodityDTO = new CommodityDTO();

        commodityDTO.setId(commodityDO.getId());
        commodityDTO.setIntro(commodityDO.getIntro());
        commodityDTO.setName(commodityDO.getName());
        commodityDTO.setPrice(commodityDO.getPrice());
        commodityDTO.setSell(commodityDO.isSell());
        commodityDTO.setUserId(commodityDO.getUserId());
        commodityDTO.setKind(commodityDO.getKind());

        return commodityDTO;
    }

    CommodityDO changDTO(CommodityDTO commodityDTO){
        CommodityDO commodityDO = new CommodityDO();

        commodityDO.setId(commodityDTO.getId());
        commodityDO.setIntro(commodityDTO.getIntro());
        commodityDO.setName(commodityDTO.getName());
        commodityDO.setPrice(commodityDTO.getPrice());
        commodityDO.setSell(commodityDTO.isSell());
        commodityDO.setUserId(commodityDTO.getUserId());
        commodityDO.setKind(commodityDTO.getKind());

        return commodityDO;
    }

    @Override
    public Long pub(CommodityDTO commodityDTO) {
        CommodityDO commodityDO = changDTO(commodityDTO);
        commodityMapper.pub(commodityDO);

        Long id = commodityDO.getId();

        return id;
    }

    @Override
    public int delete(CommodityDTO commodityDTO) {
        CommodityDO commodityDO = changDTO(commodityDTO);
        int num = commodityMapper.delete(commodityDO);

        return num;
    }

    @Override
    public int sell(CommodityDTO commodityDTO) {
        CommodityDO commodityDO = changDTO(commodityDTO);
        int num = commodityMapper.sell(commodityDO);

        return num;
    }

    @Override
    public List<CommodityDTO> getAll() {
        List<CommodityDO> doList = commodityMapper.getAll();
        List<CommodityDTO> dtoList = new ArrayList<>();

        for (CommodityDO obj : doList){
            CommodityDTO commodityDTO = changDO(obj);
            dtoList.add(commodityDTO);
        }

        return dtoList;
    }

    @Override
    public List<CommodityDTO> getCommoditiesByKind(String kind) {
        List<CommodityDO> doList = commodityMapper.getCommoditiesByKind(kind);
        List<CommodityDTO> dtoList = new ArrayList<>();

        for (CommodityDO obj : doList){
            CommodityDTO commodityDTO = changDO(obj);
            dtoList.add(commodityDTO);
        }

        return dtoList;
    }

    @Override
    public List<CommodityDTO> getUserSell(Long userId, boolean sell) {
        List<CommodityDO> doList = commodityMapper.getUserSell(userId, sell);
        List<CommodityDTO> dtoList = new ArrayList<>();

        for (CommodityDO obj : doList){
            CommodityDTO commodityDTO = changDO(obj);
            dtoList.add(commodityDTO);
        }

        return dtoList;
    }
}
