package com.cl.entity.view;

import com.cl.entity.LaoshikechengbiaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 老师课程表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-28 22:22:53
 */
@TableName("laoshikechengbiao")
public class LaoshikechengbiaoView  extends LaoshikechengbiaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LaoshikechengbiaoView(){
	}
 
 	public LaoshikechengbiaoView(LaoshikechengbiaoEntity laoshikechengbiaoEntity){
 	try {
			BeanUtils.copyProperties(this, laoshikechengbiaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}