package com.bmf.demo.api;

import com.bmf.base.annotations.BusinessApi;
import com.bmf.base.annotations.DomainService;

/**
 * 出库服务
 */
@DomainService
public interface OutboundService {

    /**
     * 创建出库单
     * @return
     */
    @BusinessApi(serviceCode = 10001, serviceAlias = "outbound_create_order_service")
    String createOutboundOrder();

    /**
     * 取消出库单
     * @return
     */
    boolean cancelOutboundOrder();
}
