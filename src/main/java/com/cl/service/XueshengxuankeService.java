package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XueshengxuankeEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XueshengxuankeView;


/**
 * 学生选课
 *
 * @author 
 * @email 
 * @date 2024-03-28 22:22:53
 */
public interface XueshengxuankeService extends IService<XueshengxuankeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XueshengxuankeView> selectListView(Wrapper<XueshengxuankeEntity> wrapper);
   	
   	XueshengxuankeView selectView(@Param("ew") Wrapper<XueshengxuankeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XueshengxuankeEntity> wrapper);
   	

}

