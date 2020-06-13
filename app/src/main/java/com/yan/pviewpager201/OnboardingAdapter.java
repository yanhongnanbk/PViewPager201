package com.yan.pviewpager201;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OnboardingAdapter extends RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder> {

    private List<OnboardingItem> mOnboardingItemList;
    private Context mContext;

    public OnboardingAdapter(List<OnboardingItem> onboardingItemList, Context context) {
        mOnboardingItemList = onboardingItemList;
        mContext = context;
    }

    @NonNull
    @Override
    public OnboardingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_container_onboarding, parent, false);

        return new OnboardingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OnboardingViewHolder holder, int position) {
        holder.setOnBoardingData(mOnboardingItemList.get(position));
    }

    @Override
    public int getItemCount() {
        return mOnboardingItemList.size();
    }

    class OnboardingViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextViewTitle, mTextViewDescription;
        private ImageView mImageView;

        public OnboardingViewHolder(@NonNull View itemView) {
            super(itemView);

            mTextViewTitle = itemView.findViewById(R.id.text_title);
            mTextViewDescription = itemView.findViewById(R.id.text_description);
            mImageView = itemView.findViewById(R.id.image_onBoarding);

        }

        void setOnBoardingData(OnboardingItem onboardingItem) {
            mTextViewTitle.setText(onboardingItem.getTitle());
            mTextViewDescription.setText(onboardingItem.getDescription());
            mImageView.setImageResource(onboardingItem.getImage());
        }
    }
}
