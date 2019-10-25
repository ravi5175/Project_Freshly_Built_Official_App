package com.freshly_built.ravi.feedpost.Java;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.freshly_built.ravi.feedpost.R;

public class MainActivity extends  FragmentActivity {

    TextView Home,Questions,Blog;
    ViewPager viewPager;
    PagerViewAdapter pagerViewAdapter;
    FragmentManager fm = getSupportFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Home=findViewById(R.id.home);
        Blog=findViewById(R.id.blog);
        Questions=findViewById(R.id.questions);
        viewPager=findViewById(R.id.fragment_pager);

        pagerViewAdapter  = new PagerViewAdapter(getSupportFragmentManager());

        viewPager.setAdapter(pagerViewAdapter);
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(0);
            }
        });

        Questions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(1);
            }
        });
        Blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(2);
            }
        });


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                onChangeTab(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }


                                              private void onChangeTab(int position)
                                              {
                                                  if (position== 0)
                                                  {
                                                      Questions.setTextSize(15);
                                                      Blog.setTextSize(15);
                                                      Home.setTextSize(20);

                                                  }
                                                  if (position== 1)
                                                  {
                                                      Home.setTextSize(15);
                                                      Blog.setTextSize(15);
                                                      Questions.setTextSize(20);

                                                  }
                                                  if (position== 2)
                                                  {
                                                      Questions.setTextSize(15);
                                                      Home.setTextSize(15);
                                                      Blog.setTextSize(20);

                                                  }
                                              }
        }





        );


    }
}
