package views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;

import androidx.annotation.Nullable;

import com.example.hitballgameroverimaxim.R;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class CustomView extends View {

    /////////////////////    RECTANGLE INITIALIZATION/////////////////////////////
    private static final int SQUARE_SIZE_DEF = 100;
    //private Rect createRett;
    //private Paint paintRett;
    //private int mSquareColor;
    //private int mSquareSize;

    /////////////////////    RANDOM NUMBER ///////////////////////////////////////
    final int min = 20;
    final int max = 2200;
    final int min2 = 20;
    final int max2 = 2200;
    private float ranPosX = new Random().nextInt((max - min) + 1) + min2;
    private float ranPosY = new Random().nextInt((max - min) + 2) + min2;
    private float ranPosX2 = new Random().nextInt((max2 - min2) + 21) + min;
    private float ranPosY2 = new Random().nextInt((max2 - min2) + 20) + min;

    /////////////////////    CIRCLE DEFINITION///////////////////////////////////
    private Paint paintCircle;
    private Paint paintCircle2;

    private final float mCircleR = 100f;

    /////////////////////    INITIALIZING A BITMAP OF THE IMAGE//////////////////
    private Bitmap mImage;

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
        //createRett = new Rect();
        //paintRett = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintCircle = new Paint();
        paintCircle.setAntiAlias(true);
        paintCircle.setColor(Color.parseColor("#00CCFF"));
        paintCircle2 = new Paint();
        paintCircle2.setAntiAlias(true);
        paintCircle2.setColor(Color.parseColor("#BB86FC"));


        //////////////////    BITMAP OF THE IMAGE/////////////////////////////////
        mImage = BitmapFactory.decodeResource(getResources(), R.drawable.image);

        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {

                getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int padding = 50;


        //////////////////    RESIZING THE IMAGE///////////////////////////////////
                mImage = getResizedBitmap(mImage, getWidth() - padding, getHeight() - padding);
                new Timer().scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        int newWidth = mImage.getWidth() -50;
                        int newHeight = mImage.getHeight() - 50;

                        if (newWidth <=0 || newHeight <=0){
                            cancel();
                            return;
                        }

                        mImage = getResizedBitmap(mImage, newWidth, newHeight);
                        postInvalidate();

                    }
                }, 1001, 41);
            }
        });

        if (set == null)
            return;

        TypedArray ta = getContext().obtainStyledAttributes(set, R.styleable.CustomView);

        //mSquareColor = ta.getColor(R.styleable.CustomView_square_color, Color.GREEN);
        //mSquareSize = ta.getDimensionPixelSize(R.styleable.CustomView_square_size, SQUARE_SIZE_DEF);
        //paintRett.setColor(mSquareColor);

        ta.recycle();
    }



    public void swapColor(){
        //paintRett.setColor(paintRett.getColor() == mSquareColor ? Color.RED : mSquareColor);
        //postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        /*createRett.left = 100;
        createRett.right = 100;
        createRett.top = createRett.left + mSquareSize;
        createRett.bottom = createRett.right + mSquareSize;

        canvas.drawRect(createRett, paintRett);*/

        /*if (mCircleX == 0f || mCircleY == 0f){
            mCircleX = getWidth()/2;
            mCircleY = getHeight()/4;
        }*/
        if (ranPosY2 < mCircleR){
            ranPosY2 = mCircleR;
            canvas.drawCircle(ranPosX2, ranPosY2, mCircleR, paintCircle);
            return;
        }else{
            canvas.drawCircle(ranPosX2, ranPosY2, mCircleR, paintCircle);
        }
        if (ranPosY2 > getHeight() - mCircleR){
            ranPosY2 = getHeight() - mCircleR;
            canvas.drawCircle(ranPosX2, ranPosY2, mCircleR, paintCircle);
            return;
        }else{
            canvas.drawCircle(ranPosX2, ranPosY2, mCircleR, paintCircle);
        }
        if (ranPosX2 < mCircleR){
            ranPosX2 = mCircleR;
            canvas.drawCircle(ranPosX2, ranPosY2, mCircleR, paintCircle);
            return;
        }else{
            canvas.drawCircle(ranPosX2, ranPosY2, mCircleR, paintCircle);
        }
        if (ranPosX2 > getWidth() - mCircleR){
            ranPosX2 = getWidth() - mCircleR;
            canvas.drawCircle(ranPosX2, ranPosY2, mCircleR, paintCircle);
            return;
        }else{
            canvas.drawCircle(ranPosX2, ranPosY2, mCircleR, paintCircle);
        }


        /*if (ranPosX == 0f || ranPosY == 0f){
            ranPosX = getWidth()/2;
            ranPosY = getHeight()/2;
        }*/

        if (ranPosY < mCircleR){
            ranPosY = mCircleR;
            canvas.drawCircle(ranPosX, ranPosY, mCircleR, paintCircle2);
            return;
        }else{
            canvas.drawCircle(ranPosX, ranPosY, mCircleR, paintCircle2);
        }
        if (ranPosY > getHeight() - mCircleR){
            ranPosY = getHeight() - mCircleR;
            canvas.drawCircle(ranPosX, ranPosY, mCircleR, paintCircle2);
            return;
        }else{
            canvas.drawCircle(ranPosX, ranPosY, mCircleR, paintCircle2);
        }
        if (ranPosX < mCircleR){
            ranPosX = mCircleR;
            canvas.drawCircle(ranPosX, ranPosY, mCircleR, paintCircle2);
            return;
        }else{
            canvas.drawCircle(ranPosX, ranPosY, mCircleR, paintCircle2);
        }
        if (ranPosX > getWidth() - mCircleR){
            ranPosX = getWidth() - mCircleR;
            canvas.drawCircle(ranPosX, ranPosY, mCircleR, paintCircle2);
            return;
        }else {
            canvas.drawCircle(ranPosX, ranPosY, mCircleR, paintCircle2);
        }

        float imageX = (getWidth() - mImage.getWidth()) /2;
        float imageY = (getHeight() - mImage.getHeight()) /2;

        canvas.drawBitmap(mImage, imageX, imageY, null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean value = super.onTouchEvent(event);

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN: {

                float x = event.getX();
                float y = event.getY();

                /*if (createRett.left < x && createRett.right > x)
                    if (createRett.top < y && createRett.bottom > y){
                        mCircleR += 10;
                        postInvalidate();
                    }*/

                return true;
            }

            case MotionEvent.ACTION_MOVE: {

                float x = event.getX();
                float y = event.getY();

                double dx = Math.pow(x - ranPosX2, 2);
                double dy = Math.pow(y - ranPosY2, 2);

                if (dx + dy < Math.pow(mCircleR, 2)){
                    //Touched
                    ranPosX2 = x;
                    ranPosY2 = y;
                    postInvalidate();
                    return true;
                }

                float x2 = event.getX();
                float y2 = event.getY();

                double dx2 = Math.pow(x2 - ranPosX, 2);
                double dy2 = Math.pow(y2 - ranPosY, 2);

                if (dx2 + dy2 < Math.pow(mCircleR, 2)){
                    //Touched
                    ranPosX = x2;
                    ranPosY = y2;
                    postInvalidate();
                    return true;
                }

                return true;
            }
        }

        return value;
    }

    private Bitmap getResizedBitmap(Bitmap bitmap, int reqWidth, int reqHeight){
        Matrix matrix = new Matrix();

        RectF src = new RectF(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF dest = new RectF(0, 0, reqWidth, reqHeight);
        matrix.setRectToRect(src, dest, Matrix.ScaleToFit.CENTER);

        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }
}
