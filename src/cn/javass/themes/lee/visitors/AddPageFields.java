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
public class AddPageFields implements Visitor {

	public Object visitTemplateElement(TemplateElement element) {
		ModuleConfModel moduleConf = element.getModuleConf();
		String addFields[] = ((ExtendConfModel) moduleConf.getMapExtends().get("addFields")).getValues();
		String addFields_CN[] = ((ExtendConfModel) moduleConf.getMapExtends().get("addFields_CN")).getValues();
		String moduleName = moduleConf.getMapExtends().get("moduleName").getValue();
		
		StringBuffer buffer = new StringBuffer("");
		for(int i=0;i<addFields.length;i++){
			//<li><label>标题:</label><input id="bonus_name" name="bonus_name" type="text" class="dfinput" value="${bonus.bonus_name}" /></li>
			buffer.append("<li><label>"+addFields_CN[i]+":</label>");
			buffer.append("<input id=\""+addFields[i]+"\" name=\""+addFields[i]+"\" type=\"text\" class=\"dfinput\" value=\"${"+moduleName+"."+addFields[i]+"}\" /></li>");
			buffer.append("\r\n");
			buffer.append("\r\n");
		}

		return buffer.toString();
	}


}
