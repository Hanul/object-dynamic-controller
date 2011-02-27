package lotus.odc;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 동적으로 객체를 생성하는 클래스
 * 
 * @author Lotus
 * 
 */
public class ObjectDynamicController {
	/**
	 * 새 객체 색성
	 */
	public Object newInstance(Class<?> clazz, Object... params) throws Exception {
		Constructor<?>[] cts = clazz.getConstructors();
		for (Constructor<?> ct : cts) {
			if (compareParamsType(ct.getParameterTypes(), params)) {
				return ct.newInstance(params);
			}
		}
		for (Constructor<?> ct : cts) {
			if (looserCompareParamsType(ct.getParameterTypes(), params)) {
				return ct.newInstance(params);
			}
		}
		for (Constructor<?> ct : cts) {
			if (looserCompareParamsType2(ct.getParameterTypes(), params)) {
				return ct.newInstance(params);
			}
		}
		for (Constructor<?> ct : cts) {
			if (looserCompareParamsType3(ct.getParameterTypes(), params)) {
				return ct.newInstance(params);
			}
		}
		for (Constructor<?> ct : cts) {
			if (looserCompareParamsType4(ct.getParameterTypes(), params)) {
				return ct.newInstance(params);
			}
		}
		for (Constructor<?> ct : cts) {
			if (looserCompareParamsType5(ct.getParameterTypes(), params)) {
				return ct.newInstance(params);
			}
		}
		return null;
	}

	/**
	 * 함수 실행
	 */
	public Object runMethod(
			Class<?> clazz,
			Object obj,
			String methodName,
			Object... params) throws Exception {

		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				if (compareParamsType(method.getParameterTypes(), params)) {
					return method.invoke(obj, params);
				}
			}
		}
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				if (looserCompareParamsType(method.getParameterTypes(), params)) {
					return method.invoke(obj, params);
				}
			}
		}
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				if (looserCompareParamsType2(method.getParameterTypes(), params)) {
					return method.invoke(obj, params);
				}
			}
		}
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				if (looserCompareParamsType3(method.getParameterTypes(), params)) {
					return method.invoke(obj, params);
				}
			}
		}
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				if (looserCompareParamsType4(method.getParameterTypes(), params)) {
					return method.invoke(obj, params);
				}
			}
		}
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				if (looserCompareParamsType5(method.getParameterTypes(), params)) {
					return method.invoke(obj, params);
				}
			}
		}
		throw new NoSuchMethodException();
	}

	/**
	 * 파라미터의 타입 비교
	 */
	private boolean compareParamsType(Class<?>[] paramTypes, Object... params) {
		if (paramTypes.length == params.length) {
			boolean correct = true;
			for (int i = 0; i < paramTypes.length; i++) {
				if (params[i] != null && !paramTypes[i].equals(params[i].getClass())) {
					correct = false;
					break;
				}
			}
			if (correct) {
				return true;
			}
		}
		return false;
	}

	private boolean looserCompareParamsType(
			Class<?>[] paramTypes,
			Object... params) throws ClassNotFoundException {

		if (paramTypes.length == params.length) {
			boolean correct = true;
			for (int i = 0; i < paramTypes.length; i++) {
				if (params[i] != null && !looserCompareType(
					paramTypes[i],
					params[i].getClass())) {

					correct = false;
					break;
				}
			}
			if (correct) {
				return true;
			}
		}
		return false;
	}

	private boolean looserCompareParamsType2(
			Class<?>[] paramTypes,
			Object... params) throws ClassNotFoundException {

		if (paramTypes.length == params.length) {
			boolean correct = true;
			for (int i = 0; i < paramTypes.length; i++) {
				if (params[i] != null && !looserCompareType2(
					paramTypes[i],
					params[i].getClass())) {

					correct = false;
					break;
				}
			}
			if (correct) {
				return true;
			}
		}
		return false;
	}

	private boolean looserCompareParamsType3(
			Class<?>[] paramTypes,
			Object... params) throws ClassNotFoundException {

		if (paramTypes.length == params.length) {
			boolean correct = true;
			for (int i = 0; i < paramTypes.length; i++) {
				if (params[i] != null && !looserCompareType3(
					paramTypes[i],
					params[i].getClass())) {

					correct = false;
					break;
				}
			}
			if (correct) {
				return true;
			}
		}
		return false;
	}

	private boolean looserCompareParamsType4(
			Class<?>[] paramTypes,
			Object... params) throws ClassNotFoundException {

		if (paramTypes.length == params.length) {
			boolean correct = true;
			for (int i = 0; i < paramTypes.length; i++) {
				if (params[i] != null && !looserCompareType4(
					paramTypes[i],
					params[i].getClass())) {

					correct = false;
					break;
				}
			}
			if (correct) {
				return true;
			}
		}
		return false;
	}

	private boolean looserCompareParamsType5(
			Class<?>[] paramTypes,
			Object... params) throws ClassNotFoundException {

		if (paramTypes.length == params.length) {
			boolean correct = true;
			for (int i = 0; i < paramTypes.length; i++) {
				if (params[i] != null && !looserCompareType5(
					paramTypes[i],
					params[i].getClass())) {

					correct = false;
					break;
				}
			}
			if (correct) {
				return true;
			}
		}
		return false;
	}

	private boolean looserCompareType(Class<?> fir, Class<?> sec) throws ClassNotFoundException {
		if (forCompareType(sec, "java.lang.Boolean", fir, "boolean")) {
			return true;
		} else if (forCompareType(sec, "java.lang.Byte", fir, "byte")) {
			return true;
		} else if (forCompareType(sec, "java.lang.Character", fir, "char")) {
			return true;
		} else if (forCompareType(sec, "java.lang.Short", fir, "short")) {
			return true;
		} else if (forCompareType(sec, "java.lang.Integer", fir, "int")) {
			return true;
		} else if (forCompareType(sec, "java.lang.Long", fir, "long")) {
			return true;
		} else if (forCompareType(sec, "java.lang.Float", fir, "float")) {
			return true;
		} else if (forCompareType(sec, "java.lang.Double", fir, "double")) {
			return true;
		}
		return false;
	}

	private boolean looserCompareType2(Class<?> fir, Class<?> sec) throws ClassNotFoundException {
		if (forCompareType(sec, "java.lang.Character", fir, "int")) {
			return true;
		} else if (forCompareType(sec, "java.lang.Integer", fir, "long")) {
			return true;
		} else if (forCompareType(sec, "java.lang.Long", fir, "float")) {
			return true;
		} else if (forCompareType(sec, "java.lang.Float", fir, "double")) {
			return true;
		}
		return false;
	}

	private boolean looserCompareType3(Class<?> fir, Class<?> sec) throws ClassNotFoundException {
		if (forCompareType(sec, "java.lang.Character", fir, "long")) {
			return true;
		} else if (forCompareType(sec, "java.lang.Integer", fir, "float")) {
			return true;
		} else if (forCompareType(sec, "java.lang.Long", fir, "double")) {
			return true;
		}
		return false;
	}

	private boolean looserCompareType4(Class<?> fir, Class<?> sec) throws ClassNotFoundException {
		if (forCompareType(sec, "java.lang.Character", fir, "float")) {
			return true;
		} else if (forCompareType(sec, "java.lang.Integer", fir, "double")) {
			return true;
		}
		return false;
	}

	private boolean looserCompareType5(Class<?> fir, Class<?> sec) throws ClassNotFoundException {
		if (forCompareType(sec, "java.lang.Character", fir, "double")) {
			return true;
		}
		return false;
	}

	private boolean forCompareType(
			Class<?> sec,
			String ClassForName,
			Class<?> fir,
			String getNameEquals) throws ClassNotFoundException {
		return sec.equals(Class.forName(ClassForName)) && fir.getName().equals(
			getNameEquals);
	}

	/**
	 * 변수에서 값 가져오기
	 */
	public Object getField(Class<?> clazz, Object obj, String fieldName) throws Exception {
		return clazz.getField(fieldName).get(obj);
	}

	/**
	 * 변수에 값 넣기
	 */
	public void setField(
			Class<?> clazz,
			Object obj,
			String fieldName,
			Object value) throws Exception {

		clazz.getField(fieldName).set(obj, value);
	}

}
