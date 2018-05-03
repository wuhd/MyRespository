package com.wuhd.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;

public class RoundedRelativeLayout extends android.widget.RelativeLayout {

	int radiu = 5;
	public RoundedRelativeLayout(Context context) {
		super(context);
		init();
	}

	public RoundedRelativeLayout(Context context, AttributeSet attrs) {
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
