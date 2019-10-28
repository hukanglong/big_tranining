package com.example.wanandroid.mvp.view;

import com.example.wanandroid.base.BaseView;
import com.example.wanandroid.beans.AuthorBean;

public interface AuthorView extends BaseView {

    void setData(AuthorBean bean);

    void setMsg(String msg);

}
