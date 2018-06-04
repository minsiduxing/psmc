package priv.guochun.psmc.authentication.license.sevice.impl;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import priv.guochun.psmc.authentication.license.dao.CounterDao;
import priv.guochun.psmc.authentication.license.interceptors.CheckLicenseInterceptor;
import priv.guochun.psmc.authentication.license.sevice.LicenseReaderService;
import priv.guochun.psmc.authentication.license.utils.LoadLicense;

public class LicenseReaderServiceImpl implements LicenseReaderService{

	private static final  Logger logger  = LoggerFactory.getLogger(LicenseReaderService.class);
	@Autowired
	private CounterDao counterDao;

	public boolean verify(String pathname) {
	    int count = 0;
		String data = LoadLicense.getDataFromLicense(pathname);
//		
//		if (data.length() == 0) {
//			return false;
//		}

		try {
			JSONObject jo = new JSONObject(data);
			count = Integer.parseInt((String) jo.get("count"));
		} catch (JSONException e) {
			return false;
		}

		// execute counterDao
		counterDao.setCount(count);

		CheckLicenseInterceptor.flag = true;
		return true;

	}
	

	public void work() {
        if (!CheckLicenseInterceptor.flag) {
            return;
        }
        int count = counterDao.decCount();
        logger.debug("还剩"+count+"分钟");
        if (count == 0) {
            CheckLicenseInterceptor.flag = false;
        }
    }
}
