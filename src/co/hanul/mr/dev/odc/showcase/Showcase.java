package co.hanul.mr.dev.odc.showcase;

import co.hanul.mr.dev.odc.ObjectDynamicController;

public class Showcase {
	public static void main(String[] args) throws Exception {
		ObjectDynamicController odc = new ObjectDynamicController();

		// t객체를 생성한다.
		Object t = odc.newInstance(TestObj.class);

		// t객체의 num필드에 12를 넣는다.
		odc.setField(TestObj.class, t, "num", 12);

		// t객체의 num필드를 불러와 출력한다.
		System.out.println(odc.getField(TestObj.class, t, "num"));

		// t객체의 doub함수를 실행한다.
		odc.runMethod(TestObj.class, t, "doub");
	}
}
