package org.bobo.common;


import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;


public class ParameterUtil {
	//private static JsonMapper mapper = JsonMapper.buildNormalMapper();
	private static Logger LOGGER = LoggerFactory.getLogger(ParameterUtil.class);
	public static final String COMMON_PARAM_NAME = "c";
    public static final String BIZ_PARAM_NAME = "b";

	/**
	 * 获取C参数
	 * @param request
	 * @return
	 */
	/*public static CommonParam getCommonParam(HttpServletRequest request) {
		String cparam = request.getParameter(COMMON_PARAM_NAME);
        if(cparam == null) {
            return null;
        }
		String commonParam = cparam;
		CommonParam param = mapper.fromJson(commonParam, CommonParam.class);
		if (param != null) {
			param.setIp(ProcessorModule.getRemoteAddress(request));
			param.setOrialCparam(commonParam);
		}else{
            LOGGER.info(cparam);
            LOGGER.info(commonParam);
		}
		return param;
	}*/
	/**
	 * 获取B参数
	 * @param request
	 * @return
	 */
	public static String getBizParameter(HttpServletRequest request) {
		String rets = "";
		String ens = request.getParameter(BIZ_PARAM_NAME);
		if (StringUtils.isNotBlank(ens)) {
			rets = ens;
		}
		LOGGER.info("B_PARAM={}",ens);
		return rets;
	}

}
