package priv.guochun.psmc.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import priv.guochun.psmc.system.util.FreemarkUtil;

public class FreeMarkUtilTest {
	String freemarkerVersionNo = "2.3.23";
	String ftlPath = "/ftl";
	FreemarkUtil ftu = FreemarkUtil.getInstance(freemarkerVersionNo, ftlPath);
	Map<String,Object> root = new HashMap<String,Object>();
	String outpath= "D:\\otherproject\\psmc\\src\\test\\resources\\template";
	@Before
	public void testInt(){
		Student stu = null;
		List<Student> stus = new ArrayList<>();
		for(int i = 0;i<50;i++){
			stu = new Student("00000"+i, "test"+i, i+"", i%2==0?"男":"女");
			stus.add(stu);
		}
		root.put("stus",stus);
	}
	@Test
	public void testgetTemplate(){
		//測試輸出流
		//ftu.sprintTemplate(root, "test.ftl");
		//測試輸出到文件
		ftu.fprintTemplate(root, "test.ftl", outpath, "test.html");
	}

}
