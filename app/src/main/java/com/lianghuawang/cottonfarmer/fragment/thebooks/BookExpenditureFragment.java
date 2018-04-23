package com.lianghuawang.cottonfarmer.fragment.thebooks;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lianghuawang.cottonfarmer.Bean;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.adapter.BookExpenditureFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 账本支出
 */
public class BookExpenditureFragment extends Fragment {
    private List<Bean> list;
    private RecyclerView bookexpenditurefragment_recy;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.bookexpenditurefragment, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        bookexpenditurefragment_recy = (RecyclerView) view.findViewById(R.id.bookexpenditurefragment_recy);

        bookexpenditurefragment_recy.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        Bean bean = new Bean();
        bean.setName("+20000");
        list.add(bean);
        BookExpenditureFragmentAdapter bookExpenditureFragmentAdapter = new BookExpenditureFragmentAdapter(list);
        bookexpenditurefragment_recy.setAdapter(bookExpenditureFragmentAdapter);
    }
}
