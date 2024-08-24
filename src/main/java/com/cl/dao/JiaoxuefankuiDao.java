package com.cl.dao;

import com.cl.entity.JiaoxuefankuiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiaoxuefankuiView;


/**
 * 教学反馈
 * 
 * @author 
 * @email 
 * @date 2024-03-28 22:22:54
 */
public interface JiaoxuefankuiDao extends BaseMapper<JiaoxuefankuiEntity> {
	
	List<JiaoxuefankuiView> selectListView(@Param("ew") Wrapper<JiaoxuefankuiEntity> wrapper);

	List<JiaoxuefankuiView> selectListView(Pagination page,@Param("ew") Wrapper<JiaoxuefankuiEntity> wrapper);
	
	JiaoxuefankuiView selectView(@Param("ew") Wrapper<JiaoxuefankuiEntity> wrapper);
	

}
