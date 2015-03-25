package cn.hubery.commservice;

import cn.hubery.commservice.adapter.TakeoutListAdapter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class TakeoutListActivity extends Activity {

	private ListView takeout_listview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.takeout_service_list);
		
		takeout_listview = (ListView) findViewById(R.id.takeout_listview);
		takeout_listview.setAdapter(new TakeoutListAdapter(this));
		takeout_listview.setOnItemClickListener(new TakeoutListClickListener());
		
		findViewById(R.id.btn_takeout_title_back).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				TakeoutListActivity.this.finish();
			}
		});
	}
	
	private class TakeoutListClickListener implements OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//			Toast.makeText(getApplicationContext(), "click list item num = "+position, Toast.LENGTH_SHORT).show();
			startActivity(new Intent(TakeoutListActivity.this, TakeoutDetailActivity.class));
		}
	}
	
}
