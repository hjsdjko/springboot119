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


import com.cl.dao.XuejixinxiDao;
import com.cl.entity.XuejixinxiEntity;
import com.cl.service.XuejixinxiService;
import com.cl.entity.view.XuejixinxiView;

@Service("xuejixinxiService")
public class XuejixinxiServiceImpl extends ServiceImpl<XuejixinxiDao, XuejixinxiEntity> implements XuejixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XuejixinxiEntity> page = this.selectPage(
                new Query<XuejixinxiEntity>(params).getPage(),
                new EntityWrapper<XuejixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XuejixinxiEntity> wrapper) {
		  Page<XuejixinxiView> page =new Query<XuejixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XuejixinxiView> selectListView(Wrapper<XuejixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XuejixinxiView selectView(Wrapper<XuejixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
