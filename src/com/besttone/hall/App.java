package com.besttone.hall;

import android.app.Application;

import com.besttone.hall.share.ShareUtil;
import com.besttone.hall.share.ShareUtil.Config;

public class App extends Application {
	final String mWXAppId = "wx44b9892d4f4669ad";
	final String mWXAppSecret = "5bb696d9ccd75a38c8a0bfe0675559b3";
	
	final String mSinaWeiBoAppId = "3921700954";
	final String mSinaWeiBoSecret = "04b48b094faeb16683c32669824ebdad";
	
	final String mYXAppId = "yx5dd4691161a34bef935b41bab53ca2aa";
	
	final String mQQZoneAppId = "1105570351";
	final String mQQZoneAppSecret = "iG3LLh3ga3d8EvF8";
	
	@Override
	public void onCreate() {
		super.onCreate();
		ShareUtil.newConfig().winXin(mWXAppId, mWXAppSecret).yiXin(mYXAppId)
				.qq(mQQZoneAppId, mQQZoneAppSecret);
	}
}
