package com.bmf.infrastructure.dal;

import com.bmf.base.tactics.entity.DomainEntity;

import java.util.List;

public interface DomainEntityRepository extends BaseRepository<DomainEntity> {

    /**
     * 根据领域编码查询实体列表
     * @param domainCode
     * @return
     */
    List<DomainEntity> selectByDomainCode(Integer domainCode);

}