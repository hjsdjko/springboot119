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

import com.cl.entity.ZiliaoxiazaiEntity;
import com.cl.entity.view.ZiliaoxiazaiView;

import com.cl.service.ZiliaoxiazaiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 资料下载
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-28 22:22:54
 */
@RestController
@RequestMapping("/ziliaoxiazai")
public class ZiliaoxiazaiController {
    @Autowired
    private ZiliaoxiazaiService ziliaoxiazaiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZiliaoxiazaiEntity ziliaoxiazai,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			ziliaoxiazai.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiaoshi")) {
			ziliaoxiazai.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZiliaoxiazaiEntity> ew = new EntityWrapper<ZiliaoxiazaiEntity>();

		PageUtils page = ziliaoxiazaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ziliaoxiazai), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZiliaoxiazaiEntity ziliaoxiazai, 
		HttpServletRequest request){
        EntityWrapper<ZiliaoxiazaiEntity> ew = new EntityWrapper<ZiliaoxiazaiEntity>();

		PageUtils page = ziliaoxiazaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ziliaoxiazai), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZiliaoxiazaiEntity ziliaoxiazai){
       	EntityWrapper<ZiliaoxiazaiEntity> ew = new EntityWrapper<ZiliaoxiazaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( ziliaoxiazai, "ziliaoxiazai")); 
        return R.ok().put("data", ziliaoxiazaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZiliaoxiazaiEntity ziliaoxiazai){
        EntityWrapper< ZiliaoxiazaiEntity> ew = new EntityWrapper< ZiliaoxiazaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( ziliaoxiazai, "ziliaoxiazai")); 
		ZiliaoxiazaiView ziliaoxiazaiView =  ziliaoxiazaiService.selectView(ew);
		return R.ok("查询资料下载成功").put("data", ziliaoxiazaiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZiliaoxiazaiEntity ziliaoxiazai = ziliaoxiazaiService.selectById(id);
		ziliaoxiazai = ziliaoxiazaiService.selectView(new EntityWrapper<ZiliaoxiazaiEntity>().eq("id", id));
        return R.ok().put("data", ziliaoxiazai);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZiliaoxiazaiEntity ziliaoxiazai = ziliaoxiazaiService.selectById(id);
		ziliaoxiazai = ziliaoxiazaiService.selectView(new EntityWrapper<ZiliaoxiazaiEntity>().eq("id", id));
        return R.ok().put("data", ziliaoxiazai);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZiliaoxiazaiEntity ziliaoxiazai, HttpServletRequest request){
    	ziliaoxiazai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(ziliaoxiazai);
        ziliaoxiazaiService.insert(ziliaoxiazai);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZiliaoxiazaiEntity ziliaoxiazai, HttpServletRequest request){
    	ziliaoxiazai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(ziliaoxiazai);
        ziliaoxiazaiService.insert(ziliaoxiazai);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZiliaoxiazaiEntity ziliaoxiazai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(ziliaoxiazai);
        ziliaoxiazaiService.updateById(ziliaoxiazai);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        ziliaoxiazaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
