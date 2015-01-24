package com.clover.menu.view;




import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.ImageView;

public class CenterImageView extends ImageView {

	private Bitmap mL2RBitmap;
	private Bitmap mR2LBitmap;
	private float xCoordinate;
	private boolean updateFlag;
	
	/**
	 * draw bitmap from left to right
	 */
	private boolean l2rFlag;
	
	private boolean mClearFlag;
	public CenterImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public CenterImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public CenterImageView(Context context) {
		super(context);
	}
	
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if (isClearFlag()) {
			canvas.drawColor(Color.TRANSPARENT);
			setClearFlag(false);
			
			if (null != mL2RBitmap && !mL2RBitmap.isRecycled()) {
				mL2RBitmap.recycle();
			}
			if (null != mR2LBitmap && !mR2LBitmap.isRecycled()) {
				mR2LBitmap.recycle();
			}
			return;
		}
		try {
			if (updateFlag) {
				System.out.println("xCoordinate---= " + xCoordinate);
				if(l2rFlag){
					if (Float.compare(xCoordinate, 0) > 0) {
						xCoordinate = 0;
					}
					if (null == mL2RBitmap) {
						return;
					}
					canvas.drawBitmap(mL2RBitmap, getXCoordinate() + getPaddingLeft(), getPaddingTop(), null);
					
				}else{
					if (Float.compare(xCoordinate, 0) < 0) {
						xCoordinate = 0;
					}
					if (null == mR2LBitmap) {
						return;
					}
					canvas.drawBitmap(mR2LBitmap, getXCoordinate() + getPaddingLeft(), getPaddingTop(), null);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void update(float arg, boolean l2rFlagArg){
		
		xCoordinate = arg;
		updateFlag = true;
		l2rFlag = l2rFlagArg;
		invalidate();
	}

	
	public void update(float arg){
		
		xCoordinate = arg;
		updateFlag = true;
		invalidate();
	}

	public float getXCoordinate() {
		return xCoordinate;
	}
	
	public void clearBitmap(){
		setClearFlag(true);
		invalidate();
	}
	
	
	public void setL2RBitmap(int resId){
		mL2RBitmap = BitmapFactory.decodeResource(getResources(), resId);
	}

	public void setR2LBitmap(int resId){
		mR2LBitmap = BitmapFactory.decodeResource(getResources(), resId);
	}
	public boolean isClearFlag() {
		return mClearFlag;
	}

	public void setClearFlag(boolean mClearFlag) {
		this.mClearFlag = mClearFlag;
	}
	
}
