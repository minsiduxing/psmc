package priv.guochun.psmc.system;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"classpath:/**/applicationContext_*.xml"})

public abstract class BaseTestClass
{
    
        @Autowired 
        protected SqlSessionTemplate sqlSession;

        @Test
        public abstract void test();
}
