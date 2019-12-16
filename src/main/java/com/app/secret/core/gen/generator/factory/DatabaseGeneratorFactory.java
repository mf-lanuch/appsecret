package com.app.secret.core.gen.generator.factory;

import java.sql.SQLException;
import java.util.List;

import com.app.secret.core.gen.generator.util.CreateBean;

/**
 * @TODO
 * @auth kexiaohong
 * @date 2019年2月28日
 * 
 */
public class DatabaseGeneratorFactory {

	public static void DatabaseGenerate(String application, String packageName, String modelName, String codeName, String controllerEntityPackage, String keyType) throws SQLException{
		List<String> tableNames = getAllTableName(application);
		for(String tableName: tableNames) {
			CodeGenerateFactory.codeGenerate(application, tableName, packageName, modelName, codeName, controllerEntityPackage, keyType);
		}
	}

	private static List<String> getAllTableName(String application) throws SQLException {
		return CreateBean.getInstance().getTables();
	}
}
