package com.lianghuawang.cottonfarmer.activity.message.news;

import com.lianghuawang.cottonfarmer.Bean;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.adapter.base.BaseAdapters;
import com.lianghuawang.cottonfarmer.adapter.base.BaseHolder;

import java.util.List;

/**
 * 1.extends  把父类的代码继承过来。  可以少写很多代码。
 * 2.因为是全部拿来的代码，所以不是所有的代码都适合当前。对于不适合当前的代码（方法）
 * 我们可选择@Override 覆盖|重写
 */


public class MyHomeAdapter extends BaseAdapters<Bean> {

    public MyHomeAdapter(List<Bean> list) {
        super(R.layout.newstfragment_item, list);
    }

    @Override
    protected void convert(BaseHolder holder, Bean bean) {
      holder.setText(R.id.item_tv_title,bean.getName());
       // holder.setText(R.id.item_tv_title, item).setImageResource(R.id.image, R.drawable.ic_default);
    }
}