package com.lianghuawang.cottonfarmer.utils;

import android.os.Environment;
import android.os.SystemClock;


import java.io.File;

public class FileUtils {

    private static String FilePath(){
        String fileDir= Environment.getExternalStorageDirectory().getPath()+"/xbdcm/";
        File file=new File(fileDir);
        if(!file.exists()){
            file.mkdir();
        }
        return fileDir;
    }

    public static String ImagePath(){

        return FilePath()+ SystemClock.elapsedRealtime()+".png";
    }

}
