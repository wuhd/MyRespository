package com.wuhd.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;

public class RoundedRelativeLayout4FocusText extends android.widget.RelativeLayout implements android.view.View.OnFocusChangeListener {

	int radiu = 5;
	public RoundedRelativeLayout4FocusText(Context context) {
		super(context);
		init();
	}

	public RoundedRelativeLayout4FocusText(Context context, AttributeSet attrs) {
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

	@Override
	public void onFocusChange(android.view.View v, boolean hasFocus) {
		if(hasFocus){
			getChildAt(0).setVisibility(android.view.View.VISIBLE);
		}else{
			getChildAt(0).setVisibility(android.view.View.INVISIBLE);
		}
	}
}
