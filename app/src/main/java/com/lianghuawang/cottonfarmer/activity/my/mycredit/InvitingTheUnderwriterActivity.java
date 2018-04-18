package com.lianghuawang.cottonfarmer.activity.my.mycredit;

import android.widget.ListView;

import com.lianghuawang.cottonfarmer.Bean;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.adapter.base.MyCommonAdapter;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

//邀请承保人
public class InvitingTheUnderwriterActivity extends BaseActivity {

    private ListView invitingtheunderwriter_lv;
    private List<Bean> beanList;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_inviting_the_underwriter;
    }

    @Override
    protected void initView() {
        invitingtheunderwriter_lv = (ListView) findViewById(R.id.invitingtheunderwriter_lv);
       iniaData();
//        invitingtheunderwriter_lv.setAdapter(new MyAdapter(this,beanList));
        invitingtheunderwriter_lv.setAdapter(new MyCommonAdapter(this,beanList,R.layout.invitingtheunderwriter_item));
    }

    private void iniaData() {
        beanList = new ArrayList<>();

        for(int i=0;i<5;i++){
            Bean bean = new Bean();
            bean.setName("昵称");
            beanList.add(bean);
        }
    }
}
