package cn.hubery.commservice.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HTTP;

import android.util.Log;

public class HttpHandler {
	private static final String TAG = HttpHandler.class.getCanonicalName();

	public static String getResponceContent(String url,
			List<NameValuePair> params, boolean flag) {
		HttpPost httpPost = null;
//		if (null == url || "".equals(url)) {
//			url = UrlUtil.Login_temp_Url;
//		}
		if (flag) {
			httpPost = new HttpPost(url);
		} else {
			httpPost = HttpParameter.getHttpPost(url);
		}

		HttpParameter.setHttpEntity(httpPost, params);
		HttpClient client = HttpParameter.getClient();
		String content = "";
		try {
			HttpResponse response = client.execute(httpPost);
			content = HttpParameter.getResponceContent(response);
			if (response.getStatusLine().getStatusCode() == 200) {
				if (flag) { // 登录时获取cookie值，下面进行复用
					List<Cookie> cookies = ((AbstractHttpClient) client)
							.getCookieStore().getCookies();
					if (cookies.isEmpty()) {
						// return Constant.RESULT_CODE_FAIL;
						return "0";
					} else {
						for (int i = 0; i < cookies.size(); i++) {
							// 保存cookie
							Cookie cookie = cookies.get(i);
							if ("JSESSIONID".equals(cookie.getName())) {
								// 得到sessionId值
								ConstantUtil.JSESSIONID = cookie.getName() + "="
										+ cookie.getValue();
							}
						}
					}
				}
				Log.i(TAG, "HttpHandler:"+ConstantUtil.JSESSIONID);
				return content;
			} else {
				return "1";
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			return "";
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public static String getResponceContent(String url, boolean flag) {
		HttpPost httpPost = null;
		if (flag) {
			httpPost = new HttpPost(url);
		} else {
			httpPost = HttpParameter.getHttpPost(url);
		}

//		try {
//			httpPost.setEntity(new StringEntity(jsonObj, HTTP.UTF_8));
//		} catch (UnsupportedEncodingException e1) {
//			e1.printStackTrace();
//		}
		
		HttpClient client = HttpParameter.getClient();
		String content = "";
		try {
			HttpResponse response = client.execute(httpPost);
			content = HttpParameter.getResponceContent(response);
			if (response.getStatusLine().getStatusCode() == 200) {
				if (flag) { // 登录时获取cookie值，下面进行复用
					List<Cookie> cookies = ((AbstractHttpClient) client)
							.getCookieStore().getCookies();
					if (cookies.isEmpty()) {
						// return Constant.RESULT_CODE_FAIL;
						return "0";
					} else {
						for (int i = 0; i < cookies.size(); i++) {
							// 保存cookie
							Cookie cookie = cookies.get(i);
							if ("JSESSIONID".equals(cookie.getName())) {
								// 得到sessionId值
								ConstantUtil.JSESSIONID = cookie.getName() + "="
										+ cookie.getValue();
							}
						}
					}
				}
				Log.i(TAG, "HttpHandler:"+ConstantUtil.JSESSIONID);
				return content;
			} else {
				return "1";
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			return "";
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}
	
}
