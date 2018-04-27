CREATE DATABASE replatform;
CREATE TABLE `station` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL ,
  `address` varchar(255) NOT NULL COMMENT '地址',
  `detailed_address` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `position` point NOT NULL,
  PRIMARY KEY (`id`),
  SPATIAL KEY `sta_pos` (`position`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `consultant` (
  `username` varchar(30) NOT NULL ,
  `password` varchar(30) not null ,
  `staid` int(10) unsigned NOT NULL COMMENT '公司id',
  PRIMARY KEY (`username`),
  KEY `ad_staid` (`staid`) USING BTREE,
  KEY `ad_nameAndPass` (`username`,`password`),
  CONSTRAINT `ad_staid` FOREIGN KEY (`staid`) REFERENCES `station` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


create table collector
(
  id               int unsigned auto_increment
    primary key,
  openid           varchar(100)                        null
  comment '回收人员openid',
  realName         varchar(14)                         null
  comment '真实姓名',
  sex              varchar(4)                          null,
  avater           varchar(255)                        null
  comment '头像',
  phoneNumber      varchar(30)                         not null,
  password         varchar(30)                         not null,
  idCardNum        varchar(30)                         not null
  comment '身份证号',
  photo            varchar(255)                        null
  comment '本人照片',
  idCardFrontPhoto varchar(255)                        null
  comment '身份证正面地址',
  idCardBackPhoto  varchar(255)                        null
  comment '身份证背面地址',
  volume           int unsigned default '0'            null
  comment '成交量',
  createTime       timestamp default CURRENT_TIMESTAMP not null,
  staid            int unsigned                        not null,
  state            int(2) unsigned default '1'         null
  comment '非法用户:0,正常用户:1',
  constraint collector_openid_uindex
  unique (openid),
  constraint c_phoneNumber
  unique (phoneNumber),
  constraint c_idCard
  unique (idCardNum),
  constraint c_staid
  foreign key (staid) references station (id)
    on update cascade
    on delete cascade
)
  engine = InnoDB
  charset = utf8;

create index c_name
  on collector (realName);

create index c_staid
  on collector (staid);



CREATE TABLE `community` (
  `id` int(10) unsigned auto_increment NOT NULL,
  `address` varchar(255) NOT NULL  COMMENT '小区地址',
  `cid` int(10) unsigned DEFAULT NULL COMMENT '归属回收员id',
  `name` varchar(40) DEFAULT NULL COMMENT '小区名',
  PRIMARY KEY (`id`),
  KEY `comm_cid` (`cid`),
  CONSTRAINT `comm_cid` FOREIGN KEY (`cid`) REFERENCES `collector` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
  `openid` varchar(100) NOT NULL,
  `avater` varchar(255) DEFAULT NULL COMMENT '头像地址',
  `state` int(2) unsigned DEFAULT 1 COMMENT '非法用户:0,正常用户:1' ,
  PRIMARY KEY (`openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `bankaccount` (
  `id` bigint(20) unsigned auto_increment NOT NULL,
  `uid` varchar(100) NOT NULL,
  `account` varchar(255) DEFAULT NULL COMMENT '银行卡号',
  `bank_code` int(5) unsigned DEFAULT NULL COMMENT '银行id',
  `username` varchar(20) DEFAULT NULL COMMENT '银行卡用户名',
  PRIMARY KEY (`id`),
  KEY `ba_uid` (`uid`),
  CONSTRAINT `ba_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `useraddress` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `uid` varchar(100) NOT NULL,
  `address` varchar(255) DEFAULT NULL COMMENT '附近坐标',
  `position` point NOT NULL COMMENT '坐标',
  `detail` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `geohash` varchar(12) DEFAULT NULL,
  `phoneNumber` varchar(255) DEFAULT NULL COMMENT '收货人手机号',
  `name` varchar(255) DEFAULT NULL COMMENT '收货人姓名',
  `community_id` int(11) unsigned DEFAULT NULL COMMENT '归属小区',
  PRIMARY KEY (`id`),
  KEY `ua_geohash` (`geohash`),
  SPATIAL KEY `ua_pos` (`position`),
  KEY `ua_commid` (`community_id`),
  KEY `ua_uid` (`uid`),
  CONSTRAINT `ua_commid` FOREIGN KEY (`community_id`) REFERENCES `community` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ua_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `orderform` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `uid` varchar(100) NOT NULL COMMENT '用户id',
  `cid` int(10) unsigned DEFAULT NULL COMMENT '接受该订单的回收员id',
  `aid` bigint(20) unsigned NOT NULL COMMENT '地址id',
  `state` tinyint(4) DEFAULT 0 COMMENT '已提交:0,已接受:1,已完成:2,请求更改:3,请求取消:4',
  `weight` double DEFAULT NULL COMMENT '总重量',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `appointTime` timestamp NULL DEFAULT NULL COMMENT '预约时间',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP  ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `price` double(10,2) DEFAULT NULL,
  `weight_state` int null comment '订单提交的重量区间',
  PRIMARY KEY (`id`),
  KEY `o_state` (`state`),
  KEY `o_uid` (`uid`),
  KEY `o_cid` (`cid`),
  CONSTRAINT `o_cid` FOREIGN KEY (`cid`) REFERENCES `collector` (`id`),
  CONSTRAINT `o_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `scrap` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `typename` varchar(20) NOT NULL COMMENT '种类名称',
  `name` varchar(20) NOT NULL,
  `unitPrice` double(10,2) unsigned DEFAULT NULL COMMENT '对于用户的单价',
  `monthVolume` double(10,2) DEFAULT NULL COMMENT '当月成交量',
  `totalVolume` double(10,2) DEFAULT NULL COMMENT '总成交量',
  PRIMARY KEY (`id`),
  KEY `s_typeName` (`typename`),
  KEY `s_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `scrapmessage` (
  `oid` bigint(20) unsigned not null  COMMENT '订单id',
  `scrapid` int(10) unsigned not null COMMENT '废品id',
  `weight` double unsigned DEFAULT NULL COMMENT '废品重量',
  `price` double unsigned DEFAULT NULL COMMENT '废品价格',
  primary key (oid, scrapid),
  KEY `sm_oid` (`oid`),
  KEY `sm_scrapid` (`scrapid`),
  CONSTRAINT `sm_oid` FOREIGN KEY (`oid`) REFERENCES `orderform` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sm_scrapid` FOREIGN KEY (`scrapid`) REFERENCES `scrap` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
