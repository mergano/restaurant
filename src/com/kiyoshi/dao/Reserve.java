package com.kiyoshi.dao;

import com.kiyoshi.bean.ReserveBean;
import java.util.ArrayList;

public interface Reserve {

    public ArrayList<ReserveBean> getReserveData();

    public boolean AddReserve(ReserveBean bean);

    public boolean DeleteReserve(ReserveBean bean, int res_no);

    public boolean EditReserve(ReserveBean bean, int n);

}
