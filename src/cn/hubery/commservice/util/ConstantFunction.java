package cn.hubery.commservice.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Decoder.BASE64Encoder;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.NetworkInfo.State;
import android.provider.MediaStore;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

/**
 *  工具类
 * @author XJ 2014-2-13
 *
 */
public class ConstantFunction {

	private ConstantFunction(){
		
	}
	private static ConstantFunction instance ;
	public synchronized static ConstantFunction getInstance() {
		if (instance  == null) {
			instance = new ConstantFunction();
		}
		return instance;
	}
	
	/**
	 * Toast 
	 * @param ct
	 * @param content to show
	 */
	public void toast(Context ct, Object content) {
		Toast.makeText(ct, content.toString(), Toast.LENGTH_SHORT).show();
	}
	
	/**
	 * Log 
	 * @param msg
	 */
	public void showLog(String msg) {
		Log.e("-----property log------", msg);
	}
	
	/**
	 * 获取屏幕高度
	 * @param ct
	 * @return
	 */
	public  int getScreenHeight(Context ct) {
		WindowManager manager=(WindowManager) ct.getSystemService(Context.WINDOW_SERVICE);
		return manager.getDefaultDisplay().getHeight();
	}
	
	/**
	 * 获取屏幕宽度
	 * @param ct
	 * @return
	 */
	public  int getScreenWidth(Context ct) {
		WindowManager manager=(WindowManager) ct.getSystemService(Context.WINDOW_SERVICE);
		return manager.getDefaultDisplay().getWidth();
	}
	
	/**
	 * 判断是否为空
	 * @param ct
	 * @param v
	 * @return
	 */
	 public boolean isEmpty(Context ct ,EditText... v) {
		 for (EditText editText : v) {
			 if (TextUtils.isEmpty(editText.getText())) {
				 toast(ct, "请完善信息");
				 editText.requestFocus();
				 return true;
			 }
		}
		 return false;
	}
	
	 /**
	  * 获取输入框内容
	  * @param ct
	  * @param edt
	  * @return
	  */
	 public static String getText(EditText edt){
		 if (TextUtils.isEmpty(edt.getText())) {
			 return "";
		 }
		 return edt.getText().toString().trim();
	 }

	/**
	 * 判断二维码格式
	 * @param format 正则式
	 * @param content 内容
	 * @return
	 */
	
	public   boolean match(String format,String content) {
		if (TextUtils.isEmpty(format)) {
			format = "^\\d{3}-\\d{4}-\\d{3}$";//123-1234-123
		}
		try {
			Pattern pattern = Pattern.compile(format);
			Matcher match = pattern.matcher(content);               
			return match.matches();
		} catch (Exception e) {
			return true;
		}
	}
		
	
	private static long lastClickTime;
	/**
	 * 判断按钮两次点击时间间隔是否大于2s 
	 */
	public   boolean isFastDoubleClick() {
		long time = System.currentTimeMillis();   
		if ( time - lastClickTime > 2000) {   
			return true;   
		}   
		lastClickTime = time;   
		return false;   
	}
	/**
	 * 网络是否连接
	 * @param ct
	 * @return
	 */
	public   boolean isNetworkConect(Context ct) {
		if (ct == null) {
			return false;
		}
		ConnectivityManager cwjManager=(ConnectivityManager)ct.getSystemService(Context.CONNECTIVITY_SERVICE);     
		NetworkInfo info = cwjManager.getActiveNetworkInfo();    
		if (info != null ){   
			return info.isAvailable();
		}else {
			Toast.makeText(ct,"请检查网络状态。" ,Toast.LENGTH_SHORT).show();
			return false;
		} 
	}
	
	/**
	 * 判断与服务器是否保持连接
	 * @param ct
	 * @return
	 */
//	public   boolean isServerConnet(Context ct) {
//		if (isNetworkConect(ct)) {
//			if (Constant.JSESSIONID != null) {
//				Log.i(ct.getPackageName(), "与服务器连接正常");
//				return true;
//			}else {
//				Log.i(ct.getPackageName(), "与服务器连接断开");
//				Toast.makeText(ct,"与服务器断开连接，请重新登录" ,Toast.LENGTH_SHORT).show();
//				Intent intent = new Intent(ct, PhReportLogin.class);
//				((Activity)ct).startActivity(intent);
//				MyAppManager.getInstance().exit();
//				return false;
//			} 
//		}else {
//			return false;
//		}
//	}
	
	
//	public   void isServerConnet(Context ct, String content) {
//		Log.i("", "刚进入超时检测方法");
//		if (isNetworkConect(ct)) {
//			Log.i("", "============刚进入超时检测方法, 正在捕捉超时==============");	
//			if(content != null && content.substring(0, 9).equals("<!DOCTYPE")) {
//				Toast.makeText(ct,"对不起，您没有登录或者您登录的session已超时，请进入登录页登录!" ,Toast.LENGTH_SHORT).show();
//				Intent intent = new Intent(ct, PhReportLogin.class);
//				((Activity)ct).startActivity(intent);
//				MyAppManager.getInstance().exit();
//			}
//		}
//	}
	
	/**
	 * 检测网络超时并跳转至登录界面。
	 * @param context 当前环境
	 * @param content 返回内容
	 * <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	 */
//	public   boolean handleTimeOutMethod(Context context, String result) {
//		Log.i("handleTimeOutMethod", "超时检测方法----起始点");
//		if(!TextUtils.isEmpty(result) && !"null".equals(result) ) {
//			if(result.length() >= 9 && result.substring(0, 9).equals("<!DOCTYPE")) {
//				Log.i("", "===========进入超时检测方法, 已捕捉到超时========");
//				Log.i("超时提醒 ", "对不起，您没有登录或者您登录的session已超时，请进入登录页登录! ");
//				context.startActivity(new Intent(context, PhReportLogin.class));
//				Log.i("", "===========已捕捉到超时,并实现跳转========");
//				return false;
//			}
//		}
//		return true;
//	}
	
	/**
	 * 根据宽度从本地图片路径获取该图片的缩略图
	 * 
	 * @param localImagePath
	 *            本地图片的路径
	 * @param width
	 *            缩略图的宽
	 * @param addedScaling
	 *            额外可以加的缩放比例
	 * @return bitmap 指定宽高的缩略图
	 */
	public  Bitmap getBitmapByWidth(String localImagePath, int width,
			int addedScaling) {
		if (TextUtils.isEmpty(localImagePath)) {
			return null;
		}
		Bitmap temBitmap = null;

		try {
			BitmapFactory.Options outOptions = new BitmapFactory.Options();
			// 设置该属性为true，不加载图片到内存，只返回图片的宽高到options中。
			outOptions.inJustDecodeBounds = true;
			// 加载获取图片的宽高
			BitmapFactory.decodeFile(localImagePath, outOptions);
//			int height = outOptions.outHeight;
//			System.out.println("1:w = "+ outOptions.outWidth +",h = "+outOptions.outHeight);
			if (outOptions.outWidth > width) {
				// 根据宽设置缩放比例
				outOptions.inSampleSize = outOptions.outWidth / width + 1
						+ addedScaling;
				outOptions.outWidth = width;
				// 计算缩放后的高度
//				height = outOptions.outHeight / outOptions.inSampleSize;
				outOptions.outHeight = width;
				// outOptions.outHeight = 80;

			} else if (outOptions.outHeight > width) {
				// 根据宽设置缩放比例
				outOptions.inSampleSize = outOptions.outHeight / width + 1
						+ addedScaling;
				outOptions.outHeight = width;
				// 计算缩放后的高度
//				height = outOptions.outWidth / outOptions.inSampleSize;
				outOptions.outWidth = width;

			}
			// 重新设置该属性为false，加载图片返回
			outOptions.inJustDecodeBounds = false;
			outOptions.inPurgeable = true;
			outOptions.inInputShareable = true;
//			System.out.println("2:w = "+ outOptions.outWidth +",h = "+outOptions.outHeight);

			temBitmap = BitmapFactory.decodeFile(localImagePath, outOptions);
		} catch (Throwable t) {
			t.printStackTrace();
		}

		return temBitmap;
	}
	
	/**
	 *  将图片文件转化为字节数组字符串，并对其进行Base64编码处理
	 * @param imgFile 图片路径
	 * @return
	 */
	public  String GetImageStr(Context ct,String imgFile) {
		byte[] data = null;
		Bitmap bitmap = getBitmapByWidth(imgFile, getScreenWidth(ct), 0);
		// 读取图片字节数组
		ByteArrayOutputStream out = new ByteArrayOutputStream();  
		bitmap.compress(Bitmap.CompressFormat.JPEG, 20, out);  
		try {  
			out.flush();  
			out.close();  
		} catch (IOException e) {  
			e.printStackTrace();  
		}  
		data = out.toByteArray();
		// 对字节数组Base64编码
		
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);
	}
	
	 
	
	/**
	 * 网络连接类型
	 */
	public void  IntenertType(Context ct) {
        ConnectivityManager cManager = (ConnectivityManager) ct
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cManager.getActiveNetworkInfo();
        if(null != networkInfo) {
        	switch (networkInfo.getType()) {
			case ConnectivityManager.TYPE_WIFI: //wifi
//				netTypeText.setText("WIFI网络");
				break;
			case ConnectivityManager.TYPE_MOBILE://手机网络
//	        	* NETWORK_TYPE_CDMA 网络类型为CDMA
//	        	* NETWORK_TYPE_EDGE 网络类型为EDGE
//	        	* NETWORK_TYPE_EVDO_0 网络类型为EVDO0
//	        	* NETWORK_TYPE_EVDO_A 网络类型为EVDOA
//	        	* NETWORK_TYPE_GPRS 网络类型为GPRS
//	        	* NETWORK_TYPE_HSDPA 网络类型为HSDPA
//	        	* NETWORK_TYPE_HSPA 网络类型为HSPA
//	        	* NETWORK_TYPE_HSUPA 网络类型为HSUPA
//	        	* NETWORK_TYPE_UMTS 网络类型为UMTS
//	        	联通的3G为UMTS或HSDPA，移动和联通的2G为GPRS或EDGE，电信的2G为CDMA，电信的3G为EVDO
				switch (networkInfo.getSubtype()) {
				case TelephonyManager.NETWORK_TYPE_CDMA:
//					netTypeText.setText("电信2G网络");
					break;
				case TelephonyManager.NETWORK_TYPE_UMTS:
				case TelephonyManager.NETWORK_TYPE_HSDPA:
//					netTypeText.setText("联通3G网络");
					break;
				case TelephonyManager.NETWORK_TYPE_GPRS:	
				case TelephonyManager.NETWORK_TYPE_EDGE:
//					netTypeText.setText("移动或联通2G网络");
					break;
				default:
//					netTypeText.setText("其他网络");
					break;
				}
				break;
			default:
				break;
			}
        }
	}
}
