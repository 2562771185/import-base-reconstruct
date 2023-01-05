package com.tjhq.wsjrj.mjz.importbase.utils;

//import weaver.general.GCONST;
//import weaver.general.TimeUtil;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;


/**
 * 日志处理类
 * @author wwq
 * @version 1.0
 */
public class YCLogUtil {
    /** 日志管理器缓存对象 **/
    private static Map<String, YCLogUtil> logManager = new HashMap<String, YCLogUtil>();
    /** 日志模式  run:运行模式  debug:调试模式 **/
    private String mode = "run";
    /** 日志文件名 **/
    private String logFileName;
    /** 日志所在目录名 **/
    private String logDirName;
    /** 调用类类型 **/
    private Type t;
    /** 日志缓存串 **/
    private StringBuffer logCacheString = new StringBuffer();
    /** 日志缓存大小（单位：字符长度） **/
    private int cacheLen = 1;
    /** 日志当前行号 **/
    private int rowCount = 0;

    /**
     * 构造函数
     * @param t 输出类名
     * @param logFileName 日志文件名
     * @param logDirName 日志目录名
     */
    private YCLogUtil(Type t, String logFileName, String logDirName){
        this.t = t;
        this.logFileName = logFileName;
        this.logDirName = logDirName;
    }

    /**
     * 获取默认日志对象
     * @return
     */
    public static YCLogUtil log(){
        return log(null, "dev", "dev");
    }

    /**
     * 获取默认日志对象
     * @return
     */
    public static YCLogUtil log(Type t){
        return log(t, "dev", "dev");
    }

    /**
     * 获取日志对象
     * @param logFileName 日志文件名
     * @param logDirName 日志目录名
     * @return
     */
    public static YCLogUtil log(String logFileName, String logDirName){
        return log(null, logFileName, logDirName);
    }

    /**
     * 获取日志对象
     * @param t 输出类名
     * @param logFileName 日志文件名
     * @param logDirName 日志目录名
     * @return
     */
    public static YCLogUtil log(Type t, String logFileName, String logDirName){
        if("".equals(logFileName) || logFileName == null){
            logFileName = "dev";
        }
        if("".equals(logDirName) || logDirName == null){
            logDirName = "dev";
        }
        String key = logFileName + "_" + logDirName;
        if(logManager.containsKey(key)){
            return logManager.get(key);
        } else {
            YCLogUtil lu = new YCLogUtil(t, logFileName, logDirName);
            logManager.put(key, lu);
            return lu;
        }
    }

    /**
     * 开始批量输出日志
     * @param cacheLen 日志输出缓存长度，字节
     */
    public void beginBatch(int cacheLen){
        this.cacheLen = cacheLen;
    }

    /**
     * 开始批量输出日志
     */
    public void beginBatch(){
        this.cacheLen = 1024 * 1024;
    }

    /**
     * 结束批量输出日志
     */
    public void endBatch(){
        this.cacheLen = 1;
        this.writeToFile();
    }

    /**
     * 输出日志
     * @param msg 日志信息
     * @param t 异常对象
     */
    public void info(String msg, Throwable t){
        info(msg, t, true);
    }

    /**
     * 输出日志
     * @param msg 日志信息
     * @param t 异常对象
     * @param isShow 是否显示日志
     */
    public void info(String msg, Throwable t, boolean isShow){
        if(!isShow){
            return;
        }
        this.logCacheString.append(getTitle()).append(msg).append("\r\n");
        if(t != null){
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try{
                t.printStackTrace(new PrintStream(baos));
                this.logCacheString.append(baos.toString());
            }finally{
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //写入文件
        if(this.logCacheString.length() >= this.cacheLen){
            writeToFile();
        }
    }

    /**
     * 输出日志
     * @param msg 日志信息
     * @param isShow 是否显示日志
     */
    public void info(String msg, boolean isShow){
        info(msg, null, isShow);
    }

    /**
     * 输出日志
     * @param msg 日志信息
     */
    public void info(String msg){
        info(msg, null);
    }

    /**
     * 输出日志
     */
    public void info(){
        info("", null);
    }

    /**
     * 输出日志
     * @param msg 日志信息
     * @param t 异常对象
     */
    public void debug(String msg, Throwable t){
        if("debug".equals(this.mode)){
            info(msg, t);
        }
    }

    /**
     * 输出日志
     * @param msg 日志信息
     */
    public void debug(String msg){
        debug(msg, null);
    }

    /**
     * 输出日志
     */
    public void debug(){
        debug("", null);
    }

    /**
     * 获取日志头
     * @return
     */
    public String getTitle(){
        rowCount++;
        String curDate = DateUtil.formatData("yyyy-MM-dd HH:mm:ss.SSS");
        String className = "";
        if(t != null){

            className = ((Class<?>)t).getName() + " ";
        }
        return "[" + rowCount + " " + curDate + " " + className + "] - ";
    }

    /**
     * 写入文件
     */
    public void writeToFile(){
        String rootPath =  getRootPath();
        System.out.println("rootPath="+rootPath);
        String logPath = rootPath + "log" + File.separator + logDirName + File.separator;
        String fileName = logFileName + DateUtil.formatData("_yyyyMMdd") + ".log";
        File dir = new File(logPath);
        try{
            System.out.println("logPath="+logPath);
            if(!dir.exists()){
                dir.mkdirs();
            }
            //写文件
            FileWriter writer = null;
            try {
                writer = new FileWriter(logPath + fileName, true);
                writer.write(this.logCacheString.toString());
                this.logCacheString = new StringBuffer();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if(writer != null){
                        writer.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }


    /**
     * 输出所有缓存
     */
    public static void flush(){
        for(String key : logManager.keySet()){
            logManager.get(key).writeToFile();
        }
    }

    /**
     * 获取项目绝对路径
     * @return
     */
    public static String getRootPath(){
        //return System.getProperty("user.dir");
        String rootPath = YCLogUtil.class.getResource("").toString();
        try {//中文路径处理
            rootPath = java.net.URLDecoder.decode(rootPath, "utf-8");
        }catch (Exception e){}
        if(rootPath.length() > 0){
            rootPath = rootPath.replace("file:/", "");
            int index = rootPath.indexOf("WEB-INF/classes/");
            if(index >= 0){
                rootPath = rootPath.substring(0, index);
            }
            index = rootPath.indexOf("classbean/");
            if(index >= 0){
                rootPath = rootPath.substring(0, index);
            }
            rootPath = rootPath.replace("/", File.separator);
            if(rootPath.indexOf(":") < 0 && !rootPath.startsWith("/")){
                rootPath = "/" + rootPath;
            }
        }
        return rootPath;
    }

    public static void main(String[] args) {
//		System.out.println(YCLogUtil.class.getName());
        String rootPath = getRootPath();
        System.out.println("rootPath = " + rootPath);
//        YCLogUtil.log(YCLogUtil.class).info("测试1");
//        YCLogUtil.log().info("测试2");
//        YCLogUtil.log().info("测试3");
//        YCLogUtil.flush();
    }
}