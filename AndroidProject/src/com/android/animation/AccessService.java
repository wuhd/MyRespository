package com.android.animation;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Toast;

public class AccessService extends AccessibilityService {

	@Override
	public void onAccessibilityEvent(AccessibilityEvent event) {
		Toast.makeText(this, event.toString(), Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onInterrupt() {

	}
	

}
