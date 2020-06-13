package com.yan.pviewpager201;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private OnboardingAdapter mOnboardingAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupOnboardingItems();

        ViewPager2 onboardingViewPager = findViewById(R.id.onBoardingViewPager);
        onboardingViewPager.setAdapter(mOnboardingAdapter);
    }

    private void setupOnboardingItems(){
        List<OnboardingItem> onboardingItems = new ArrayList<>();
        OnboardingItem itemPayOnline = new OnboardingItem();

        itemPayOnline.setTitle("Pay your Bill online");
        itemPayOnline.setDescription("Electric bill payment is a feature of online, mobile, etc");
        itemPayOnline.setImage(R.drawable.aa);

        OnboardingItem itemOntheWay = new OnboardingItem() ;
        itemOntheWay.setTitle("your food is blah");
        itemOntheWay.setDescription("Our delivery rider.....");
        itemOntheWay.setImage(R.drawable.ab);

        OnboardingItem itemEatTogether = new OnboardingItem() ;
        itemEatTogether.setTitle("your food eat togetherh");
        itemEatTogether.setDescription("Our meal togetherr.....");
        itemEatTogether.setImage(R.drawable.ac);


        onboardingItems.add(itemPayOnline);
        onboardingItems.add(itemOntheWay);
        onboardingItems.add(itemEatTogether);

        mOnboardingAdapter = new OnboardingAdapter(onboardingItems,this) ;

    }
}
