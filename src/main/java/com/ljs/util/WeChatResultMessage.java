package com.ljs.util;

import com.ljs.pojo.weChat.Article;
import com.ljs.pojo.weChat.NewsMessage;
import com.ljs.pojo.weChat.TextMessage;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;



/**
 * 
* @Title: WeChatResultMessage.java  
* @Package com.somur.common  
* @Description: 用户返回的message  
* @author lujiasen
* @date 2016年11月16日 下午5:11:09  
* @version V1.3
 */

public class WeChatResultMessage {


	private static final String EXPRESS = "{\"shunfeng\":\"SF,顺丰速运\",\"shentong\":\"STO,申通快递\",\"zhongtong\":\"ZTO,中通快递\",\"yuantong\":\"YTO,圆通速递\",\"yunda\":\"YD,韵达速递\",\"ems\":\"EMS,EMS\",\"tiantian\":\"HHTT,天天快递\",\"debangwuliu\":\"DBL,德邦\",\"youzhengguonei\":\"YZPY,邮政快递包裹\",\"quanfengkuaidi\":\"QFKD,全峰快递\",\"youshuwuliu\":\"UC,优速快递\",\"kuaijiesudi\":\"FAST,快捷快递\",\"zhaijisong\":\"ZJS,宅急送\",\"huitongkuaidi\":\"HTKY,百世快递\"}";
	/**
	 * 
	* @return  
	* @Description: 订阅事件返回数据  
	* @author lujiasen
	* @date 2016年11月16日 下午5:12:42  
	* @version V1.2
	 */
	public static String getEvent(Map<String,String> map,String paramEWM){
		String  resultXml="";
		TextMessage textMessage = new TextMessage();
		textMessage.setCreateTime(Long.parseLong(map.get("CreateTime")));
		textMessage.setFromUserName(map.get("ToUserName"));
		textMessage.setToUserName(map.get("FromUserName"));
		textMessage.setMsgType("text");
		textMessage.setContent("你好!!!");
		resultXml= MessageUtil.textMessageToXml(textMessage);
		return resultXml;
	}
	
	/**
	 * 
	* @return  
	* @Description: 关键词文章  
	* @author lujiasen
	* @date 2016年11月16日 下午5:12:57  
	* @version V1.2
	 */
	public static String getSearchMessage(Map<String,String> map,String paramEWM){
		String  resultXml = "";
		String content = map.get("Content");
		String return_content = "";
		if(content.startsWith("单号")){
			String express_no = content.substring(2);
			return_content = getExpressCompany(express_no,Integer.valueOf(map.get("userId")));
		}
		TextMessage textMessage = new TextMessage();
		textMessage.setCreateTime(Long.parseLong(map.get("CreateTime")));
		textMessage.setFromUserName(map.get("ToUserName"));
		textMessage.setToUserName(map.get("FromUserName"));
		textMessage.setMsgType("text");
		textMessage.setContent(return_content);
		resultXml= MessageUtil.textMessageToXml(textMessage);
		return resultXml;
		
	}
	//#wechat_redirect
	public static  String getExpressCompany(String express_no,int userId){
		String json_string = KdniaoTrackQueryAPI.getExpressCompany(express_no);
		JSONObject json = JSONObject.fromObject(json_string);
		JSONArray list_exprss = json.getJSONArray("Shippers");
		if(list_exprss ==null || list_exprss.size() == 0){
			return "暂无物流信息";
		}else{
			StringBuffer content = new StringBuffer();
			content.append("点击查看详情\n");
			JSONArray list = json.getJSONArray("Shippers");
			JSONObject express_json = JSONObject.fromObject(EXPRESS);
			list.forEach((Object j) -> {
				JSONObject company = JSONObject.fromObject(j);
				String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx5179c821a45f7352&redirect_uri=http://www.lujiasen.com/wechat/weChat/redirectUrl?param=expressNo="+
						express_no + ",companyCode="+company.get("ShipperCode")+",userId="+userId
						+"&response_type=code&scope=snsapi_base&state=express_information&connect_redirect=1#wechat_redirect";
				System.out.println(url);
				content.append("<a href='"+url+"'>"+express_no + "\t" + company.get("ShipperName")+"\t"+"</a>\n");
			});
			return content.toString();
		}
	}
}
