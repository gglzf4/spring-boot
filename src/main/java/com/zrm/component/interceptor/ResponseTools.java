package com.zrm.component.interceptor;

import com.google.gson.Gson;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseTools {
	private static Log logger = LogFactory.getLog(ResponseTools.class);
    private static Gson gson = new Gson();

	public static void push2client(HttpServletResponse response, Object obj) {
        String result = gson.toJson(obj);
        logger.info(result);
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("application/json; charset=UTF-8");
        PrintWriter writer = null;
		try {
            writer = response.getWriter();
            response.setHeader("Content-Length", String.valueOf(result.getBytes("UTF-8").length));
			writer.write(result);
        }catch (IOException e) {
            logger.error("Push2Client failed! The data is :\r\n" + result + " \r\n Exception:", e);
			e.printStackTrace();
		} finally{
            if(writer != null){
                writer.flush();
                writer.close();
            }
        }
	}

	public static void push(HttpServletResponse response, String result) {
		logger.info(result);
		//response.setHeader("Cache-Control", "no-cache");
		response.setContentType("application/json");
		response.addHeader("access-control-allow-origin","*");
		response.addHeader("Access-Control-Allow-Methods","GET, POST, DELETE, PUT");
		response.addHeader("Access-Control-Allow-Headers","Content-Type, api_key, Authorization");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			//response.setHeader("Content-Length", String.valueOf(result.getBytes("UTF-8").length));
			writer.write(result);
		}catch (IOException e) {
			logger.error("Push2Client failed! The data is :\r\n" + result + " \r\n Exception:", e);
			e.printStackTrace();
		} finally{
			if(writer != null){
				writer.flush();
				writer.close();
			}
		}
	}

	/*public static void push2client(HttpServletResponse response, String result, String format) {
		try {
			logger.info(result);
			String responsetag = response.getHeader("request_tag");
			response.setHeader("Cache-Control", "no-cache");
			response.setHeader("Content-Length", String.valueOf(result.getBytes("UTF-8").length));
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.write(result);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			logger.error("Push2Client failed! The data is :\r\n" + result + " \r\n Exception:", e);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
}
