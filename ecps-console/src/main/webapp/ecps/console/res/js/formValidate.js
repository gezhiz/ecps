/*//������Ϊnull��������֤
function validate_notnull(tag) {
	var nullMessage = $(tag).attr("nullTip");
	var message = $(tag).attr("tip");
	var name = $(tag).val();
	if (name == "" || name == null) {
		$(tag).next("span")
				.html("<font color='red'>" + nullMessage + "</font>");
		return false;
	}
	var regStr = $(tag).attr("reg2");
	// ����������ʽ����
	var reg = new RegExp(regStr);
	if (!reg.test(name)) {
		$(tag).next("span").html("<font color='red'>" + message + "</font>");
		return false;
	} else {
		$(tag).next("span").html("");
	}
	return true;
}
// ����Ϊnull��������֤
function validate_null(tag, reg, message) {
	var name = $(tag).val();
	var regStr = $(tag).attr("reg2");
	// ����������ʽ����
	var reg = new RegExp(regStr);
	if (!reg.test(name)) {
		$(tag).next("span").html("<font color='red'>" + message + "</font>");
		return false;
	} else {
		$(tag).next("span").html("");
	}
	return true;
}*/
$.fn.pluginName = function() {
	alert();
}
