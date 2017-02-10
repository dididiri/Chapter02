package com.gura.step04example;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        //국가에 대한 정보를 담고 있는 모델
        public static List<CountryDto> countries;

        // static 초기화 (생성자를 호출이안되서 초기화함 new 인스터스를 할때마다 밑에껄 복수할수없어서~)
        static {
            countries=new ArrayList<>();
            CountryDto dto1=new CountryDto
                    (R.drawable.austria,"오스트리아", "어쩌구.. 저쩌구...");
            CountryDto dto2=new CountryDto
                    (R.drawable.belgium,"벨기에", "어쩌구.. 저쩌구...");
            CountryDto dto3=new CountryDto
                    (R.drawable.brazil,"브라질", "어쩌구.. 저쩌구...");
            CountryDto dto4=new CountryDto
                    (R.drawable.france,"프랑스", "어쩌구.. 저쩌구...");
            CountryDto dto5=new CountryDto
                    (R.drawable.germany,"독일", "어쩌구.. 저쩌구...");
            CountryDto dto6=new CountryDto
                    (R.drawable.greece,"그리스", "어쩌구.. 저쩌구...");
            CountryDto dto7=new CountryDto
                    (R.drawable.israel,"이스라엘", "어쩌구.. 저쩌구...");
            CountryDto dto8=new CountryDto
                    (R.drawable.italy,"이탈리아", "어쩌구.. 저쩌구...");
            CountryDto dto9=new CountryDto
                    (R.drawable.japan,"일본", "어쩌구.. 저쩌구...");
            CountryDto dto10=new CountryDto
                    (R.drawable.korea,"대한민국", "어쩌구.. 저쩌구...");
            CountryDto dto11=new CountryDto
                    (R.drawable.poland,"폴란드", "어쩌구.. 저쩌구...");
            CountryDto dto12=new CountryDto
                    (R.drawable.spain,"스페인", "어쩌구... 저쩌구...");
            CountryDto dto13=new CountryDto
                    (R.drawable.usa,"미국", "어쩌구.. 저쩌구...");
            countries.add(dto1);
            countries.add(dto2);
            countries.add(dto3);
            countries.add(dto4);
            countries.add(dto5);
            countries.add(dto6);
            countries.add(dto7);
            countries.add(dto8);
            countries.add(dto9);
            countries.add(dto10);
            countries.add(dto11);
            countries.add(dto12);
            countries.add(dto13);
        }



        public PlaceholderFragment() {
        }


        public static PlaceholderFragment newInstance(int index) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            //Bundle 객체 생성
            Bundle bundle=new Bundle();
            // "dto" 라는 키값으로 ContryDto 객체를 담는다.
            bundle.putSerializable("dto", countries.get(index));
            // Fragment 에 Bundle 객체를 전달한다.
            fragment.setArguments(bundle);
            // Bundle 객체가 전달된 Fragment 객체를 리턴해준다.
            return fragment;
        }
        // Fragment 가 활성화 되기 직전에 호출되는 메소드
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            // res/layout/fragment_main.xml 문서에 정의된 View 의 참조값
            ImageView imageView=(ImageView)
                    rootView.findViewById(R.id.imageView);
            TextView textName=(TextView)
                    rootView.findViewById(R.id.textName);
            TextView textDatail=(TextView)
                    rootView.findViewById(R.id.textDetail);
            // 전달된 Bundle 객체의 참조값 얻어오기
            Bundle bundle=getArguments();
            // Bundle 객체에 "dto" 라는 키값으로 저장된 CountryDto 객체
            CountryDto dto=(CountryDto)bundle.getSerializable("dto");
            // dto 객체에 담긴 내용을 각각의 View 에 출력하기
            imageView.setImageResource(dto.getImageResId());
            textName.setText(dto.getName());
            textDatail.setText(dto.getDetail());
            // View 객체 리턴해주기
            return rootView;
        }
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            return PlaceholderFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            //list 의 size 를 리턴해준다.(모델에 총갯수)
            return PlaceholderFragment.countries.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }
}
