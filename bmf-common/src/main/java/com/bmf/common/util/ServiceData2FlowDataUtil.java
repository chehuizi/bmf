package com.bmf.common.util;

import com.bmf.base.tactics.flow.context.FlowInput;
import com.bmf.base.tactics.flow.context.FlowInputDataBase;
import com.bmf.base.tactics.flow.context.FlowOutput;
import com.bmf.base.tactics.flow.context.FlowOutputDataBase;
import com.bmf.base.tactics.service.ServiceReq;
import com.bmf.base.tactics.service.ServiceReqDataBase;
import com.bmf.base.tactics.service.ServiceResp;
import com.bmf.base.tactics.service.ServiceRespDataBase;

public class ServiceData2FlowDataUtil {

    public static <T extends FlowInputDataBase, R extends ServiceReqDataBase> FlowInput<T> convertServiceData2FlowData(ServiceReq<R> serviceReq) {
        return null;
    }

    public static <T extends ServiceRespDataBase, R extends FlowOutputDataBase> ServiceResp<T> convertFlowData2ServiceData(FlowOutput<R> flowOutput) {
        return null;
    }
}