package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XuejixinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XuejixinxiView;


/**
 * 学籍信息
 *
 * @author 
 * @email 
 * @date 2024-03-28 22:22:54
 */
public interface XuejixinxiService extends IService<XuejixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XuejixinxiView> selectListView(Wrapper<XuejixinxiEntity> wrapper);
   	
   	XuejixinxiView selectView(@Param("ew") Wrapper<XuejixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XuejixinxiEntity> wrapper);
   	

}

