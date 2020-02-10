package com.biye.hxpj.service;

import com.biye.hxpj.model.TotalEmDaily;
import com.biye.hxpj.model.TotalEmHour;
import com.biye.hxpj.model.TotalWmDaily;
import com.biye.hxpj.model.TotalWmHour;

import java.util.List;

public interface EchartService {
    List<TotalEmDaily> getEMDailyScaleList();

    List<TotalWmDaily> getWmDailyScaleList();

    List<TotalEmHour> getEmTotalHour();

    List<TotalWmHour> getWmTotalHour();
}
