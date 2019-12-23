package com.app.secret.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.app.secret.core.vo.Example;
import com.app.secret.entity.MfMagnification;
import com.app.secret.entity.MfMagnificationIt;
import com.app.secret.mapper.MfMagnificationItMapper;
import com.app.secret.mapper.MfMagnificationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.secret.core.vo.AjaxResult;
import com.app.secret.entity.MfUserInfo;
import com.app.secret.entity.MfWork;
import com.app.secret.services.MfUserInfoService;
import com.app.secret.services.MfWorkService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/*
 * Devil
 * 2019年12月22日
 */
@RestController
@RequestMapping(value = "/demo")
@Api(tags="数据")
public class DemoController {

	@Autowired
	private MfWorkService mfWorkService;
	
	@Autowired
	private MfUserInfoService mfUserInfoService;

	@Autowired
	private MfMagnificationMapper mfMagnificationMapper;

	@Autowired
	private MfMagnificationItMapper mfMagnificationItMapper;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	@ApiOperation("造数据")
	public AjaxResult<String> createData() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		SimpleDateFormat dateSdf = new SimpleDateFormat("yyyy-MM-dd");
		int []year = {2018, 2019};
		int []month = {10, 11, 12};
		int []day = {31, 30, 31};
		List<MfUserInfo> userInfos = mfUserInfoService.getMfUserInfoList(new MfUserInfo());
		for (MfUserInfo userInfo: userInfos) {
			for (int k = 0; k < year.length; k++) {
				for (int i = 0; i < month.length; i++) {
					MfWork deleteObj = new MfWork();
					deleteObj.setWorkMonth(month[i]);
					deleteObj.setWorkYear(year[k]);
					deleteObj.setUserId(userInfo.getId());
					mfWorkService.delete(deleteObj);
					for (int j = 1; j < day[i]; j ++) {
						Calendar c = Calendar.getInstance();
						String date = getDate(year[k], month[i], j);
						Date workDate = dateSdf.parse(date);
						c.setTime(workDate);
						int y = c.get(Calendar.YEAR);
						int m = month[i];
						int d = j;
						int w = c.get(Calendar.DAY_OF_WEEK);
						if (w == Calendar.SUNDAY) {
							w = 7;
						} else {
							w --;
						}
						if(w == 6 || w == 7) {
							double r = Math.random();
							if(r > 0.2) {
								continue ;
							}
						}
						MfWork mfWork = new MfWork();
						mfWork.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
						mfWork.setUserId(userInfo.getId());
						mfWork.setWorkDate(workDate);
						mfWork.setWeek(w);
						mfWork.setWorkYear(y);
						mfWork.setWorkMonth(m);
						mfWork.setStatus(1);
						mfWork.setStartTime(sdf.parse(getStartTime(w)));
						mfWork.setEndTime(sdf.parse(getEndTime(w)));
						if(mfWork.getStartTime().getTime() > mfWork.getEndTime().getTime()) {
							continue ;
						}
						mfWork.setInsertTime(new Date());
						mfWork.setUpdateTime(new Date());
						mfWorkService.insert(mfWork);
						System.out.println(date + "=>>" + userInfo.getPname());
					}
				}
			}
		}
		return new AjaxResult<String>(200, "SUCCESS");
	}

	@RequestMapping(value = "/initMfMagnification", method = RequestMethod.GET)
	@ApiOperation("初始化倍率")
	public AjaxResult<String> initMfMagnification() {
		// 非IT倍率
		MfMagnification magnification1 = new MfMagnification();
		magnification1.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
		magnification1.setInsertTime(new Date());
		// 工作日
		magnification1.setWorkDateType(1);
		// 倍率
		magnification1.setMagValue(1);
		mfMagnificationMapper.insertSelective(magnification1);

		MfMagnification magnification2 = new MfMagnification();
		magnification2.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
		magnification2.setInsertTime(new Date());
		// 周末
		magnification2.setWorkDateType(2);
		// 倍率
		magnification2.setMagValue(2);
		mfMagnificationMapper.insertSelective(magnification2);

		MfMagnification magnification3 = new MfMagnification();
		magnification3.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
		magnification3.setInsertTime(new Date());
		// 节假日
		magnification3.setWorkDateType(3);
		// 倍率
		magnification3.setMagValue(3);
		mfMagnificationMapper.insertSelective(magnification3);

		// IT倍率
		MfMagnificationIt mfMagnificationIt1 = new MfMagnificationIt();
		mfMagnificationIt1.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
		mfMagnificationIt1.setInsertTime(new Date());
		// 工作日
		mfMagnificationIt1.setWorkDateType(1);
		// 倍率
		mfMagnificationIt1.setMagValue(1);
		mfMagnificationItMapper.insertSelective(mfMagnificationIt1);

		MfMagnificationIt mfMagnificationIt2 = new MfMagnificationIt();
		mfMagnificationIt2.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
		mfMagnificationIt2.setInsertTime(new Date());
		// 周末
		mfMagnificationIt2.setWorkDateType(2);
		// 倍率
		mfMagnificationIt2.setMagValue(1);
		mfMagnificationItMapper.insertSelective(mfMagnificationIt2);

		MfMagnificationIt mfMagnificationIt3 = new MfMagnificationIt();
		mfMagnificationIt3.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
		mfMagnificationIt3.setInsertTime(new Date());
		// 节假日
		mfMagnificationIt3.setWorkDateType(3);
		// 倍率
		mfMagnificationIt3.setMagValue(1);
		mfMagnificationItMapper.insertSelective(mfMagnificationIt3);

		return new AjaxResult<String>(200, "SUCCESS");
	}

	private String getEndTime(int w) {
		int hour = 16;
		int minute = 30;
		int second = 0;
		double random = Math.random();
		if (w == 6 || w == 7) {
			hour = (int)Math.floor(Math.random() * 14 + 8);
			minute = (int) (Math.floor(Math.random() * 29) + 30);
			second = (int) (Math.floor(Math.random() * 59));
			return formatNumber(hour) + ":" + formatNumber(minute) + ":" + formatNumber(second); 
		}
		if(random < 0.4) {
			hour += 1;
		} else if (random < 0.7) {
			hour += 2;
		} else if(random < 0.9){
			hour += 3;
		} else {
			hour += (int)Math.floor(Math.random() * 4);
		}
		minute = (int) (Math.floor(Math.random() * 59));
		second = (int) (Math.floor(Math.random() * 59));
		return formatNumber(hour) + ":" + formatNumber(minute) + ":" + formatNumber(second);
	}

	private String getStartTime(int w) {
		int hour = 0;
		int minute = 0;
		int second = 0;
		double random = Math.random();
		if(random < 0.5) {
			hour = 7;
			if(w == 6 || w == 7) {
				hour = (int)(Math.floor(Math.random() * 3) + 8);
			}
			minute = (int) (Math.floor(Math.random() * 29) + 30);
			second = (int) (Math.floor(Math.random() * 59));
		} else {
			hour = 8;
			if(w == 6 || w == 7) {
				hour = (int)(Math.floor(Math.random() * 3) + 11);
			}
			minute = (int) (Math.floor(Math.random() * 15));
			second = (int) (Math.floor(Math.random() * 59));
		}
		return formatNumber(hour) + ":" + formatNumber(minute) + ":" + formatNumber(second);
	}
	
	

	private String formatNumber(int value) {
		if(value < 10) {
			return "0" + value;
		}
		return String.valueOf(value);
	}

	private String getDate(int year, int month, int day) {
		String m = String.valueOf(month);
		String d = String.valueOf(day);
		if (month < 10) {
			m = "0" + m;
		}
		if (day < 10) {
			d = "0" + d;
		}
		return year +"-" + m + "-" + d;
	}
	
	public static void main(String []args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse("2019-10-01"));
		System.out.println(c.get(Calendar.DAY_OF_WEEK));
	}
}
