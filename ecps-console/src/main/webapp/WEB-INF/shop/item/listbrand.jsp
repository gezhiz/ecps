<%@ include file="/ecps/console/common/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<title>品牌管理_商品管理</title>
<meta name="heading" content="<fmt:message key='mainMenu.heading'/>" />
<meta name="brand" content="brandName" />
<script type="text/javascript">
	var flag=null;
    function singleDel(brandId){
    	//tipShow('#confirmDiv');
    	if(confirm("你确认要删除该品牌吗?")){
    		window.location.href = "${path}/item/brand/deleteBrand.do?brandId="+brandId;
    	}
    }
    function batchDel(){
        if(!isChecked()){
            alert("请选择记录");
            return;
        }
        tipShow('#confirmDiv');
        flag="batchDel";
/*         if(confirm("确定删除这些记录")){
        	$("#form1").attr("action","${base}/item/brand/batchDelBrandById.do");
	       	$("#form1").submit();
        } */

    }

    

    

    $(document).ready(function(){
		$("#all").click(function(){
	     	if($("#all").attr("checked")){
	        	$("input[name='ids']").attr("checked", true);
	        }else{
	        	$("input[name='ids']").attr("checked", false);
	        }
	    });
		$("#checkall").click(function(){
			$("input[name='ids']").attr("checked", true);
			$("#all").attr("checked",true)
		});
		$("#cancelall").click(function(value){
			$("input[name='ids']").attr("checked", false);
			$("#all").attr("checked",false)
		});
		

		<c:if test="${message!=null }">
			alert("<c:out value='${message }'/>");
		</c:if>
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
				当前位置：商品管理&nbsp;&raquo;&nbsp;<span class="gray">品牌管理</span>
			</div>

			<form id="form1" name="form1"
				action="${base}/item/brand/listBrand.do" method="post">
				<div class="page_c">

					<span class="r inb_a"> <a
						href="${path }/item/brand/addBrandUI.do" title="添加" class="btn80x20">添加</a>
					</span>
				</div>

				<table cellspacing="0" summary="" class="tab">
					<thead>
						<th>品牌编号</th>
						<th>品牌图片</th>
						<th>品牌名称</th>
						<th>品牌网址</th>
						<th>品牌描述</th>
						<th width="10%">排序</th>
						<th width="10%">操作</th>
					</thead>
					<tbody>
						<c:forEach items="${brandList}" var="brand" varStatus="index">
							<tr>
								<td>${brand.brandId }</td>
								<td><img id='imgsImgSrc'
									src="${hostPath}/${brand.imgs}"
									height="50" width="50" /></td>
								<td>${brand.brandName }</td>
								<td class="nwp">${brand.website }</td>
								<td class="nwp">${brand.brandDesc }</td>
								<td>${brand.brandSort }</td>
								<td><a href="${path }/item/brand/editBrandUI.do?brandId=${brand.brandId }">编辑</a>
									<a href="#" onclick="singleDel(${brand.brandId })">删除</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</form>
		</div>
	</div>
</body>


