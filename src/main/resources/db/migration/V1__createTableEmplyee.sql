CREATE TABLE `EMPLOYEE`
(
    `id` int(20)  NOT NULL auto_increment,
    `name`     VARCHAR(100),
    `email`    VARCHAR(100),
    PRIMARY KEY (
                 `id`
        )
) ROW_FORMAT = Default;