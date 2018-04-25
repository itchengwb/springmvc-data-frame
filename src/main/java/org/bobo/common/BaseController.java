package org.bobo.common;


import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

/***
 * 公共controller
 * <p>Date: 2015-03-03 13:50:12</p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: qunar.com</p>
 *
 */
public abstract class BaseController {
	
	private JsonMapper mapper = JsonMapper.buildNonNullMapper();
	public Object getBizParam(HttpServletRequest request,Class classType){
		String bizParamStr = ParameterUtil.getBizParameter(request);
		if(StringUtils.isNotBlank(bizParamStr)){
		   return mapper.fromJson(bizParamStr, classType);
		}
		return null;
	}

}
