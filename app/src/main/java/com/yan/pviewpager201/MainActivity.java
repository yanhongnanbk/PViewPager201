package com.yan.pviewpager201;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private OnboardingAdapter mOnboardingAdapter;
    private LinearLayout mLinearLayoutOnboardingIndicator;
    private MaterialButton mButtonOnboardingAction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLinearLayoutOnboardingIndicator = findViewById(R.id.layoutOnboardingViewPager);
        mButtonOnboardingAction = findViewById(R.id.buttonOnboardingAction);


        setupOnboardingItems();

        final ViewPager2 onboardingViewPager = findViewById(R.id.onBoardingViewPager);
        onboardingViewPager.setAdapter(mOnboardingAdapter);


        setupOnboardingIndicator();
        setCurrentOnboardingIndicator(0);
        onboardingViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnboardingIndicator(position);
            }
        });

        mButtonOnboardingAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onboardingViewPager.getCurrentItem()+1<mOnboardingAdapter.getItemCount()){
                    onboardingViewPager.setCurrentItem(onboardingViewPager.getCurrentItem()+1);
                }else{
                    startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                    finish();
                }
            }
        });
    }

    private void setupOnboardingItems() {
        List<OnboardingItem> onboardingItems = new ArrayList<>();
        OnboardingItem itemPayOnline = new OnboardingItem();

        itemPayOnline.setTitle("Pay your Bill online");
        itemPayOnline.setDescription("Electric bill payment is a feature of online, mobile, etc");
        itemPayOnline.setImage(R.drawable.aa);

        OnboardingItem itemOntheWay = new OnboardingItem();
        itemOntheWay.setTitle("your food is blah");
        itemOntheWay.setDescription("Our delivery rider.....");
        itemOntheWay.setImage(R.drawable.ab);

        OnboardingItem itemEatTogether = new OnboardingItem();
        itemEatTogether.setTitle("your food eat togetherh");
        itemEatTogether.setDescription("Our meal togetherr.....");
        itemEatTogether.setImage(R.drawable.ac);


        onboardingItems.add(itemPayOnline);
        onboardingItems.add(itemOntheWay);
        onboardingItems.add(itemEatTogether);

        mOnboardingAdapter = new OnboardingAdapter(onboardingItems, this);

    }

    private void setupOnboardingIndicator() {
        ImageView[] indicators = new ImageView[mOnboardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        layoutParams.setMargins(8, 8, 8, 0);
        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(), R.drawable.onboarding_indicator_inactive

            ));
            indicators[i].setLayoutParams(layoutParams);
            mLinearLayoutOnboardingIndicator.addView(indicators[i]);

        }


    }

    private void setCurrentOnboardingIndicator(int index){
        int childCount = mLinearLayoutOnboardingIndicator.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView)mLinearLayoutOnboardingIndicator.getChildAt(i);
            if (i==index){
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(),R.drawable.onboarding_indicator_active)
                );

            }else{
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(),R.drawable.onboarding_indicator_inactive)
                );
            }
        }

        if (index == mOnboardingAdapter.getItemCount()-1){
            mButtonOnboardingAction.setText("Start");
        }else{
            mButtonOnboardingAction.setText("Next");
        }
    }
}
