package com.cl.dao;

import com.cl.entity.LaoshikechengbiaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.LaoshikechengbiaoView;


/**
 * 老师课程表
 * 
 * @author 
 * @email 
 * @date 2024-03-28 22:22:53
 */
public interface LaoshikechengbiaoDao extends BaseMapper<LaoshikechengbiaoEntity> {
	
	List<LaoshikechengbiaoView> selectListView(@Param("ew") Wrapper<LaoshikechengbiaoEntity> wrapper);

	List<LaoshikechengbiaoView> selectListView(Pagination page,@Param("ew") Wrapper<LaoshikechengbiaoEntity> wrapper);
	
	LaoshikechengbiaoView selectView(@Param("ew") Wrapper<LaoshikechengbiaoEntity> wrapper);
	

}
