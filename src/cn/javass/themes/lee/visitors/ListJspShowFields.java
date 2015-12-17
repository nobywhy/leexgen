package cn.javass.themes.lee.visitors;

import cn.javass.xgen.genconf.vo.ExtendConfModel;
import cn.javass.xgen.genconf.vo.ModuleConfModel;
import cn.javass.xgen.template.visitors.TemplateElement;
import cn.javass.xgen.template.visitors.Visitor;

/**
 * 生成列表页面中展示的字段名
 * @author Administrator
 *
 */
public class ListJspShowFields implements Visitor {

	public Object visitTemplateElement(TemplateElement element) {
		ModuleConfModel moduleConf = element.getModuleConf();
		String showFields[] = ((ExtendConfModel) moduleConf.getMapExtends().get("showFields")).getValues();
		String moduleName = moduleConf.getMapExtends().get("moduleName").getValue();
		
		StringBuffer buffer = new StringBuffer("");
		for(int i=0;i<showFields.length;i++){
//			<td>${prize.mobile}</a></td>
//            <td>${prize.prize_code}</a></td>
//            <td>${prize.prizename}</td>
//            <td>${prize.activity_code}</td>
//            <td>${prize.createtime}</td>
			
			buffer.append("<td>${"+moduleName+"."+showFields[i]+"}</td>").append("\r\n");
			
		}

		return buffer.toString();
	}


}
