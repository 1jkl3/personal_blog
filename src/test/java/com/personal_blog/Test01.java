package com.personal_blog;

import org.junit.Test;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

@Component
public class Test01 extends PersonalBlogApplicationTests {
    @Test
    public void test() throws FileNotFoundException {
        String path = ResourceUtils.getURL("classpath:").getPath();
        System.out.println(new File(path));
    }
    @Test
    public void t(){
        String a="1";

        Integer i=1;
        Integer[] integer= {i};
    }

}
