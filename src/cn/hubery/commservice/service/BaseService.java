package cn.hubery.commservice.service;

import com.google.gson.Gson;

/**
 * 网络连接的服务类的父类
 * @author  24K
 * @created 2014年2月26日18:18:44
 */
public abstract class BaseService {

	public static final String TAG = "BaseService";
	protected Gson gson = new Gson();
}
