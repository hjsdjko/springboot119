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

import com.cl.entity.JiaoxuefankuiEntity;
import com.cl.entity.view.JiaoxuefankuiView;

import com.cl.service.JiaoxuefankuiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 教学反馈
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-28 22:22:54
 */
@RestController
@RequestMapping("/jiaoxuefankui")
public class JiaoxuefankuiController {
    @Autowired
    private JiaoxuefankuiService jiaoxuefankuiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiaoxuefankuiEntity jiaoxuefankui,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			jiaoxuefankui.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JiaoxuefankuiEntity> ew = new EntityWrapper<JiaoxuefankuiEntity>();

		PageUtils page = jiaoxuefankuiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaoxuefankui), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiaoxuefankuiEntity jiaoxuefankui, 
		HttpServletRequest request){
        EntityWrapper<JiaoxuefankuiEntity> ew = new EntityWrapper<JiaoxuefankuiEntity>();

		PageUtils page = jiaoxuefankuiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaoxuefankui), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiaoxuefankuiEntity jiaoxuefankui){
       	EntityWrapper<JiaoxuefankuiEntity> ew = new EntityWrapper<JiaoxuefankuiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiaoxuefankui, "jiaoxuefankui")); 
        return R.ok().put("data", jiaoxuefankuiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiaoxuefankuiEntity jiaoxuefankui){
        EntityWrapper< JiaoxuefankuiEntity> ew = new EntityWrapper< JiaoxuefankuiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiaoxuefankui, "jiaoxuefankui")); 
		JiaoxuefankuiView jiaoxuefankuiView =  jiaoxuefankuiService.selectView(ew);
		return R.ok("查询教学反馈成功").put("data", jiaoxuefankuiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiaoxuefankuiEntity jiaoxuefankui = jiaoxuefankuiService.selectById(id);
		jiaoxuefankui = jiaoxuefankuiService.selectView(new EntityWrapper<JiaoxuefankuiEntity>().eq("id", id));
        return R.ok().put("data", jiaoxuefankui);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiaoxuefankuiEntity jiaoxuefankui = jiaoxuefankuiService.selectById(id);
		jiaoxuefankui = jiaoxuefankuiService.selectView(new EntityWrapper<JiaoxuefankuiEntity>().eq("id", id));
        return R.ok().put("data", jiaoxuefankui);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiaoxuefankuiEntity jiaoxuefankui, HttpServletRequest request){
    	jiaoxuefankui.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaoxuefankui);
        jiaoxuefankuiService.insert(jiaoxuefankui);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiaoxuefankuiEntity jiaoxuefankui, HttpServletRequest request){
    	jiaoxuefankui.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaoxuefankui);
        jiaoxuefankuiService.insert(jiaoxuefankui);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiaoxuefankuiEntity jiaoxuefankui, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiaoxuefankui);
        jiaoxuefankuiService.updateById(jiaoxuefankui);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiaoxuefankuiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
