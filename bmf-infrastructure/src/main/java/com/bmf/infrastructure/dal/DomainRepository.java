package com.bmf.infrastructure.dal;

import com.bmf.base.BusinessDomain;

import java.util.List;

public interface DomainRepository extends BaseRepository<BusinessDomain> {

    /**
     * 查询领域编码查询
     * @param domainCodeList
     * @return
     */
    List<BusinessDomain> selectByDomainCode(List<Integer> domainCodeList);

    /**
     * 根据领域别名查询
     * @param businessCode
     * @param domainAliasList
     * @return
     */
    List<BusinessDomain> selectByDomainAlias(Integer businessCode, List<String> domainAliasList);

    /**
     * 批量插入领域
     * @param businessDomainList
     * @return
     */
    boolean batchInsert(List<BusinessDomain> businessDomainList);
}
