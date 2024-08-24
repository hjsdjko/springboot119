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


import com.cl.dao.JiaoxuepingguDao;
import com.cl.entity.JiaoxuepingguEntity;
import com.cl.service.JiaoxuepingguService;
import com.cl.entity.view.JiaoxuepingguView;

@Service("jiaoxuepingguService")
public class JiaoxuepingguServiceImpl extends ServiceImpl<JiaoxuepingguDao, JiaoxuepingguEntity> implements JiaoxuepingguService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiaoxuepingguEntity> page = this.selectPage(
                new Query<JiaoxuepingguEntity>(params).getPage(),
                new EntityWrapper<JiaoxuepingguEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiaoxuepingguEntity> wrapper) {
		  Page<JiaoxuepingguView> page =new Query<JiaoxuepingguView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JiaoxuepingguView> selectListView(Wrapper<JiaoxuepingguEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiaoxuepingguView selectView(Wrapper<JiaoxuepingguEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
