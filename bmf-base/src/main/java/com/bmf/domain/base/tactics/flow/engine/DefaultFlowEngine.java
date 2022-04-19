package com.bmf.domain.base.tactics.flow.engine;


import com.bmf.domain.base.tactics.flow.context.*;
import lombok.Data;

@Data
public class DefaultFlowEngine implements FlowEngine {

    @Override
    public <T extends FlowOutputDataBase, R extends FlowInputDataBase> FlowOutput<T> trigger(FlowInput<R> flowInput) {
        // 构造流程上下文
        FlowContext<R, T> flowContext = new FlowContext<>();
        flowContext.setInputData(flowInput.getData());

        // 触发流程
        FlowExecutor flowExecutor = new FlowExecutor();
        flowExecutor.execute(flowContext);

        // 返回结果
        FlowOutput<T> flowOutput = new FlowOutput<>();
        flowOutput.setData(flowContext.getOutputData());
        return flowOutput;
    }
}