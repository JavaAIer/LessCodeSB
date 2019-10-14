package com.javaaier.lesscode.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.javaaier.lesscode.common.utils.http.HttpUtils;
import com.javaaier.lesscode.framework.config.LesscodeConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 获取地址类
 * 
 * @author javaaier
 */
public class AddressUtils
{
    private static final Logger log = LoggerFactory.getLogger(AddressUtils.class);

    /**
     * 淘宝ip地址接口url
     */
    public static final String IP_URL = "http://ip.taobao.com/service/getIpInfo.php";

    /**
     * 根据 ip 地址获取实际地址
     * @param ip
     * @return
     */
    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    public static String getRealAddressByIP(String ip)
    {
        String address = "XX XX";
        // 内网不查询
        if (IpUtils.internalIp(ip))
        {
            return "内网IP";
        }
        if (LesscodeConfig.isAddressEnabled())
        {
            String rspStr = HttpUtils.sendPost(IP_URL, "ip=" + ip);
            if (StringUtils.isEmpty(rspStr))
            {
                log.error("获取地理位置异常 {}", ip);
                return address;
            }
            JSONObject obj = JSONObject.parseObject(rspStr);
            JSONObject data = obj.getObject("data", JSONObject.class);
            String region = data.getString("region");
            String city = data.getString("city");
            address = region + " " + city;
        }
        return address;
    }
}
