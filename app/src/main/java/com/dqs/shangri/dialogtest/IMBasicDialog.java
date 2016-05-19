package com.dqs.shangri.dialogtest;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Shangri on 5/5/2016.
 */
public class IMBasicDialog extends Dialog {

    public IMBasicDialog(Context context, int theme) {
        super(context, R.style.IMBasicDialog);
        setLayout();
    }

    public IMBasicDialog(Context context) {
        super(context, R.style.IMBasicDialog);
        setLayout();
    }

    public void setLayout() {
        LAYOUT = R.layout.im_basic_dialog;
    }

    public boolean isHasCancel() {
        return hasCancel;
    }

    public void setHasCancel(boolean hasCancel) {
        this.hasCancel = hasCancel;
    }

    public boolean isHasConfirm() {
        return hasConfirm;
    }

    public void setHasConfirm(boolean hasConfirm) {
        this.hasConfirm = hasConfirm;
    }

    public String getTitle() {
        return titleText;
    }

    public void setTitle(String titleText) {
        this.titleText = titleText;
    }

    public String getCancel() {
        return cancelText;
    }

    public void setCancel(String cancelText) {
        this.cancelText = cancelText;
    }

    public int getMessageColor() {
        return messageColor;
    }

    public void setMessageColor(int messageColor) {
        this.messageColor = messageColor;
    }

    public String getConfirm() {
        return confirmText;
    }

    public void setConfirm(String confirmText) {
        this.confirmText = confirmText;
    }

    public String getMessage() {
        return messageText;
    }

    public void setMessage(String messageText) {
        this.messageText = messageText;
    }

    public int getTitleColor() {
        return titleColor;
    }

    public void setTitleColor(int titleColor) {
        this.titleColor = titleColor;
    }

    public int getCancelColor() {
        return cancelColor;
    }

    public void setCancelColor(int cancelColor) {
        this.cancelColor = cancelColor;
    }

    public int getConfirmColor() {
        return confirmColor;
    }

    public void setConfirmColor(int confirmColor) {
        this.confirmColor = confirmColor;
    }

    private boolean hasCancel = true;
    private boolean hasConfirm = true;

    private String messageText = null;
    private String titleText = null;
    private String cancelText = null;
    private String confirmText = null;

    private int messageColor = 0;
    private int titleColor = 0;
    private int cancelColor = 0;
    private int confirmColor = 0;

    protected TextView titleTextView = null;
    protected TextView messageTextView = null;
    protected Button cancelButton = null;
    protected Button confirmButton = null;
    protected RelativeLayout cancelLayout = null;
    protected RelativeLayout buttonSplitLayout = null;
    protected RelativeLayout confirmLayout = null;

    protected int LAYOUT = R.layout.im_basic_dialog;

    public Callback getCallback() {
        return callback;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    private Callback callback = new Callback();

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.im_basic_dialog_cancel_button:
                    if (callback != null) {
                        callback.onCancel(IMBasicDialog.this);
                    }
                    break;
                case R.id.im_basic_dialog_confirm_button:
                    if (callback != null) {
                        callback.onConfirm(IMBasicDialog.this);
                    }
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        setCancelable(false);
        setCanceledOnTouchOutside(false);

        initDefaultView();
        setData();
    }

    protected void initDefaultView() {
        titleTextView = (TextView) findViewById(R.id.im_basic_dialog_title);
        messageTextView = (TextView) findViewById(R.id.im_basic_dialog_message);
        cancelButton = (Button) findViewById(R.id.im_basic_dialog_cancel_button);
        confirmButton = (Button) findViewById(R.id.im_basic_dialog_confirm_button);

        cancelLayout = (RelativeLayout) findViewById(R.id.im_basic_dialog_cancel);
        buttonSplitLayout = (RelativeLayout) findViewById(R.id.im_basic_dialog_button_split);
        confirmLayout = (RelativeLayout) findViewById(R.id.im_basic_dialog_confirm);

        titleTextView.setText(getContext().getString(R.string.im_custom_dialog_title));
        cancelButton.setText(getContext().getString(R.string.im_custom_dialog_cancel));
        confirmButton.setText(getContext().getString(R.string.im_custom_dialog_ok));

        cancelButton.setOnClickListener(listener);
        confirmButton.setOnClickListener(listener);
    }

    protected void setData() {
        if (titleText != null)
            titleTextView.setText(titleText);
        if (messageText != null)
            messageTextView.setText(messageText);
        if (cancelText != null)
            cancelButton.setText(cancelText);
        if (confirmText != null)
            confirmButton.setText(confirmText);

        if (titleColor != 0)
            titleTextView.setTextColor(getContext().getResources().getColor(titleColor));
        if (messageColor != 0)
            messageTextView.setTextColor(getContext().getResources().getColor(messageColor));
        if (cancelColor != 0)
            cancelButton.setTextColor(getContext().getResources().getColor(cancelColor));
        if (confirmColor != 0)
            confirmButton.setTextColor(getContext().getResources().getColor(confirmColor));

        if (!hasCancel) {
            cancelLayout.setVisibility(View.GONE);
            buttonSplitLayout.setVisibility(View.GONE);
        }
        if (!hasConfirm) {
            confirmLayout.setVisibility(View.GONE);
            buttonSplitLayout.setVisibility(View.GONE);
        }
    }

    public static class Callback {
        public void onCancel(IMBasicDialog d) {
            d.dismiss();
        }

        public void onConfirm(IMBasicDialog d) {
            d.dismiss();
        }
    }

    ;

}
