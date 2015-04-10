package com.sanluan.common.dialect;

import java.sql.Types;

import org.hibernate.dialect.MySQLDialect;
import org.hibernate.type.StandardBasicTypes;

/**
 * @author zhangxd
 *
 */
public class MyDialect extends MySQLDialect{

	protected void registerVarcharTypes() {
		super.registerVarcharTypes();
		registerColumnType(Types.CHAR, 255, "char($l)");
		registerHibernateType( Types.CHAR, StandardBasicTypes.STRING.getName() );
	}

}
