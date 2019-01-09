/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.auge.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 * 
 * @author soya
 * @date 2016年10月27日 下午9:59:27
 */
public class R<T> extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;

	public static int CODE_SUCCESS = 0;
	public static int CODE_FAILED = 500;
	public static int CODE_INVALID_USER = 501;

	public R() {
		put("code", CODE_SUCCESS);
		put("msg", "success");
	}

	public static R error() {
		return error(CODE_FAILED, "未知异常，请联系管理员");
	}

	public static R error(String msg) {
		return error(CODE_FAILED, msg);
	}

	public static R error(int code, String msg) {
		R r = new R();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static R ok(String msg) {
		R r = new R();
		r.put("msg", msg);
		return r;
	}

	public static R ok(Map<String, Object> map) {
		R r = new R();
		r.putAll(map);
		return r;
	}

	public static R ok() {
		return new R();
	}

	@Override
	public R put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
