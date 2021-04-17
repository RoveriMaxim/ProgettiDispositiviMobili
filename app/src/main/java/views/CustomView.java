package views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class CustomView extends View {

    private static final int SQUARE_SIZE = 100;

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


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(@Nullable AttributeSet set){
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Rect rect = new Rect();
        rect.left=100;
        rect.right = 100;
        rect.top = rect.left + SQUARE_SIZE;
        rect.bottom = rect.right + SQUARE_SIZE;

        rect.height();
        rect.width();

        Paint paint = new Paint();
        paint.setColor(Color.RED);

        canvas.drawRect(rect, paint);
    }
}
