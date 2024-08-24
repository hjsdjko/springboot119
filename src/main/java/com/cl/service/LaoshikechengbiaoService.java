package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.LaoshikechengbiaoEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.LaoshikechengbiaoView;


/**
 * 老师课程表
 *
 * @author 
 * @email 
 * @date 2024-03-28 22:22:53
 */
public interface LaoshikechengbiaoService extends IService<LaoshikechengbiaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LaoshikechengbiaoView> selectListView(Wrapper<LaoshikechengbiaoEntity> wrapper);
   	
   	LaoshikechengbiaoView selectView(@Param("ew") Wrapper<LaoshikechengbiaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LaoshikechengbiaoEntity> wrapper);
   	

}

