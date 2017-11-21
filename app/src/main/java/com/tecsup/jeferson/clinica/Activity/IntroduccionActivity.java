package com.tecsup.jeferson.clinica.Activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;

import com.github.paolorotolo.appintro.AppIntro2;
import com.tecsup.jeferson.clinica.R;

public class IntroduccionActivity extends AppIntro2 {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addSlide(SliderActivity.newInstance(R.layout.slider_1));
        addSlide(SliderActivity.newInstance(R.layout.slider_2));
        addSlide(SliderActivity.newInstance(R.layout.slider_3));
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        finish();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        Intent launcher=new Intent(this,LoginActivity.class);
        startActivity(launcher);
        finish();
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
    }
}
