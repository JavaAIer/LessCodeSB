package com.javaaier.lesscode.common.utils.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 通用http发送方法
 *
 * @author javaaier
 */
@SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
public class HttpUtils {
    private static final Logger log = LoggerFactory.getLogger(HttpUtils.class);

    /**
     * 向指定 URL 发送GET方法的请求
     *
     * @param url   发送请求的 URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        StringBuilder result = new StringBuilder();
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            log.info("sendGet - {}", urlNameString);
            URL realUrl = new URL(urlNameString);
            URLConnection connection = realUrl.openConnection();
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.connect();
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
            log.info("recv - {}", result);
        } catch (ConnectException e) {
            log.error("调用HttpUtils.sendGet ConnectException, url=" + url + ",param=" + param, e);
        } catch (SocketTimeoutException e) {
            log.error("调用HttpUtils.sendGet SocketTimeoutException, url=" + url + ",param=" + param, e);
        } catch (IOException e) {
            log.error("调用HttpUtils.sendGet IOException, url=" + url + ",param=" + param, e);
        } catch (Exception e) {
            log.error("调用HttpsUtil.sendGet Exception, url=" + url + ",param=" + param, e);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception ex) {
                log.error("调用in.close Exception, url=" + url + ",param=" + param, ex);
            }
        }
        return result.toString();
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url   发送请求的 URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();
        try {
            String urlNameString = url + "?" + param;
            log.info("sendPost - {}", urlNameString);
            URL realUrl = new URL(urlNameString);
            URLConnection conn = realUrl.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Accept-Charset", "utf-8");
            conn.setRequestProperty("contentType", "utf-8");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            out = new PrintWriter(conn.getOutputStream());
            out.print(param);
            out.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
            log.info("recv - {}", result);
        } catch (ConnectException e) {
            log.error("调用HttpUtils.sendPost ConnectException, url=" + url + ",param=" + param, e);
        } catch (SocketTimeoutException e) {
            log.error("调用HttpUtils.sendPost SocketTimeoutException, url=" + url + ",param=" + param, e);
        } catch (IOException e) {
            log.error("调用HttpUtils.sendPost IOException, url=" + url + ",param=" + param, e);
        } catch (Exception e) {
            log.error("调用HttpsUtil.sendPost Exception, url=" + url + ",param=" + param, e);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                log.error("调用in.close Exception, url=" + url + ",param=" + param, ex);
            }
        }
        return result.toString();
    }

    /**
     * 向指定的url发送ssl Post请求
     *
     * @param url   发送请求的 URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return
     */
    public static String sendSSLPost(String url, String param) {
        StringBuilder result = new StringBuilder();
        String urlNameString = url + "?" + param;
        try {
            log.info("sendSSLPost - {}", urlNameString);
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, new TrustManager[]{new TrustAnyTrustManager()}, new java.security.SecureRandom());
            URL console = new URL(urlNameString);
            HttpsURLConnection conn = (HttpsURLConnection) console.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Accept-Charset", "utf-8");
            conn.setRequestProperty("contentType", "utf-8");
            conn.setDoOutput(true);
            conn.setDoInput(true);

            conn.setSSLSocketFactory(sc.getSocketFactory());
            conn.setHostnameVerifier(new TrustAnyHostnameVerifier());
            conn.connect();
            InputStream is = conn.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String ret = "";
            while ((ret = br.readLine()) != null) {
                if (ret != null && !"".equals(ret.trim())) {
                    result.append(new String(ret.getBytes("ISO-8859-1"), "utf-8"));
                }
            }
            log.info("recv - {}", result);
            conn.disconnect();
            br.close();
        } catch (ConnectException e) {
            log.error("调用HttpUtils.sendSSLPost ConnectException, url=" + url + ",param=" + param, e);
        } catch (SocketTimeoutException e) {
            log.error("调用HttpUtils.sendSSLPost SocketTimeoutException, url=" + url + ",param=" + param, e);
        } catch (IOException e) {
            log.error("调用HttpUtils.sendSSLPost IOException, url=" + url + ",param=" + param, e);
        } catch (Exception e) {
            log.error("调用HttpsUtil.sendSSLPost Exception, url=" + url + ",param=" + param, e);
        }
        return result.toString();
    }

    /**
     * 自己实现了信任管理器类，如何使用呢？
     * 类HttpsURLConnection似乎并没有提供方法设置信任管理器。
     * 其实，HttpsURLConnection通过SSLSocket来建立与HTTPS的安全连接，SSLSocket对象是由SSLSocketFactory生成的。
     * HttpsURLConnection提供了方法setSSLSocketFactory(SSLSocketFactory)设置它使用的SSLSocketFactory对象。
     * SSLSocketFactory通过SSLContext对象来获得，在初始化SSLContext对象时，可指定信任管理器对象。
     * <p>
     * 假设自己实现的X509TrustManager类的类名为：TrustAnyTrustManager，下面的代码片断说明了如何使用TrustAnyTrustManager：
     * <p>
     * //创建SSLContext对象，并使用我们指定的信任管理器初始化
     * TrustManager[] tm = {new TrustAnyTrustManager ()};
     * SSLContext sslContext = SSLContext.getInstance("SSL","SunJSSE");
     * sslContext.init(null, tm, new java.security.SecureRandom());
     * <p>
     * //从上述SSLContext对象中得到SSLSocketFactory对象
     * SSLSocketFactory ssf = sslContext.getSocketFactory();
     * <p>
     * //创建HttpsURLConnection对象，并设置其SSLSocketFactory对象
     * HttpsURLConnection httpsConn = (HttpsURLConnection)myURL.openConnection();
     * httpsConn.setSSLSocketFactory(ssf);
     * <p>
     * 这样，HttpsURLConnection对象就可以正常连接HTTPS了，
     * 无论其证书是否经权威机构的验证，只要实现了接口X509TrustManager的类MyX509TrustManager信任该证书。
     * <p>
     * 本文主要介绍了在HTTPS的证书未经权威机构认证的情况下，访问HTTPS站点的两种方法，
     * 一种方法是把该证书导入到Java的TrustStore文件中，
     * 另一种是自己实现并覆盖JSSE缺省的证书信任管理器类。
     * 两种方法各有优缺点，
     * 第一种方法不会影响JSSE的安全性，但需要手工导入证书；
     * 第二种方法虽然不用手工导入证书，但需要小心使用，否则会带来一些安全隐患。
     * <p>
     * 以上来自：https://blog.csdn.net/cj649934578/article/details/47042131
     */
    private static class TrustAnyTrustManager implements X509TrustManager {
        /**
         * 该方法检查客户端的证书，若不信任该证书则抛出异常。
         * 由于我们不需要对客户端进行认证，因此我们只需要执行默认的信任管理器的这个方法。
         * JSSE中，默认的信任管理器类为TrustManager。
         *
         * @param chain
         * @param authType
         */
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) {
        }

        /**
         * 该方法检查服务器的证书，若不信任该证书同样抛出异常。
         * 通过自己实现该方法，可以使之信任我们指定的任何证书。
         * 在实现该方法时，也可以简单的不做任何处理，即一个空的函数体，由于不会抛出异常，它就会信任任何证书。
         *
         * @param chain
         * @param authType
         */
        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) {
        }

        /**
         * 返回受信任的X509证书数组。
         *
         * @return
         */
        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[]{};
        }
    }

    /**
     * [强制]在实现的HostnameVerifier子类中，需要使用verify函数效验服务器主机名的合法性，否则会导致恶意程序利用中间人攻击绕过主机名效验。
     * 说明：
     * 在握手期间，如果URL的主机名和服务器的标识主机名不匹配，则验证机制可以回调此接口实现程序来确定是否应该允许此连接，如果回调内实现不恰当，默认接受所有域名，则有安全风险。
     * <p>
     * 作者：Code27149
     * 链接：https://www.jianshu.com/p/ad4c7ce94518
     * 来源：简书
     * 简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。
     */
    private static class TrustAnyHostnameVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;

        }
        /*
         @Override
         public boolean verify(String hostname, SSLSession session) {
             if (TextUtils.isEmpty(hostname)) {
                 return false;
             }
             return !Arrays.asList(VERIFY_HOST_NAME_ARRAY).contains(hostname);
         }
         */

       /* @Override
        public boolean verify(String hostname, SSLSession session) {
            if ("youhostname".equals(hostname)) {
                return true;
            } else {
                HostnameVerifier hv = HttpsURLConnection.getDefaultHostnameVerifier();
                return hv.verify(hostname, session);
            }
        }*/
    }

}