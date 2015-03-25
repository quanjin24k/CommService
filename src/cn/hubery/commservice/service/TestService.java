package cn.hubery.commservice.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.util.Log;

import cn.hubery.commservice.util.HttpHandler;
import cn.hubery.commservice.util.UrlUtils;

/**
 * 测试task 之后可删除。
 * @author  24K
 * @created 2014年2月28日12:17:41
 */
public class TestService extends BaseService {
	
	public void getTestResult(String collectId) {
		List<NameValuePair> valuePairs = new ArrayList<NameValuePair>();
		valuePairs.add(new BasicNameValuePair("id", collectId));
//		valuePairs.add(new BasicNameValuePair("taskStatus", "1"));
//		valuePairs.add(new BasicNameValuePair("pmpenyId", pmpenyId));

		 
		String response = HttpHandler.getResponceContent(UrlUtils.intoCollectViewURL, valuePairs, false);
//		String response = HttpHandler.getResponceContent(UrlUtils.intoRoomViewURL, valuePairs, false);
//		String response = HttpHandler.getResponceContent(UrlUtils.roomListURL , valuePairs, false);
//		String response = HttpHandler.getResponceContent(UrlUtils.floorListURL, valuePairs, false);
		Log.i(TAG, response);
	}
	
}
