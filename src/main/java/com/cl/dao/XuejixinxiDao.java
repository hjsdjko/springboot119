package com.cl.dao;

import com.cl.entity.XuejixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XuejixinxiView;


/**
 * 学籍信息
 * 
 * @author 
 * @email 
 * @date 2024-03-28 22:22:54
 */
public interface XuejixinxiDao extends BaseMapper<XuejixinxiEntity> {
	
	List<XuejixinxiView> selectListView(@Param("ew") Wrapper<XuejixinxiEntity> wrapper);

	List<XuejixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<XuejixinxiEntity> wrapper);
	
	XuejixinxiView selectView(@Param("ew") Wrapper<XuejixinxiEntity> wrapper);
	

}
