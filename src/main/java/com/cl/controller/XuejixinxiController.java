package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.XuejixinxiEntity;
import com.cl.entity.view.XuejixinxiView;

import com.cl.service.XuejixinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 学籍信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-28 22:22:54
 */
@RestController
@RequestMapping("/xuejixinxi")
public class XuejixinxiController {
    @Autowired
    private XuejixinxiService xuejixinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XuejixinxiEntity xuejixinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			xuejixinxi.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XuejixinxiEntity> ew = new EntityWrapper<XuejixinxiEntity>();

		PageUtils page = xuejixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xuejixinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XuejixinxiEntity xuejixinxi, 
		HttpServletRequest request){
        EntityWrapper<XuejixinxiEntity> ew = new EntityWrapper<XuejixinxiEntity>();

		PageUtils page = xuejixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xuejixinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XuejixinxiEntity xuejixinxi){
       	EntityWrapper<XuejixinxiEntity> ew = new EntityWrapper<XuejixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xuejixinxi, "xuejixinxi")); 
        return R.ok().put("data", xuejixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XuejixinxiEntity xuejixinxi){
        EntityWrapper< XuejixinxiEntity> ew = new EntityWrapper< XuejixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xuejixinxi, "xuejixinxi")); 
		XuejixinxiView xuejixinxiView =  xuejixinxiService.selectView(ew);
		return R.ok("查询学籍信息成功").put("data", xuejixinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XuejixinxiEntity xuejixinxi = xuejixinxiService.selectById(id);
		xuejixinxi = xuejixinxiService.selectView(new EntityWrapper<XuejixinxiEntity>().eq("id", id));
        return R.ok().put("data", xuejixinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XuejixinxiEntity xuejixinxi = xuejixinxiService.selectById(id);
		xuejixinxi = xuejixinxiService.selectView(new EntityWrapper<XuejixinxiEntity>().eq("id", id));
        return R.ok().put("data", xuejixinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XuejixinxiEntity xuejixinxi, HttpServletRequest request){
    	xuejixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xuejixinxi);
        xuejixinxiService.insert(xuejixinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XuejixinxiEntity xuejixinxi, HttpServletRequest request){
    	xuejixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xuejixinxi);
        xuejixinxiService.insert(xuejixinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XuejixinxiEntity xuejixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xuejixinxi);
        xuejixinxiService.updateById(xuejixinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xuejixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
