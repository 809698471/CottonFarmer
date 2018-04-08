package com.lianghuawang.cottonfarmer.tools;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.lianghuawang.cottonfarmer.R;

import java.io.File;


/**
 *    Glide加载框架封装框架
 */

public class GlideImgManager {
    public static void loadImage(Context context, String url, int erroImg, int emptyImg, ImageView iv) {
        Glide.with(context).load(url).placeholder(emptyImg).error(erroImg).into(iv);
    }
    public static void loadImage(Context context, String url, ImageView iv) {
        Glide.with(context).load(url).crossFade().placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(iv);
    }

    public static void loadGifImage(Context context, String url, ImageView iv) {
        Glide.with(context).load(url).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(iv);
    }


    public static void loadCircleImage(Context context, String url, ImageView iv) {
        Glide.with(context).load(url).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).transform(new GlideCircleTransform(context)).into(iv);
    }

    /**
     * 加载圆形图片。加载过程以及加载失败
     * */
    public static void loadCircleImage2(Context context, String url, int erroImg, int emptyImg, ImageView iv) {
        Glide.with(context).load(url).placeholder(emptyImg).error(erroImg).transform(new GlideCircleTransform(context)).into(iv);
    }
    public static void loadCircleImage(Context context, Uri url, ImageView iv) {
        Glide.with(context).load(url).transform(new GlideCircleTransform(context)).into(iv);
    }

    public static void loadRoundCornerImage(Context context, String url, ImageView iv) {
        Glide.with(context).load(url).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).transform(new GlideRoundTransform(context,4)).into(iv);
    }
    public static void loadRoundCornerImageTen(Context context, String url, ImageView iv) {
        Glide.with(context).load(url).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).transform(new GlideRoundTransform(context,10)).into(iv);
    }
    public static void loadRoundCornerImage1(Context context, String url, ImageView iv) {
        Glide.with(context).load(url).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).transform(new GlideRoundTransform(context,6)).into(iv);
    }
    public static void loadRoundCornerImagecourse(Context context, String url, ImageView iv) {
        Glide.with(context).load(url).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).transform(new GlideRoundTransform(context,0)).into(iv);
    }
    public static void loadRoundCornerImagecourseTwo(Context context, String url, ImageView iv) {
        Glide.with(context).load(url).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).transform(new GlideRoundTransform(context,2)).into(iv);
    }
    public static void loadImage(Context context, final File file, final ImageView imageView) {
        Glide.with(context)
                .load(file)
                .into(imageView);
    }
    public static void loadImage(Context context, final int resourceId, final ImageView imageView) {
        Glide.with(context)
                .load(resourceId)
                .into(imageView);
    }
}
