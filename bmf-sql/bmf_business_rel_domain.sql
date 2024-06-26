CREATE TABLE `bmf_business_rel_domain` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `business_code` int(11) NOT NULL COMMENT '业务编码',
  `domain_code` bigint(20) unsigned NOT NULL COMMENT '领域编码',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否删除（1:删除 0:正常）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_business_code_domain_code` (`business_code`, `domain_code`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8