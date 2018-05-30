CREATE TABLE demo (
    id BIGINT NOT NULL auto_increment,
	userName VARCHAR(32),
	password VARCHAR(32),
	status INT ,
	freezeAmt decimal(20,2),
	lastTradeDate date,
	createTime TIMESTAMP ,
	updateTime TIMESTAMP,
	PRIMARY KEY  (`id`)
);