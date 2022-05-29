package com.bmf.base.tactics.flow.context;

import lombok.Data;

/**
 * 业务领域服务流程输出
 * @param <T>
 */
@Data
public class FlowOutput<T extends FlowOutputDataBase> {

    /**
     * 服务流程输出
     */
    private T data;
}
