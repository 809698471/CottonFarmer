package com.lianghuawang.cottonfarmer.widget.linkage_menu;

/**
 * Author: Blincheng.
 * Date: 2017/5/9.
 * Description:
 */

public interface OnItemAddressClickListener {
    /**
     * @param city 返回地址列表对应点击的对象
     * @param tabPosition 对应tab的位置
     * */
    void itemClick(AddressSelector addressSelector, CityInterface city, int tabPosition);
}
