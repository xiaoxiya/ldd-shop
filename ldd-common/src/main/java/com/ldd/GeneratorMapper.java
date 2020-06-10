package com.ldd;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoxiya
 * @date 2020/6/9 22:42
 * @describe 使用mybatis自动生成dao和mapper.xml
 */
public class GeneratorMapper {
    public static void main(String[] args) throws Exception {
        //执行过程中共的警告信息
        List<String> warings = new ArrayList<>();
        //生成重复代码，覆盖原代码
        boolean overwrite = true;
        //读取mybatis配置文件
        InputStream inputStream = GeneratorMapper.class.getResourceAsStream("/mybatis-generator.xml");
        ConfigurationParser cp = new ConfigurationParser(warings);
        Configuration configuration = cp.parseConfiguration(inputStream);
        inputStream.close();
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        //创建mybatisgenerator
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration, callback, warings);
        //执行生成代码
        myBatisGenerator.generate(null);
        //输出警告信息
        for (String warning : warings) {
            System.out.println(warning);
        }
    }

}
