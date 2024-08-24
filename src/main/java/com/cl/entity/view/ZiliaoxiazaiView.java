package com.cl.entity.view;

import com.cl.entity.ZiliaoxiazaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 资料下载
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-28 22:22:54
 */
@TableName("ziliaoxiazai")
public class ZiliaoxiazaiView  extends ZiliaoxiazaiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZiliaoxiazaiView(){
	}
 
 	public ZiliaoxiazaiView(ZiliaoxiazaiEntity ziliaoxiazaiEntity){
 	try {
			BeanUtils.copyProperties(this, ziliaoxiazaiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
