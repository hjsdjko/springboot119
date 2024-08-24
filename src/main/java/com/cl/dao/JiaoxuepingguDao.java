package com.cl.dao;

import com.cl.entity.JiaoxuepingguEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiaoxuepingguView;


/**
 * 教学评估
 * 
 * @author 
 * @email 
 * @date 2024-03-28 22:22:54
 */
public interface JiaoxuepingguDao extends BaseMapper<JiaoxuepingguEntity> {
	
	List<JiaoxuepingguView> selectListView(@Param("ew") Wrapper<JiaoxuepingguEntity> wrapper);

	List<JiaoxuepingguView> selectListView(Pagination page,@Param("ew") Wrapper<JiaoxuepingguEntity> wrapper);
	
	JiaoxuepingguView selectView(@Param("ew") Wrapper<JiaoxuepingguEntity> wrapper);
	

}
