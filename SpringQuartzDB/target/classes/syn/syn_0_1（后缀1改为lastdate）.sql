BEGIN
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;
	# 定义SQL异常时将t_error置为1
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	begin
		get diagnostics condition 1 msg = message_text;
		set t_error = 1;
	end;
	# 开启事务
	START TRANSACTION;

	if (select COUNT(*) from information_schema.TABLES where table_name='tmp_bj1')>0 then
		set @newname = (select date_format(str_to_date(max(lastvenddate),'%Y-%m-%d'),'%Y%m%d') from tmp_bj1);

		SET @strsql = CONCAT('ALTER TABLE tmp_bj1 RENAME TO tmp_bj',@newname);
		PREPARE stmt FROM @strsql;
		EXECUTE stmt;
		deallocate prepare stmt;
		INSERT INTO tmp_centlec (table_name, execute_status, remark) VALUES (CONCAT('tmp_bj',@newname), 0, 'start');

		#0-修改tmp1为tmp当前日期
		if (select COUNT(*) from information_schema.TABLES where table_name='tmp_yh1')>0 then
			SET @strsql = CONCAT('ALTER TABLE tmp_yh1 RENAME TO tmp_yh',@newname);
			PREPARE stmt FROM @strsql;
			EXECUTE stmt;
			deallocate prepare stmt;
			INSERT INTO tmp_centlec (table_name, execute_status, remark) VALUES (CONCAT('tmp_yh',@newname), 0, 'start');
		end if;

		if (select COUNT(*) from information_schema.TABLES where table_name='tmp_zw1')>0 then
			SET @strsql = CONCAT('ALTER TABLE tmp_zw1 RENAME TO tmp_zw',@newname);
			PREPARE stmt FROM @strsql;
			EXECUTE stmt;
			deallocate prepare stmt;
			INSERT INTO tmp_centlec (table_name, execute_status, remark) VALUES (CONCAT('tmp_zw',@newname), 0, 'start');
		end if;

		if (select COUNT(*) from information_schema.TABLES where table_name='tmp_ljz1')>0 then
			SET @strsql = CONCAT('ALTER TABLE tmp_ljz1 RENAME TO tmp_ljz',@newname);
			PREPARE stmt FROM @strsql;
			EXECUTE stmt;
			deallocate prepare stmt;
			INSERT INTO tmp_centlec (table_name, execute_status, remark) VALUES (CONCAT('tmp_ljz',@newname), 0, 'start');
		end if;
	end if;

	IF t_error = 1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;
	SELECT t_error, msg;
END