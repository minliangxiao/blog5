package club.huangliang.utils;

import java.util.UUID;

public class IDUtil {
	public static String getUUID() {
		UUID uuid=UUID.randomUUID();
		String id=uuid.toString();
		//替换 生成的uuid中的-
		id=id.replaceAll("-", "");
		//
		int hash=id.hashCode();
		//去除符号
		hash =Math.abs(hash);
		id=String.valueOf(hash);
		return id;
	}
}
