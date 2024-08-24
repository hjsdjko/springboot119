package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.JiaoxuefankuiDao;
import com.cl.entity.JiaoxuefankuiEntity;
import com.cl.service.JiaoxuefankuiService;
import com.cl.entity.view.JiaoxuefankuiView;

@Service("jiaoxuefankuiService")
public class JiaoxuefankuiServiceImpl extends ServiceImpl<JiaoxuefankuiDao, JiaoxuefankuiEntity> implements JiaoxuefankuiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiaoxuefankuiEntity> page = this.selectPage(
                new Query<JiaoxuefankuiEntity>(params).getPage(),
                new EntityWrapper<JiaoxuefankuiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiaoxuefankuiEntity> wrapper) {
		  Page<JiaoxuefankuiView> page =new Query<JiaoxuefankuiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JiaoxuefankuiView> selectListView(Wrapper<JiaoxuefankuiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiaoxuefankuiView selectView(Wrapper<JiaoxuefankuiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
