package priv.guochun.psmc.authentication.license.controller;

import java.io.File;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import priv.guochun.psmc.authentication.license.sevice.LicenseReaderService;

@RequestMapping("/license")
@Controller
public class ReadLicenseController {
	@Autowired
	private LicenseReaderService licenseReaderService;

	@RequestMapping("/load")
	public ModelAndView load(
			@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request) {

		ModelAndView view = null;
		HashMap<String, Object> result = new HashMap<String, Object>();

		if (file == null || file.isEmpty()) {
			result.put("stat", -2);
			result.put("msg", "空文件");
			view = new ModelAndView("redirect:/license.jsp", result);
			return view;
		}

		String path = request.getSession().getServletContext().getRealPath("/")
				+ "upload";

		File targetFile = new File(path, "license.lic");
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		// 保存
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}

		boolean stat = licenseReaderService.verify(path + "/license.lic");

		if (stat) {
			view = new ModelAndView("redirect:/index.jsp");
		} else {
			result.put("stat", -1);
			result.put("msg", "证书验证失败");
			view = new ModelAndView("redirect:/license.jsp", result);
		}

		return view;
	}
}
