package org.tain.controller.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tain.mybatis.mappers.UserMapper;
import org.tain.utils.IpPrint;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserRestController {

	@Autowired
	private UserMapper userMapper;
		
	@RequestMapping(value = {"/user/logincheck"}, method = {RequestMethod.GET, RequestMethod.POST})
	public String userlogin(HttpEntity<String> httpEntity) throws Exception {
		String reqBody = null;
		if (Boolean.TRUE) {
			HttpHeaders reqHeaders = httpEntity.getHeaders();
			reqBody = httpEntity.getBody();
			log.info(">>>>> ip.info: " + IpPrint.get());
			log.info(">>>>> reqHeaders: " + reqHeaders.toString());
			log.info(">>>>> reqBody1: " + reqBody);
			//reqBody = URLDecoder.decode(reqBody, "utf-8");
			//log.info(">>>>> reqBody2: " + reqBody);
			//reqBody = "{\"code\": \"C001\"}";
			if (reqBody == null)
				reqBody = "{}";
		}
		
		Map<String,Object> mapOut = null;
		Map<String,Object> mapIn = null;
		if (Boolean.TRUE) {
			mapIn = new ObjectMapper().readValue(reqBody, new TypeReference<Map<String, Object>>() {});
			mapOut = this.userMapper.selectOne(mapIn);
			log.info(">>>>> mapOut: {}", mapOut);
		}
		if(mapOut != null) {
			String pwIn = (String)mapIn.get("pw");
			String pwOut = (String)mapOut.get("pw");
			if(pwIn.equals(pwOut)) {
				System.out.println("----> success");
				return "{\"msg\":\"success\"}";
			}
		}
		System.out.println("----> FAIL");
		return "{\"msg\":\"fail\"}";
	}
}

