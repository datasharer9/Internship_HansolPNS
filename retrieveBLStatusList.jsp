<%@ include file="/sys/include/doctype.jsp" %>
<%@ page contentType="text/html; charset=utf-8"%>
<%--
/*
 *************************************************************************
 * @source  : retrieveBLStatusList.jsp
 * @desc    : 수입BL 진행현황
 *------------------------------------------------------------------------
 * VER  DATE         AUTHOR      DESCRIPTION
 * -----------------------------------------------------------------------
 * 1.0  2017/08/22   LEEJP       최초 작성
 * -----------------------------------------------------------------------
 * 한솔CSN 구축
 * Copyright(c) 2006-2007 LG CNS,  All rights reserved.
 *************************************************************************
 */
--%>
<html>
<head>
<%@include file="/sys/include/head.jsp"%>
<%@include file="/sys/include/gauce.jsp"%>
<%@include file="/jsp/iv/iv02/ivCommon.jsp"%>

<script language="javascript" src="<%= jsPath %>/comm/iv.js"></script>
<link href="<%= cssPath %>/widelayout.css"   rel="stylesheet" type="text/css"/>
<%
	String userId = userData.getUserId();
	String _sqlPath = "";
	if(ivPtnFlag) {
		_sqlPath = "select/iv/comm/comPopup/retrieveWorkPlInfoOrderPopupIv";
	}

%>
<!-----------------------------------------------------------------------------
  J A V A   S C R I P T   D E C L A R A T I O N
------------------------------------------------------------------------------>
<script language="javascript">

  var g_whseid   = '';
  var g_workPlCd = '';
  //-------------------------------------------------------------------------
  // 화면로딩시
  //-------------------------------------------------------------------------
  function f_OnLoad() {
    var from = "<%=pbf.comm.transfer.gauce.util.DateUtil.addDays(pbf.fw.support.util.DateUtil.getSysdate(),-31)%>";
    var to =  "<%=pbf.comm.transfer.gauce.util.DateUtil.getCurrentDateString()%>";  
     
    document.all.frDate.Text = from;
    document.all.toDate.Text   = to;  
  	document.all.q_workPlCd.value = "";
  	ds_BLStatusList.ClearData();  
  }
  
  //-------------------------------------------------------------------------
  // 저장
  //-------------------------------------------------------------------------
	//made by 구희성
	function f_Save() { //추후 함수명 수정

		//엑셀 업로드로 생성된 데이타를 디비에 저장하기위해 type를 ""로 변경한다.		
		for(var i = 1; i <= ds_BLStatusList.CountRow; i++) {

			if(ds_BLStatusList.NameValue(i, "type") == "E") {
				ds_BLStatusList.NameValue(i, "type") = "";
			}
		}
		
		//튜플이 없을 때는 저장할 것이 없습니다 경고창
		if(ds_BLStatusList.CountRow == 0) {
			cfAlertMsg("<sf:ez>pbf.inf.com.nosave</sf:ez>");
			return;
		}

   		//수정할 것이 없음 경고창
		if(!ds_BLStatusList.IsUpdated) {
			cfAlertMsg("<sf:ez>pbf.is.no.change</sf:ez>");
			return;
		}

		if (!cfValidate(document.all.gr_BLStatusList)) return;

		
		if(confirm("<sf:ez>pbf.cfm.com.save</sf:ez>")) {

	 		//tr_BLStatusList.Parameters = condition;
	    	tr_cudData.Action = "hsni.om.om02.salesOrdMngt.saveBLStatusList.gau"; //수정
	    	tr_cudData.post();		
		}
	}




  //-------------------------------------------------------------------------
  // 검색
  //-------------------------------------------------------------------------
  function f_Retrieve() {
    var f = document.all;
    var v_whseid   = "";

    // 필수 입력 항목
	if(!cfValidate(div_search)) {
	  return;
	}   
 
    if(!cfCheckPeriod("frDate", "toDate")) return;
    
  	//if ( !f_CheckDateTerm(document.all.frDate.text, document.all.toDate.text) ) {
	//	cfAlertMsg('일자 조회기간은 1개월이내만 가능합니다.');
	//	return;
	//}
    
    if(document.all.q_ptnCd.value!=""){ //WM센터정보를 조회하는 곳
        v_whseid = f_getWhseIdByWorkPlCdChg();
    }
    
  	var condition = "?whseid="         +v_whseid;
  		condition += "&q_ptnCd="       +document.all.q_ptnCd.value;   
  	    condition += "&q_workPlCd="    +document.all.q_workPlCd.value;                                            
	    condition += "&frDate="        +document.all.frDate.Text;                                                                      
	    condition += "&toDate="        +document.all.toDate.Text;                                          
	 
    ds_BLStatusList.DataID = "hsni.om.om02.salesOrdMngt.retrieveBLStatusList.gau"+condition;
    ds_BLStatusList.Reset();
    
  }
 
 //--------------------------------------------------------------
 
   function f_Retrieve2() {
    ds_importGrGiMngt.ClearData(); 
    
    //qtyl.innerHTML = "";
    //qtye.innerHTML = "";
    //qtyr.innerHTML = "";
    document.all.txt_TotalQtyexpected.value = 0;
    document.all.txt_TotalQtyreceived.value = 0;
    
    var v_whseid   = ""; 
  	 
	if(document.all.q_workPlCd.value!=""){ //WM센터정보를 조회하는 곳
        //v_whseid = cfRetrieveSingleDataFromDB("getWmWorkPlCd", "workPlCd="+document.all.q_workPlCd.value );
        v_whseid = f_getWhseIdByWorkPlCdChg();
    }
    // 필수 입력 항목
	if(!cfValidate(div_search)) {
	  return;
	}      

    var condition = "?whseid="        +v_whseid;    
	    condition += "&q_ptnCd="       +document.all.q_ptnCd.value;                                          
	    condition += "&co_DateFlag="   +co_DateFlag.ValueOfIndex("code",co_DateFlag.Index);                                         
	    condition += "&frDate="        +document.all.frDate.Text;                                                                      
	    condition += "&toDate="        +document.all.toDate.Text;                                          
		condition += "&co_status="     +co_status.ValueOfIndex("code",co_status.Index);                                                             
		condition += "&q_sku="         +document.all.q_sku.value;                                            
		condition += "&q_itemLvl1Cd="  +q_itemLvl1Cd.ValueOfIndex("code",q_itemLvl1Cd.Index);                                           
		condition += "&q_itemLvl2Cd="  +q_itemLvl2Cd.ValueOfIndex("code",q_itemLvl2Cd.Index);                                           
	    condition += "&q_itemLvl3Cd="  +q_itemLvl3Cd.ValueOfIndex("code",q_itemLvl3Cd.Index);                                                                                       
	    //condition += "&q_susr6="       +document.all.q_susr6.value;                                          
		//condition += "&q_susr9="       +document.all.q_susr9.value;                   
		//condition += "&q_susr7="       +document.all.q_susr7.value;                                          
		//condition += "&q_susr8="       +document.all.q_susr8.value;                                            
		//condition += "&q_lottable01="  +document.all.q_lottable01.value;  
		//condition += "&q_carNo="  	   +document.all.q_carNo.value;  
		//condition += "&q_shipmentNo="  +document.all.q_shipmentNo.value;  
		//condition += "&q_ordNo="  	   +document.all.q_ordNo.value;  
		//condition += "&q_skuLike="     +document.all.q_skuLike.value;                    
		condition += "&q_blNo="     		+document.all.q_blNo.value;                    
		condition += "&q_lottable10="     	+document.all.q_lottable10.value;  
		condition += "&q_workPlCd="			+q_workPlCd.value                  
        condition += "&inhYn="+INH_YN; //WMS INHOUNS DB 적용여부  
    //ds_importGrGiMngt.DataID = "hsni.wms.wm02.misMnfNo.retrieveMisMnfNoList.gau"+encodeURI(condition); 
    ds_importGrGiMngt.DataID = "hsni.wms.wm02.importGrGiMngt.retrieveImportGrGiMngtList.gau"+encodeURI(condition); 
    ds_importGrGiMngt.Reset();
 }
  
  function f_getWhseIdByWorkPlCdChg(){
  	  		
  	var v_whseid = "";
  	
  	  // 필수 입력 항목
	if(!cfValidate(div_search)) {
	  return;
	}   
  	
  	
  	if(g_workPlCd != document.all.q_workPlCd.value ) {
	  	if(document.all.q_workPlCd.value!=""){ //WM센터정보를 조회하는 곳
	        v_whseid = cfRetrieveSingleDataFromDB("getWmWorkPlCd", "workPlCd="+document.all.q_workPlCd.value );
	    }
	    
	    g_whseid = v_whseid;
	    g_workPlCd = document.all.q_workPlCd.value ;
    }
    
    return g_whseid ;
  }	

</script>


<!-----------------------------------------------------------------------------
  T R A N S A C T I O N   C O M P O N E N T S   D E C L A R A T I O N
------------------------------------------------------------------------------>
<!-- CUD TR -->

<OBJECT id=tr_cudData classid="<%=LGauceId.TR%>">
  <param name="KeyName" value="toinb_dataid4">
  <param name="KeyValue" value="Servlet(I:IN_DS1=ds_BLStatusList)"> <!--개발시 정정영역-->
  <param name="ServerIP" value="">
  <param name="SendNullData" value="true">
  <param name="Action" value="">
</OBJECT>

<!-----------------------------------------------------------------------------
    D A T A S E T   C O M P O N E N T S   D E C L A R A T I O N
------------------------------------------------------------------------------>
<!-- BLStatusList DataSet -->
<object id="ds_BLStatusList" classid="<%=LGauceId.DATASET%>">
	<param name=ViewDeletedRow  value=true>
</object>

<!-----------------------------------------------------------------------------
    G A U C E   C O M P O N E N T' S   E V E N T S
------------------------------------------------------------------------------>
<!-- 검색 DataSet -->
<script language=JavaScript for=ds_BLStatusList event=OnLoadCompleted(rowCnt)>
  cfShowTotalRows(document.all("blRowCnt"), rowCnt);
  cfHideDSWaitMsg(gr_BLStatusList);
  cfFillGridNoDataMsg(gr_BLStatusList);
</script>

<script language=JavaScript for=ds_BLStatusList event=OnLoadError()>
  cfShowErrMsg(ds_BLStatusList);
</script>

</header>
<!-----------------------------------------------------------------------------
    화면영역 시작
------------------------------------------------------------------------------>
<body OnLoad="f_OnLoad();">

<div class="layout_page">

  <div class="breadcrumb"><sf:breadcrumb menu="<%=curMenuCd%>"/></div>

  <div class="page_title"><sf:pagetitle menu="<%=curMenuCd%>"/></div>

  <div class="search" id="div_search">
    <table>
    <colgroup>
		<col width="7%"  align="right"/>
		<col width="20%"  align="left"/>
		<col width="7%" align="right"/>
		<col width="20%" align="left"/>
		<col width="10%" align="right"/>
		<col width="22%" align="left"/>
		<col width="7%" align="right"/>
	</colgroup>
	<tr> 
	  <td><font color=<%=LColor.MANDATORY%>>*</font><sf:ez>고객사</sf:ez> : </td>
	  <td>
	    <input type="TEXT" class="input_text" id="q_ptnCd"  style="width:55px;" maxlength="7" objType="data" onkeydown="cfKeyDown('ptn', 'C', q_ptnCd, q_ptnNm, '','','f_CallBack', '03');" onBlur="cfOnBlurPopup('ptn', 'C', q_ptnCd, q_ptnNm, '','','','','f_CallBack', '03');" validExp="<sf:ez>고객사</sf:ez>:yes:maxLength=7">
	    <input type="TEXT" class="input_text" id="q_ptnNm" style="width:100px;" objType="data" onkeydown="cfKeyDown('ptn', 'N', q_ptnCd, q_ptnNm, '','','f_CallBack', '03');" onBlur="cfOnBlurPopup('ptn', 'N', q_ptnCd, q_ptnNm, '','','','','f_CallBack', '03');">
	    <img src="<%=imagePath%>/pbf/Content_icon_search.gif" id="q_imgId" OnClick="cfOpenCommonPopup('ptn', 'M', q_ptnCd, q_ptnNm, '','','f_CallBack', '03')" onmouseOver="this.style.cursor='hand'">
	  </td> 
	  <td><font color=<%=LColor.MANDATORY%>>*</font>&nbsp;<sf:ez>항구</sf:ez> : </td>
	  <td>
		<input type="text" ID="q_workPlCd" class="input_text"  style="width:55px;" maxlength="5"  objType="data" onkeydown="cfKeyDown('workPl', 'C',q_workPlCd,q_workPlNm,'','센터','','05');" onBlur="cfOnBlurPopup('workPl', 'C',q_workPlCd,q_workPlNm,'','','','센터','','05');" validExp="<sf:ez>센터</sf:ez>:yes:maxLength=5">
		<input type="text" ID="q_workPlNm" class="input_text" style="width:100px;" maxlength="100"  objType="data" onkeydown="cfKeyDown('workPl', 'N',q_workPlCd,q_workPlNm,'','센터','','05');" onBlur="cfOnBlurPopup('workPl', 'C',q_workPlCd,q_workPlNm,'','','','센터','','05');">
		<img src="<%=imagePath%>/pbf/Content_icon_search.gif" OnClick="cfWorkPlInfoPtnPopupIv('M',q_workPlCd,q_workPlNm,'','05','workUserId=<%=userData.getUserId()%>;','','','<%=_sqlPath%>')" onmouseOver="this.style.cursor='hand'">
	  </td> 
      <td>&nbsp;<sf:ez>BL 수신일자</sf:ez> : </td>
		<td> 
			<comment id="__NOSCRIPT_ID__">
		        <object id="frDate" class="comnDate" classid="<%=LGauceId.EMEDIT%>" objType="data"  
		                validExp="시작일:no:date=YYYYMMDD">
		     	</object>
		     	</comment>
		     	<SCRIPT>__ShowEmbedObject(__NOSCRIPT_ID__);</SCRIPT>
		     	   <img src='<%=imagePath%>/pbf/calendar.gif' width='19' height='16' border='0' onClick='iv_cfShowCalendar(frDate);' 
		     	        onmouseOver=this.style.cursor='hand'  objType="data"> 
	     	   ~     
			<comment id="__NOSCRIPT_ID__">
		        <object id="toDate" class="comnDate" classid="<%=LGauceId.EMEDIT%>" objType="data"  
		                validExp="시작일:no:date=YYYYMMDD">
		     	</object>
		     	</comment>
		     	<SCRIPT>__ShowEmbedObject(__NOSCRIPT_ID__);</SCRIPT>
		     	   <img src='<%=imagePath%>/pbf/calendar.gif' width='19' height='16' border='0' onClick='iv_cfShowCalendar(toDate);' 
		     	        onmouseOver=this.style.cursor='hand'  objType="data">      	        
	      </td>
	      <td><input name="reset32" type="button" class="button_search" onClick="f_Retrieve()" value="<sf:ez>검색</sf:ez>"></td>
	  </tr>
    </table>
  </div>
  
  <div width="100%" class="table_layout">
    <!--Grid Component-->
    <comment id="__NOSCRIPT_ID__"><object id="gr_BLStatusList" classid="<%=LGauceId.GRID%>" class="comn" style="width:980px;height:380px;"
          dataName="Pattern 2"
          validFeatures="ignoreStatus=no"       
    >
      <param name="DataID"           value="ds_BLStatusList">
      <Param Name="AutoResizing"     value=true>
      <param name="ColSizing"		 value=true>
      <Param Name="DragDropEnable"   value=True>
      <Param Name="MultiRowSelect"   value=True>
      <Param Name="SortView"         value="Right">
      <Param Name="Editable"         value=True>
      <Param Name="AddSelectRows"    value=True>
      <Param Name="Format"           value='
        <c> id=custOrdRecpYmd    name=" <sf:ez>BL 수신일자</sf:ez> "  show=true  width=100   align=center sort=true   Edit=none  mask="XXXX-XX-XX"</c>
        <c> id=mblNo             name=" <sf:ez>BL NO</sf:ez> "        show=true  width=130   align=left   sort=true   Edit=none  </c>
        <c> id=podCd             name=" <sf:ez>입항항</sf:ez> "       show=true  width=100   align=center sort=true   Edit=none  </c>
        <c> id=arvPortPrarYmd    name=" <sf:ez>입항예정일자</sf:ez> " show=true  width=100   align=center sort=true   Edit=none  mask="XXXX-XX-XX"</c>
        <c> id=cargoFormCd       name=" <sf:ez>화물형태</sf:ez> "     show=true  width=100   align=center sort=true   Edit=none  EditStyle=Combo Data="<sf:gridcombodata code="CARGO_FORM_CD" />" </c>
        <c> id=tranCondCd        name=" <sf:ez>운송조건</sf:ez> "     show=true  width=100   align=center sort=true   Edit=none  EditStyle=Combo Data="<sf:gridcombodata code="TRAN_COND_CD" />" </c>
        <c> id=itemCd            name=" <sf:ez>아이템코드</sf:ez> "   show=true  width=100   align=left   sort=true   Edit=none  </c>
        <c> id=itemNm            name=" <sf:ez>아이템명</sf:ez> "     show=true  width=130   align=left   sort=true   Edit=none  </c>
        <c> id=ordQty            name=" <sf:ez>수량</sf:ez> "         show=true  width=100   align=right  sort=true   Edit=none  </c>
        <c> id=ordAdmt           name=" <sf:ez>ADMT</sf:ez> "         show=true  width=120   align=right  sort=true   Edit=none  </c>
        <c> id=ordWgt            name=" <sf:ez>중량</sf:ez> "         show=true  width=120   align=right  sort=true   Edit=none  </c>
        <c> id=statusYn          name=" <sf:ez>불용여부</sf:ez> "     show=true  width=100   align=center sort=true   Edit=none  </c>
        <c> id=status            name=" <sf:ez>입고상태</sf:ez> "     show=false width=100   align=center sort=true   Edit=none  </c>
        <c> id=statusNm          name=" <sf:ez>입고상태</sf:ez> "     show=true  width=100   align=center sort=true   Edit=none  </c>
        <c> id=clncDate          name=" <sf:ez>통관일자</sf:ez> "     show=true  width=100   align=center sort=true   Edit=none  mask="XXXX-XX-XX"</c>
        <c> id=actualrecorddate  name=" <sf:ez>입고일자</sf:ez> "     show=true  width=100   align=center sort=true   Edit=none  mask="XXXX-XX-XX"</c>
		<c> id=demFrtimeDays	 name=" <sf:ez>DEM</sf:ez> "    show=true width=100 align=right   sort=true Edit=true </c>
		<c> id=detFrtimeDays	 name=" <sf:ez>DET</sf:ez> "    show=true width=100 align=right   sort=true Edit=true </c>
		'>
    </object></comment><SCRIPT>__ShowEmbedObject(__NOSCRIPT_ID__);</SCRIPT>
  </div>

  <div class="button">
  <table width="100%" border="0" class="ds_table">
  <tr>
   <td align="left" width="12%">
     <sf:etcObj type="dsBtn" name="gr_BLStatusList" desc="blStatusList"/>
   </td> 
   <td align="left" width="33%">
     <span id="blRowCnt"></span>
   </td>
   <td align="right">
       &nbsp;
   </td>
 </tr>
 </table>
  <input type="button" id="bSave" class="button_default" value="<sf:ez>저장</sf:ez>" onclick="f_Save()" objType="bSave">
  
  </div>
</div>

<!-----------------------------------------------------------------------------
    화면영역 종료
------------------------------------------------------------------------------>

<!-----------------------------------------------------------------------------
      B I N D   C O M P O N E N T S   D E F I N I T I O N
------------------------------------------------------------------------------>
<%@include file="/sys/include/tail.jsp"%>
</body>
</html>

