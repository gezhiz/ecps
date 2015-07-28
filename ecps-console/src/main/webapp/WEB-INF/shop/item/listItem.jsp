<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/ecps/console/common/taglibs.jsp"%>
<head>
<title>商品录入及上下架管理_商品管理</title>
<meta name="heading" content="商品录入及上下架管理" />
<meta name="menu" content="ItemMgmtMenu" />
<script type="text/javascript"
	src="<c:url value='/${system}/res/js/jquery.form.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/${system}/res/js/jquery.tablesorter.js'/>"></script>
<script language="javascript" type="text/javascript">
	$(function() {
		var showStatus = $("#showStatus").val();
		showStatus = parseInt(showStatus);
		if(showStatus==1){
			//未上架
			$("#label4").attr("class","here");
			$("#label5").attr("class","nor");
			$("#label6").attr("class","nor");
		}
		else	if(showStatus==0){
			//已上架
			$("#label4").attr("class","nor");
			$("#label5").attr("class","here");
			$("#label6").attr("class","nor");
			
		}else{
			//全部
			$("#label4").attr("class","nor");
			$("#label5").attr("class","nor");
			$("#label6").attr("class","here");
		}
		
		var pageNo = parseInt($("#pageNo").val());
		var totalPage = parseInt($("#totalPage").val());
		if(totalPage<=1){
			$("#previous").hide();
			$("#next").hide();
			$("#firstPage").hide();
			$("#lastPage").hide();
		}else if(pageNo<=1){
			$("#previous").hide();
			$("#next").show();
			$("#firstPage").hide();
			$("#lastPage").show();
		}else if(pageNo>1&&pageNo<totalPage){
			$("#previous").show();
			$("#next").show();
			$("#firstPage").show();
			$("#lastPage").show();
		}else{
			$("#previous").show();
			$("#next").hide();
			$("#firstPage").show();
			$("#lastPage").hide();
		}
		$("#next").click(function (){
			 $("#pageNo").val(pageNo+1);
			 $("#form1").submit();
		});
		$("#previous").click(function (){
			$("#pageNo").val(pageNo-1);
			 $("#form1").submit();
		});
		$("#firstPage").click(function (){
			 $("#pageNo").val(1);
			 $("#form1").submit();
		});
		$("#lastPage").click(function (){
			$("#pageNo").val(totalPage);
			 $("#form1").submit();
		});
	});
</script>
</head>
<body id="main">

	<div class="frameL">
		<div class="menu icon">
			<jsp:include page="/${system}/common/itemmenu.jsp" />
		</div>
	</div>

	<div class="frameR">
		<div class="content">

			<div class="loc icon">
				<samp class="t12"></samp>
				当前位置：商品管理&nbsp;&raquo;&nbsp;<span class="gray" title="商品录入及上下架">商品录入及上下架</span>
			</div>

			<h2 class="h2_ch">
				<span id="tabs" class="l"> <!--  <a id="label3" href="${base}/item/listEntity.do?showStatus=2"   title="待上架实体商品" class="nor">待上架</a>  -->
					<a id="label6" href="${path}/item/queryItemByCondtion.do"
					title="全部实体商品" class="nor">全部</a> <a id="label4"
					href="${path}/item/queryItemByCondtion.do?showStatus=1&auditStatus=1"
					title="未上架实体商品" class="nor">未上架</a> <a id="label5"
					href="${path}/item/queryItemByCondtion.do?showStatus=0&auditStatus=1"
					title="已上架实体商品" class="nor">已上架</a>
				</span>
			</h2>

			<form id="form1" name="form1"
				action="${path}/item/queryItemByCondtion.do" method="post">

				<input type="hidden" id="deleteAction" name="deleteAction"
					value="${base}/item/deleteItem.do" /> <input type="hidden"
					id="deleteCheckAction" name="deleteCheckAction"
					value="${base}/item/deleteCheck.do" /> <input type="hidden"
					id="showStatus" name="showStatus" value="${queryCondition.showStatus}" /><!--  <input
					type="hidden" id="auditStatus" name="auditStatus" value="1" /> -->
				<div class="sch">
					<input type="hidden" id="userSearch" name="userSearch" />
					<p>
						搜索：
						<ui:select name="catID" list="catList" rootId="0"
							defaulttext="所有分类" defaultvalue="" currentValue="${catID}" />
						<select id="brandId" name="brandId" value="">
							<option value="">全部品牌</option>
							<c:forEach items="${bList }" var="brand">
								<option value="${brand.brandId }"
									<c:if test="${brand.brandId == queryCondition.brandId}">selected</c:if>>${brand.brandName }
								</option>
							</c:forEach>
						</select>
						 <select id="auditStatus" name="auditStatus">
							<option value="" selected>全部审核状态</option>
							<option value="0"
								<c:if test="${queryCondition.auditStatus == 0}">selected</c:if>>待审核</option>
							<option value="1"
								<c:if test="${queryCondition.auditStatus == 1}">selected</c:if>>通过</option>
							<option value="2"
								<c:if test="${queryCondition.auditStatus == 2}">selected</c:if>>不通过</option>
						</select> <input type="text" id="searchText" value="${queryCondition.itemName }"
							name="itemName" title="请输入商品名称" class="text20 medium gray" /> <input
							type="submit" id="goSearch" class="hand btn60x20" value="查询" />
					</p>
				</div>

				<div class="page_c">
					<span class="l"> </span> <span class="r inb_a"> <a
						href="${path}/item/toAddItem.do" class="btn80x20" title="添加商品">添加商品</a>
					</span>
				</div>

				<table cellspacing="0" summary="" class="tab" id="myTable">
					<thead>
						<th>商品编号</th>
						<th class="wp">商品名称</th>
						<th>图片</th>
						<th>新品</th>
						<th>推荐</th>
						<th>特价</th>
						<th>上下架</th>
						<th>审核状态</th>
						<th>操作</th>
					</thead>
					<tbody>
						<c:forEach items="${page.items}" var="item">
							<tr>
								<td>${item.itemId }</td>
								<td>${item.itemName }</td>
								<td><img alt=""
									src="http://127.0.0.1:8088/pic_server/upload/" width="50"
									height="50"></td>
								<td><span class="<c:if test='${item.isNew==1}'>is</c:if><c:if test='${item.isNew==0}'>not</c:if>"></span></td>
								<td><span class="<c:if test='${item.isNew==1}'>is</c:if><c:if test='${item.isNew==0}'>not</c:if>"></span></td>
								<td><span class="<c:if test='${item.isNew==1}'>is</c:if><c:if test='${item.isNew==0}'>not</c:if>"></span></td>
								<td><span class="<c:if test='${item.isNew==1}'>is</c:if><c:if test='${item.isNew==0}'>not</c:if>"></span></td>
								<td>
									<c:if test="${item.auditStatus==2}">不通过</c:if>
									<c:if test="${item.auditStatus==1}">通过</c:if>
									<c:if test="${item.auditStatus==0}">待审核</c:if>
								</td>
								<td><a href="${path}/item/viewItem.do?itemId=${item.itemId}"
									title="查看">查看</a> <a
									href="/ecps-console/ecps/console/item/editItem.do?type=1&itemId=2384">编辑</a>
									<a href="javascript:void(0);" onclick="singleDel('2384')">删除</a>
									<a href="javascript:void(0);" group="2384,0" itemId=2440
									showStatus="0">上架</a></td>
							</tr>
					</tbody>
					</c:forEach>
					<tr>
						<td colspan="13" align="right">选择：<a
							href="javascript:void(0);" title="全选" onclick="checkAllIds();">全选</a>
							<samp>-</samp> <a href="javascript:void(0);" title="取消"
							onclick="uncheckAllIds();">取消</a>
						</td>
					</tr>
				</table>

				<div class="page_c">
					<span class="l inb_a"> </span>
					 <span class="r page"> 
					 <input type="hidden" value="${page.startNo }" id="startNo" name="startNo"/>
					 <input type="hidden" value="${page.endNo }" id="endNo" name="endNo"/>
					<input 	type="hidden" value="${page.pageNo }" id="pageNo" name="pageNo" /> 
					<input 	type="hidden" value="${page.totalCount}" id="totalCount" 	name="totalCount" /> 
					<input type="hidden" 	value="${page.totalPage}" id="totalPage" name="totalPage" />
								 共 <var s	id="pagePiece" class="orange">${ page.totalCount}</var>条<var id="pageTotal">${ page.pageNo}/${page.totalPage }</var>
					<a href="#" id="firstPage" class="hidden" title="上一页">第一页</a> 
					<a href="#" id="previous" class="hidden" title="上一页">上一页</a> 
					<a href="#" id="next" 	class="hidden" title="下一页">下一页</a>
					<a href="#" id="lastPage" 	class="hidden" title="下一页">最后一页</a>
					</span>
				</div>
			</form>
		</div>
	</div>
</body>