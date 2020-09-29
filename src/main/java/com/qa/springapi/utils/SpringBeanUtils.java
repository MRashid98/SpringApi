package com.qa.springapi.utils;

import org.springframework.beans.BeanUtils;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SpringBeanUtils {

	public static void mergerObjects(Object source, Object target) {
		BeanUtils.copyProperties(source, target);
	}

}
