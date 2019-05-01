package com.bigfish.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Copyright: Copyright (c) 2019 LanRu-Caifu
 *
 * @ClassName: ReadPropertiesUtil
 * @Description: java读取properties文件
 *                  1. 使用ClassLoader读取配置文件
 *                  2. 使用InputStream读取配置文件
 *                  3. 使用ResourceBundle读取配置文件
 * @author: liusheng
 * @date: 2019-05-01 22:08
 * @version: v1.0.0
 * ---------------------------------------------------------*
 * Modification History:
 * Date          Author         Version         Description
 * ---------------------------------------------------------*
 * 2019-05-01   liusheng        v1.0.0          Modify reason
 */
public class ReadPropertiesUtil {


    /**
     * @MethodName: getClassLoaderProperties
     * @Description: 通过类加载来读取配置文件,
     *          注意: 该方式只能读取类路径下的配置文件，有局限但是如果配置文件在类路径下比较方便
     * @return：java.util.Map<java.lang.String,java.lang.String>
     * @throws：IOException io异常
     * @version: v1.0.0
     * @author: liusheng
     * @date: 2019-05-01 22:25
     * <p>
     * Modification History:
     * Date          Author         Version         Description
     * ---------------------------------------------------------*
     * 2019-05-01   liusheng        v1.0.0          Modify reason
     */
    public static Map<String, String> getClassLoaderProperties() {

        Map<String, String> resultMap = new HashMap<>(16);
        Properties properties = new Properties();
        // 使用ClassLoader加载properties配置文件生成对应的输入流
        InputStream in = null;
        try {
            // 使用ClassLoader加载properties配置文件生成对应的输入流
            in = ReadPropertiesUtil.class.getClassLoader().getResourceAsStream("config/db.properties");
            // 使用properties对象加载输入流
            properties.load(in);
            // 获取key对应的value的值
            resultMap.put("driverClass", properties.getProperty("jdbc.driverClass"));
            resultMap.put("url", properties.getProperty("jdbc.url"));
            resultMap.put("user", properties.getProperty("jdbc.password"));
            resultMap.put("password", properties.getProperty("jdbc.password"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return resultMap;
    }

    /**
     * @MethodName: getInputStreamProperties
     * @Description: 基于 InputStream 读取配置文件
     *          注意：该方式的优点在于可以读取任意路径下的配置文件
     * @return：java.util.Map<java.lang.String,java.lang.String>
     * @throws：FileNotFoundException IOException
     * @version: v1.0.0
     * @author: liusheng
     * @date: 2019-05-01 22:33
     * <p>
     * Modification History:
     * Date          Author         Version         Description
     * ---------------------------------------------------------*
     * 2019-05-01   liusheng        v1.0.0          Modify reason
     */
    public static Map<String, String> getInputStreamProperties() {

        Properties properties = new Properties();
        Map<String, String> resultMap = new HashMap<>(16);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("springjdbc/src/main/resources/config/db.properties"));
            properties.load(br);
            // 获取key对应的value的值
            resultMap.put("driverClass", properties.getProperty("jdbc.driverClass"));
            resultMap.put("url", properties.getProperty("jdbc.url"));
            resultMap.put("user", properties.getProperty("jdbc.password"));
            resultMap.put("password", properties.getProperty("jdbc.password"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return resultMap;
    }


    /**
     * @MethodName: getResourceBundle
     * @Description: 通过 java.util.ResourceBundle 类来读取，这种方式比使用 Properties 要方便一些
     * 　　          1>通过 ResourceBundle.getBundle() 静态方法来获取（ResourceBundle是一个抽象类）,
     *                  这种方式来获取properties属性文件不需要加.properties后缀名，只需要文件名即可
     *              2>注意：在使用中遇到的最大的问题可能是配置文件的路径问题，如果配置文件入在当前类所在的包下,
     *                  那么需要使用包名限定，如：config.properties入在com.test.config包下,
     *                  则要使用com/test/config/config.properties（通过Properties来获取）或com/test/config/config（通过ResourceBundle来获取）,
     *                  属性文件在src根目录下，则直接使用config.properties或config即可
     * @return：java.util.Map<java.lang.String,java.lang.String>
     * @version: v1.0.0
     * @author: liusheng
     * @date: 2019-05-01 22:38
     * <p>
     * Modification History:
     * Date          Author         Version         Description
     * ---------------------------------------------------------*
     * 2019-05-01   liusheng        v1.0.0          Modify reason
     */
    public static Map<String, String> getResourceBundle() {

        Map<String, String> resultMap = new HashMap<>(16);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("config/db");
        resultMap.put("driverClass", resourceBundle.getString("jdbc.driverClass"));
        resultMap.put("url", resourceBundle.getString("jdbc.url"));
        resultMap.put("user", resourceBundle.getString("jdbc.user"));
        resultMap.put("password", resourceBundle.getString("jdbc.password"));
        return resultMap;
    }


}