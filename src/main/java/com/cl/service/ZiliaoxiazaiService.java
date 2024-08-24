package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZiliaoxiazaiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZiliaoxiazaiView;


/**
 * 资料下载
 *
 * @author 
 * @email 
 * @date 2024-03-28 22:22:54
 */
public interface ZiliaoxiazaiService extends IService<ZiliaoxiazaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZiliaoxiazaiView> selectListView(Wrapper<ZiliaoxiazaiEntity> wrapper);
   	
   	ZiliaoxiazaiView selectView(@Param("ew") Wrapper<ZiliaoxiazaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZiliaoxiazaiEntity> wrapper);
   	

}

