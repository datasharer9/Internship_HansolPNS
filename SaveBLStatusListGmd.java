/*
 *------------------------------------------------------------------------------
 * $Id: SaveSalesOrdSearchListGmd.java,v 1.0 2007/10/09 17:14:19 sniper76
 * 
 * PROJ : 한솔CSN 프로젝트 
 * Copyright 2006-2007 LG CNS All rights reserved
 *------------------------------------------------------------------------------
 *                  변         경         사         항
 *------------------------------------------------------------------------------
 *   DATE       AUTHOR                      DESCRIPTION
 * -----------  ------  ---------------------------------------------------------
 * 2007/10/09   kkm         최초 프로그램 작성
 *----------------------------------------------------------------------------
 */
package hsni.om.om02.salesOrdMngt.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import laf.core.exception.LBizException;
import laf.core.exception.LException;
import laf.core.log.LLog;
import laf.support.collection.LCollectionUtility;
import laf.support.collection.LData;
import laf.support.collection.LMultiData;
import lafx.bridge.gauce.util.LGauceConverter;
import pbf.fw.foundation.cmd.AbstractGauceCmd;
import pbf.fw.foundation.pbc.PbcUtil;
import pbf.fw.support.util.GauceUtil;
import pbf.fw.support.util.MessageUtil;
import pbf.fw.taglib.message.SayMessage;
import pbf.comm.security.AuthorManager;
import pbf.comm.security.UserData;

import com.gauce.GauceDataSet;
import com.gauce.io.GauceRequest;
import com.gauce.io.GauceResponse;
import hsni.om.om02.salesOrdMngt.pbc.ISalesOrdMngt;
/**
 * <PRE>
 * 판매오더검색팝업 정보를 조회하여 가우스 데이터셋으로 변환 처리하는 클래스.
 * 
 * </PRE>
 *   
 * @author    kkm
 * @see       SalesOrdMngt
 */
public class SaveBLStatusListGmd extends AbstractGauceCmd {
    /**
     * 판매오더검색팝업 Request 정보가 실제 수행되는 인터페이스 메소드
     *
     * @param req Http Request 객체.
     * @param res Http Response 객체.
     * @param gauceRequest 가우스 Request 객체.
     * @param gauceResponse 가우스 Response 객체.
     * @exception LException Commnad 단 이하의 모든 에러.
     */
	public void execute(HttpServletRequest req, HttpServletResponse res, 
                         GauceRequest gauceRequest, GauceResponse gauceResponse) 
	             throws LException {
		 
		try {	
			//GauceDataSet gds = new GauceDataSet(); // 필수
			//gauceResponse.enableFirstRow(gds);
			
			GauceDataSet BLStatusListGds = gauceRequest.getGauceDataSet("IN_DS1");
		    LMultiData inputList = LGauceConverter.convertToLMultiDataWithJobType(BLStatusListGds);
			//LData inputData = LCollectionUtility.getData(req);
			
			UserData userData = AuthorManager.getUserData(req); //필수
	        String userId = userData.getUserId(); // 필수
	        		    
			LLog.err.println(inputList);
          			
			GauceUtil.fillColValue(inputList, "demFrtimeDays", userId); //fillColValue
	        GauceUtil.fillColValue(inputList, "detFrtimeDays", userId);
	        
	        ISalesOrdMngt pbc = (ISalesOrdMngt) PbcUtil.getPbc(ISalesOrdMngt.class);
	        pbc.saveBLStatusList(inputList); // 마무리구문
			
	        //inputData.setString("userId", userId); 
			
			//LLog.debug.println("\n ========== inputData ========== \n " + inputData);

			
			//LMultiData result = pbc.saveBLStatusList(inputData);//반환타입이 일치하지 않는다.
			    
			//LGauceConverter.extractToGauceDataSet(result, gds);
			//gds.flush();
		} catch(Exception se) {
			
            SayMessage.setMessageCode(req, res, se.getMessage());
			throw new LBizException(MessageUtil.getMessageWithParam(req, res, se.getMessage()), se);
		}
    }
}

