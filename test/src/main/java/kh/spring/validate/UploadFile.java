package kh.spring.validate;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UploadFile {
	private String name;
	private String desc;
	private MultipartFile mpfile;
}
