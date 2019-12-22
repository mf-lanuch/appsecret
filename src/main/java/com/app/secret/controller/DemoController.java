package com.app.secret.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	@ApiOperation("造数据")
	public AjaxResult<String> createData() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		SimpleDateFormat dateSdf = new SimpleDateFormat("yyyy-MM-dd");
		int []month = {10, 11};
		int []day = {31, 30};
		List<MfUserInfo> userInfos = mfUserInfoService.getMfUserInfoList(new MfUserInfo());
		for (MfUserInfo userInfo: userInfos) {
			for (int i = 0; i < month.length; i++) {
				for (int j = 1; j < day[i]; j ++) {
					Calendar c = Calendar.getInstance();
					String date = getDate(month[i], j);
					Date workDate = dateSdf.parse(date);
					c.setTime(workDate);
					int year = c.get(Calendar.YEAR);
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
					mfWork.setWorkYear(year);
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

	private String getDate(int month, int day) {
		String m = String.valueOf(month);
		String d = String.valueOf(day);
		if (month < 10) {
			m = "0" + m;
		}
		if (day < 10) {
			d = "0" + d;
		}
		return "2019-" + m + "-" + d;
	}
	
	public static void main(String []args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse("2019-10-01"));
		System.out.println(c.get(Calendar.DAY_OF_WEEK));
	}
}
