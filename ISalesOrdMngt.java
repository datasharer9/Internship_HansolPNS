/*
 *------------------------------------------------------------------------------
 * ISalesOrdMngt.java,v 1.0 2007/10/12 09:38:11 chj Exp $
 * 
 * PROJ : 한솔CSN 프로젝트 
 * Copyright 2006-2007 LG CNS All rights reserved
 *------------------------------------------------------------------------------
 *                  변         경         사         항
 *------------------------------------------------------------------------------
 *   DATE       AUTHOR                      DESCRIPTION
 * -----------  ------  ---------------------------------------------------------
 * 2007/10/12   chj         최초 프로그램 작성
 *----------------------------------------------------------------------------
 */
package hsni.om.om02.salesOrdMngt.pbc;

import laf.core.exception.LException;
import laf.support.collection.LData;
import laf.support.collection.LMultiData;

/**
 * <PRE>
 * 내부 기본 판매오더 등록 정보의 조회/추가/수정/삭제/ 업무를 처리하는 Biz 클래스.
 *
 * Database Tables : 
 * </PRE>
 * @author    chj
 */
public interface ISalesOrdMngt {

    /**
     * 고객오더오류목록조회
     * @param inputData
     * @throws LException
     */
    public LMultiData retrieveCustOrdErrList(LData inputData) throws LException;
    
    /**
     * 고객오더목록조회
     * @param inputData
     * @throws LException
     */
    public LMultiData retrieveCustOrdList(LData inputData) throws LException;
    
    /**
     * 고객오더 매핑 조회하는 메소드.
     *
     * @param inputData Command로 부턴 전달받은 input LDataProtocol
     * 
     * @return LMultiData 조회된 리스트 결과.
     * @exception LException 메소드 수행시 발생한 모든 에러.
     */
    public LMultiData saveSalesOrdMpng(LData inputData) throws LException;

    /**
     * 내부 기본 판매오더 등록 정보를 조회하는 메소드.
     *
     * @param inputData Command로 부턴 전달받은 input LDataProtocol
     * 
     * @return LMultiData 조회된 리스트 결과.
     * @exception LException 메소드 수행시 발생한 모든 에러.
     */
    public LMultiData retrieveSalesOrdMngtList(LData inputData) throws LException;
    
   /** Achievement 정보를 조회하는 메소드.
    *
    * @param inputData Command로 부턴 전달받은 input LDataProtocol
    * 
    * @return LMultiData 조회된 리스트 결과.
    * @exception LException 메소드 수행시 발생한 모든 에러.
    */
   public LMultiData retrieveIsdBasisCopyTgtOrd(LData inputData) throws LException;
 
    /**
     * 내부 기본 판매오더 등록 정보를 추가/수정/삭제하는 메소드.
     *
     * @param inputData Command로 부턴 전달받은 input LDataProtocol
     * 
     * @exception LException 메소드 수행시 발생한 모든 에러.
     */
    public LMultiData createIsdBasisSalesOrd(LMultiData inputData) throws LException;
    
    /**
     * 내부 기본 판매오더 등록 의 가용재고 체크 메소드.
     *
     * @param inputData Command로 부턴 전달받은 input LDataProtocol
     * 
     * @exception LException 메소드 수행시 발생한 모든 에러.
     */
    public LMultiData retrieveAvailStock(LData inputData) throws LException;

    /**
     * 내부 기본 판매오더 등록 의 가용재고 체크 메소드.
     *
     * @param inputData Command로 부턴 전달받은 input LDataProtocol
     * 
     * @exception LException 메소드 수행시 발생한 모든 에러.
     */
    public LMultiData retrieveWrhsAvailStock(LData inputData) throws LException;
    
    /**
     * 오더유형 조회 메소드.
     *
     * @param inputData Command로 부턴 전달받은 input LDataProtocol
     * 
     * @exception LException 메소드 수행시 발생한 모든 에러.
     */
    public LMultiData retrieveCustCtrtOrdType(LData inputData) throws LException;
    /**
     * 내부 기본 판매오더 등록 의 아이템코드 팝업 조회 메소드.
     *
     * @param inputData Command로 부턴 전달받은 input LDataProtocol
     * 
     * @exception LException 메소드 수행시 발생한 모든 에러.
     */
    public LMultiData retrieveItemCdList(LData inputData) throws LException;
    
    /**
     * 내부 기본 판매오더 등록 의 아이템코드 팝업 조회 메소드.
     *
     * @param inputData Command로 부턴 전달받은 input LDataProtocol
     * 
     * @exception LException 메소드 수행시 발생한 모든 에러.
     */
    public LMultiData confirmAvailStockBatch(LData inputData) throws LException;

    /**
     * 판매오더검색팝업 정보를 조회하는 메소드.
     *
     * @param inputData Command로 부턴 전달받은 input LDataProtocol
     * 
     * @return LMultiData 조회된 리스트 결과.
     * @exception LException 메소드 수행시 발생한 모든 에러.
     */
    public LMultiData retrieveSalesOrdSearchList(LData inputData) throws LException;

    /**
     * 판매오더수동완료대상을 조회하는 메소드.
     *
     * @param inputData Command로 부턴 전달받은 input LDataProtocol
     * 
     * @return LMultiData 조회된 리스트 결과.
     * @exception LException 메소드 수행시 발생한 모든 에러.
     */
    public LMultiData retrieveSalesOrdManualCmpt(LData inputData) throws LException;
    
    /**
     * 판매오더수동완료 처리를 하는 메소드.
     *
     * @param inputData Command로 부턴 전달받은 input LDataProtocol
     * 
     * @return LMultiData 조회된 리스트 결과.
     * @exception LException 메소드 수행시 발생한 모든 에러.
     */
    public void saveSalesOrdManualCmpt(LMultiData inputData) throws LException;    
    /**
     * 판매오더Partial완료목록 정보를 조회하는 메소드.
     *
     * @param inputData Command로 부턴 전달받은 input LDataProtocol
     * 
     * @return LMultiData 조회된 리스트 결과.
     * @exception LException 메소드 수행시 발생한 모든 에러.
     */
    public LMultiData retrieveSalesOrdPartCmptList(LData inputData) throws LException;

    /**
     * 판매오더수정이력목록 정보를 조회하는 메소드.
     *
     * @param inputData Command로 부턴 전달받은 input LDataProtocol
     * 
     * @return LMultiData 조회된 리스트 결과.
     * @exception LException 메소드 수행시 발생한 모든 에러.
     */
    public LMultiData retrieveMdfDlySalesOrdList(LData inputData) throws LException;

    /** 해상수입판매오더포워딩 정보를 조회하는 메소드.
     *
     * @param inputData Command로 부턴 전달받은 input LDataProtocol
     * 
     * @return LMultiData 조회된 리스트 결과.
     * @exception LException 메소드 수행시 발생한 모든 에러.
     */
    public LMultiData retrieveOceanImpSalesOrd(LData inputData) throws LException;

    /** 해상수입판매오더포워딩 정보를 조회하는 메소드.
     *
     * @param inputData Command로 부턴 전달받은 input LDataProtocol
     * 
     * @return LMultiData 조회된 리스트 결과.
     * @exception LException 메소드 수행시 발생한 모든 에러.
     */
    public LMultiData saveOceanImpSalesOrd(LMultiData multi) throws LException;

    /** 해상수입판매오더포워딩 정보를 조회하는 메소드.
     * 	@param inputData Command로 부턴 전달받은 input LDataProtocol
     *   	
     * @return LMultiData 조회된 리스트 결과.
     * @exception LException 메소드 수행시 발생한 모든 에러.
	 */
    public LMultiData divideOceanImpTran(LMultiData inputData, LMultiData multi) throws LException;
    
    /**
     * 판매오더검색팝업 정보를 추가/수정/삭제하는 메소드.
     *
     * @param inputData Command로 부턴 전달받은 input LDataProtocol
     * 
     * @exception LException 메소드 수행시 발생한 모든 에러.
     */
    public void cudSalesOrdMngt(LData inputData) throws LException;
    
    /**
     * 예외오더등록 정보를 조회하는 메소드.
     *
     * @param inputData Command로 부턴 전달받은 input LDataProtocol
     * 
     * @return LMultiData 조회된 리스트 결과.
     * @exception LException 메소드 수행시 발생한 모든 에러.
     */
    public LMultiData retrieveExceptSalesOrd(LData inputData) throws LException;
    
    /**
     * 판매오더수정이력조회
     * @param inputData
     * @return
     * @throws LException
     */
    public LMultiData retrieveSalesOrdMdfHist(LData inputData) throws LException;
    
    /**
     * 에외오더등록 계약고객 정보를 조회하는 메소드.
     *
     * @param inputData Command로 부턴 전달받은 input LDataProtocol
     * 
     * @return LMultiData 조회된 리스트 결과.
     * @exception LException 메소드 수행시 발생한 모든 에러.
     */
    public LMultiData retrieveCustCtrtExceptOrdType(LData inputData) throws LException;
    
    /**
     * 에외오더등록 계약고객 정보를 조회하는 메소드.
     *
     * @param inputData Command로 부턴 전달받은 input LDataProtocol
     * 
     * @return LMultiData 조회된 리스트 결과.
     * @exception LException 메소드 수행시 발생한 모든 에러.
     */
    public LMultiData retrieveCustOrdTypeEachCtrt(LData inputData) throws LException;
    
    /**
     * 수출입 계약번호 정보를 조회하는 메소드.
     *
     * @param inputData Command로 부턴 전달받은 input LDataProtocol
     * 
     * @return LMultiData 조회된 리스트 결과.
     * @exception LException 메소드 수행시 발생한 모든 에러.
     */
    public LMultiData retrieveCustOrdTypeEachCtrtTPL(LData inputData) throws LException;

    /**
     * 예외오더등록 정보를 추가/수정/삭제하는 메소드.
     *
     * @param inputData Command로 부턴 전달받은 input LDataProtocol
     * 
     * @exception LException 메소드 수행시 발생한 모든 에러.
     */
    public LMultiData saveExceptSalesOrd(LMultiData inputData) throws LException;
    
    public void changeExceptEoNo(LData inputData) throws LException;

    public LMultiData retrieveChangeOrderTypeList(LData inputData) throws LException;
    
    /**
     * 대기오더관리 정보를 조회하는 메소드.
     *
     * @param inputData Command로 부턴 전달받은 input LDataProtocol
     * 
     * @return LMultiData 조회된 리스트 결과.
     * @exception LException 메소드 수행시 발생한 모든 에러.
     */
    public LMultiData retrieveBackOrderList(LData inputData) throws LException;

    /**
     * 대기오더의 라인아이템 정보를 조회하는 메소드.
     *
     * @param inputData Command로 부턴 전달받은 input LDataProtocol
     * 
     * @return LMultiData 조회된 리스트 결과.
     * @exception LException 메소드 수행시 발생한 모든 에러.
     */
    public LMultiData retrieveBackOrderItemList(LData inputData) throws LException;
    
    /**
     * 대기오더의 대기오더를 분배하는  메소드.
     *
     * @param inputData Command로 부턴 전달받은 input LDataProtocol
     * @param inputData Command로 부턴 전달받은 input LDataProtocol
     * 
     * @exception LException 메소드 수행시 발생한 모든 에러.
     */
    public void divideBackOrd(LMultiData inputData1, LData inputData2) throws LException;

    /**
     * 대기오더의 대기오더(일괄)를 분배하는  메소드.
     *
     * @param inputData Command로 부턴 전달받은 input LDataProtocol
     * @param inputData Command로 부턴 전달받은 input LDataProtocol
     * 
     * @exception LException 메소드 수행시 발생한 모든 에러.
     */
    public void divideAllBackOrd(LData inputData1, LData inputData2) throws LException;
    
    
    /**
     * 미연계 판매오더 생성  메소드.
     *
     * @param inputData Command로 부턴 전달받은 input LDataProtocol
     * 
     * @exception LException 메소드 수행시 발생한 모든 에러.
     */
    public String createDcnctSalesOrd(LData inputData) throws LException;

    /** 내수판매오더실행관리 정보를 조회하는 메소드.
    *
    * @param inputData Command로 부턴 전달받은 input LDataProtocol
    * 
    * @return LMultiData 조회된 리스트 결과.
    * @exception LException 메소드 수행시 발생한 모든 에러.
    */
   public LMultiData retrieveDomSalesExceMngt(LData inputData) throws LException;
    
   /** 내수판매오더실행관리 정보를 저장하는 메소드.
   *
   * @param inputData Command로 부턴 전달받은 input LDataProtocol
   * 
   * @return LMultiData 조회된 리스트 결과.
   * @exception LException 메소드 수행시 발생한 모든 에러.
   */
  public void saveDomSalesOrdExceMngt(LMultiData inputData) throws LException;

  /** 오더를 취소하는 메소드.
  *
  * @param inputData Command로 부턴 전달받은 input LDataProtocol
  * 
  * @return LMultiData 조회된 리스트 결과.
  * @exception LException 메소드 수행시 발생한 모든 에러.
  */
 public LMultiData cancelSO(LData inputData) throws LException;

 /** Tpl 해상수출판매오더포워딩 정보를 조회하는 메소드.
 *
 * @param inputData Command로 부턴 전달받은 input LDataProtocol
 * 
 * @return LMultiData 조회된 리스트 결과.
 * @exception LException 메소드 수행시 발생한 모든 에러.
 */
public LMultiData retrieveTplOceanExpSalesOrdFwd(LData inputData) throws LException;
 
/** Tpl 해상수출판매오더포워딩 정보를 저장하는 메소드.
*
* @param inputData Command로 부턴 전달받은 input LDataProtocol
* 
* @return LMultiData 조회된 리스트 결과.
* @exception LException 메소드 수행시 발생한 모든 에러.
*/
public LMultiData saveTplOceanExpSalesOrdFwd(LMultiData inputData) throws LException;

/** 판매오더 상태 정보를 변경하는 메소드.
*
* @param inputData Command로 부턴 전달받은 input LDataProtocol
* 
* @return LMultiData 조회된 리스트 결과.
* @exception LException 메소드 수행시 발생한 모든 에러.
*/
public void changeSalesOrdStat(LData inputData) throws LException;

/** Tpl 해상수출판매오더포워딩의 운송분배를 지시하는 메소드.
*
* @param inputData Command로 부턴 전달받은 input LDataProtocol
* @param multiData Command로 부턴 전달받은 input LMultiDataProtocol
* 
* @exception LException 메소드 수행시 발생한 모든 에러.
*/
public LMultiData divideTplOcenaExpTran(LData inputData, LMultiData multiData) throws LException;


/** [판매오더생성]고객오더에의한 판매오더 생성하는 메소드.
 * 	@param 고객오더, 고객오더아이템리스트
 *   	
 * @exception LException 메소드 수행시 발생한 모든 에러.
 */
public LData createSalesOrd(LData inputData, LMultiData multi) throws LException;

/** 수정보류 판매오더 상세조회 메소드
*
* @param inputData Command로 부턴 전달받은 input LDataProtocol
* 
* @exception LException 메소드 수행시 발생한 모든 에러.
*/
public LMultiData retrieveMdfDlySalesOrdDtl(LData inputData) throws LException;

/** 수정보류 판매오더 상세조회 수정반영 메소드
*
* @param inputData Command로 부턴 전달받은 input LDataProtocol
* 
* @exception LException 메소드 수행시 발생한 모든 에러.
*/
public LMultiData applyMdfDlySalesOrdDtl(LMultiData inputData) throws LException;

/** 수정보류 판매오더 상세조회 수정거부 메소드
*
* @param inputData Command로 부턴 전달받은 input LDataProtocol
* 
* @exception LException 메소드 수행시 발생한 모든 에러.
*/
public LMultiData rejectMdfDlySalesOrdDtl(LData inputData) throws LException;

/** 판매오더 Partial 완료 상세 정보를 조회하는 메소드.
*
* @param inputData Command로 부턴 전달받은 input LDataProtocol
* 
* @return LMultiData 조회된 리스트 결과.
* @exception LException 메소드 수행시 발생한 모든 에러.
*/
public LMultiData retrieveSalesOrdPartCmptDtl(LData inputData) throws LException;

/** 판매오더 Partial 완료 사유 저장하는 메소드.
*
* @param inputData Command로 부턴 전달받은 input LDataProtocol
* 
* @return LMultiData 조회된 리스트 결과.
* @exception LException 메소드 수행시 발생한 모든 에러.
*/
public LMultiData updateSalesOrdPartCmpt(LMultiData inputData) throws LException;

/** 수출오더 혼적처리 하는 메소드
*
* @param inputData Command로 부턴 전달받은 input LDataProtocol
* 
* @return LMultiData 조회된 리스트 결과.
* @exception LException 메소드 수행시 발생한 모든 에러.
*/
public LData processExpOrdConsol(LMultiData inputData) throws LException;

/** 계열수출오더 포워딩관리 조회하는 메소드
*
* @param inputData Command로 부턴 전달받은 input LDataProtocol
* 
* @return LMultiData 조회된 리스트 결과.
* @exception LException 메소드 수행시 발생한 모든 에러.
*/
public LMultiData retrieveBranchOceanExpSalesOrdFwd(LData inputData) throws LException;

/** 계열수출오더 포워딩관리 Booking List 조회 하는 메소드
*
* @param inputData Command로 부턴 전달받은 input LDataProtocol
* 
* @return LMultiData 조회된 리스트 결과.
* @exception LException 메소드 수행시 발생한 모든 에러.
*/
public LMultiData retrieveBranchOceanExpSalesOrdBookingList(LData inputData) throws LException;

/** 계열수출오더 포워딩관리 저장 하는 메소드
*
* @param inputData Command로 부턴 전달받은 input LDataProtocol
* 
* @return LMultiData 조회된 리스트 결과.
* @exception LException 메소드 수행시 발생한 모든 에러.
*/
public LMultiData saveBranchOceanExpSalesOrdFwd(LMultiData inputData) throws LException;


public boolean saveBranchOceanExpSalesOrdFwdDir(LData inputData) throws LException;

/** 항공수입판매오더포워딩 정보를 조회하는 메소드.
*
* @param inputData Command로 부턴 전달받은 input LDataProtocol
* 
* @return LMultiData 조회된 리스트 결과.
* @exception LException 메소드 수행시 발생한 모든 에러.
*/
public LMultiData retrieveAirImpSalesOrd(LData inputData) throws LException;

/** 항공수입판매오더포워딩 정보를 저장하는 메소드.
*
* @param inputData Command로 부턴 전달받은 input LDataProtocol
* 
* @return LMultiData 조회된 리스트 결과.
* @exception LException 메소드 수행시 발생한 모든 에러.
*/
public LMultiData saveAirImpSalesOrd(LMultiData inputData) throws LException;
/** 항공수출판매오더포워딩 정보를 조회하는 메소드.
*
* @param inputData Command로 부턴 전달받은 input LDataProtocol
* 
* @return LMultiData 조회된 리스트 결과.
* @exception LException 메소드 수행시 발생한 모든 에러.
*/
public LMultiData retrieveAirExpSalesOrd(LData inputData) throws LException;

/** 항공수출판매오더포워딩 정보를 저장하는 메소드.
*
* @param inputData Command로 부턴 전달받은 input LDataProtocol
* 
* @return LMultiData 조회된 리스트 결과.
* @exception LException 메소드 수행시 발생한 모든 에러.
*/
public LMultiData saveAirExpSalesOrd(LMultiData inputData) throws LException;

/** 수출입판매오더실행관리 정보를 조회하는 메소드.
*
* @param inputData Command로 부턴 전달받은 input LDataProtocol
* 
* @return LMultiData 조회된 리스트 결과.
* @exception LException 메소드 수행시 발생한 모든 에러.
*/
public LMultiData retrieveExpImpSalesOrdExceMngt(LData inputData) throws LException;

/**
 * 항공수출판매오더포워딩 MAWB 정보조회하는 메소드.
 *
 * @param inputData Command로 부턴 전달받은 input LDataProtocol
 * 
 * @return LMultiData 조회된 리스트 결과.
 * @exception LException 메소드 수행시 발생한 모든 에러.
 */
public LMultiData retrieveMbl(LData inputData) throws LException;    


/**
 * 한솔제지 수입컨테이너 생성 메소드
 *
 * @param inputData Command로 부턴 전달받은 input LDataProtocol
 * 
 * @return LMultiData 조회된 리스트 결과.
 * @exception LException 메소드 수행시 발생한 모든 에러.
 */
public LData createHansolpaperImpCntr(LMultiData inputData) throws LException;

/** 수출입판매오더실행관리 정보를 저장하는 메소드.
*
* @param inputData Command로 부턴 전달받은 input LDataProtocol
* 
* @return LMultiData 조회된 리스트 결과.
* @exception LException 메소드 수행시 발생한 모든 에러.
*/
public void saveExpImpSalesOrdExceMngt(LMultiData inputData) throws LException;


/** 한솔홈데코 수입 BL 확정 정보를 전송하는 메소드.
*
* @param inputData Command로 부턴 전달받은 input LDataProtocol
* 
* @return LMultiData 조회된 리스트 결과.
* @exception LException 메소드 수행시 발생한 모든 에러.
*/
public void transferHansolhomedecoImpBlDcsn(LData inputData) throws LException;

/** 판매오더를 자동완료 처리하는 메소드
*
* @param inputData Command로 부턴 전달받은 input LDataProtocol
* 
* @return LMultiData 조회된 리스트 결과.
* @exception LException 메소드 수행시 발생한 모든 에러.
*/
public void processSalesOrdAutoCmpt(LData inputData) throws LException;

/** 판매오더 고객완료 처리하는 메소드
*
* @param inputData Command로 부턴 전달받은 input LDataProtocol
* 
* @return LMultiData 조회된 리스트 결과.
* @exception LException 메소드 수행시 발생한 모든 에러.
*/
public void processSalesOrdCustCmpt(LData inputData) throws LException;

/** 예외오더를 자동완료 처리하는 메소드
*
* @param inputData Command로 부턴 전달받은 input LDataProtocol
* 
* @return LMultiData 조회된 리스트 결과.
* @exception LException 메소드 수행시 발생한 모든 에러.
*/
public void processExceptOrdCmpt() throws LException;

/** 수입BL번호를 사용하여 해당하는 고객코드와 고객오더번호를 조회한다.
*
* @param inputData Command로 부턴 전달받은 input LDataProtocol
* 
* @return LMultiData 조회된 리스트 결과.
* @exception LException 메소드 수행시 발생한 모든 에러.
*/
public LMultiData retrieveImpBlCustSalesOrd(LData inputData) throws LException;

/** 고객코드와 고객오더번호로 수입BL정보를 조회한다.
*
* @param inputData Command로 부턴 전달받은 input LDataProtocol
* 
* @return LMultiData 조회된 리스트 결과.
* @exception LException 메소드 수행시 발생한 모든 에러.
*/
public LMultiData retrieveImpBlOrd(LData inputData) throws LException;

/**
 * 삼성토탈 수출컨테이너 생성/삭제하는 메소드.
 * 
 * @param inputData
 *            Command로 부턴 전달받은 input LDataProtocol
 * 
 * @exception LException
 *                메소드 수행시 발생한 모든 에러.
 */
public LData createStcExpCntr(LMultiData inputData) throws LException;

/**
 * 수입BL 생성하는 메소드.
 * 
 * @param inputData    Command로 부턴 전달받은 input LDataProtocol
 * 
 * @exception LException  메소드 수행시 발생한 모든 에러.
 */
public LMultiData createImpBlSalesOrd(LMultiData inputData) throws LException;

/**
 * 수입BL 취소하는 메소드.
 * 
 * @param inputData    Command로 부턴 전달받은 input LDataProtocol
 * 
 * @exception LException  메소드 수행시 발생한 모든 에러.
 */
public void cancelImpBlSalesOrd(LData inputData) throws LException;

/**
 * 수입출고오더분배 헤더 조회하는 메소드.
 * 
 * @param inputData    Command로 부턴 전달받은 input LDataProtocol
 * 
 * @exception LException  메소드 수행시 발생한 모든 에러.
 */
public LMultiData retrieveImpGiOrdList(LData inputData) throws LException;

/**
 * 수입출고오더분배 작업경로 조회하는 메소드.
 * 
 * @param inputData    Command로 부턴 전달받은 input LDataProtocol
 * 
 * @exception LException  메소드 수행시 발생한 모든 에러.
 */
public LMultiData retrieveImpGiItemWorkRouteList(LData inputData) throws LException;

/**
 * 수입출고오더분배 BL 가용재고 조회하는 메소드.
 * 
 * @param inputData    Command로 부턴 전달받은 input LDataProtocol
 * 
 * @exception LException  메소드 수행시 발생한 모든 에러.
 */
public LMultiData retrieveBlAvailStock(LData inputData) throws LException;

/**
 * 해상수입출고 저장  메소드.
 *
 * @param inputData Command로 부턴 전달받은 input LDataProtocol
 * 
 * @exception LException 메소드 수행시 발생한 모든 에러.
 */
public void saveDivideImpGiOrd(LMultiData inputData) throws LException;

/**
 * Liner PIC 조회하는 메소드.
 * 
 * @param inputData    Command로 부턴 전달받은 input LDataProtocol
 * 
 * @exception LException  메소드 수행시 발생한 모든 에러.
 */
public LMultiData retrieveShipOfcrList(LData inputData) throws LException;

/**
 * 판매오더 이력데이터 생성 메소드
 * 
 * @param inputData    Command로 부턴 전달받은 input LDataProtocol
 * 
 * @exception LException  메소드 수행시 발생한 모든 에러.
 */
public void setSalesOrdHistory(LData inputData) throws LException;

/**
 * 판매오더 자동수정 메소드
 * 
 * @param inputData    Command로 부턴 전달받은 input LDataProtocol
 * 
 * @exception LException  메소드 수행시 발생한 모든 에러.
 */
public LData updateSalesOrdAuto(LData header, LMultiData item) throws LException;

/**
 * 고객 거래선 입고오더 등록 메소드
 * 
 * @param inputData    Command로 부턴 전달받은 input LDataProtocol
 * 
 * @exception LException  메소드 수행시 발생한 모든 에러.
 */
public void createCustOfCustGrOrd(LData inputData) throws LException;

/**
 * HBL 중복조회. 
 * 
 * @param inputData    Command로 부턴 전달받은 input LDataProtocol
 * 
 * @exception LException  메소드 수행시 발생한 모든 에러.
 */
public LMultiData retrieveHblNoDouble(LData inputData) throws LException;

/** 출고취소 대상 정보를 조회하는 메소드.
*
* @param inputData Command로 부턴 전달받은 input LDataProtocol
* 
* @return LMultiData 조회된 리스트 결과.
* @exception LException 메소드 수행시 발생한 모든 에러.
*/
public LMultiData retrieveGiCnclTgtItem(LData inputData) throws LException;

/** 출고취소 정보를 저장하는 메소드.
*
* @param inputData Command로 부턴 전달받은 input LDataProtocol
* 
* @return LMultiData 조회된 리스트 결과.
* @exception LException 메소드 수행시 발생한 모든 에러.
*/
public LMultiData cancelGi(LMultiData inputData) throws LException;


/** 한솔제지수출오더완료처리 하는 메소드
*
* @param inputData Command로 부턴 전달받은 input LDataProtocol
* 
* @return LMultiData 조회된 리스트 결과.
* @exception LException 메소드 수행시 발생한 모든 에러.
*/
public LData processHansolpaperExpOrdCmpt(LData inputData, LMultiData multi) throws LException;

/** 오더완료처리 하는 메소드
*
* @param inputData Command로 부턴 전달받은 input LDataProtocol
* 
* @return LMultiData 조회된 리스트 결과.
* @exception LException 메소드 수행시 발생한 모든 에러.
*/
public LData processOrdCmpt(LData inputData, LMultiData multi) throws LException;


/** [판매오더생성]고객오더에의한 판매오더를 멀티건으로 생성하는 메소드.
 * 	@param 고객오더, 고객오더아이템리스트
 *   	
 * @exception LException 메소드 수행시 발생한 모든 에러.
 */
public LMultiData createSalesOrdMulti(LMultiData inputData, LMultiData multi) throws LException;

/**
 * 고객 거래선 입고오더 취소 메소드
 * 
 * @param inputData    Command로 부턴 전달받은 input LDataProtocol
 *  실행오더번호 
 * @exception LException  메소드 수행시 발생한 모든 에러.
 */
public void cancelCustOfCustGrOrd(LData inputData) throws LException;

/**
 * 수정-내수 분배취소 메소드
 * 
 * @param inputData    Command로 부턴 전달받은 input LDataProtocol
 *  실행오더번호 
 * @exception LException  메소드 수행시 발생한 모든 에러.
 */
public void deleteWorkRouteDomSalesOrd(LMultiData inputData) throws LException;

/** [수량 중량 환산]판매오더의 수량 중량을 환산
 * 	@param 고객오더, 고객오더아이템리스트
 *   	
 * @exception LException 메소드 수행시 발생한 모든 에러.
 */
public LMultiData changeQtyWgt(LData inputData, LMultiData multi) throws LException;

/** [판매오더생성잔여작업]
 * 	@param 판매오더, 판매오더아이템리스트
 *   	
 * @exception LException 메소드 수행시 발생한 모든 에러.
 */
public LData createSalesOrdRest(LData inputData, LMultiData multi) throws LException;


/**
 * 해상수입판매오더 포워딩 정보를 조회하는 메소드.
 *
 * @param inputData Command로 부턴 전달받은 input LDataProtocol
 * 
 * @return LMultiData 조회된 리스트 결과.
 * @exception LException 메소드 수행시 발생한 모든 에러.
 */
public LMultiData retrieveOceanImpPtnFwdOrd(LData inputData) throws LException;

/**
 * 해상수입판매오더 포워딩 정보를 조회하는 메소드.
 *
 * @param inputData Command로 부턴 전달받은 input LDataProtocol
 * 
 * @return LMultiData 조회된 리스트 결과.
 * @exception LException 메소드 수행시 발생한 모든 에러.
 */
public LMultiData retrieveOceanImpPtnFwdOrdInit(LData inputData) throws LException;

/**
 * 수입출고오더분배 헤더 조회하는 메소드.
 * 
 * @param inputData    Command로 부턴 전달받은 input LDataProtocol
 * 
 * @exception LException  메소드 수행시 발생한 모든 에러.
 */
public LMultiData retrieveOceanImpGiOrd(LData inputData) throws LException;

/**
 * 수입출고 아이템 분배내역을 조회하는 메소드.
 *
 * @param inputData Command로 부턴 전달받은 input LDataProtocol
 * 
 * @return LMultiData 조회된 리스트 결과.
 * @exception LException 메소드 수행시 발생한 모든 에러.
 */
public LMultiData retrieveImpGiItemDiv(LData inputData) throws LException;

/**
 * 상차지연실적번호를 수정하는 메소드.
 *
 * @param inputData Command로 부턴 전달받은 input LDataProtocol
 * 
 * @return void
 * @exception LException 메소드 수행시 발생한 모든 에러.
 */
public void updateLoadDlyRsltNo(LMultiData inputData) throws LException;

/**
 * 가용재고확인여부를 조회하는 메소드.
 *
 * @param inputData Command로 부턴 전달받은 input LDataProtocol
 * 
 * @return LMultiData 조회된 리스트 결과.
 * @exception LException 메소드 수행시 발생한 모든 에러.
 */
public LMultiData retrieveAvailStockConfYn(LData inputData) throws LException;

/**
 * Booking No 조회하는 메소드.
 *
 * @param inputData Command로 부턴 전달받은 input LDataProtocol
 * 
 * @return LMultiData 조회된 리스트 결과.
 * @exception LException 메소드 수행시 발생한 모든 에러.
 */
public LMultiData retrieveBookingNo(LData inputData) throws LException;

/**
 * 오더 SMS 전송.
 *
 * @param inputData 
 * 
 * @return void.
 * @exception LException 메소드 수행시 발생한 모든 에러.
 */
public void sendCustOrdStatSms(LData inputData) throws LException;

/**
 * 국제TPL SMS 전송.
 *
 * @param inputData 
 * 
 * @return void.
 * @exception LException 메소드 수행시 발생한 모든 에러.
 */
public void sendTplTranSms(LData inputData) throws LException;

/**
 * 오더접근권한 조회하는 메소드.
 *
 * @param inputData Command로 부턴 전달받은 input LDataProtocol
 * 
 * @return LMultiData 조회된 리스트 결과.
 * @exception LException 메소드 수행시 발생한 모든 에러.
 */
public void retrieveOrdAccessAuth(LData inputData) throws LException;

/**
 * 수출오더접근권한 조회하는 메소드.
 *
 * @param inputData Command로 부턴 전달받은 input LDataProtocol
 * 
 * @return LMultiData 조회된 리스트 결과.
 * @exception LException 메소드 수행시 발생한 모든 에러.
 */
public void retrieveExpOrdAccessAuth(LData inputData) throws LException;

/**
 * 항구재고오더를 조회하는 메소드.
 *
 * @param inputData Command로 부턴 전달받은 input LDataProtocol
 * 
 * @return LMultiData 조회된 리스트 결과.
 * @exception LException 메소드 수행시 발생한 모든 에러.
 */
public LMultiData retrievePortStockOrd(LData inputData) throws LException;

/**
 * 항구재고오더 분배하는 메소드.
 *
 * @param inputData Command로 부턴 전달받은 input LDataProtocol
 * 
 * @return void
 * @exception LException 메소드 수행시 발생한 모든 에러.
 */
public void dividePortStockOrd(LMultiData dataHolder) throws LException;

/**
 * 항구재고오더 분배취소하는 메소드.
 *
 * @param inputData Command로 부턴 전달받은 input LDataProtocol
 * 
 * @return void
 * @exception LException 메소드 수행시 발생한 모든 에러.
 */
public void cancelPortStockOrdDiv(LMultiData ordList) throws LException;

/**
 * 계열해상수출포워딩 고객정산담당자 변경 메소드
 *
 * @param inputData Command로 부턴 전달받은 input LDataProtocol
 * 
 * @return void
 * @exception LException 메소드 수행시 발생한 모든 에러.
 */
public void saveCustExcaOfcrNm(LMultiData ordList) throws LException;

/**
 * 계열해상수출포워딩 화물형태 변경 메소드
 *
 * @param inputData Command로 부턴 전달받은 input LDataProtocol
 * 
 * @return void
 * @exception LException 메소드 수행시 발생한 모든 에러.
 */
public void saveCargoFormCd(LMultiData ordList) throws LException;

/**
 * 전주페이퍼수출반품오더 조회
 *
 * @param inputData Command로 부턴 전달받은 input LDataProtocol
 * 
 * @return void
 * @exception LException 메소드 수행시 발생한 모든 에러.
 */
public LMultiData retrieveCancelGiExport(LData inputData) throws LException;

/**
 * 전주페이퍼수출반품오더 등록
 *
 * @param inputData Command로 부턴 전달받은 input LDataProtocol
 * 
 * @return void
 * @exception LException 메소드 수행시 발생한 모든 에러.
 */
public LMultiData saveCancelGiExport(LMultiData inputData) throws LException;

/**
 * 출고취소오더 조회
 *
 * @param inputData Command로 부턴 전달받은 input LDataProtocol
 * 
 * @return void
 * @exception LException 메소드 수행시 발생한 모든 에러.
 */
public LMultiData retrieveGiCnclOrdList(LData inputData) throws LException;

/**
 * 출고취소오더 조회
 *
 * @param inputData Command로 부턴 전달받은 input LDataProtocol
 * 
 * @return void
 * @exception LException 메소드 수행시 발생한 모든 에러.
 */
public LMultiData retrieveGiCnclOrdItemList(LData inputData) throws LException;

/**
 * 출고취소오더 조회
 *
 * @param inputData Command로 부턴 전달받은 input LDataProtocol
 * 
 * @return void
 * @exception LException 메소드 수행시 발생한 모든 에러.
 */
public LMultiData retrieveBackOrderMultiList(LData inputData) throws LException;

/** 청구고객, 매출부서 조회
*
* @param inputData Command로 부턴 전달받은 input LDataProtocol
* 
* @return LMultiData 조회된 리스트 결과.
* @exception LException 메소드 수행시 발생한 모든 에러.
*/
public LData getBilgCustInfo(LData inputData) throws LException;


/**
 * 판매오더 부분완료 상세 - 배치Job 처리 : 제지, 적송, 장항센터, 생성일로 부터 7일이후되도록 종결이 안된 오더
 *
 * @param inputData Command로 부턴 전달받은 input LDataProtocol
 * 
 * @return void
 * @exception LException 메소드 수행시 발생한 모든 에러.
 */
public void updateSalesOrdBatchPartCmpt() throws LException;

/**
 * 수입B/L 가용재고 생성 프로시져 호출 메소드.
 *
 * @param inputData Command로 부턴 전달받은 input LDataProtocol
 * 
 * @exception LException 메소드 수행시 발생한 모든 에러.
 */
public LData createImpBlAvailStock(LData inputData) throws LException;

/**
 * 수입출고 아이템 분배내역을 조회하는 메소드.(개선:가용재고생성로직적용)
 *
 * @param inputData Command로 부턴 전달받은 input LDataProtocol
 * 
 * @return LMultiData 조회된 리스트 결과.
 * @exception LException 메소드 수행시 발생한 모든 에러.
 */
public LMultiData retrieveImpGiImprvItemDiv(LData inputData) throws LException;

/**
 * 판매오더별 가용재고 체크
 * @param inputData
 * @throws LException
 */
public LData checkAvailStock(LData inputData) throws LException;

public void changeSelfTranOrderType(LData inputData1) throws LException;

public void changeCsnTranOrderType(LData inputData1) throws LException;

public String getCustOrdNo(LData inputData) throws LException;

public LMultiData saveBookingSheetFwd(LMultiData inputData) throws LException;

public LMultiData retrieveBookingSheetList(LData inputData) throws LException;

public LData getBilgCustInfoInh(LData inputData) throws LException;

public LData getBilgCustInfoFw(LData inputData) throws LException;


/**
 * 영업사원 정보를 조회하는 메소드.
 *
 * @param inputData Command로 부턴 전달받은 input LDataProtocol
 * 
 * @return LMultiData 조회된 리스트 결과.
 * @exception LException 메소드 수행시 발생한 모든 에러.
 */
public LMultiData retrieveSalesOfcrInfo(LData inputData) throws LException;

/** 페이퍼텍 오더생성 혹은 수정 후 프로시져 호출   
 * 	@param 고객코드, 오더번호, 등록자ID
 *   	
 * @exception LException 메소드 수행시 발생한 모든 에러.
 */
public LData createSalesOrdPaperProc(LData inputData) throws LException;

/** 페이퍼텍 tb_silk_order 테이블에 등록  하는 메소드.
 * 	@param 고객코드, 오더번호, 등록자ID
 *   	
 * @exception LException 메소드 수행시 발생한 모든 에러.
 */
public void createSilkOrder(LData inputData) throws LException;

/** 페이퍼텍 tb_silk_order 테이블에 수정 하는 메소드.
 * 	@param 고객코드, 오더번호, 등록자ID
 *   	
 * @exception LException 메소드 수행시 발생한 모든 에러.
 */
public void updateSilkOrder(LMultiData inputData) throws LException;

/** 페이퍼텍 tb_silk_order 테이블에 수정 하는 메소드.
 * 	@param 고객코드, 오더번호, 등록자ID
 *   	
 * @exception LException 메소드 수행시 발생한 모든 에러.
 */
public void deleteSilkOrder(LData inputData) throws LException;

/** 출고취소목록 조회하는 메소드.
 * 	@param inputData
 *   	
 * @exception LException 메소드 수행시 발생한 모든 에러.
 */
public LMultiData retrieveCancelGiList(LData inputData) throws LException;


/** 종결원복 목록 조회하는 메소드.
 * 	@param inputData
 *   	
 * @exception LException 메소드 수행시 발생한 모든 에러.
 */
public LMultiData retrievePartCmptList(LData inputData) throws LException;

/** 종결원복 저장하는 메소드.
 * 	@param inputData
 *   	
 * @exception LException 메소드 수행시 발생한 모든 에러.
 */
public void savePartCmptList(LMultiData inputData) throws LException;

/** 한솔제지예약오더완료처리 하는 메소드
*
* @param inputData Command로 부턴 전달받은 input LDataProtocol
* 
* @return LMultiData 조회된 리스트 결과.
* @exception LException 메소드 수행시 발생한 모든 에러.
*/
public LData processHppTransferOrdCmpt(LData inputData, LMultiData multi) throws LException;

/** BL진행 목록 조회하는 메소드.
 * 	@param inputData    
 *   	 
 * @exception LException 메소드 수행시 발생한 모든 에러.
 */
public LMultiData retrieveBLStatusList(LData inputData) throws LException;


public void saveBLStatusList(LMultiData inputData) throws LException;


// DEM, DET, TOT 속성 저장 기능 

}

