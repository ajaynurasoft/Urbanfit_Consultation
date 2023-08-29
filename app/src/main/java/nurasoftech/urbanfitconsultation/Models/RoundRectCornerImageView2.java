package nurasoftech.urbanfitconsultation.Models;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

public class RoundRectCornerImageView2 extends AppCompatImageView {

    private float radius = 20.0f;
    private Path path;
    private RectF rect;

    public RoundRectCornerImageView2(Context context) {
        super(context);
        init();
    }

    public RoundRectCornerImageView2(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RoundRectCornerImageView2(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        path = new Path();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        rect = new RectF(this.getWidth(), this.getHeight(), 0, 0);
        path.addRoundRect(rect, radius, radius, Path.Direction.CW);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }
}