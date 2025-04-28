package com.zhengyuan.liunao.service;

import com.zhengyuan.liunao.entity.Location;

import java.util.List;

public interface LocationService {
    List<Location> findInDistanceLocations(double distance, String type, String tag, String sort);
}
