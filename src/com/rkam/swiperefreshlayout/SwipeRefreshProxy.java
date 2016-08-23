package com.rkam.swiperefreshlayout;

import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.view.TiUIView;

import android.app.Activity;

@Kroll.proxy(creatableInModule=SwiperefreshlayoutModule.class)
public class SwipeRefreshProxy extends TiViewProxy {

	private SwipeRefresh swipeRefresh;
	
	public SwipeRefreshProxy() {
		super();
		this.swipeRefresh = new SwipeRefresh(this);
	}

	@Override
	public TiUIView createView(Activity activity) {
		return this.swipeRefresh;
	}
	
	@Kroll.method
	public void setRefreshing(boolean refreshing) {
		if (this.swipeRefresh != null){
			
			if (refreshing)
				this.swipeRefresh.startRefreshing();
			else
				this.swipeRefresh.endRefreshing();			
		}		
	}
	
	@Kroll.method
	public void add(TiViewProxy view) {
		this.swipeRefresh.add(view);
		return;
	}
	
	@Kroll.method @Kroll.getProperty
	public boolean isRefreshing() {
		if (this.swipeRefresh != null){
			return this.swipeRefresh.isRefreshing();
		}
		return false;
	}
}
