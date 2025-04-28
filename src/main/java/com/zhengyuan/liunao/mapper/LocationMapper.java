package com.zhengyuan.liunao.mapper;

import com.zhengyuan.liunao.entity.Location;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LocationMapper {
	List<Location> selectAllLocations(@Param("type") String type, @Param("tag") String tag);
}
