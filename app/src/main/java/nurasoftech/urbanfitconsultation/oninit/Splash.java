package nurasoftech.urbanfitconsultation.oninit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import nurasoftech.urbanfitconsultation.Models.SwiperImageModel;
import nurasoftech.urbanfitconsultation.R;
import nurasoftech.urbanfitconsultation.utils.CalendarUtils;
import nurasoftech.urbanfitconsultation.utils.ConstantsValue;
import nurasoftech.urbanfitconsultation.utils.Utility;

public class Splash extends AppCompatActivity {

    private ViewPager viewPager;
    private DotsIndicator dotsIndicator;
    final long DELAY_MS = 200, PERIOD_MS = 2000;
    int currentPage1 = 0;
    ArrayList<SwiperImageModel> swiperImagesModels = new ArrayList<>();
    SwiperImageAdapter swiperImageAdapter;
    Button get_started_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Objects.requireNonNull(getSupportActionBar()).hide();

        viewPager = findViewById(R.id.view_pager);
        dotsIndicator = findViewById(R.id.dots_indicator);
        get_started_button = findViewById(R.id.get_started_button);

        CalendarUtils.selectedDate = LocalDate.now();

        swiperImagesModels.add(new SwiperImageModel(R.drawable.splash));
        swiperImagesModels.add(new SwiperImageModel(R.drawable.mondey_image));
        swiperImagesModels.add(new SwiperImageModel(R.drawable.heart_ic));
        swiperImagesModels.add(new SwiperImageModel(R.drawable.demo_profile));

        final Runnable Update31 = new Runnable() {
            public void run() {
                if (currentPage1 == swiperImagesModels.size()) {
                    currentPage1 = 0;
                }
                viewPager.setCurrentItem(currentPage1++, true);
            }
        };
        Timer timer11 = new Timer();
        timer11.schedule(new TimerTask() {
            @Override
            public void run() {
                viewPager.post(Update31);
            }
        }, DELAY_MS, PERIOD_MS);

        swiperImageAdapter = new SwiperImageAdapter(Splash.this, swiperImagesModels);
        viewPager.setAdapter(swiperImageAdapter);
        dotsIndicator.setSelectedDotColor(R.color.orange);
        dotsIndicator.setViewPager(viewPager);

        get_started_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Splash.this, Login.class));
            }
        });

        try {
            PackageInfo info = null;
            try {
                info = getApplicationContext().getPackageManager().getPackageInfo(getApplicationContext().getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            assert info != null;
            ConstantsValue.versionNo = info.versionName;


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class SwiperImageAdapter extends PagerAdapter {
        private final ArrayList<SwiperImageModel> swiperImagesModelArrayList;
        LayoutInflater inflater;
        Context mContext;
        Activity sactivity;

        public SwiperImageAdapter(FragmentActivity activity, ArrayList<SwiperImageModel> swiperImagesModels) {
            mContext = activity;
            sactivity = activity;
            swiperImagesModelArrayList = swiperImagesModels;
            inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View viewItem = inflater.inflate(R.layout.screen_single_slider, container, false);
            ImageView imageView = viewItem.findViewById(R.id.image);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);

            int Url = swiperImagesModelArrayList.get(position).image;
            if (mContext != null) {
                Glide.with(mContext)
                        .load(Url)
                        .thumbnail(0.5f)
                        .into(imageView);
            }

            container.addView(viewItem);

            return viewItem;
        }

        @Override
        public int getCount() {
            return (null != swiperImagesModelArrayList ? swiperImagesModelArrayList.size() : 0);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((LinearLayout) object);
        }

    }

}