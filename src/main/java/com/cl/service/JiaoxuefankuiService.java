package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JiaoxuefankuiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiaoxuefankuiView;


/**
 * 教学反馈
 *
 * @author 
 * @email 
 * @date 2024-03-28 22:22:54
 */
public interface JiaoxuefankuiService extends IService<JiaoxuefankuiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiaoxuefankuiView> selectListView(Wrapper<JiaoxuefankuiEntity> wrapper);
   	
   	JiaoxuefankuiView selectView(@Param("ew") Wrapper<JiaoxuefankuiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiaoxuefankuiEntity> wrapper);
   	

}

