package kh.spring.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import kh.spring.service.test1Imple;
import kh.spring.service.testService;
import kh.spring.validate.FileVaildator;
import kh.spring.validate.UploadFile;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	@Autowired
	private testService testservice;

	@Autowired
	private test1Imple testImple;

	@Autowired
	private FileVaildator fileValidator;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping("/main")
	public String tilesmethod() {
		return "main";
	}

	@RequestMapping(value = "/")
	public String home() {
		System.out.println("숫자 : " + testservice.testcount());
		System.out.println("리스트  : " + testservice.selectlistservice());
		System.out.println("다른방식 test : " + testImple.test1list());
		System.out.println("새로운 방식: " + testservice.test2DAOlist());
		return "home";
	}

	@RequestMapping(value = "/home")
	public String home2() {
		return "home";
	}

	@RequestMapping("/form")
	public String uplodForm() {
		return "upload";
	}

	@RequestMapping("/upload")
	public String fileUpload(HttpServletRequest request, Model model, UploadFile uploadFile, BindingResult result)
			throws Exception {

		fileValidator.validate(uploadFile, result);
		if (result.hasErrors()) {
			return "upload";
		}

		MultipartFile file = uploadFile.getMpfile();
		String name = file.getOriginalFilename();

		System.out.println("이름 : " + name);

		UploadFile fileObj = new UploadFile();
		fileObj.setName(name);
		fileObj.setDesc(uploadFile.getDesc());

		InputStream inputStream = null;
		OutputStream outputStream = null;

		try {
			inputStream = file.getInputStream();
			String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/resources/storage");
			System.out.println("다운로드 경로 : " + path);

			File storage = new File(path);
			if (!storage.exists()) {
				storage.mkdir();
			}

			File newFile = new File(path + "/" + name);
			if (!newFile.exists()) {
				newFile.createNewFile();
			}

			outputStream = new FileOutputStream(newFile);

			int read = 0;
			byte[] b = new byte[(int) file.getSize()];

			while ((read = inputStream.read(b)) != -1) {
				outputStream.write(b, 0, read);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		model.addAttribute("fileObj", fileObj);

		return "download";
	}

	@ResponseBody
	@RequestMapping("/download")
	public byte[] fileDownload(HttpServletRequest request, HttpServletResponse response, String name) {

		byte[] down = null;

		try {
			String path = WebUtils.getRealPath(request.getSession().getServletContext(), "resources/storage");
			File file = new File(path + "/" + name);

			down = FileCopyUtils.copyToByteArray(file);
			String filename = new String(file.getName().getBytes(), "8859_1");

			response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
			response.setContentLength(down.length);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return down;
	}

}
