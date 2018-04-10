package com.lianghuawang.cottonfarmer.utils;

import android.os.Handler;
import android.os.Message;

public class TimekeeperUtil extends Thread {

    private int NUMBER;
    private int count_number;
    private Handler handler;

    public TimekeeperUtil(Handler handler,int NUMBER, int count_number){
        this.handler = handler;
        this.NUMBER = NUMBER;
        this.count_number = count_number;
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            if (count_number < 0) {
                count_number = NUMBER;
                return;
            }
            Message message = new Message();
            message.what = count_number;
            if (count_number == 0) {
                message.what = -1;
            }
            handler.sendMessage(message);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count_number--;
        }
    }
}
