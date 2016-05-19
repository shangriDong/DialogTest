package com.dqs.shangri.dialogtest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dqs.shangri.wheelview.OnWheelScrollListener;
import com.dqs.shangri.wheelview.WheelView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    private final Logger log = Logger.getLogger(MainActivity.class.getName());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showQueryYearDialog(MainActivity.this);
    }

    public void showQueryYearDialog(Context context) {
        final int startYear = 2016;
        String title = context.getString(R.string.time_selecte_red_packets);
        String cancel = context.getString(R.string.im_custom_dialog_cancel);
        String confirm = context.getString(R.string.im_custom_dialog_ok);
        final IMWheelViewDialog dialog = new IMWheelViewDialog(context);
        dialog.setTitle(title);
        dialog.setCancel(cancel);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        int curYearValue = Integer.parseInt(formatter.format(curDate));

        String[] arr = new String[curYearValue - startYear + 1];

        for (int i = curYearValue - startYear, j = 0; i >= 0; i--, j++) {
            arr[j] = (startYear + i) + "年";
        }
        dialog.setArrWheelContent(arr);

        OnWheelScrollListener scrollListener = new OnWheelScrollListener() {
            public void onScrollingStarted(WheelView wheel) {
            }

            public void onScrollingFinished(WheelView wheel) {
                int currentYear = dialog.getWheelView().getCurrentItem();
                log.info("currentYear = " + currentYear);
            }
        };

        dialog.setLabel(scrollListener);
        dialog.setConfirm(confirm);

        dialog.setCallback(new IMBasicDialog.Callback() {
            @Override
            public void onConfirm(IMBasicDialog d) {
                super.onConfirm(d);
                //result.confirm(dialog.getEditText());
                //log.error("确认");
            }

            @Override
            public void onCancel(IMBasicDialog d) {
                super.onCancel(d);
                //result.cancel();
                //log.error("取消");
            }
        });

        dialog.show();
    }
}
