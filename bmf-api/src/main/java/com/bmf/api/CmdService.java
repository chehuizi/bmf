package com.bmf.api;

/**
 * cmd服务
 * @param <T>
 */
public interface CmdService<T extends ReqDTO, R extends RespDTO> {

    /**
     * 增加
     * @param req
     * @return
     */
    Result<R> create(T req);

    /**
     * 更新
     * @param req
     * @return
     */
    Result<R> update(T req);

    /**
     * 删除
     * @param req
     * @return
     */
    Result<R> delete(T req);

}
