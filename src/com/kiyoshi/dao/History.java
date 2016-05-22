package com.kiyoshi.dao;

import com.kiyoshi.bean.HistoryBean;
import java.util.ArrayList;

public interface History {

    public ArrayList<HistoryBean> getHistoryData();

    public void truncateHistory();
}
