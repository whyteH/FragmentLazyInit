package whyte.com.fragmentlazyinit;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager mViewPager;
    private List<Fragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnClick1 = (Button) findViewById(R.id.btn_click1);
        Button btnClick2 = (Button) findViewById(R.id.btn_click2);
        Button btnClick3 = (Button) findViewById(R.id.btn_click3);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mFragments.add(CustomListFragment.newInstance(CustomListFragment.FIRST_FRAGMENT));
        mFragments.add(CustomListFragment.newInstance(CustomListFragment.SECOND_FRAGMENT));
        mFragments.add(CustomListFragment.newInstance(CustomListFragment.THIRD_FRAGMENT));
        btnClick1.setOnClickListener(this);
        btnClick2.setOnClickListener(this);
        btnClick3.setOnClickListener(this);
        mViewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), mFragments));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_click1:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.btn_click2:
                mViewPager.setCurrentItem(1);
                break;
            case R.id.btn_click3:
                mViewPager.setCurrentItem(2);
                break;
        }
    }

    class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        List<Fragment> mFragments;

        public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> mFragments) {
            super(fm);
            this.mFragments = mFragments;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }
}
