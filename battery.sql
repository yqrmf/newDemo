CREATE DATABASE battery;

USE battery;

DROP TABLE IF EXISTS vehicles;
CREATE TABLE vehicles (
    vid VARCHAR(16) NOT NULL,
    car_id INT NOT NULL,
    battery_type ENUM('三元电池', '铁锂电池') NOT NULL,
    total_mileage FLOAT,
    battery_health FLOAT,
    PRIMARY KEY (vid)
);
INSERT INTO vehicles (vid, car_id, battery_type, total_mileage, battery_health) 
VALUES (SUBSTRING(UUID(), 1, 16), 1, '三元电池', 100, 100),
		(SUBSTRING(UUID(), 1, 16), 2, '铁锂电池', 600, 95),
		(SUBSTRING(UUID(), 1, 16), 3, '三元电池', 300, 98);

/*select * from vehicles;*/


DROP TABLE IF EXISTS rules;
CREATE TABLE rules (
    id INT AUTO_INCREMENT,
    rule_number INT NOT NULL,
    rule_name VARCHAR(100) NOT NULL,
    battery_type ENUM('三元电池', '铁锂电池') NOT NULL,
    signal_mi FLOAT,
    signal_ma FLOAT,
    alarm_level INT NOT NULL,
    PRIMARY KEY (id)
);
INSERT INTO rules (id, rule_number, rule_name, battery_type, signal_mi, signal_ma, alarm_level)
VALUES (1, 1, '电压差报警', '三元电池', 5, 9999, 0),
		(2, 1, '电压差报警', '三元电池', 3, 5, 1),
		(3, 1, '电压差报警', '三元电池', 1, 3, 2),
		(4, 1, '电压差报警', '三元电池', 0.6, 1, 3),
		(5, 1, '电压差报警', '三元电池', 0.2, 0.6, 4),
		(6, 1, '电压差报警', '三元电池', 0, 0.2, 6),

		(7, 1, '电压差报警', '铁锂电池', 2, 9999, 0),
		(8, 1, '电压差报警', '铁锂电池', 1, 2, 1),
		(9, 1, '电压差报警', '铁锂电池', 0.7, 1, 2),
		(10, 1, '电压差报警', '铁锂电池', 0.4, 0.7, 3),
		(11, 1, '电压差报警', '铁锂电池', 0.2, 0.4, 4),
		(12, 1, '电压差报警', '铁锂电池', 0, 0.2, 6),

		(13, 2, '电流差报警', '三元电池', 3, 9999, 0),
		(14, 2, '电流差报警', '三元电池', 1, 3, 1),
		(15, 2, '电流差报警', '三元电池', 0.2, 1, 2),
		(16, 2, '电流差报警', '三元电池', 0, 0.2, 6),

		(17, 2, '电流差报警', '铁锂电池', 1, 9999, 0),
		(18, 2, '电流差报警', '铁锂电池', 0.5, 1, 1),
		(19, 2, '电流差报警', '铁锂电池', 0.2, 0.5, 2),
		(20, 2, '电流差报警', '铁锂电池', 0, 0.2, 6);

/*select * from rules;*/


-- 使用条件查询获取 alert_rule
/*SELECT alarm_level
FROM rules
WHERE rule_number = 1
  AND battery_type = '三元电池'
  AND 1 >=signal_mi
  AND 1 < signal_ma;*/

