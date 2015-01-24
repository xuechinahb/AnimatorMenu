package com.clover.menu.view;



import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class MenuImageView extends ImageView {

	
	private int imageResourceId;
	public MenuImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public MenuImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public MenuImageView(Context context) {
		super(context);
	}

	public void updateContent(){
		setImageResource(imageResourceId);
	}

	public int getImageResourceId() {
		return imageResourceId;
	}

	public void setImageResourceId(int imageResourceId) {
		this.imageResourceId = imageResourceId;
	}
	
	
}
