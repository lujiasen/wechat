package com.ljs.util;



import java.util.Map;




/**
 * 
 * @Title: WeiXinServer.java
 * @Package com.somur.common
 * @Description: 微信公共工具类
 * @author lujiasen
 * @date 2016-4-22 上午09:39:33
 * @version V1.0
 */
public class WeiXinServerMenu {
	
	/**
	 * 
	* @param map
	* @return  
	* @Description: 处理微信回复信息  
	* @author lujiasen    
	* @date 2016-10-12 下午02:22:24  
	* @version V1.2
	 */
	public static String replyMessage(Map<String,String> map,String welcomeContent,String type,String paramEWM){
		 
		//信息类型
		String msgType = map.get("MsgType");
		
		String resultXml=null;
		//事件推送
		if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)){
			String event = map.get("Event");
			System.out.println("event============"+event);
			//订阅
			if(event.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)){
				resultXml =WeChatResultMessage.getEvent(map,welcomeContent,type,paramEWM);
			}
		}
		//文本信息回復
		else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)){
			   resultXml =WeChatResultMessage.getSearchMessage(map,welcomeContent,type,paramEWM);
		}
		
		return resultXml;
	}
	
}
