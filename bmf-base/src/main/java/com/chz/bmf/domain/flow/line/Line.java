package com.chz.bmf.domain.flow.line;

import com.chz.bmf.domain.flow.node.NodeBase;
import lombok.Data;

@Data
public class Line {

    /**
     * 起点
     */
    private NodeBase from;
    /**
     * 终点
     */
    private NodeBase to;
    /**
     * 线条件
     */
    private LineCondition lineCondition;

    /**
     * 是否满足条件
     * @param val
     * @param <T>
     * @return
     */
    public <T> boolean isMatchCondition(T val) {
        return lineCondition.check(val);
    }
}
