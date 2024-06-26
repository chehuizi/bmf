package com.bmf.demo.api;

import com.bmf.base.annotations.BusinessApi;
import com.bmf.base.annotations.DomainService;

/**
 * 入库服务
 */
@DomainService
public interface InboundService {

    /**
     * 创建入库单
     * @return
     */
    @BusinessApi(serviceCode = 10002, serviceAlias = "inbound_create_order_service")
    String createInboundOrder();

    /**
     * 取消入库单
     * @return
     */
    boolean cancelInboundOrder();
}
