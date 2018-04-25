package org.bobo.common;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParser.Feature;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;


/**
 * 简单封装Jackson实现JSON<->Java Object的Mapper.
 * 
 * 封装不同的输出风格, 使用不同的builder函数创建实例.
 */
public class JsonMapper {

	private static final Logger logger = LoggerFactory.getLogger(JsonMapper.class);

	private static ObjectMapper mapper;
	
	private static final int ARRAY_MAX = 1024;

	public JsonMapper(Inclusion inclusion) {
		mapper = new ObjectMapper();
		//设置输出时包含属性的风格
		mapper.getSerializationConfig().setSerializationInclusion(inclusion);
		//设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		//允许字段名不带引号
		mapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
	}


	/**
	 * 创建只输出非空属性到Json字符串的Mapper.
	 */
	public static JsonMapper buildNonNullMapper() {
		return new JsonMapper(Inclusion.NON_NULL);
	}


    /**
     * 如果JSON字符串为Null或"null"字符串, 返回Null.
     * 如果JSON字符串为"[]", 返回空集合.
     * 
	 * 如需读取集合如List/Map, 且不是List<String>这种简单类型时使用如下语句,使用後面的函數.
     */
	public <T> T fromJson(String jsonString, Class<T> clazz) {
		if (StringUtils.isEmpty(jsonString)) {
			return null;
		}

		try {
			T t = (T) mapper.readValue(jsonString, clazz);
			/*if (t instanceof DeepEntity) {
				((DeepEntity) t).afterPropertiesSet();
			}*/
			return t;
		} catch (IOException e) {
			logger.error("parse json string error:" + jsonString, e);
			return null;
		}
	}
	


	/**
	 * 如果对象为Null, 返回"null".
	 * 如果集合为空集合, 返回"[]".
	 */
	public static String toJson(Object object) {
		try {
			return mapper.writeValueAsString(object);
		} catch (IOException e) {
			logger.error("write to json string error:" + object, e);
			return null;
		}
	}


	
	 /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     * @param <T>
     *
     * @param json
     * @return
     * @throws java.io.IOException
     * @throws org.codehaus.jackson.map.JsonMappingException
     */
    @SuppressWarnings("unchecked")
    public <T> List<T> jsonToList(String json,Class<T> clazz) {
    	if(StringUtils.isNotBlank(json)){
    		T[] t =  (T[]) Array.newInstance(clazz, ARRAY_MAX);
            try {
                t =  (T[]) mapper.readValue(json, t.getClass());
                return  Arrays.asList(t);
            } catch (JsonGenerationException e) {
            	logger.error(e.getMessage());
            } catch (JsonMappingException e) {
            	logger.error(e.getMessage());
            } catch (IOException e) {
            	logger.error(e.getMessage());
            }
    	}
        return null;
    }
	
}
