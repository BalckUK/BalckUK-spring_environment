package kh.spring.util;

import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Service;

@Service
public class Encoding {
	
	public String Encodingmethod(String str) throws UnsupportedEncodingException {
		return new String(new String(str).getBytes("ISO-8859-1"), "utf-8");
	}

}
