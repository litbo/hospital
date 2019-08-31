package com.litbo.hospital.lifemanage.dao.provider;

import com.google.common.base.CaseFormat;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.scripting.xmltags.XMLLanguageDriver;
import org.apache.ibatis.session.Configuration;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Administrator
 * @date 2018/3/9
 * 自定义Select注解,用于动态生成Select语句
 */

public class SimpleSelectLangDriver extends XMLLanguageDriver implements LanguageDriver {
    /**
     * Pattern静态申明
     */
    private final Pattern inPattern = Pattern.compile("\\(#\\{(\\w+)\\}\\)");
    /**
     * 实现自定义Select注解
     *
     * @param configuration 配置参数
     * @param script        入参
     * @param parameterType 参数类型
     * @return 转换后的SqlSource
     */

    @Override
    public SqlSource createSqlSource(Configuration configuration, String script, Class<?> parameterType) {
        Matcher matcher = inPattern.matcher(script);
        if (matcher.find()) {
            StringBuilder sb = new StringBuilder();
            sb.append("<where>");
            for (Field field : parameterType.getDeclaredFields()) {
                String tmp = "<if test=\"_field != null\"> AND _column=#{_field}</if>";
                sb.append(tmp.replaceAll("_field", field.getName()).replaceAll("_column",
                        CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, field.getName())));
            }
            sb.append("</where>");
            script = matcher.replaceAll(sb.toString());
            script = "<script>" + script + "</script>";
        }
        return super.createSqlSource(configuration, script, parameterType);
    }

}
