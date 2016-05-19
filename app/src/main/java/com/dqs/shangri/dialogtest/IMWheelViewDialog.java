package com.dqs.shangri.dialogtest;

import android.content.Context;
import android.os.Bundle;

import com.dqs.shangri.wheelview.ArrayWheelAdapter;
import com.dqs.shangri.wheelview.OnWheelScrollListener;
import com.dqs.shangri.wheelview.WheelView;

import java.util.logging.Logger;

/*import org.apache.log4j.Logger;*/

/**
 * Created by Shangri on 2016/5/10.
 */
public class IMWheelViewDialog extends IMBasicDialog {

    public IMWheelViewDialog(Context context, int theme) {
        super(context, theme);
    }

    public IMWheelViewDialog(Context context) {
        super(context);
    }

    @Override
    public void setLayout() {
        this.LAYOUT = R.layout.im_wheelview_dialog;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initDefaultView() {
        super.initDefaultView();
        m_WheelView = (WheelView) findViewById(R.id.year_query_wv);
    }

    @Override
    protected void setData() {
        super.setData();

        m_WheelView.setAdapter(new ArrayWheelAdapter<Object>(m_arrWheelContent));
        m_WheelView.setCurrentItem(0);
        m_WheelView.addScrollingListener(scrollListener);
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

    private int minValue = 0;
    private int maxValue = 0;
    private WheelView m_WheelView;
    private final Logger log = Logger.getLogger(IMWheelViewDialog.class.getName());
    private OnWheelScrollListener scrollListener;
    private Object[] m_arrWheelContent;

    public void setMinValue(int value) {
        minValue = value;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMaxValue(int value) {
        maxValue = value;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setArrWheelContent(Object[] o) {
        m_arrWheelContent = o;
    }

    public void setLabel(OnWheelScrollListener l) {
        scrollListener = l;
    }

    public WheelView getWheelView() {
        return m_WheelView;
    }
}
