package com.sunzn.menu.swipe.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;

import com.sunzn.menu.swipe.library.OnActivityTouchListener;
import com.sunzn.menu.swipe.library.RecyclerTouchListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerTouchListener.RecyclerTouchListenerHelper {

    private RecyclerView mRecyclerView;
    private RecyclerTouchListener mTouchListener;
    private OnActivityTouchListener mActivityTouchListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        initView();
        initData();
        bindView();
    }

    private void bindView() {

    }

    private void initData() {

    }

    private void initView() {
        mRecyclerView = findViewById(R.id.rv);
        mRecyclerView.setAdapter(new MainAdapter(getData()));
        mRecyclerView.addItemDecoration(new LineDecoration(10));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mTouchListener = new RecyclerTouchListener(this, mRecyclerView);
        mTouchListener.setIndependentViews(R.id.rowButton).setViewsToFade(R.id.rowButton)
                .setClickable(new RecyclerTouchListener.OnRowClickListener() {
                    @Override
                    public void onRowClicked(int position) {

                    }

                    @Override
                    public void onIndependentViewClicked(int independentViewID, int position) {

                    }
                })
                .setLongClickable(false)
                .setSwipeOptionViews(R.id.edit, R.id.del)
                .setSwipeAble(R.id.foreground_holder, R.id.background_holder, new RecyclerTouchListener.OnSwipeOptionsClickListener() {
                    @Override
                    public void onSwipeOptionClicked(int viewID, int position) {
                        switch (viewID) {
                            case R.id.edit:
                                break;
                            case R.id.del:
                                break;
                        }
                    }
                });
    }

    private ArrayList<ModelBean> getData() {
        ArrayList<ModelBean> data = new ArrayList<>(25);
        for (int i = 0; i < 25; i++) {
            data.add(new ModelBean("Row " + (i + 1), "Some Text..."));
        }
        return data;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (mActivityTouchListener != null) {
            mActivityTouchListener.getTouchCoordinates(ev);
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public void setOnActivityTouchListener(OnActivityTouchListener listener) {
        this.mActivityTouchListener = listener;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mRecyclerView.addOnItemTouchListener(mTouchListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mRecyclerView.removeOnItemTouchListener(mTouchListener);
    }

}
