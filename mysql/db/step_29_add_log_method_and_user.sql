ALTER TABLE LOG CHANGE COLUMN LOG_TYME LOG_TIME DATETIME NOT NULL;
ALTER TABLE LOG ADD COLUMN LOG_METHOD VARCHAR(64) NULL AFTER LOG_CLASS;
ALTER TABLE LOG ADD COLUMN LOG_USER VARCHAR(50) NULL AFTER LOG_MESS;

ALTER TABLE LOG CHANGE COLUMN LOG_MESS LOG_MESS VARCHAR(1024) NULL DEFAULT NULL;