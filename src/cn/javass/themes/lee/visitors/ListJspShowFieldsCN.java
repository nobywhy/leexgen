package cn.javass.themes.lee.visitors;

import cn.javass.xgen.genconf.vo.ExtendConfModel;
import cn.javass.xgen.genconf.vo.ModuleConfModel;
import cn.javass.xgen.template.visitors.TemplateElement;
import cn.javass.xgen.template.visitors.Visitor;

/**
 * 生成列表页面中展示数据的中文标题
 * @author Administrator
 *
 */
public class ListJspShowFieldsCN implements Visitor {

	public Object visitTemplateElement(TemplateElement element) {
		ModuleConfModel moduleConf = element.getModuleConf();
		String showFields_CN[] = ((ExtendConfModel) moduleConf.getMapExtends().get("showFields_CN")).getValues();
		 
		StringBuffer buffer = new StringBuffer("");
		for(int i=0;i<showFields_CN.length;i++){
//			<th width="5%">手机号</th>
//	        <th width="5%">奖品代码</th>
//	        <th width="15%">奖品名称</th>
//	        <th width="5%">活动编号</th>
//	        <th width="5%">抽奖时间</th>
			
			buffer.append("<th width=\"5%\">"+showFields_CN[i]+"</th>");
			buffer.append("\r\n");
		}

		return buffer.toString();
	}


}
