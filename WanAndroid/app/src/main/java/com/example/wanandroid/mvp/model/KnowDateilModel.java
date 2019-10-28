package com.example.wanandroid.mvp.model;

import com.example.wanandroid.base.BaseModel;
import com.example.wanandroid.beans.AuthorBean;
import com.example.wanandroid.beans.KnowDateilBean;
import com.example.wanandroid.util.ApiService;
import com.example.wanandroid.util.ResultCallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class KnowDateilModel extends BaseModel {

    public void getKnowDatileData(int id,int cid,final ResultCallBack<KnowDateilBean> callBack){

        Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiService.url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = build.create(ApiService.class);
        Observable<KnowDateilBean> authorData = apiService.getKnowDateil(id,cid);
        authorData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<KnowDateilBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(KnowDateilBean bean) {
                        callBack.onSuccess(bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

}
