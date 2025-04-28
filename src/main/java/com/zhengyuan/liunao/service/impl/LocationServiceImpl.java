package com.zhengyuan.liunao.service.impl;

import com.zhengyuan.liunao.entity.Location;
import com.zhengyuan.liunao.mapper.LocationMapper;
import com.zhengyuan.liunao.service.LocationService;
import com.zhengyuan.liunao.tools.CalDistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationMapper locationMapper;

    @Override
    public List<Location> findInDistanceLocations(double distance, String type, String tag, String sort) {
        List<Location> allList = locationMapper.selectAllLocations(type, tag);
        List<Location> resList = new ArrayList<>();

        for (Location location : allList) {
            if (CalDistance.haversine(location.getLatitude(), location.getLongitude(), 39.9, 116.4) <= distance) {
                resList.add(location);
            }
        }

        return resList;
    }
}
