<%@ include file="/ecps/console/common/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<title>添加品牌_品牌管理_商品管理</title>
<meta name="heading" content="品牌管理" />
<meta name="tag" content="tagName" />
<script type="text/javascript"
	src="<c:url value='/${system}/res/js/jquery.form.js'/>"></script>
<script type="text/javascript">
	$(function() {
		$("#form111").submit(function() {
			var cansubmit = true;
			//验证能为空值的表单值
			$("#form111").find("[reg1]").each(function() {
				if (!validate_null($(this))) {
					cansubmit = false;
				}
			});
			//验证不能为空值的表单值
			$("#form111").find("[reg2]").each(function() {
				if (!validate_notnull($(this))) {
					cansubmit = false;
				}
			});
			if(validateName($("#brandName"))){
				//验证成功，品牌名可以使用
			}else{
				//验证不成功，品牌名不能使用
				$("#brandName").next("span").html("<font color='red'>品牌名已经被使用，请更换</font>");
				cansubmit = false;
			}
			
			return cansubmit;
		});
		
		function validateName(tag){
			var result = true;
			//异步请求，查询品牌名称是否已经存在
			if (tag.attr("id") == "brandName") {
				$.ajax({
					url : '${path}/item/brand/nameExist.do',
					type : 'post',
					async: false,//主线程需要用到异步加载的返回值，所以使用与主线程同步
					dataType:'text',
					data:{
						brandName:$("#brandName").val()
					},
					success : function(responseText) {
						if(responseText=="no"){
							result = false;
						}
					}
				});
			}
			return result;
		}

		//只需要提供提示消息
		$("#form111").find("[reg2]").blur(function() {
			//创建正则表达式对象
			if (!validate_notnull($(this))) {
				return;
			}
			if(validateName($(this))){
				//验证成功，品牌名可以使用
			}else{
				//验证不成功，品牌名不能使用
				$(this).next("span").html("<font color='red'>品牌名已经被使用，请更换</font>");
			}
		});
		$("#form111").find("[reg1]").blur(function() {
			//创建正则表达式对象
			if (!validate_null($(this))) {
				return;
			}
		});

		//上传平拍logo图片
		$("#imgsFile").change(function() {
			if (!validate_notnull($(this))) {
				return;
			}
			var options = {
				url : '${path}/upload/uploadPic.do',
				type : 'post',
				dataType : 'text',
				success : function(responseText) {
					var jsonObj = $.parseJSON(responseText);
					$("#imgsImgSrc").attr("src",jsonObj.realPath);
					$("#imgs").val(jsonObj.relativePath);
					$("#lastPath").val(jsonObj.realPath);
				},
				error : function() {
					alert("系统错误");
				}
			};
			$("#form111").ajaxSubmit(options);//jQuery-form提供的异步提交表单的方式
		});
		//不允许为null的正则验证
		function validate_notnull(tag) {
			var nullMessage = tag.attr("nullTip");
			var message = tag.attr("tip");
			var name = tag.val();
			//不允许为null值或""
			if (name == "" || name == null) {
				tag.next("span").html(
						"<font color='red'>" + nullMessage + "</font>");
				return false;
			}
			var regStr = tag.attr("reg2");
			//创建正则表达式对象
			var reg = new RegExp(regStr);
			if (!reg.test(name)) {
				tag.next("span").html(
						"<font color='red'>" + message + "</font>");
				return false;
			} else {
				tag.next("span").html("");
			}
			return true;
		}
		//允许为null的正则验证
		function validate_null(tag) {
			var message = tag.attr("tip");
			var name = tag.val();
			var regStr = tag.attr("reg1");
			if (name == "" || name == null) {
				tag.next("span").html("");
				return true;
			}
			//创建正则表达式对象
			var reg = new RegExp(regStr);
			if (!reg.test(name)) {
				tag.next("span").html(
						"<font color='red'>" + message + "</font>");
				return false;
			} else {
				tag.next("span").html("");
			}
			return true;
		}
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

			<c:url value="/${system}/item/brand/listBrand.do" var="backurl" />

			<div class="loc icon">
				<samp class="t12"></samp>
				当前位置：商品管理&nbsp;&raquo;&nbsp;<a
					href="<c:url value="/${system }/brand/listBrand.do"/>" title="品牌管理">品牌管理</a>&nbsp;&raquo;&nbsp;<span
					class="gray">添加品牌</span> <a
					href="<c:url value="/item/brand/listBrand.do"/>"
					title="返回品牌管理" class="inb btn80x20">返回品牌管理</a>
			</div>
			<form id="form111" name="form111" action="${path }/item/brand/addBrand.do"
				method="post" enctype="multipart/form-data">
				<div class="edit set">
					<p>
						<label><samp>*</samp>品牌名称：</label><input type="text"
							id="brandName" name="brandName" class="text state"
							reg2="^[a-zA-Z0-9\u4e00-\u9fa5]{1,20}$"
							tip="亲,必须是中英文或数字字符，长度1-20" nullTip="亲,品牌名称不允许为null" /> <span></span>
					</p>
					<p>
						<label class="alg_t"><samp>*</samp>品牌LOGO：</label><img
							id='imgsImgSrc' src="" height="100" width="100" />
					</p>
					<p>
						<label></label><input type='file' size='27' id='imgsFile'
							reg2='^.*.(?:jpg|gif|jpeg)$' tip="亲,你上传的文件不符合格式"
							nullTip="亲！您忘记上传图片了。" name='imgsFile' class="file" /> <span
							style="color: red"></span> <span id="submitImgTip" class="pos">请上传图片宽为120px，高为50px，大小不超过100K。</span>
							<input id="imgs" type="hidden" name="imgs" value=""/>
							<input id="lastPath" type="hidden" name="lastPath" value=""/>
					</p>

					<p>
						<label>品牌网址：</label><input type="text" name="website"
							class="text state" maxlength="100" tip="请以http://开头"
							reg1="http:///*" /> <span class="pos">&nbsp;</span>
					</p>
					<p>
						<label class="alg_t">品牌描述：</label>
						<textarea rows="4" cols="45" name="brandDesc" class="are"
							reg1="^(.|\n){0,300}$" tip="任意字符，长度0-300"></textarea>
						<span class="pos">&nbsp;</span>
					</p>
					<p>
						<label>排序：</label><input type="text" id="brandSort"
							reg1="^[1-9][0-9]{0,2}$" tip="排序只能输入1-3位数的正整数" name="brandSort"
							class="text small" /> <span class="pos">&nbsp;</span>
					</p>
					<p>
						<label>&nbsp;</label><input type="submit" name="button1" d
							class="hand btn83x23" value="完成" /><input type="button"
							class="hand btn83x23b" id="reset1" value='取消'
							onclick="backList('${backurl}')" />
					</p>
				</div>
			</form>
			<div class="loc">&nbsp;</div>
		</div>
	</div>
</body>
