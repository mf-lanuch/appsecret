package com.app.secret.core.gen.main;


import com.app.secret.core.gen.generator.def.FtlDef;
import com.app.secret.core.gen.generator.factory.DatabaseGeneratorFactory;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * @TODO 自动化生成代码(整个数据库)
 * @auth kexiaohong
 * @date 2019年2月28日
 * 
 */
public class DatabaseGenerator {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("请输入数据库/包名/模块名(\"/\"隔开):");
		String tableName = sc.next();
		sc.close();
		if (tableName.contains("/"))
			try {
				config(tableName);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		else
			System.out.println("输入的模块和表名不正确！");
	}

	private static void config(String tableName) throws SQLException {
		String codeName = "系统配置";// 中文注释 当然你用英文也是可以的
		String entityPackage = "admin";// 实体包
		String keyType = FtlDef.KEY_TYPE_01;// 主键生成方式 01:UUID 02:自增
		String[] args = tableName.split("/");
		DatabaseGeneratorFactory.DatabaseGenerate(args[0], args[1], args[2], codeName, entityPackage, keyType);
	}

}
