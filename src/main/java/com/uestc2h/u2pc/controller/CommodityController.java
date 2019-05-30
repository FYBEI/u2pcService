package com.uestc2h.u2pc.controller;

import com.uestc2h.u2pc.controller.DTO.CommodityDTO;
import com.uestc2h.u2pc.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommodityController {

    @Autowired
    CommodityService commodityService;

    @RequestMapping(value = "/pub", method = RequestMethod.POST)
    public Long pub(CommodityDTO commodityDTO){
        Long id = commodityService.pub(commodityDTO);

        return id;
    };

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public boolean delete(CommodityDTO commodityDTO){
        int result = commodityService.delete(commodityDTO);

        if (result > 0)
            return true;
        else
            return false;
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

        return list;
    }

    @RequestMapping(value = "/kind", method = RequestMethod.GET)
    public List<CommodityDTO> getCommoditiesByKind(String kind){
        List<CommodityDTO> list = commodityService.getCommoditiesByKind(kind);

        return list;
    }

    @RequestMapping(value = "/usersell", method = RequestMethod.GET)
    public List<CommodityDTO> getUserSell(Long userId, boolean sell){
        List<CommodityDTO> list = commodityService.getUserSell(userId, sell);

        return list;
    }
}
