package com.lianghuawang.cottonfarmer.activity.my.bankcard;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

//我的银行卡
public class BankCardActivity extends BaseActivity implements View.OnClickListener {
    private ListView lv_item;
    private ImageView commit;
    private List<Card_Bean> card_beans = new ArrayList<>();
    private Adapter adapter;
    int count = 0;
    private ImageView bankcard_return;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bank_card;
    }

    @Override
    protected void initView() {
        bankcard_return = (ImageView) findViewById(R.id.bankcard_return);
        lv_item = (ListView) findViewById(R.id.lv_item);
        commit = (ImageView) findViewById(R.id.commit);
        setListViewHeightBasedOnChildren(lv_item);
        adapter = new Adapter(this, card_beans);
        lv_item.setAdapter(adapter);
        commit.setOnClickListener(this);
        bankcard_return.setOnClickListener(this);
    }
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        if (listView == null) return;
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.commit:
                count++;
                Log.e("点击几次", count + "");
                card_beans.clear();
                for (int i = 0; i < count; i++) {
                    Card_Bean card_bean = new Card_Bean("中国工商银行", "**** **** **** 5428", R.mipmap.ic_launcher);
                    card_beans.add(card_bean);
                }
                setListViewHeightBasedOnChildren(lv_item);
                adapter.notifyDataSetChanged();
                break;
            case R.id.bankcard_return:
                finish();
                break;
        }
    }
}
