/**
 * 
 */
package com.hgsoft.carowner.service;

import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import com.hgsoft.carowner.entity.Dictionary;
import com.hgsoft.common.message.RunningData;
import com.hgsoft.common.utils.MsgSendUtil;
import com.hgsoft.common.utils.MsgThread;
import com.hgsoft.common.utils.SerialNumberUtil;

/**
 * @author liujialin
 * 请求批量信息
 * 20150812
 */
@Service
public class MsgBatchReqService {
	private final Log logger = LogFactory.getLog(MsgBatchReqService.class);
	@Resource
	DictionaryService  dictionaryService;
//	@Resource
//	private MsgSendUtil msgSendUtil;
	/**
	 * 
	 * @param obdSn obdId
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return 终端ACK，00成功，01失败
	 */
	public String msgBatchReq(String obdSn){
		MsgSendUtil msgSendUtil = new MsgSendUtil();
		Dictionary dic=dictionaryService.getDicByCodeAndType("owner.command", "server.batchMsg");
//		StringBuffer sb=new StringBuffer();
//		String startStr=(String)DateUtil.fromatDate(startTime,"yyyyMMddHHmmss");
//		String endStr=(String)DateUtil.fromatDate(endTime,"yyyyMMddHHmmss");
//		sb.append(startStr).append(endStr);
		//获取流水号
		int serialNumber=SerialNumberUtil.getSerialnumber();
		String common = dic.getTrueValue();//命令字
		
		//确定唯一消息
		String msgId=obdSn+"_"+common+"_"+serialNumber;
		logger.info(msgId+"*********************服务端消息KEY:"+obdSn+"_"+common+"_"+serialNumber);
		Map<String, Object> respMap=RunningData.getIdResponseMap();
		respMap.put(msgId, null);
		try {
			msgSendUtil.msgSend(obdSn, common,serialNumber, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//如果服务端在：HelloServerHandler.channelRead()方法里读取到客户端的响应消息，则线程获取消息。
		MsgThread thread =new MsgThread(msgId);
		thread.start();
		try {
			//线程同步锁，顺序执行
			thread.join(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//获取到客户端的响应消息
		String resultStr= (String) thread.getResMsg();
		logger.info(resultStr+"*************************800e客户端响应结果");
		if(resultStr!=null){
			respMap.remove(msgId);//获取响应消息后，清除对应的消息
		}
		return resultStr;
	}
}
