package com.cl.dao;

import com.cl.entity.ZiliaoxiazaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZiliaoxiazaiView;


/**
 * 资料下载
 * 
 * @author 
 * @email 
 * @date 2024-03-28 22:22:54
 */
public interface ZiliaoxiazaiDao extends BaseMapper<ZiliaoxiazaiEntity> {
	
	List<ZiliaoxiazaiView> selectListView(@Param("ew") Wrapper<ZiliaoxiazaiEntity> wrapper);

	List<ZiliaoxiazaiView> selectListView(Pagination page,@Param("ew") Wrapper<ZiliaoxiazaiEntity> wrapper);
	
	ZiliaoxiazaiView selectView(@Param("ew") Wrapper<ZiliaoxiazaiEntity> wrapper);
	

}
