package com.biye.hxpj.service;

import com.biye.hxpj.model.ComputeEmDailydevicerecord;
import com.biye.hxpj.model.ComputeEmMonthlydevicerecord;
import com.biye.hxpj.model.ComputeWmDailydevicerecord;
import com.biye.hxpj.model.ComputeWmMonthlydevicerecord;
import com.github.pagehelper.PageInfo;

public interface ComputeDailyService {

    PageInfo<ComputeEmDailydevicerecord> getDailyEmRecordList(Integer pageNum,Integer pageSize);

    PageInfo<ComputeWmDailydevicerecord> getDailyWmRecordList(Integer pageNum, Integer pageSize);

    PageInfo<ComputeEmMonthlydevicerecord> getMonthlyEmRecordList(Integer pageNum,Integer pageSize);

    PageInfo<ComputeWmMonthlydevicerecord> getMonthlyWmRecordList(Integer pageNum,Integer pageSize);

    int addDailyEmRecord(ComputeEmDailydevicerecord computeEmDailydevicerecord);

    int addDailyWmRecord(ComputeWmDailydevicerecord computeWmDailydevicerecord);

    int addMonthlyEmRecord(ComputeEmMonthlydevicerecord computeEmMonthlydevicerecord);

    int addMonthlyWmRecord(ComputeWmMonthlydevicerecord computeWmMonthlydevicerecord);

    int updateDailyEmRecord(ComputeEmDailydevicerecord computeEmDailydevicerecord);

    int deleteDailyEmRecord(ComputeEmDailydevicerecord computeEmDailydevicerecord);

    int deleteDailyWmRecord(ComputeWmDailydevicerecord computeWmDailydevicerecord);

    int deleteMonthlyEmRecord(ComputeEmMonthlydevicerecord computeEmMonthlydevicerecord);

    int deleteMonthlyWmRecord(ComputeWmMonthlydevicerecord computeWmMonthlydevicerecord);

}
