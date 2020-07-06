## Data Definition Language (DDL)

```sqlite
CREATE TABLE IF NOT EXISTS `ConnectedApp`
(
    `connected_app_id` INTEGER,
    `app_name` TEXT, PRIMARY KEY(`connected_app_id`)
);


CREATE TABLE IF NOT EXISTS `Timeframe`
(
    `timeframe_id` INTEGER,
    `pre_set_time` INTEGER NOT NULL,
    `connected_app_id` INTEGER NOT NULL, PRIMARY KEY(`timeframe_id`),
    FOREIGN KEY(`connected_app_id`)
    REFERENCES `ConnectedApp`(`connected_app_id`) ON UPDATE NO ACTION ON DELETE SET NULL
);


CREATE INDEX IF NOT EXISTS `index_Timeframe_connected_app_id` ON `Timeframe` (`connected_app_id`);

CREATE TABLE IF NOT EXISTS `Notification`
(
    `notification_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `summary` TEXT NOT NULL,
    `timeframe_id` INTEGER NOT NULL, FOREIGN KEY(`timeframe_id`)
        REFERENCES `Timeframe`(`timeframe_id`)
        ON UPDATE NO ACTION ON DELETE SET NULL
);


CREATE INDEX IF NOT EXISTS `index_Notification_summary` ON `Notification` (`summary`);

CREATE INDEX IF NOT EXISTS `index_Notification_timeframe_id` ON `Notification` (`timeframe_id`);

```

[docs/sql/ddl.sql](docs/sql/ddl.sql)