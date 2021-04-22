package com.project.stuckyi.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.project.stuckyi.domain.TransWriteDTO;

public class TransValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		System.out.println("supports(" + clazz.getName() + ")");
		return TransWriteDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		TransWriteDTO dto = (TransWriteDTO)target;
		
		//오류 검출할것들
		
		String addr = dto.getTransAddr();
		if(addr == null || addr.trim().isEmpty()) {
			System.out.println("주소지를 입력해주세요");
		} else {
			System.out.println("주소지 입력완료.");
		}
		
		String callname = dto.getTransComment();
		if(callname == null || callname.trim().isEmpty()) {
			System.out.println("탑승자 이름을 입력해주세요");
		} else {
			System.out.println("탑승자 이름 입력완료.");
		}

	}
}
