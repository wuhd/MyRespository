package com.wuhd.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.AbsoluteLayout;

public class RoundedAbsLayout extends AbsoluteLayout{
	int radiu = 6;

	public RoundedAbsLayout(Context context) {
		super(context);
		init();
	}

	public RoundedAbsLayout(Context context, AttributeSet attrs) {
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
