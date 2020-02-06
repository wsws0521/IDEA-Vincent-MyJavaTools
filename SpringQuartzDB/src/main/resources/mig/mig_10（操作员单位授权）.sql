select aa.userNo, aa.userId, aa.userName, bb.id, bb.name, 0 "cascade", bb.no, 1579511310266 "upTime" from
(select u.no "userNo", u.id "userId", u.name "userName", o.id "orgId", o.name "orgName", o.no "orgNo" from uap_user u
left join uap_organization o on u.org_id = o.id
where u.id not in ('1','2','10000')) aa
LEFT JOIN uap_organization bb on bb.no like CONCAT(aa.orgNo,'%')
ORDER BY aa.userId, bb.no;



INSERT INTO `uap_user_org_manage` (`id`, `user_no`, `user_id`, `user_name`, `org_id`, `org_name`, `is_cascade`, `org_no`, `up_time`, `ORG_PATH_ID`)
SELECT a.mainkey, a.userNo, a.userId, a.userName, a.id, a.name, a.cascade, a.no, a.upTime, NULL
FROM tmp_user_org a;


update uap_sequence set next_val = 2000001 where sequence_name = 'userOrgManageId';



-------------------------------------tmp_user_org  自动建表语句-----------------------------------------
CREATE TABLE `tmp_user_org` (
  `mainkey` varchar(128) NOT NULL,
  `userNo` varchar(128) DEFAULT NULL,
  `userId` varchar(128) DEFAULT NULL,
  `userName` varchar(128) DEFAULT NULL,
  `id` varchar(128) DEFAULT NULL,
  `name` varchar(128) DEFAULT NULL,
  `cascade` varchar(128) DEFAULT NULL,
  `no` varchar(128) DEFAULT NULL,
  `upTime` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`mainkey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;