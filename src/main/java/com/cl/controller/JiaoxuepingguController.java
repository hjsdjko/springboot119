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

import com.cl.entity.JiaoxuepingguEntity;
import com.cl.entity.view.JiaoxuepingguView;

import com.cl.service.JiaoxuepingguService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 教学评估
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-28 22:22:54
 */
@RestController
@RequestMapping("/jiaoxuepinggu")
public class JiaoxuepingguController {
    @Autowired
    private JiaoxuepingguService jiaoxuepingguService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiaoxuepingguEntity jiaoxuepinggu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			jiaoxuepinggu.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			jiaoxuepinggu.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JiaoxuepingguEntity> ew = new EntityWrapper<JiaoxuepingguEntity>();

		PageUtils page = jiaoxuepingguService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaoxuepinggu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiaoxuepingguEntity jiaoxuepinggu, 
		HttpServletRequest request){
        EntityWrapper<JiaoxuepingguEntity> ew = new EntityWrapper<JiaoxuepingguEntity>();

		PageUtils page = jiaoxuepingguService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaoxuepinggu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiaoxuepingguEntity jiaoxuepinggu){
       	EntityWrapper<JiaoxuepingguEntity> ew = new EntityWrapper<JiaoxuepingguEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiaoxuepinggu, "jiaoxuepinggu")); 
        return R.ok().put("data", jiaoxuepingguService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiaoxuepingguEntity jiaoxuepinggu){
        EntityWrapper< JiaoxuepingguEntity> ew = new EntityWrapper< JiaoxuepingguEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiaoxuepinggu, "jiaoxuepinggu")); 
		JiaoxuepingguView jiaoxuepingguView =  jiaoxuepingguService.selectView(ew);
		return R.ok("查询教学评估成功").put("data", jiaoxuepingguView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiaoxuepingguEntity jiaoxuepinggu = jiaoxuepingguService.selectById(id);
		jiaoxuepinggu = jiaoxuepingguService.selectView(new EntityWrapper<JiaoxuepingguEntity>().eq("id", id));
        return R.ok().put("data", jiaoxuepinggu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiaoxuepingguEntity jiaoxuepinggu = jiaoxuepingguService.selectById(id);
		jiaoxuepinggu = jiaoxuepingguService.selectView(new EntityWrapper<JiaoxuepingguEntity>().eq("id", id));
        return R.ok().put("data", jiaoxuepinggu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiaoxuepingguEntity jiaoxuepinggu, HttpServletRequest request){
    	jiaoxuepinggu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaoxuepinggu);
        jiaoxuepingguService.insert(jiaoxuepinggu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiaoxuepingguEntity jiaoxuepinggu, HttpServletRequest request){
    	jiaoxuepinggu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaoxuepinggu);
        jiaoxuepingguService.insert(jiaoxuepinggu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiaoxuepingguEntity jiaoxuepinggu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiaoxuepinggu);
        jiaoxuepingguService.updateById(jiaoxuepinggu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiaoxuepingguService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
