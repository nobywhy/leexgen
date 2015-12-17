package cn.javass.themes.lee.visitors;

import cn.javass.xgen.genconf.vo.ExtendConfModel;
import cn.javass.xgen.genconf.vo.ModuleConfModel;
import cn.javass.xgen.template.visitors.TemplateElement;
import cn.javass.xgen.template.visitors.Visitor;

public class SelectParamSql implements Visitor {

	public Object visitTemplateElement(TemplateElement element) {
		ModuleConfModel moduleConf = element.getModuleConf();
		String cols[] = ((ExtendConfModel) moduleConf.getMapExtends().get(
				"selectParams")).getValues();
//		String cols[] = new String[]{"userName","password"};
//		<if test="accountName!=null &amp;&amp; accountName!=''">
//			and accountName=#{accountName}
//		</if>
		StringBuffer buffer = new StringBuffer("");
		for (int i = 0; i < cols.length; i++) {
			buffer.append("<if test=\""+cols[i]+"!=null"+" &amp;&amp; "+""+cols[i]+"!=''\">").append("\r\n");
			buffer.append("and "+cols[i]+"=#{"+cols[i]+"}").append("\r\n");
			buffer.append("</if>").append("\r\n");
		}
		return buffer.toString();
	}
	
	public static void main(String[] args) {
		Object visitTemplateElement = new SelectParamSql().visitTemplateElement(null);
		System.out.println(visitTemplateElement);
	}
	
}
