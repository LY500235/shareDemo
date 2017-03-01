package com.besttone.hall;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import com.besttone.hall.core.activity.BaseActivity;
import com.besttone.hall.share.OnShareListener;
import com.besttone.hall.share.ShareUtil;
import com.umeng.socialize.bean.SHARE_MEDIA;

public class MainActivity extends BaseActivity implements OnShareListener,
		OnClickListener {
	
	@Override
	protected int getMainViewResId() {
		return R.layout.activity_main;
	}
	
	@Override
	protected void initView() {
		super.initView();
		findViewById(R.id.tv_share1).setOnClickListener(this);
		findViewById(R.id.tv_share2).setOnClickListener(this);
	}
	
	@Override
	public void onResult(SHARE_MEDIA platform) {
		Log.d("plat", "platform" + platform);
		if (platform.name().equals(SHARE_MEDIA.QQ)) {
			showToast(platform + " QQ分享");
		} else {
			showToast(platform + " 分享成功啦");
		}
	}
	
	@Override
	public void onError(SHARE_MEDIA platform, Throwable t) {
		showToast(platform + " 分享失败啦");
		if (t != null) {
			Log.d("throw", "throw:" + t.getMessage());
		}
	}
	
	@Override
	public void onCancel(SHARE_MEDIA platform) {
		showToast(platform + " 分享取消了");
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		ShareUtil.onActivityResult(this, requestCode, resultCode, data);
	}
	
	@Override
	public void onClick(View v) {
		String title = "号码百事通";
		String content = "骚年!快来下载号码百事通,好礼多多,优惠多多,还完全免费哟!还不赶快加入!!";
//		String imagUrl = "http://dianhua.118114.cn/icon/omc/1450609039593.png";
		String imagUrl = "http://hb.118114.net:8443/118114ng/images/114number_activity/test.jpg";
		String targetUrl = "http://dianhua.118114.cn/apk";
		switch (v.getId()) {
		case R.id.tv_share1:
			ShareUtil.onShareImage(this, title, content, imagUrl, targetUrl);
			break;
		case R.id.tv_share2:
			ShareUtil.onShare(this, title, content, targetUrl);
			break;
		default:
			break;
		
		}
	}
}
