package com.wuhd.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;

public class RoundedFrameLayout extends android.widget.FrameLayout {
	public static final String TAG = RoundedFrameLayout.class.getName();
	
	int radiu = 5;
	
	public RoundedFrameLayout(Context context) {
		super(context);
		init();
	}

	public RoundedFrameLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}
	
	private void init() {
		if (Build.VERSION.SDK_INT < 18)
			setLayerType(LAYER_TYPE_SOFTWARE, null);
	}
	

	@Override
	protected void dispatchDraw(Canvas canvas) {
		Path clipPath = new Path();
	    clipPath.addRoundRect(new RectF(canvas.getClipBounds()), radiu, radiu, Path.Direction.CW);
	    canvas.clipPath(clipPath);
		super.dispatchDraw(canvas);
	}

}
