package com.chz.bmf.domain.biz.ims.meta;

import com.chz.bmf.domain.base.tactics.meta.BusinessDomainMeta;
import com.chz.bmf.domain.base.tactics.meta.BusinessDomainLevelEnum;
import com.chz.bmf.domain.base.tactics.meta.BusinessDomainNameEnum;

public class ImsDomainMeta extends BusinessDomainMeta {

    public ImsDomainMeta() {
        super(BusinessDomainLevelEnum.TWO, BusinessDomainNameEnum.INVENTORY_MANAGEMENT_SERVICE);
    }
}