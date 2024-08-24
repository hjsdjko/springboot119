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

import com.cl.entity.LaoshikechengbiaoEntity;
import com.cl.entity.view.LaoshikechengbiaoView;

import com.cl.service.LaoshikechengbiaoService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 老师课程表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-28 22:22:53
 */
@RestController
@RequestMapping("/laoshikechengbiao")
public class LaoshikechengbiaoController {
    @Autowired
    private LaoshikechengbiaoService laoshikechengbiaoService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LaoshikechengbiaoEntity laoshikechengbiao,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			laoshikechengbiao.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<LaoshikechengbiaoEntity> ew = new EntityWrapper<LaoshikechengbiaoEntity>();

		PageUtils page = laoshikechengbiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, laoshikechengbiao), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LaoshikechengbiaoEntity laoshikechengbiao, 
		HttpServletRequest request){
        EntityWrapper<LaoshikechengbiaoEntity> ew = new EntityWrapper<LaoshikechengbiaoEntity>();

		PageUtils page = laoshikechengbiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, laoshikechengbiao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LaoshikechengbiaoEntity laoshikechengbiao){
       	EntityWrapper<LaoshikechengbiaoEntity> ew = new EntityWrapper<LaoshikechengbiaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( laoshikechengbiao, "laoshikechengbiao")); 
        return R.ok().put("data", laoshikechengbiaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LaoshikechengbiaoEntity laoshikechengbiao){
        EntityWrapper< LaoshikechengbiaoEntity> ew = new EntityWrapper< LaoshikechengbiaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( laoshikechengbiao, "laoshikechengbiao")); 
		LaoshikechengbiaoView laoshikechengbiaoView =  laoshikechengbiaoService.selectView(ew);
		return R.ok("查询老师课程表成功").put("data", laoshikechengbiaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LaoshikechengbiaoEntity laoshikechengbiao = laoshikechengbiaoService.selectById(id);
		laoshikechengbiao = laoshikechengbiaoService.selectView(new EntityWrapper<LaoshikechengbiaoEntity>().eq("id", id));
        return R.ok().put("data", laoshikechengbiao);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LaoshikechengbiaoEntity laoshikechengbiao = laoshikechengbiaoService.selectById(id);
		laoshikechengbiao = laoshikechengbiaoService.selectView(new EntityWrapper<LaoshikechengbiaoEntity>().eq("id", id));
        return R.ok().put("data", laoshikechengbiao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LaoshikechengbiaoEntity laoshikechengbiao, HttpServletRequest request){
    	laoshikechengbiao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(laoshikechengbiao);
        laoshikechengbiaoService.insert(laoshikechengbiao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LaoshikechengbiaoEntity laoshikechengbiao, HttpServletRequest request){
    	laoshikechengbiao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(laoshikechengbiao);
        laoshikechengbiaoService.insert(laoshikechengbiao);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody LaoshikechengbiaoEntity laoshikechengbiao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(laoshikechengbiao);
        laoshikechengbiaoService.updateById(laoshikechengbiao);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        laoshikechengbiaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
