package com.example.verticaltexttest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class VerticalTextView extends View {
    private static final String TAG = "VerticalTextView";
    private static final boolean DBG = true;

    private Context mContext;
    private Paint mPaint = new Paint();
    private int mWidth;
    private int mHeight;
    private float mFontSize;
    private int mLayout;
    private int mColor;
    private String mText;

    private float startY;

    private StringBuilder sb = new StringBuilder();


    public VerticalTextView(Context context) {
        super(context);
        mContext = context;
//        initPaint();
    }

    public VerticalTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
//        initPaint();
    }

    public VerticalTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
//        initPaint();
    }

    public void initPaint() {
        mPaint.setTextSize(mFontSize);
        mPaint.setTextAlign(Paint.Align.LEFT);
//        mPaint.setColor(mColor);
        mPaint.setStrokeWidth(5);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);

        Paint.FontMetrics metrics = mPaint.getFontMetrics();
        float midToBaseline = (metrics.descent - metrics.ascent) / 2 - metrics.descent;
        float mid = mFontSize / 2;
        startY = mFontSize - mid + midToBaseline;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < mText.length(); i++) {
            String text = mText.substring(i, i + 1);
            float textWidth = mPaint.measureText(text);

            canvas.drawText(text, (mFontSize - textWidth) / 2, startY, mPaint);
            startY += mFontSize;
        }

        Log.d(TAG, sb.toString());

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(mWidth, mHeight);
    }

    public void setWidth(int width) {
        mWidth = width;
    }

    public void setHeight(int height) {
        mHeight = height;
    }

    public void setFontSize(float size) {
        mFontSize = size;
    }

    public void setText(String text) {
        mText = text;
    }
}
