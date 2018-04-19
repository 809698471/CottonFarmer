package com.lianghuawang.cottonfarmer.netutils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.lianghuawang.cottonfarmer.MyApp;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;


/**
 * Author:renchaofang
 * CreateData:2018-02-03
 * 网络请求管理工具类
 */

public class OkHttp3Utils {
    /**
     * 懒汉 安全 加同步
     * 私有的静态成员变量 只声明不创建
     * 私有的构造方法
     * 提供返回实例的静态方法
     */

    private static OkHttp3Utils okHttp3Utils = null;

    private OkHttp3Utils() {
    }

    public static OkHttp3Utils getInstance() {
        if (okHttp3Utils == null) {
            //加同步安全
            synchronized (OkHttp3Utils.class) {
                if (okHttp3Utils == null) {
                    okHttp3Utils = new OkHttp3Utils();
                }
            }

        }

        return okHttp3Utils;
    }

    private static OkHttpClient okHttpClient = null;

    private synchronized static OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            //判空 为空创建实例
            // okHttpClient = new OkHttpClient();
/**
 */
            //  File sdcache = getExternalCacheDir();
            //缓存目录
            File sdcache = new File(Environment.getExternalStorageDirectory(), "cache");
            int cacheSize = 10 * 1024 * 1024;
            //OkHttp3拦截器
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    Log.i("xxx", message.toString());
                }
            });
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


            okHttpClient = new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS)
                    //添加OkHttp3的拦截器
                    .addInterceptor(httpLoggingInterceptor)
                    .addNetworkInterceptor(new CacheInterceptor())
                    .writeTimeout(20, TimeUnit.SECONDS).readTimeout(20, TimeUnit.SECONDS)
                    //.cache(new Cache(sdcache.getAbsoluteFile(), cacheSize))
                    .build();
        }
        return okHttpClient;
    }

    private static Handler mHandler = null;

    public synchronized static Handler getHandler() {
        if (mHandler == null) {
            mHandler = new Handler();
        }

        return mHandler;
    }

    /**
     * get请求
     * 参数1 url
     * 参数2 回调Callback
     */

    public static void doGet(String url, Callback callback) {

        //创建OkHttpClient请求对象
        OkHttpClient okHttpClient = getOkHttpClient();
        //创建Request
        Request request = new Request.Builder().url(url).build();
        //得到Call对象
        Call call = okHttpClient.newCall(request);
        //执行异步请求
        call.enqueue(callback);
    }

    public static void doGet(String token, String url, Callback callback) {
        //创建OkHttpClient请求对象
        OkHttpClient okHttpClient = getOkHttpClient();
        //创建Request
        Request request = new Request.Builder().addHeader("Authorization", token).url(url).build();
        //得到Call对象
        Call call = okHttpClient.newCall(request);
        //执行异步请求
        call.enqueue(callback);
    }

    public static void doGet(String token, String url, LinkedHashMap<String, String> params, Callback callback) {
        //创建OkHttpClient请求对象
        OkHttpClient okHttpClient = getOkHttpClient();
        //创建Request
        String data_url = attachHttpGetParams(url, params);
        Request request = new Request.Builder().addHeader("token", token).url(data_url).build();
        //得到Call对象
        Call call = okHttpClient.newCall(request);
        //执行异步请求
        call.enqueue(callback);
    }

    /**
     * post请求  token头部添加
     * 参数1 url
     * 参数2 回调Callback
     */
    public static void doPost(String token, String url, Map<String, String> params, Callback callback) {
        //创建OkHttpClient请求对象
        OkHttpClient okHttpClient = getOkHttpClient();
        //3.x版本post请求换成FormBody 封装键值对参数
        FormBody.Builder builder = new FormBody.Builder();
        //遍历集合
        for (String key : params.keySet()) {
            builder.add(key, params.get(key));
        }
        Request.Builder builder1 = new Request.Builder();
//        builder1.addHeader("token",token);
        builder1.addHeader("Authorization",token);
        Request request = builder1.url(url).post(builder.build()).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }

    public static void doPost(String url, Map<String, String> params, Callback callback) {
        //创建OkHttpClient请求对象
        OkHttpClient okHttpClient = getOkHttpClient();
        //3.x版本post请求换成FormBody 封装键值对参数
        FormBody.Builder builder = new FormBody.Builder();
        //遍历集合
        for (String key : params.keySet()) {
            builder.add(key, params.get(key));
        }
        //创建Request
        Request request = new Request.Builder().url(url).post(builder.build()).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }

    /**
     * post请求上传文件
     * 参数1 url
     * 参数2 回调Callback
     */
    public static void uploadPic(String token, final Context context, String url, Map<String, Object> params) {
        //创建OkHttpClient请求对象
        OkHttpClient okHttpClient = getOkHttpClient();
        //创建MultipartBody.Builder 设置支持FORM
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof File) {
                File file = (File) value;
                //创建RequestBody 封装file参数
                builder.addFormDataPart(entry.getKey(), file.getName(), RequestBody.create(MediaType.parse("application/octet-stream"), file));

            } else {
                builder.addFormDataPart(entry.getKey(), value.toString());
            }
        }
        //创建RequestBody 设置类型等
        RequestBody requestBody = builder.build();
        final Request.Builder request = new Request.Builder();
//        request.addHeader("token", token);
        Request request1 = request.url(url).post(requestBody).build();
        Call call = okHttpClient.newCall(request1);
        //执行请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //上传成功回调 目前不需要处理
                Looper.prepare();
                String string = response.body().string();
                LogUtils.d("jkjkjk", string);
                //进行保存token值
                try {
                    JSONObject jsonObject = new JSONObject(string);
                    String code = jsonObject.getString("code");
                    if (code.equals("200")) {
                        JSONObject result = jsonObject.getJSONObject("result");
                        String token = result.getString("token");

                    } else if (code.equals("4001")) {
                        String descriptions = jsonObject.getString("descriptions");
                        ToastUtils.showShort(context, descriptions);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Looper.loop();
            }
        });
    }

    public static void changeuploadPic(String token, final Context context, String url, Map<String, Object> params) {
        //创建OkHttpClient请求对象
        OkHttpClient okHttpClient = getOkHttpClient();
        //创建MultipartBody.Builder 设置支持FORM
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof File) {
                File file = (File) value;
                //创建RequestBody 封装file参数
                builder.addFormDataPart(entry.getKey(), file.getName(), RequestBody.create(MediaType.parse("application/octet-stream"), file));

            } else {
                builder.addFormDataPart(entry.getKey(), value.toString());
            }
        }
        //创建RequestBody 设置类型等
        RequestBody requestBody = builder.build();
        Request.Builder builder1 = new Request.Builder();
        builder1.addHeader("token", token);

        Request request = builder1.url(url).post(requestBody).build();
        Call call = okHttpClient.newCall(request);
        //执行请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //上传成功回调 目前不需要处理
                Looper.prepare();
                Toast.makeText(context, "修改成功", Toast.LENGTH_SHORT).show();
                String string = response.body().string();
                //进行保存token值
//                try {
//                    JSONObject jsonObject = new JSONObject(string);
//                    JSONObject result = jsonObject.getJSONObject("result");
//                    String token = result.getString("token");
//                    LogUtils.i("hhhh",token);
//                    /**
//                     * 将其保留到sp
//                     * */
//                    SPUtil.put(MyApp.getInstance(),"token",token);
//                } catch (JSONException e) {e.printStackTrace();
//                }
                LogUtils.i("string", string);
                Looper.loop();
            }
        });
    }

    /**
     * 下载文件 以流的形式把apk写入的指定文件 得到file后进行安装
     * 参数一：请求Url
     * 参数二：保存文件的路径名
     * 参数三：保存文件的文件名
     */
    public static void download(final Context context, final String url, final String saveDir) {
        Request request = new Request.Builder().url(url).build();
        Call call = getOkHttpClient().newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("xxx", e.toString());
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {

                InputStream is = null;
                byte[] buf = new byte[2048];
                int len = 0;
                FileOutputStream fos = null;
                try {
                    is = response.body().byteStream();
                    //apk保存路径
                    final String fileDir = isExistDir(saveDir);
                    //文件
                    File file = new File(fileDir, getNameFromUrl(url));
                    fos = new FileOutputStream(file);
                    while ((len = is.read(buf)) != -1) {
                        fos.write(buf, 0, len);
                    }
                    fos.flush();
                    //apk下载完成后 调用系统的安装方法
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                    context.startActivity(intent);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (is != null) is.close();
                    if (fos != null) fos.close();
                }
            }
        });
    }

    /**
     * @param saveDir
     * @return
     * @throws IOException 判断下载目录是否存在
     */
    public static String isExistDir(String saveDir) throws IOException {
        // 下载位置
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {

            File downloadFile = new File(Environment.getExternalStorageDirectory(), saveDir);
            if (!downloadFile.mkdirs()) {
                downloadFile.createNewFile();
            }
            String savePath = downloadFile.getAbsolutePath();
            Log.e("savePath", savePath);
            return savePath;
        }
        return null;
    }

    /**
     * @param url
     * @return 从下载连接中解析出文件名
     */
    private static String getNameFromUrl(String url) {
        return url.substring(url.lastIndexOf("/") + 1);
    }

    /**
     * 为okhttp添加缓存，这里是考虑到服务器不支持缓存时，从而让okhttp支持缓存
     */
    private static class CacheInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            // 有网络时 设置缓存超时时间1个小时
            int maxAge = 60 * 60;
            // 无网络时，设置超时为1天
            int maxStale = 60 * 60 * 24;
            Request request = chain.request();
            if (NetWorkUtils.isNetWorkAvailable(MyApp.getInstance())) {
                //有网络时只从网络获取
                request = request.newBuilder().cacheControl(CacheControl.FORCE_NETWORK).build();
            } else {
                //无网络时只从缓存中读取
                request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
               /* Looper.prepare();
                Toast.makeText(MyApp.getInstance(), "走拦截器缓存", Toast.LENGTH_SHORT).show();
                Looper.loop();*/
            }
            Response response = chain.proceed(request);
            if (NetWorkUtils.isNetWorkAvailable(MyApp.getInstance())) {
                response = response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .build();
            } else {
                response = response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();
            }
            return response;
        }
    }

    /**
     * 为HttpGet 的 url 方便的添加多个name value 参数。
     * url
     * params
     */
    public static String attachHttpGetParams(String url, LinkedHashMap<String, String> params) {

        Iterator<String> keys = params.keySet().iterator();
        Iterator<String> values = params.values().iterator();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("?");

        for (int i = 0; i < params.size(); i++) {
            stringBuffer.append(keys.next() + "=" + values.next());
            if (i != params.size() - 1) {
                stringBuffer.append("&");
            }
        }
        return url + stringBuffer.toString();
    }

    /**
     * 为HttpGet 的 url 方便的添加1个name value 参数。
     * url
     * name
     * value
     */
    public static String attachHttpGetParam(String url, String name, String value) {
        return url + "?" + name + "=" + value;
    }

    public static void Cancel() {

    }
}
