package com.biye.hxpj.service;

import com.biye.hxpj.model.ComputeEmDailyfirmrecord;
import com.biye.hxpj.model.ComputeEmMonthlyfirmrecord;
import com.biye.hxpj.model.ComputeWmDailyfirmrecord;
import com.biye.hxpj.model.ComputeWmMonthlyfirmrecord;
import com.github.pagehelper.PageInfo;

public interface ComputeFirmService {

    PageInfo<ComputeEmDailyfirmrecord> getEmFirmDailyList(Integer pageNum,Integer pageSize);

    PageInfo<ComputeEmMonthlyfirmrecord> getEmFirmMonthlyList(Integer pageNum, Integer pageSize);

    PageInfo<ComputeWmDailyfirmrecord> getWmFirmDailyList(Integer pageNum, Integer pageSize);

    PageInfo<ComputeWmMonthlyfirmrecord> getWmFirmMonthlyList(Integer pageNum, Integer pageSize);

    int addEmFirmDaily(ComputeEmDailyfirmrecord computeEmDailyfirmrecord);

    int addEmFirmMonthly(ComputeEmMonthlyfirmrecord computeEmMonthlyfirmrecord);

    int addWmFirmDaily(ComputeWmDailyfirmrecord computeWmDailyfirmrecord);

    int addWmFirmMonthly(ComputeWmMonthlyfirmrecord computeWmMonthlyfirmrecord);

    int deleteEmFirmDaily(ComputeEmDailyfirmrecord computeEmDailyfirmrecord);

    int deleteEmFirmMonthly(ComputeEmMonthlyfirmrecord computeEmMonthlyfirmrecord);

    int deleteWmFirmDaily(ComputeWmDailyfirmrecord computeWmDailyfirmrecord);

    int deleteWmFirmMonthly(ComputeWmMonthlyfirmrecord computeWmMonthlyfirmrecord);

    int updateEmFirmDaily(ComputeEmDailyfirmrecord computeEmDailyfirmrecord);

    int updateEmFirmMonthly(ComputeEmMonthlyfirmrecord computeEmMonthlyfirmrecord);

    int updateWmFirmDaily(ComputeWmDailyfirmrecord computeWmDailyfirmrecord);

    int updateWmFirmMonthly(ComputeWmMonthlyfirmrecord computeWmMonthlyfirmrecord);


}
