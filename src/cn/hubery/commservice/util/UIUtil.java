package cn.hubery.commservice.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * UI工具类
 * @author  24K
 * @created 2014年2月11日11:20:57
 */
public class UIUtil {

	public static <T> void startActivity(Context context, Class<T> c) {
		context.startActivity(new Intent(context, c));
//		((Activity) context).finish();
	}
	
	public static void toastShort(Context context, String msg) {
		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
	}
	
	public static void toastLong(Context context, String msg) {
		Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
	}
	
	
}
