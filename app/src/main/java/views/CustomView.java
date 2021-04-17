package views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.hitballgameroverimaxim.R;

public class CustomView extends View {

    private static final int SQUARE_SIZE_DEF = 100;
    private Rect createRett;
    private Paint paintRett;
    private int mSquareColor;
    private int mSquareSize;

    private Paint paintCircle;

    private float mCircleX, mCircleY;
    private float mCircleR = 100f;

    public CustomView(Context context) {
        super(context);
        init(null);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }



    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(@Nullable AttributeSet set){
        createRett = new Rect();
        paintRett = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintCircle = new Paint();
        paintCircle.setAntiAlias(true);

        paintCircle.setColor(Color.parseColor("#00CCFF"));

        if (set == null)
            return;

        TypedArray ta = getContext().obtainStyledAttributes(set, R.styleable.CustomView);

        mSquareColor = ta.getColor(R.styleable.CustomView_square_color, Color.GREEN);
        mSquareSize = ta.getDimensionPixelSize(R.styleable.CustomView_square_size, SQUARE_SIZE_DEF);
        paintRett.setColor(mSquareColor);

        ta.recycle();
    }

    public void swapColor(){
        paintRett.setColor(paintRett.getColor() == mSquareColor ? Color.RED : mSquareColor);
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        createRett.left = 100;
        createRett.right = 100;
        createRett.top = createRett.left + mSquareSize;
        createRett.bottom = createRett.right + mSquareSize;

        canvas.drawRect(createRett, paintRett);

        if (mCircleX == 0f || mCircleY == 0f){
            mCircleX = getWidth()/2;
            mCircleY = getHeight()/2;
        }

        canvas.drawCircle(mCircleX, mCircleY, mCircleR, paintCircle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean value = super.onTouchEvent(event);

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN: {

                float x = event.getX();
                float y = event.getY();

                if (createRett.left < x && createRett.right > x)
                    if (createRett.top < y && createRett.bottom > y){
                        mCircleR += 10;
                        postInvalidate();
                    }

                return true;
            }


            case MotionEvent.ACTION_MOVE: {

                float x = event.getX();
                float y = event.getY();

                double dx = Math.pow(x - mCircleX, 2);
                double dy = Math.pow(y - mCircleY, 2);

                if (dx + dy < Math.pow(mCircleR, 2)){
                    //Touched
                    mCircleX = x;
                    mCircleY = y;

                    postInvalidate();

                    return true;
                }

                return true;
            }
        }

        return value;
    }
}
