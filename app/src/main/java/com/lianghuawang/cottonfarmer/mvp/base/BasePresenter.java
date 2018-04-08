package com.lianghuawang.cottonfarmer.mvp.base;

import java.lang.ref.WeakReference;

/**
 *
 * Created by 1 on 2018/2/4.
 */

public abstract class BasePresenter<M,V> {
    protected M mModel;
    protected WeakReference<V> mViewRef;

    public void onAttach(M model, V view) {
        mModel = model;
        mViewRef = new WeakReference<>(view);
    }

    protected V getView() {
        return isViewAttached() ? mViewRef.get() : null;
    }

    protected boolean isViewAttached() {
        return null != mViewRef && null != mViewRef.get();
    }

    public void onDetach() {
        if (null != mViewRef) {
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
