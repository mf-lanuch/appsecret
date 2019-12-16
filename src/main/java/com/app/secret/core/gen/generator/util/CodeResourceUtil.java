package com.app.secret.core.gen.generator.util;

import java.util.ResourceBundle;

public class CodeResourceUtil
{
  private static final ResourceBundle bundle = ResourceBundle.getBundle("conf/database");
  private static final ResourceBundle bundlePath = ResourceBundle.getBundle("conf/config");

  public static String DIVER_NAME = "com.mysql.jdbc.Driver";

  public static String URL = "jdbc:mysql://www.lrans.xin:3306/appsecret?useUnicode=true&characterEncoding=UTF-8";

  public static String USERNAME = "root";

  public static String PASSWORD = "123456";

  public static String DATABASE_NAME = "appsecret";

  public static String DATABASE_TYPE = "mysql";
  public static String DATABASE_TYPE_MYSQL = "mysql";
  public static String DATABASE_TYPE_ORACLE = "oracle";

  public static String UI_FIELD_REQUIRED_NUM = "4";

  public static String UI_FIELD_SEARCH_NUM = "3";

  public static String web_root_package = "";

  public static String source_root_package = "src";

  //public static String bussiPackage = "sun";
  //public static String bussiPackageUrl = "sun";
  public static String bussiResourceUrl = "sun";

  public static String entity_package = "entity";

 // public static String page_package = "page";

  //public static String ENTITY_URL = source_root_package + "/" + bussiPackageUrl + "/" + entity_package + "/";

  //public static String PAGE_URL = source_root_package + "/" + bussiPackageUrl + "/" + page_package + "/";

  //public static String ENTITY_URL_INX = bussiPackage + "." + entity_package + ".";

  //public static String PAGE_URL_INX = bussiPackage + "." + page_package + ".";
  public static String TEMPLATEPATH;
  //public static String CODEPATH = source_root_package + "/" + bussiPackageUrl + "/";

  //public static String JSPPATH = web_root_package + "/" + bussiPackageUrl + "/";
  public static String GENERATE_TABLE_ID;
  public static String GENERATE_UI_FILTER_FIELDS;
  public static String SYSTEM_ENCODING;

  static
  {
    DIVER_NAME = getDIVER_NAME();
    URL = getURL();
    USERNAME = getUSERNAME();
    PASSWORD = getPASSWORD();
    DATABASE_NAME = getDATABASE_NAME();

    SYSTEM_ENCODING = getSYSTEM_ENCODING();
    TEMPLATEPATH = getTEMPLATEPATH();
    source_root_package = getSourceRootPackage();
    web_root_package = getWebRootPackage();
    web_root_package.replace(".", "/");
    //bussiPackage = getBussiPackage();
    //bussiPackageUrl = bussiPackage.replace(".", "/");
    bussiResourceUrl = getResourcePath();
    bussiResourceUrl = bussiResourceUrl.replace(".", "/");

    GENERATE_TABLE_ID = getGenerate_table_id();

    UI_FIELD_SEARCH_NUM = getUi_search_filed_num();

    if ((URL.indexOf("mysql") >= 0) || (URL.indexOf("MYSQL") >= 0))
      DATABASE_TYPE = DATABASE_TYPE_MYSQL;
    else if ((URL.indexOf("oracle") >= 0) || (URL.indexOf("ORACLE") >= 0)) {
      DATABASE_TYPE = DATABASE_TYPE_ORACLE;
    }

    source_root_package = source_root_package.replace(".", "/");
  }

  public static final String getDIVER_NAME()
  {
    return bundle.getString("diver_name");
  }

  public static final String getURL()
  {
    return bundle.getString("url");
  }

  public static final String getUSERNAME()
  {
    return bundle.getString("username");
  }

  public static final String getPASSWORD()
  {
    return bundle.getString("password");
  }

  public static final String getDATABASE_NAME()
  {
    return bundle.getString("database_name");
  }

  private static String getResourcePath() {
	    return bundlePath.getString("resource_package");
	  }

  public static final String getEntityPackage()
  {
    return bundlePath.getString("entity_package");
  }

  public static final String getPagePackage()
  {
    return bundlePath.getString("page_package");
  }

  public static final String getTEMPLATEPATH()
  {
    return bundlePath.getString("templatepath");
  }

  public static final String getSourceRootPackage()
  {
    return bundlePath.getString("source_root_package");
  }

  public static final String getWebRootPackage()
  {
    return bundlePath.getString("webroot_package");
  }

  public static final String getSYSTEM_ENCODING()
  {
    return bundlePath.getString("system_encoding");
  }

  public static final String getGenerate_table_id()
  {
    return bundlePath.getString("generate_table_id");
  }

  public static final String getGenerate_ui_filter_fields()
  {
    return bundlePath.getString("generate_ui_filter_fields");
  }

  public static final String getUi_search_filed_num()
  {
    return bundlePath.getString("ui_search_filed_num");
  }

  public static final String getUi_field_required_num()
  {
    return bundlePath.getString("ui_field_required_num");
  }
}