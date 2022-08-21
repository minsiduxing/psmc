package priv.guochun.psmc.system.framework.activiti.util;


import de.odysseus.el.ExpressionFactoryImpl;
import de.odysseus.el.util.SimpleContext;

import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import java.util.List;
import java.util.Map;

public class FlowElContans {


	public static boolean isConditionOfBool(String el, Map<String,Object> data) {
		ExpressionFactory expressionFactory = new ExpressionFactoryImpl();
		SimpleContext simpleContext = new SimpleContext();
		for (String dataKey : data.keySet()) {
			simpleContext.setVariable(dataKey, expressionFactory.createValueExpression(data.get(dataKey), String.class));
		}
		ValueExpression e = expressionFactory.createValueExpression(simpleContext, el, boolean.class);
		return (Boolean) e.getValue(simpleContext);
	}

	public static String isConditionOfString(String el, Map<String,Object> data) {
		ExpressionFactory expressionFactory = new ExpressionFactoryImpl();
		SimpleContext simpleContext = new SimpleContext();
		for (String dataKey : data.keySet()) {
			simpleContext.setVariable(dataKey, expressionFactory.createValueExpression(data.get(dataKey), String.class));
		}
		ValueExpression e = expressionFactory.createValueExpression(simpleContext, el, String.class);
		return (String) e.getValue(simpleContext);
	}

	public static List isConditionOfList(String el, Map<String,Object> data) {
		ExpressionFactory expressionFactory = new ExpressionFactoryImpl();
		SimpleContext simpleContext = new SimpleContext();
		for (String dataKey : data.keySet()) {
			simpleContext.setVariable(dataKey, expressionFactory.createValueExpression(data.get(dataKey), List.class));
		}
		ValueExpression e = expressionFactory.createValueExpression(simpleContext, el, List.class);
		return (List) e.getValue(simpleContext);
	}
}
