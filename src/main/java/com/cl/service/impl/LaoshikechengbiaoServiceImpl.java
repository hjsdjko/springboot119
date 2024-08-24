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


import com.cl.dao.LaoshikechengbiaoDao;
import com.cl.entity.LaoshikechengbiaoEntity;
import com.cl.service.LaoshikechengbiaoService;
import com.cl.entity.view.LaoshikechengbiaoView;

@Service("laoshikechengbiaoService")
public class LaoshikechengbiaoServiceImpl extends ServiceImpl<LaoshikechengbiaoDao, LaoshikechengbiaoEntity> implements LaoshikechengbiaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LaoshikechengbiaoEntity> page = this.selectPage(
                new Query<LaoshikechengbiaoEntity>(params).getPage(),
                new EntityWrapper<LaoshikechengbiaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LaoshikechengbiaoEntity> wrapper) {
		  Page<LaoshikechengbiaoView> page =new Query<LaoshikechengbiaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<LaoshikechengbiaoView> selectListView(Wrapper<LaoshikechengbiaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LaoshikechengbiaoView selectView(Wrapper<LaoshikechengbiaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
