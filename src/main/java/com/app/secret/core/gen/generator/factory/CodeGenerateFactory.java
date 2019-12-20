package com.app.secret.core.gen.generator.factory;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.app.secret.core.gen.generator.model.ColumnData;
import com.app.secret.core.gen.generator.page.parser.CommonPageParser;
import com.app.secret.core.gen.generator.util.CodeResourceUtil;
import com.app.secret.core.gen.generator.util.CommUtil;
import com.app.secret.core.gen.generator.util.CreateBean;
import org.apache.velocity.VelocityContext;

public class CodeGenerateFactory
{
  private static final Log log = LogFactory.getLog(CodeGenerateFactory.class);

  //private static String buss_package = CodeResourceUtil.bussiPackage;
  private static String projectPath = getProjectPath();

  public static void codeGenerate(String application,String tableName, String packageName, String modelName, String codeName, String controllerEntityPackage, String keyType){
	  codeGenerate(application,tableName, packageName, modelName, codeName,"", controllerEntityPackage, keyType);
  }
  
  
  public static void codeGenerate(String application,String tableName, String packageName, String modelName, String codeName, String entityPackage, String controllerEntityPackage, String keyType)
  {
	CreateBean createBean = CreateBean.getInstance();
    String buss_package = application;

    String className = createBean.getTablesNameToClassName(tableName);
    String lowerName = className.substring(0, 1).toLowerCase() + className.substring(1, className.length());

    String srcPath = projectPath + CodeResourceUtil.source_root_package + "/";

    String pckPath = srcPath + "com/"+ packageName +"/";
    String resPath = projectPath + CodeResourceUtil.bussiResourceUrl + "/";

    String webPath = projectPath + CodeResourceUtil.web_root_package + "/view/" + buss_package + "/";
    String entityPath=(entityPackage==null||"".equals(entityPackage))?"": entityPackage + "/";
    
    String modelPath = modelName + "/entity/" + entityPath + className + ".java";
//    String paramPath =  "param/" + entityPath + className + "Param.java";
    String servicePath = modelName + "/services/" + entityPath + className + "Service.java";
    String daoPath = modelName + "/mapper/" + entityPath + className + "Mapper.java";
    String serviceImplPath = modelName + "/services/impl/" + entityPath + className + "ServiceImpl.java";
    String controllerPath = modelName + "/controller/" + className + "Controller.java";
    String mapperPath = "mapper/" + className + ".xml";
    webPath = modelName + "/" + webPath + entityPath;

//    String jspPath = lowerName + ".jsp";

    VelocityContext context = new VelocityContext();
    context.put("className", className);
    context.put("modelName", modelName);
    context.put("packageName", packageName);
    context.put("lowerName", lowerName);
    context.put("codeName", codeName);
    context.put("tableName", tableName);
    context.put("bussPackage", buss_package);
    context.put("applicationUpper", buss_package.toUpperCase());
    context.put("application", buss_package.substring(0, 1).toUpperCase() + buss_package.substring(1, buss_package.length()));
    context.put("entityPackage", entityPackage==""?null:entityPackage);
    context.put("controllerEntityPackage", controllerEntityPackage==""?null:controllerEntityPackage);
    context.put("keyType", keyType);
    try
    {
      context.put("feilds", createBean.getBeanFeilds(tableName));
      context.put("firstGet", createBean.firstGet);
      context.put("keyProperty", createBean.keyProperty);
    } catch (Exception e) {
      e.printStackTrace();
    }

    try
    {
      Map<String, Object> sqlMap = createBean.getAutoCreateSql(tableName);
      List<ColumnData> columnDatas = createBean.getColumnDatas(tableName);
      context.put("columnDatas", columnDatas);
      context.put("primaryColumn", columnDatas.get(0).getColumnName());
      context.put("formatPrimaryColumn", CommUtil.formatName(columnDatas.get(0).getColumnName()));
      context.put("SQL", sqlMap);
    } catch (Exception e) {
      e.printStackTrace();
      return;
    }

    CommonPageParser.WriterPage(context, "EntityTemplate.ftl", pckPath, modelPath);
//    CommonPageParser.WriterPage(context, "ParamTemplate.ftl", pckPath, paramPath);
    CommonPageParser.WriterPage(context, "MapperTemplate.ftl", pckPath, daoPath);
    CommonPageParser.WriterPage(context, "ServiceTemplate.ftl", pckPath, servicePath);
    CommonPageParser.WriterPage(context, "ServiceImplTemplate.ftl", pckPath, serviceImplPath);
    CommonPageParser.WriterPage(context, "MapperTemplate.xml", resPath, mapperPath);
    CommonPageParser.WriterPage(context, "ControllerTemplate.ftl", pckPath, controllerPath);

   // CommonPageParser.WriterPage(context, "jspTemplate.ftl", webPath, jspPath);

    log.info("----------------------------\u4EE3\u7801\u751F\u6210\u5B8C\u6BD5---------------------------");
  }

  public static String getProjectPath()
  {
    String path = System.getProperty("user.dir").replace("\\", "/") + "/";
    return path;
  }
}