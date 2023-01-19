package kh.spring.validate;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class FileVaildator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		UploadFile file = (UploadFile) target;

		if (file.getMpfile().getSize() == 0) {
			errors.rejectValue("mpfile", "fileNPE", "Please select a file");
		}

	}

}
