package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JiaoxuepingguEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiaoxuepingguView;


/**
 * 教学评估
 *
 * @author 
 * @email 
 * @date 2024-03-28 22:22:54
 */
public interface JiaoxuepingguService extends IService<JiaoxuepingguEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiaoxuepingguView> selectListView(Wrapper<JiaoxuepingguEntity> wrapper);
   	
   	JiaoxuepingguView selectView(@Param("ew") Wrapper<JiaoxuepingguEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiaoxuepingguEntity> wrapper);
   	

}

