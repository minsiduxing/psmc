package priv.guochun.psmc.system.common.city.service.impl;

import java.util.ArrayList;
import java.util.List;

import priv.guochun.psmc.system.common.city.service.TestRfCxfService;

public class TestRfCxfServiceImpl implements TestRfCxfService {

	@Override
	public List<String> getInfoMethod() {
		List<String> list = new ArrayList<String>();
		list.add("1.1");
		list.add("1.2");
		return list;
	}

}
