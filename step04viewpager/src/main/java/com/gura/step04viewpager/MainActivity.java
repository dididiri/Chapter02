package com.gura.step04viewpager;

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
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;
    //스나이퍼에서 한장씩 넘어가게해주는게 viewpager 화면하나하나는 fragment임
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // ViewPager 에 연결할 아답타 객체 생성하기
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // ViewPager 의 참조값 얻어와서
        mViewPager = (ViewPager) findViewById(R.id.container);
        // ViewPager 에 아답타 연결하기
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


    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        // Fragment 객체를 생성해서 리턴해주는 statioc 맴버 메소드
        //호출될때마다 새로운 PlaceholderFragment 객체가 리턴된다
        public static PlaceholderFragment newInstance(int sectionNumber) {
            //Fragment 객체 생성해서
            PlaceholderFragment fragment = new PlaceholderFragment();
            // 생성된 Fragment 에 전달할 데이터가 있다면 Bundle 객체를 생성해서
            Bundle args = new Bundle();// 버들(꾸러미) 객체에다 필요한객체를 담아서putInt 전달
            // Bundle 객체에 특정 키값으로 데이터를 담고
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            //생성된 Fragment 에 인자로 전달한다.
            fragment.setArguments(args);
            // 생성된 Fragment 객체를 리턴해준다.
            return fragment;
        }
        //fragemnt 활성될때 나타는 매소드
        //getArguments().getInt 위에 번들담긴객체를 읽어오는방법
        // View 객체를 리턴해주는 메소드 Fragment 의 UI 가 된다.
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // res/layout/fragment_main.xml 문서를 전개해서 View 객체를 만들고
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            // 만들어진 View 객체에서 TextView 의 참조값을 얻어온다.
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            // Fragment 에 전달된 인자를 얻어온다.
            Bundle args=getArguments();
            int sectionNumber=args.getInt(ARG_SECTION_NUMBER);
            // TextView 에 section 번호를 문자열로 출력하기
            //textView.setText(Integer.toString(sectionNumber));
            textView.setText("Section 번호:"+sectionNumber);
            /*textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));*/
            return rootView;
        }
    }

    // ViewPager 에 Fragment 를 공급할 아답타 클래스 설계
    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        //생성자
        public SectionsPagerAdapter(FragmentManager fm) {

            super(fm); //부모생성자에 필요한 값 전달
        }
        // ViewPager 에 Fragment 객체를 리턴해주는 메소드
        // viewpager 호출한다 필요한 시점에 위에 매소드가
        // 처음에 0 ,1 이 인자로 들어옴
        @Override
        public Fragment getItem(int position) {
            // position 인덱스에 해당하는 Fragment 객체를 리턴해주어야 한다.
            return PlaceholderFragment.newInstance(position + 1);
        }
        // 전체 Fragment 의 갯수를 리턴하는 메소드
        @Override
        public int getCount() {

            return 5;
        }
        // 프레그먼트의 제목을 리턴하는 메소드
        @Override
        public CharSequence getPageTitle(int position) {
            // 인자로 전달된 position 에 해당하는 Fragment 의 제목을
            // 리턴해 준다. (이걸 이용해서 탭을 만들수 있다)
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
                case 3:
                    return "SECTION 4";
                case 4:
                    return "SECTION 5";
            }
            return null;
        }
    }
}
