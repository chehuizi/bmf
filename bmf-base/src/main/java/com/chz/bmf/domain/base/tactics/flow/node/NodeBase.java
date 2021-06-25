package com.chz.bmf.domain.base.tactics.flow.node;

import com.chz.bmf.domain.base.tactics.flow.context.FlowContext;
import com.chz.bmf.domain.base.tactics.flow.context.FlowInputDataBase;
import com.chz.bmf.domain.base.tactics.flow.context.FlowOutputDataBase;
import com.chz.bmf.domain.base.tactics.flow.processor.Processor;
import lombok.Data;

/**
 * 节点基类
 */
@Data
public class NodeBase {

    /**
     * 节点名称
     */
    private String name;
    /**
     * 原子能力
     */
    private Processor processor;

    public <T> T output() {
        FlowContext<FlowInputDataBase, FlowOutputDataBase> flowContext = new FlowContext<>();
        return processor.process(flowContext);
    }

}