package com.example.web.service;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * Created by 鹏飞 on 2017/2/28.
 */
@Service
public class ProviderServiceImpl implements ProviderService {

	public String hello(){
		return "hello";
	}

}
