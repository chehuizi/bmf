package com.chz.bmf.flow;

import lombok.Data;

/**
 * 业务领域服务流程输入
 * @param <T>
 */
@Data
public class FlowInput<T extends FlowInputDataBase> {

    /**
     * 服务流程输入
     */
    private T data;
}
