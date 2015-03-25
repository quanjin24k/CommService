package cn.hubery.commservice.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class PhoneCallUtil {

	public static void call(Context context, String phoneNum) {
		Intent intent = new Intent();
	    intent.setAction(Intent.ACTION_DIAL);//"android.intent.action.DIAL"
	    intent.setData(Uri.parse("tel:"+phoneNum));//"tel:400 616 0066"
	    context.startActivity(intent);  
	}
	
}
