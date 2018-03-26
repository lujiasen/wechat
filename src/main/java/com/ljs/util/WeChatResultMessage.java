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
		if(type.equals("genex")){
			NewsMessage newsMessage = new NewsMessage();
			newsMessage.setFromUserName(map.get("ToUserName"));
			newsMessage.setToUserName(map.get("FromUserName"));
			newsMessage.setCreateTime(Long.parseLong(map.get("CreateTime")));
			newsMessage.setMsgType("news");
			newsMessage.setArticleCount(5);
			List<Article> articles = new ArrayList<Article>();
			
			Article article1 = new Article();
			article1.setTitle("钱买不到的东西只有这么一样了！");
			article1.setPicUrl("http://mmbiz.qpic.cn/mmbiz_jpg/8ele1dwbibdIYjA4m0DqfgUQ8NnibG2kMAI1KuF0hr9BOBWAcu6iayxSicRfFmhNPPic2FsXIgc3Z8HDIn2nL5xn9kw/640?wx_fmt=jpeg&tp=webp&wxfrom=5&wx_lazy=1");
			article1.setUrl("https://mp.weixin.qq.com/s?__biz=MzIwNDUzODgxOA==&mid=2247483713&idx=1&sn=d872001dda7da036ea0b869025db8115&chksm=973fd7eca0485efa07c18813959b613878ea46b8944ead5c025b9a16e9a91e801c55649c865c&mpshare=1&scene=1&srcid=1116d4yhwQKcTW5bwkYdgeAz&pass_ticket=vAXQih5HXGJEJHDKl4dUXFxKHpX4ZH2GALISa5arK93T6o9FBPID7PD4ll44YFsx#rd");
			
			Article article2 = new Article();
			article2.setTitle("曝光x基因的显赫血统");
			article2.setPicUrl("http://mmbiz.qpic.cn/mmbiz_jpg/8ele1dwbibdIYjA4m0DqfgUQ8NnibG2kMAknBYfb7vJ5KrAwQYRMED7IfjwxsibWFH29CFaMKgDN3YZsYt6vib5LvA/640?wx_fmt=jpeg&tp=webp&wxfrom=5&wx_lazy=1");
			article2.setUrl("https://mp.weixin.qq.com/s?__biz=MzIwNDUzODgxOA==&mid=2247483715&idx=2&sn=32527831054e50c1d62c2297f11187b8&chksm=973fd7eea0485ef8732b1f31cc3b9cf3eb50876e253edb207fa96305573c97e4a60bd9cafada&mpshare=1&scene=1&srcid=1118Vc9XeBvePDWnYR0C5FKq&pass_ticket=zx1Kig3uWGrg4NGrf43BBfql510DZIHu2RcDEyx0Hgtc3xbAI5LdkDZwTo%2FLo0wn#rd");
			
			
			Article article3 = new Article();
			article3.setTitle("疑遭泄密,人类可能不再生病的内幕曝光！");
			article3.setPicUrl("https://mmbiz.qlogo.cn/mmbiz_jpg/8ele1dwbibdIaVMfkG8hKGxsBicQr8uv2nW4icfrNRzYBkyqVfslyks3hzkfRE6zpRyIP9TTibPjWiaHEicRaHVia6Vng/0?wx_fmt=jpeg");
			article3.setUrl("https://mp.weixin.qq.com/s?__biz=MzIwNDUzODgxOA==&mid=2247483713&idx=3&sn=f554b5618a99a6082c78838a9db503b7&chksm=973fd7eca0485efa058806659a85dfeb8cfa410052454a751ce59002b6fa99f00591779fd323&mpshare=1&scene=1&srcid=1116gFK0TPqVpZ8iRchCrWHE&pass_ticket=vAXQih5HXGJEJHDKl4dUXFxKHpX4ZH2GALISa5arK93T6o9FBPID7PD4ll44YFsx#rd");
			
			
			Article article4 = new Article();
			article4.setTitle("命中注定你就是个胖子");
			article4.setPicUrl("http://mmbiz.qpic.cn/mmbiz_png/8ele1dwbibdIYjA4m0DqfgUQ8NnibG2kMAibssM3RYVqaZibrz3jt1ibXK1CbFicILzuI8UeSjXyySP8LBDvic863jJQA/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1");
			article4.setUrl("https://mp.weixin.qq.com/s?__biz=MzIwNDUzODgxOA==&mid=2247483713&idx=4&sn=b2c2d9ef91f032d69679e15707435f89&chksm=973fd7eca0485efae9c0a15833686a000cb9fdb17f8204b5a5718342eefbbc45879e47b3341f&mpshare=1&scene=1&srcid=1116hLzCsV4GRj0xl3L9axte&pass_ticket=vAXQih5HXGJEJHDKl4dUXFxKHpX4ZH2GALISa5arK93T6o9FBPID7PD4ll44YFsx#rd");
			
			Article article5 = new Article();
			article5.setTitle("你亲手杀死了一个天才");
			article5.setPicUrl("http://mmbiz.qpic.cn/mmbiz_png/8ele1dwbibdIaVMfkG8hKGxsBicQr8uv2nbm4YicfqwqiaT1ZQF4NeO8LcuahibCVAiblDK9dnsEUX0R6R4f8cfXYJfA/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1");
			article5.setUrl("https://mp.weixin.qq.com/s?__biz=MzIwNDUzODgxOA==&mid=2247483713&idx=5&sn=7b46a5925f388dfda381553b5f3d6b44&chksm=973fd7eca0485efa4c72378951123f37b7bee7821c16713d81601de98a1485f8effbf25dea7e&mpshare=1&scene=1&srcid=1116iBof3kda3RbTxWxE35tE&pass_ticket=vAXQih5HXGJEJHDKl4dUXFxKHpX4ZH2GALISa5arK93T6o9FBPID7PD4ll44YFsx#rd");
			
			articles.add(article1);
			articles.add(article2);
			articles.add(article3);
			articles.add(article4);
			articles.add(article5);
			newsMessage.setArticles(articles);
			
			resultXml= MessageUtil.newsMessageToXml(newsMessage);
		}else if(type.equals("somur")){
			NewsMessage newsMessage = new NewsMessage();
			
			if(paramEWM.equals("11")){
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
			}else{
				newsMessage.setFromUserName(map.get("ToUserName"));
				newsMessage.setToUserName(map.get("FromUserName"));
				newsMessage.setCreateTime(Long.parseLong(map.get("CreateTime")));
				newsMessage.setMsgType("news");
				newsMessage.setArticleCount(1);
				List<Article> articles = new ArrayList<Article>();
				
				Article article1 = new Article();
				article1.setTitle("水母基因私人健康管理师");
				article1.setPicUrl("http://api2.somur.com:8081/wechat/index_wechat.png");
				article1.setUrl("http://www.somur.com/index.php?a=scheme&from=health");
				articles.add(article1);
				newsMessage.setArticles(articles);
			}
			
			resultXml= MessageUtil.newsMessageToXml(newsMessage);
		}else if(type.equals("shuimuadmin")){
			if(paramEWM.equals("2")){
				NewsMessage newsMessage = new NewsMessage();
				newsMessage.setFromUserName(map.get("ToUserName"));
				newsMessage.setToUserName(map.get("FromUserName"));
				newsMessage.setCreateTime(Long.parseLong(map.get("CreateTime")));
				newsMessage.setMsgType("news");
				newsMessage.setArticleCount(1);
				List<Article> articles = new ArrayList<Article>();
				
				Article article1 = new Article();
				article1.setTitle("绑定样本");
				article1.setPicUrl("http://api2.somur.com:8081/bind.png");
				article1.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx344fdd5fa92d2917&redirect_uri=http://yw.somur.com/saas_service/ccj/toBindingHtml.json?company_id=5f42e993ceec4bab942d2e38a8647f15&response_type=code&scope=snsapi_base&state=5#wechat_redire");
				articles.add(article1);
				newsMessage.setArticles(articles);
				resultXml= MessageUtil.newsMessageToXml(newsMessage);
			}else if(MessageUtil.SCAN.equals(paramEWM)){
				TextMessage textMessage = new TextMessage();
				textMessage.setCreateTime(Long.parseLong(map.get("CreateTime")));
				textMessage.setFromUserName(map.get("ToUserName"));
				textMessage.setToUserName(map.get("FromUserName"));
				textMessage.setMsgType("text");
				String content="Hi~ 亲\n\n感谢您关注水母基因臭臭君\n\n"
						+ "申请肠道菌群监测 请点击    <a href='https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx344fdd5fa92d2917&redirect_uri=http://yw.somur.com/saas_service/ccj/toQuestion.json?company_id=5f42e993ceec4bab942d2e38a8647f15&response_type=code&scope=snsapi_base&state=5#wechat_redire'>参与活动。</a>\n\n"
						+ "完善信息&绑定样本 请点击   <a href='https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx344fdd5fa92d2917&redirect_uri=https://yw.somur.com/saas_service/ccj/toFamilyTree.json?company_id=5f42e993ceec4bab942d2e38a8647f15&response_type=code&scope=snsapi_base&state=5#wechat_redire'>我的监测。</a>\n\n"
						+ "获取更多小课堂信息 请点击   <a href='http://mp.weixin.qq.com/s/Pu7BztQhmwQCdAX1kSZP8A'>我的学堂</a>";
				textMessage.setContent(content);
				resultXml= MessageUtil.textMessageToXml(textMessage);
			}else{
				NewsMessage newsMessage = new NewsMessage();
				newsMessage.setFromUserName(map.get("ToUserName"));
				newsMessage.setToUserName(map.get("FromUserName"));
				newsMessage.setCreateTime(Long.parseLong(map.get("CreateTime")));
				newsMessage.setMsgType("news");
				newsMessage.setArticleCount(1);
				List<Article> articles = new ArrayList<Article>();
				
				Article article1 = new Article();
				article1.setTitle("臭臭征集令");
				article1.setPicUrl("http://api2.somur.com:8081/first_page.png");
				article1.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx344fdd5fa92d2917&redirect_uri=http://yw.somur.com/saas_service/ccj/toQuestion.json?company_id=5f42e993ceec4bab942d2e38a8647f15&active_type=1&response_type=code&scope=snsapi_base&state=5#wechat_redire");
				articles.add(article1);
				newsMessage.setArticles(articles);
				resultXml= MessageUtil.newsMessageToXml(newsMessage);
			}
			
		}else if(type.equals("smwechat")){
			NewsMessage newsMessage = new NewsMessage();
			newsMessage.setFromUserName(map.get("ToUserName"));
			newsMessage.setToUserName(map.get("FromUserName"));
			newsMessage.setCreateTime(Long.parseLong(map.get("CreateTime")));
			newsMessage.setMsgType("news");
			newsMessage.setArticleCount(1);
			List<Article> articles = new ArrayList<Article>();
			Article article1 = new Article();
			article1.setTitle("中欧“长城杯”健儿专享基因检测服务");
			article1.setDescription("点击开启兑换流程");
			article1.setPicUrl("http://yw.somur.com:8081/ccj/zhongou.png");
			article1.setUrl("http://yw.somur.com/saas_service/ccj/toCoupon_g_f_2.json");
			articles.add(article1);
			newsMessage.setArticles(articles);
			resultXml= MessageUtil.newsMessageToXml(newsMessage);
		}else{
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
