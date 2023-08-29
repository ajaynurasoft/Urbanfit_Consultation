package nurasoftech.urbanfitconsultation.Home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Objects;

import nurasoftech.urbanfitconsultation.Models.CategoryModel;
import nurasoftech.urbanfitconsultation.Models.CoachInfo;
import nurasoftech.urbanfitconsultation.R;
import nurasoftech.urbanfitconsultation.ScheduleAppointment.counsellor_1;

public class MainHome extends AppCompatActivity {

    RecyclerView categoriesRV, coachRV;
    ArrayList<CategoryModel> categoryModel = new ArrayList<>();
    ArrayList<CoachInfo> coachInfoList = new ArrayList<>();
    CategoryAdapter categoryAdapter;
    CoachAdapter coachAdapter;
    LinearLayoutManager linearLayout;
    CardView card_view;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_home);

        Objects.requireNonNull(getSupportActionBar()).hide();

        categoriesRV = findViewById(R.id.categoriesRV);
        coachRV = findViewById(R.id.coachRV);
        card_view = findViewById(R.id.card_view);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        categoryModel.add(new CategoryModel(0, "All"));
        categoryModel.add(new CategoryModel(R.drawable.sales, getString(R.string.session)));
        categoryModel.add(new CategoryModel(R.drawable.sales, getString(R.string.session)));
        categoryModel.add(new CategoryModel(R.drawable.sales, getString(R.string.session)));
        categoryModel.add(new CategoryModel(R.drawable.sales, getString(R.string.session)));
        categoryModel.add(new CategoryModel(R.drawable.sales, getString(R.string.session)));

        categoryAdapter = new CategoryAdapter(MainHome.this, categoryModel);
        linearLayout = new LinearLayoutManager(MainHome.this, LinearLayoutManager.HORIZONTAL, false);
        categoriesRV.setLayoutManager(linearLayout);
        categoriesRV.setAdapter(categoryAdapter);

        coachInfoList.add(new CoachInfo(R.drawable.demo_profile, "Steve", "4.8", "Sales", "Management", "Sales", "1.00"));
        coachInfoList.add(new CoachInfo(R.drawable.demo_profile, "Steve", "4.8", "Sales", "Management", "Sales", "1.00"));
        coachInfoList.add(new CoachInfo(R.drawable.demo_profile, "Steve", "4.8", "Sales", "Management", "Sales", "1.00"));
        coachInfoList.add(new CoachInfo(R.drawable.demo_profile, "Steve", "4.8", "Sales", "Management", "Sales", "1.00"));
        coachInfoList.add(new CoachInfo(R.drawable.demo_profile, "Steve", "4.8", "Sales", "Management", "Sales", "1.00"));
        coachInfoList.add(new CoachInfo(R.drawable.demo_profile, "Steve", "4.8", "Sales", "Management", "Sales", "1.00"));
        coachInfoList.add(new CoachInfo(R.drawable.demo_profile, "Steve", "4.8", "Sales", "Management", "Sales", "1.00"));
        coachInfoList.add(new CoachInfo(R.drawable.demo_profile, "Steve", "4.8", "Sales", "Management", "Sales", "1.00"));
        coachInfoList.add(new CoachInfo(R.drawable.demo_profile, "Steve", "4.8", "Sales", "Management", "Sales", "1.00"));
        coachInfoList.add(new CoachInfo(R.drawable.demo_profile, "Steve", "4.8", "Sales", "Management", "Sales", "1.00"));

        coachAdapter = new CoachAdapter(MainHome.this, coachInfoList);
        linearLayout = new GridLayoutManager(MainHome.this, 2);
        coachRV.setLayoutManager(linearLayout);
        coachRV.setAdapter(coachAdapter);
    }

    public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

        private ArrayList<CategoryModel> categoryModels;
        private Context context;

        public CategoryAdapter(Context context, ArrayList<CategoryModel> categoryModels) {
            this.context = context;
            this.categoryModels = categoryModels;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.category_adapter, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            holder.profile_image.setImageResource(categoryModels.get(position).getImage());
            holder.bottom_text.setText(categoryModels.get(position).getCategoryName());

            if (categoryModel.get(position).getCategoryName().equals("All")){
                holder.ll_categorymain.setBackground(AppCompatResources.getDrawable(context,R.drawable.btn_rounded_corner_orange));
            }else{
                Log.e("TAG", "onBindViewHolder: " );
            }
        }

        @Override
        public int getItemCount() {
            return categoryModels.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            LinearLayout ll_categorymain;
            ImageView profile_image;
            TextView bottom_text;

            public ViewHolder(View itemView) {
                super(itemView);
                profile_image = itemView.findViewById(R.id.profile_image);
                bottom_text = itemView.findViewById(R.id.bottom_text);
                ll_categorymain = itemView.findViewById(R.id.ll_categorymain);
            }
        }
    }

    public class CoachAdapter extends RecyclerView.Adapter<CoachAdapter.ViewHolder> {

        private Context context;
        private ArrayList<CoachInfo> dataList;

        public CoachAdapter(Context context, ArrayList<CoachInfo> dataList) {
            this.context = context;
            this.dataList = dataList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.coach_adapter, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            holder.profile_image.setImageResource(dataList.get(position).getImage());
            holder.coachNameTV.setText(dataList.get(position).getName());
            holder.ratingTV.setText(dataList.get(position).getRating());
            holder.hashtag1TV.setText("#"+dataList.get(position).getHashtag1());
            holder.hashtag2TV.setText("#"+dataList.get(position).getHashtag2());
            holder.skillsTV.setText(dataList.get(position).getSkills());
            holder.priceTV.setText("$"+dataList.get(position).getPrice()+"/min");

            holder.ll_coachMain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(context, CoachDetails.class));
                }
            });

        }

        @Override
        public int getItemCount() {
            return dataList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            ImageView profile_image;
            TextView coachNameTV, ratingTV, hashtag1TV, hashtag2TV, skillsTV, priceTV;
            LinearLayout ll_coachMain;

            public ViewHolder(View itemView) {
                super(itemView);
                profile_image = itemView.findViewById(R.id.profile_image);
                coachNameTV = itemView.findViewById(R.id.coachNameTV);
                ratingTV = itemView.findViewById(R.id.ratingTV);
                hashtag1TV = itemView.findViewById(R.id.hashtag1TV);
                hashtag2TV = itemView.findViewById(R.id.hashtag2TV);
                skillsTV = itemView.findViewById(R.id.skillsTV);
                priceTV = itemView.findViewById(R.id.priceTV);
                ll_coachMain = itemView.findViewById(R.id.ll_coachMain);
            }
        }
    }
}