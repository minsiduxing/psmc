package priv.guochun.psmc.authentication.license.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import priv.guochun.psmc.authentication.license.dao.CounterDao;

public class CheckLicenseInterceptor extends HandlerInterceptorAdapter {

	public static boolean flag = false;
	private static boolean oneTime = true;
	@Autowired
	private CounterDao counterDao;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String rest = FilenameUtils.getBaseName(request.getRequestURI());

		if (rest.equals("load")) {
			return true;
		}

		// 只在第一次请求的时候查询,如果License没过期则继续使用
		if (oneTime) {
			int count = counterDao.getCount();

			if (count < 1) {
				flag = false;
			} else {
				flag = true;
			}
			oneTime = false;
		}

		if (flag == false) {
			response.sendRedirect("/psmc/license.jsp?auth=none");
		}

		return flag;
	}
}
