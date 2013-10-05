package com.engsoc.p5client;

import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;

public class MainActivity extends FragmentActivity {

	ActionBar actionBar;
	TitlePagerAdapter mPagerAdapter;
	ViewPager mViewPager;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		//Setup ViewPager and create adapter
		mPagerAdapter = new TitlePagerAdapter(getSupportFragmentManager());
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mPagerAdapter);


		//Create Fragments
		//mPagerAdapter.addFragment(new DemoObjectFragment(), "Submit");
		//mPagerAdapter.addFragment(new DemoObjectFragment(), "View");


		//Setup the ActionBar
		actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// Create a tab listener that is called when the user changes tabs.
		ActionBar.TabListener tabListener = new ActionBar.TabListener() {
			@Override
			public void onTabReselected(Tab tab, FragmentTransaction ft) {
			}

			@Override
			public void onTabSelected(Tab tab, FragmentTransaction ft) {
				mViewPager.setCurrentItem(tab.getPosition());
			}

			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			}
		};

		//Add Tabs to ActionBar
		for(int i = 0; i < mPagerAdapter.getCount(); i++){
			actionBar.addTab(actionBar.newTab().setText(mPagerAdapter.getPageTitle(i)).setTabListener(tabListener));
		}

		//Switch tabs on swipe
		mViewPager.setOnPageChangeListener(
				new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						// When swiping between pages, select the corresponding tab.
						getActionBar().setSelectedNavigationItem(position);
					}
				});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}

/**
 * Adapter class to serve Fragments and Titles to the ViewPager and Tabs
 */
class TitlePagerAdapter extends FragmentStatePagerAdapter {

	List<Fragment> mFragmentList;
	List<String> mTitleList;

	public TitlePagerAdapter(FragmentManager fm) {
		super(fm);
		mFragmentList = new ArrayList<Fragment>();
		mTitleList = new ArrayList<String>();
	}

	public void addFragment(Fragment fragment, String title){
		mFragmentList.add(fragment);
		mTitleList.add(title);
		this.notifyDataSetChanged();
	}

	@Override
	public Fragment getItem(int position) {
		return mFragmentList.get(position);
	}

	@Override
	public int getCount() {
		return mFragmentList.size();
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return mTitleList.get(position);
	}
}
