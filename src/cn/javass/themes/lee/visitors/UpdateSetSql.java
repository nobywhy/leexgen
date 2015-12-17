package cn.javass.themes.lee.visitors;

import cn.javass.xgen.genconf.vo.ExtendConfModel;
import cn.javass.xgen.genconf.vo.ModuleConfModel;
import cn.javass.xgen.template.visitors.TemplateElement;
import cn.javass.xgen.template.visitors.Visitor;

public class UpdateSetSql implements Visitor {

	public Object visitTemplateElement(TemplateElement element) {
		ModuleConfModel moduleConf = element.getModuleConf();
		String cols[] = ((ExtendConfModel) moduleConf.getMapExtends().get(
				"cols")).getValues();
//		String cols[] = new String[]{"userName","password"};
//		<if test="userName!=null &amp;&amp; userName!=''">
//		 userName=#{userName},
//	    </if>
		StringBuffer buffer = new StringBuffer("");
		for (int i = 0; i < cols.length; i++) {			
			buffer.append("<if test=\""+cols[i]+"!=null"+" &amp;&amp; "+""+cols[i]+"!=''\">").append("\r\n");
			buffer.append(cols[i]+"=#{"+cols[i]+"}").append(",\r\n");
			buffer.append("</if>").append("\r\n");
		}
		String replaceAll = buffer.toString();
		return replaceAll;
	}
	
	
	public static void main(String[] args) {
		Object visitTemplateElement = new UpdateSetSql().visitTemplateElement(null);
		System.out.println(visitTemplateElement);
	}
	
}
