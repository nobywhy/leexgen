package cn.javass.themes.lee.visitors;

import cn.javass.xgen.genconf.vo.ExtendConfModel;
import cn.javass.xgen.genconf.vo.ModuleConfModel;
import cn.javass.xgen.template.visitors.TemplateElement;
import cn.javass.xgen.template.visitors.Visitor;

/**
 * 生成列表页面的查询条件
 * @author Administrator
 *
 */
public class ListJspQueryFields implements Visitor {

	public Object visitTemplateElement(TemplateElement element) {
		ModuleConfModel moduleConf = element.getModuleConf();
		String queryFields[] = ((ExtendConfModel) moduleConf.getMapExtends().get("queryFields")).getValues();
		String queryFields_CN[] = ((ExtendConfModel) moduleConf.getMapExtends().get("queryFields_CN")).getValues();
		 
		StringBuffer buffer = new StringBuffer("");
		for(int i=0;i<queryFields.length;i++){
			//<li><label>手机号</label><input value="${queryParams.mobile!''}" name="mobile" id="mobile" type="text" class="scinput" /></li>
			buffer.append("<li><label>").append(queryFields_CN[i]).append("</label>");
			buffer.append("<input value=\"${queryParams."+queryFields[i]+"!''}\" name=\""+queryFields[i]+"\" id=\""+queryFields[i]+"\" type=\"text\" class=\"scinput\" /></li>");
			buffer.append("\r\n");
		}

		return buffer.toString();
	}


}
