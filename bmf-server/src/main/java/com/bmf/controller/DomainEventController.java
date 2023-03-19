package com.bmf.controller;

import com.alibaba.fastjson.JSON;
import com.bmf.api.Result;
import com.bmf.api.domain.dto.DomainEventQryReqDTO;
import com.bmf.api.domain.dto.DomainEventRespDTO;
import com.bmf.api.domain.dto.DomainServiceQryReqDTO;
import com.bmf.api.domain.dto.DomainServiceRespDTO;
import com.bmf.api.domain.qry.DomainEventQryService;
import com.bmf.base.tactics.event.DomainEvent;
import com.bmf.base.tactics.service.DomainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "domain/event")
public class DomainEventController {

    private static final Logger logger = LoggerFactory.getLogger(DomainEventController.class);

    @Autowired
    private DomainEventQryService domainEventQryService;

    @GetMapping("detail")
    public String detail(@RequestParam("domain_code") Integer domainCode,
                         @RequestParam("event_code") Integer eventCode,
                         @RequestParam("include_all") Boolean includeAll) {
        DomainEventQryReqDTO domainEventQryReqDTO = new DomainEventQryReqDTO();
        DomainEvent domainEvent = new DomainEvent();
        domainEvent.setDomainCode(domainCode);
        domainEvent.setEventCode(eventCode);
        domainEventQryReqDTO.setDomainEvent(domainEvent);
        domainEventQryReqDTO.setIncludeAttr(includeAll);
        Result<DomainEventRespDTO> result = domainEventQryService.queryOne(domainEventQryReqDTO);
        return JSON.toJSONString(result);
    }

}