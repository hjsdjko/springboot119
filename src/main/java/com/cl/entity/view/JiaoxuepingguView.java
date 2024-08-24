package com.cl.entity.view;

import com.cl.entity.JiaoxuepingguEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 教学评估
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-28 22:22:54
 */
@TableName("jiaoxuepinggu")
public class JiaoxuepingguView  extends JiaoxuepingguEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JiaoxuepingguView(){
	}
 
 	public JiaoxuepingguView(JiaoxuepingguEntity jiaoxuepingguEntity){
 	try {
			BeanUtils.copyProperties(this, jiaoxuepingguEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
