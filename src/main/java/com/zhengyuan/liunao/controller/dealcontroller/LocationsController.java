package com.zhengyuan.liunao.controller.dealcontroller;

import com.zhengyuan.liunao.entity.Location;
import com.zhengyuan.liunao.service.LocationService;
import com.zhengyuan.liunao.tools.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationsController {

    @Autowired
    private LocationService locationService;

    @RequestMapping("/locations")
    public Result queryInDistanceLocations(Double distance, String type, String tag, String sort) {
        System.out.println(distance);
        System.out.println(type);
        System.out.println(tag);
        System.out.println(sort);
        List<Location> resList = locationService.findInDistanceLocations(distance, type, tag, sort);
        System.out.println(resList);
        return Result.success(resList);
    }
}
