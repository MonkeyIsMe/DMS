package com.dms.util;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016091500515956";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCL8/nk/6RjiXZVvZz3feXhk0nK3u2+fj6MPXDYBM8bb8/Oj0JzlLsngOiULTZl/FD4CMJqLxZVsk6R30Yr0ZNgRchNvQHKnaKLTn0rojJ8wZZq7dgze62AtofeTHSlpCnrru7W0KIzCRSEUNO7BhLg6maXwXpJCTiSILrkhBgBrZiZVgLBNU7pZf348SvzclnV0a77qjORk06mBmPeYRAC061hcA/MeGaG0yu3QQniO1xEy79v76r8bl8m02QAVqR2uNu8AxtfIsTuYtkTsfCPrYhtBnRlIw0zULhctAGu+6QXSYzmQOzm+kP3JhuIa+xjXVztSTfi8khi13k8OvcdAgMBAAECggEAHn2K5e8kG2NpWoiy1+Cf4qM6Im6rESNj8R25pfZ2QJ39gh0H9zJiC9sz0ISBI3rzEPanlIapsQXlxDYGjaldGE5bs0QITeJF9V+mOYlewntSj/09awn45N/fffjeOPApCeXUtwxBKilCRQlu94H9Pu8SZuGKCLtvjbZ/wSVeLY8X/5X6UhtSg5z+pFoqYHBQl+3aA8PIF82KA3/nIWxiKHVl859ikC8p8pp4Ew8+c6rUOUbMoRwgNzc14ytro6FQlFTRTp/G2eewBk3gCDTG8JiXbd3jzRaJQBieP9/swIUwPib9Ew8rcM6ji51F29AMsfin6px7kTjVRmOxdqqIaQKBgQDBLhvFzvzxHI7hnaa+JmNVDxP2dSDXtIXUafOWyrwpgUIAh8l0+ddVXETGtSfqXfNLgVfHYhjkOKE+jWY3fuP/uSr8jm+xqq445AiaZEoqtrNjDgZRj1IgXqYVI1PzLFSjhj+QzHsjCNZUHJvtfukdde+0KZgU3Tz6rJkXYTLHPwKBgQC5ds98hfeX4CQ0Lc58YotAupOopY79xqWq/BoRuUBbtx1ymKZQh6byFJEkwbT6BwB0zykh1PPVqIXIhZvP+DuYe56f5XF2p+UTMcyzsVz1aIfTbJp7EUz+EVfL2Ay+gAkit2wcH0pjM+ogFHlMrWz/KG27o7vtYcmy2WeD/L1mowKBgQCoh2cnPJqiZj2oSnbrMGY8EHlj628Jf625T+14QcnBk8hW2h9Ac64OA/7kM6ps5iWYW3COut/oShcxkP35sDOMJqh/yGtc3gA8FYQD3TZu6RC6e8O7Z4NIRgoyKq3UWXpFZpsR4bITMGR64LKPkMYiM38494h7uz61mdm88cjw1QKBgBte9XAjNU8svSsWN4sT4AlFf9U72caKMpjxa8eB14WxmJ74+FKaMoE3l9Qc4mCj9+VFTYS4sOOvY08cqMogkGsIk3h1nDEuxhf3GYbLfjSZoLILLSFMhFhapuJmmDrlGnQNLd9YntnVJ5BkdSJj1doyVT+EApAeBm5mt2g7PJiRAoGAWgc2mOCxn1HWWI+ffNVd5eHjxiWSTQW+dpIxg4/0gdJSPa518K20AhkJs4rckF3uUSqE5ckYNj1YjgQxO09kc1THolmGQzzRXN7WoLfRCF/0ss6TMEkqPbtQmK6PLugTFrqbeeiDDc701dk/Kn8qzTxnQCxLhfSEcLS7fWduJDU=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuDSBIiZcJ3CbkhT2E7ICQY+3t9oEtsnu0cljCxB8B8fWIsaq2HotEPYgwGYsFZay/S3fFhYDpVM1n644u7C8XlpklNPdvy3c44bjHFtv+nqupNylajH59z29FNkqtEGgPuvS8DpxWNdlHANTsWv2Lu/93cMaIeOYxnlHZA7SiQYKsq47yfs3bHf3n4EW/jB5dJTBSYJz8onVpbCaor+m33oPYR8vG78t84+S78FVsrk1ZA4C/j/P0oP3KY0pa0biDpiHYt3wODlERyNMrMMDSncEdgNQefyV0XWYf1dSGUWyLXEJaOZu3390b/4HNKbmZdTkJQsbceJbxMCxg5/THwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost/DMSThird/R";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\alipaylog";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

