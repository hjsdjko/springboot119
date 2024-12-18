package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 教学评估
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-28 22:22:54
 */
@TableName("jiaoxuepinggu")
public class JiaoxuepingguEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JiaoxuepingguEntity() {
		
	}
	
	public JiaoxuepingguEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 教师工号
	 */
					
	private String jiaoshigonghao;
	
	/**
	 * 教师姓名
	 */
					
	private String jiaoshixingming;
	
	/**
	 * 课程名称
	 */
					
	private String kechengmingcheng;
	
	/**
	 * 课程类型
	 */
					
	private String kechengleixing;
	
	/**
	 * 教学态度
	 */
					
	private String jiaoxuetaidu;
	
	/**
	 * 教学内容
	 */
					
	private String jiaoxueneirong;
	
	/**
	 * 教学进度
	 */
					
	private String jiaoxuejindu;
	
	/**
	 * 教学创新
	 */
					
	private String jiaoxuechuangxin;
	
	/**
	 * 教学水平
	 */
					
	private String jiaoxueshuiping;
	
	/**
	 * 学号
	 */
					
	private String xuehao;
	
	/**
	 * 学生姓名
	 */
					
	private String xueshengxingming;
	
	/**
	 * 评估时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date pinggushijian;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：教师工号
	 */
	public void setJiaoshigonghao(String jiaoshigonghao) {
		this.jiaoshigonghao = jiaoshigonghao;
	}
	/**
	 * 获取：教师工号
	 */
	public String getJiaoshigonghao() {
		return jiaoshigonghao;
	}
	/**
	 * 设置：教师姓名
	 */
	public void setJiaoshixingming(String jiaoshixingming) {
		this.jiaoshixingming = jiaoshixingming;
	}
	/**
	 * 获取：教师姓名
	 */
	public String getJiaoshixingming() {
		return jiaoshixingming;
	}
	/**
	 * 设置：课程名称
	 */
	public void setKechengmingcheng(String kechengmingcheng) {
		this.kechengmingcheng = kechengmingcheng;
	}
	/**
	 * 获取：课程名称
	 */
	public String getKechengmingcheng() {
		return kechengmingcheng;
	}
	/**
	 * 设置：课程类型
	 */
	public void setKechengleixing(String kechengleixing) {
		this.kechengleixing = kechengleixing;
	}
	/**
	 * 获取：课程类型
	 */
	public String getKechengleixing() {
		return kechengleixing;
	}
	/**
	 * 设置：教学态度
	 */
	public void setJiaoxuetaidu(String jiaoxuetaidu) {
		this.jiaoxuetaidu = jiaoxuetaidu;
	}
	/**
	 * 获取：教学态度
	 */
	public String getJiaoxuetaidu() {
		return jiaoxuetaidu;
	}
	/**
	 * 设置：教学内容
	 */
	public void setJiaoxueneirong(String jiaoxueneirong) {
		this.jiaoxueneirong = jiaoxueneirong;
	}
	/**
	 * 获取：教学内容
	 */
	public String getJiaoxueneirong() {
		return jiaoxueneirong;
	}
	/**
	 * 设置：教学进度
	 */
	public void setJiaoxuejindu(String jiaoxuejindu) {
		this.jiaoxuejindu = jiaoxuejindu;
	}
	/**
	 * 获取：教学进度
	 */
	public String getJiaoxuejindu() {
		return jiaoxuejindu;
	}
	/**
	 * 设置：教学创新
	 */
	public void setJiaoxuechuangxin(String jiaoxuechuangxin) {
		this.jiaoxuechuangxin = jiaoxuechuangxin;
	}
	/**
	 * 获取：教学创新
	 */
	public String getJiaoxuechuangxin() {
		return jiaoxuechuangxin;
	}
	/**
	 * 设置：教学水平
	 */
	public void setJiaoxueshuiping(String jiaoxueshuiping) {
		this.jiaoxueshuiping = jiaoxueshuiping;
	}
	/**
	 * 获取：教学水平
	 */
	public String getJiaoxueshuiping() {
		return jiaoxueshuiping;
	}
	/**
	 * 设置：学号
	 */
	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}
	/**
	 * 获取：学号
	 */
	public String getXuehao() {
		return xuehao;
	}
	/**
	 * 设置：学生姓名
	 */
	public void setXueshengxingming(String xueshengxingming) {
		this.xueshengxingming = xueshengxingming;
	}
	/**
	 * 获取：学生姓名
	 */
	public String getXueshengxingming() {
		return xueshengxingming;
	}
	/**
	 * 设置：评估时间
	 */
	public void setPinggushijian(Date pinggushijian) {
		this.pinggushijian = pinggushijian;
	}
	/**
	 * 获取：评估时间
	 */
	public Date getPinggushijian() {
		return pinggushijian;
	}

}
