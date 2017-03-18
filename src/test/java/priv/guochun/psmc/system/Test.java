package priv.guochun.psmc.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test
{

    protected static final  Logger logger  = LoggerFactory.getLogger(Test.class);
    
    public void  testExcption(){
        String aa = null;
        System.out.println(aa.toLowerCase());
    }
    
    public void  testExcption2(){
        try{
            testExcption();
        }catch(Exception e){
            logger.error(" test print log "+e);
            //throw new RuntimeException("bbbbbbbbbbbbbbbbbbbbbbbbb  ");
            throw new RuntimeException("message ",e);
        }
    }
    
    
    public static void main(String[] args){
        Test t = new Test();
        t.testExcption2();
    }
    
}
