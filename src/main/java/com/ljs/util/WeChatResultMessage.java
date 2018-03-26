package com.ljs.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.jiang.resp.Article;
import com.jiang.resp.NewsMessage;
import com.jiang.resp.TextMessage;


/**
 * 
* @Title: WeChatResultMessage.java  
* @Package com.somur.common  
* @Description: 用户返回的message  
* @author jiangpeng     
* @date 2016年11月16日 下午5:11:09  
* @version V1.3
 */
public class WeChatResultMessage {
	
	/**
	 * 
	* @return  
	* @Description: 订阅事件返回数据  
	* @author jiangpeng    
	* @date 2016年11月16日 下午5:12:42  
	* @version V1.2
	 */
	public static String getEvent(Map<String,String> map,String welcomeContent,String type,String paramEWM){
		String  resultXml="";
		if (type.equals("lujiasen")){
			TextMessage textMessage = new TextMessage();
			textMessage.setCreateTime(Long.parseLong(map.get("CreateTime")));
			textMessage.setFromUserName(map.get("ToUserName"));
			textMessage.setToUserName(map.get("FromUserName"));
			textMessage.setMsgType("text");
			textMessage.setContent(welcomeContent);
			resultXml= MessageUtil.textMessageToXml(textMessage);
		}
		
		return resultXml;
		
		
	}
	
	/**
	 * 
	* @return  
	* @Description: 关键词文章  
	* @author jiangpeng    
	* @date 2016年11月16日 下午5:12:57  
	* @version V1.2
	 */
	public static String getSearchMessage(Map<String,String> map,String welcomeContent,String type,String paramEWM){
		String book="基因、检测、体检、健康、了解、病，公司，介绍，安全、权威";
		String  resultXml="";
		if(type.equals("genex")){
			String seachTxt=map.get("Content").toString();
			if(book.indexOf(seachTxt)!=-1){
				NewsMessage newsMessage = new NewsMessage();
				newsMessage.setFromUserName(map.get("ToUserName"));
				newsMessage.setToUserName(map.get("FromUserName"));
				newsMessage.setCreateTime(Long.parseLong(map.get("CreateTime")));
				newsMessage.setMsgType("news");
				newsMessage.setArticleCount(1);
				List<Article> articles = new ArrayList<Article>();
				
				Article article1 = new Article();
				article1.setTitle("钱买不到的东西只有这么一样了！");
				article1.setPicUrl("http://mmbiz.qpic.cn/mmbiz_jpg/8ele1dwbibdIYjA4m0DqfgUQ8NnibG2kMAI1KuF0hr9BOBWAcu6iayxSicRfFmhNPPic2FsXIgc3Z8HDIn2nL5xn9kw/640?wx_fmt=jpeg&tp=webp&wxfrom=5&wx_lazy=1");
				article1.setUrl("https://mp.weixin.qq.com/s?__biz=MzIwNDUzODgxOA==&mid=2247483713&idx=1&sn=d872001dda7da036ea0b869025db8115&chksm=973fd7eca0485efa07c18813959b613878ea46b8944ead5c025b9a16e9a91e801c55649c865c&mpshare=1&scene=1&srcid=1116d4yhwQKcTW5bwkYdgeAz&pass_ticket=vAXQih5HXGJEJHDKl4dUXFxKHpX4ZH2GALISa5arK93T6o9FBPID7PD4ll44YFsx#rd");
				articles.add(article1);
				newsMessage.setArticles(articles);
				resultXml= MessageUtil.newsMessageToXml(newsMessage);
			}else{
				TextMessage textMessage = new TextMessage();
				textMessage.setCreateTime(Long.parseLong(map.get("CreateTime")));
				textMessage.setFromUserName(map.get("ToUserName"));
				textMessage.setToUserName(map.get("FromUserName"));
				textMessage.setMsgType("text");
				textMessage.setContent("未找到您输入的关键词！"+DateUtil.getDateTimeByDate(new Date()));
				resultXml= MessageUtil.textMessageToXml(textMessage);
			}
			
		}else if(type.equals("somur")){
				String seachTxt=map.get("Content").toString();
				if(seachTxt.indexOf("义乌")!=-1){
					NewsMessage newsMessage = new NewsMessage();
					newsMessage.setFromUserName(map.get("ToUserName"));
					newsMessage.setToUserName(map.get("FromUserName"));
					newsMessage.setCreateTime(Long.parseLong(map.get("CreateTime")));
					newsMessage.setMsgType("news");
					newsMessage.setArticleCount(2);
					List<Article> articles = new ArrayList<Article>();
					
					Article article1 = new Article();
					article1.setTitle("购买健康管理服务年卡");
					article1.setPicUrl("http://api2.somur.com:8081/wechat/wechat_pay.png");
					article1.setUrl("http://www.somur.com/index.php?c=wap&a=product_info&product_id=11&suite_id=207&nickname=smjk");
					articles.add(article1);
					
					Article article2 = new Article();
					article2.setTitle("预约购买健康管理服务");
					article2.setPicUrl("http://api2.somur.com:8081/wechat/yuyue.png");
					article2.setUrl("http://www.somur.com/index.php?a=beforebuy&from=health");
					articles.add(article2);
					
					newsMessage.setArticles(articles);
					resultXml= MessageUtil.newsMessageToXml(newsMessage);
				}else{
					TextMessage textMessage = new TextMessage();
					textMessage.setCreateTime(Long.parseLong(map.get("CreateTime")));
					textMessage.setFromUserName(map.get("ToUserName"));
					textMessage.setToUserName(map.get("FromUserName"));
					textMessage.setMsgType("transfer_customer_service");
					resultXml= MessageUtil.textMessageToXml(textMessage);
					System.out.println(resultXml);
				}
		}else if(type.equals("shuimuadmin")){
			String seachTxt=map.get("Content").toString();
			if(seachTxt.indexOf("志愿者")!=-1){
				TextMessage textMessage = new TextMessage();
				textMessage.setCreateTime(Long.parseLong(map.get("CreateTime")));
				textMessage.setFromUserName(map.get("ToUserName"));
				textMessage.setToUserName(map.get("FromUserName"));
				textMessage.setMsgType("text");
				textMessage.setContent("爱心大使，等的就是您。工作人员会第一时间和您联系哦！");
				resultXml= MessageUtil.textMessageToXml(textMessage);
			}else if(seachTxt.indexOf("DK37HT")!=-1){
				TextMessage textMessage = new TextMessage();
				textMessage.setCreateTime(Long.parseLong(map.get("CreateTime")));
				textMessage.setFromUserName(map.get("ToUserName"));
				textMessage.setToUserName(map.get("FromUserName"));
				textMessage.setMsgType("text");
				textMessage.setContent("尊敬的用户，您好！请依据您和宝宝真实信息填写<a href='https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx344fdd5fa92d2917&redirect_uri=http://yw.somur.com/saas_service/ccj/toWenJuan.json?type=4&response_type=code&scope=snsapi_base&state=5#wechat_redire'>调查问卷</a>，最终报告会依据您填写的问卷及检测结果结合给到精准解读和指导建议！如有疑问添加臭臭君个人微信账号：SomurCCJ。");
				resultXml= MessageUtil.textMessageToXml(textMessage);
			}else if(seachTxt.indexOf("车来了福利")!=-1){
				TextMessage textMessage = new TextMessage();
				textMessage.setCreateTime(Long.parseLong(map.get("CreateTime")));
				textMessage.setFromUserName(map.get("ToUserName"));
				textMessage.setToUserName(map.get("FromUserName"));
				textMessage.setMsgType("text");
				textMessage.setContent("尊敬的用户，您好！请依据您和宝宝真实信息填写<a href='https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx344fdd5fa92d2917&redirect_uri=http://yw.somur.com/saas_service/ccj/toWenJuan.json?type=5&response_type=code&scope=snsapi_base&state=5#wechat_redire'>调查问卷</a>，最终报告会依据您填写的问卷及检测结果结合给到精准解读和指导建议！如有疑问添加臭臭君个人微信账号：SomurCCJ。");
				resultXml= MessageUtil.textMessageToXml(textMessage);
			}else{
				TextMessage textMessage = new TextMessage();
				textMessage.setCreateTime(Long.parseLong(map.get("CreateTime")));
				textMessage.setFromUserName(map.get("ToUserName"));
				textMessage.setToUserName(map.get("FromUserName"));
				textMessage.setMsgType("transfer_customer_service");
				resultXml= MessageUtil.textMessageToXml(textMessage);
				System.out.println(resultXml);
			}
	      }
		else{
			TextMessage textMessage = new TextMessage();
			textMessage.setCreateTime(Long.parseLong(map.get("CreateTime")));
			textMessage.setFromUserName(map.get("ToUserName"));
			textMessage.setToUserName(map.get("FromUserName"));
			textMessage.setMsgType("text");
			textMessage.setContent(welcomeContent);
			resultXml= MessageUtil.textMessageToXml(textMessage);
		}
		
		return resultXml;
		
	}

}
