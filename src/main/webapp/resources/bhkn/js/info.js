/**
 * 新闻资讯展现页面的js
 */
// 页面模板js初始化
new WOW().init();
//全局变量定义------------begin------
//定义新闻类型参数变量
var newsType = "hotNews";
// 定义当前的新闻总条数
var newsArraySize = hotNewsArry.length;
// 定义总页数
var pageNum;
// 定义当前所在的页数
var currentPageNum;
//全局变量定义------------end------
// 新闻页面初始化方法 ------begin
$(function() {
	$('[data-toggle="tooltip"]').tooltip();
	$('#topinfo').text("行情资讯");
	initnews ();
});

//初始化新闻页面
function initnews (){
	$('#newsBlock1').hide();
	$('#newsBlock2').hide();
	 newsType = "hotNews";//初始化默认展示热点新闻
	 newsArraySize = hotNewsArry.length; //初始化默认热点新闻长度
	// 初始化给页面渲染三个类型新闻列表信息
	 printAllNewsList();
	 //初始化分页信息
	 getPageListButton(newsArraySize);
}
// 新闻页面初始化方法 ------end
//新闻分类点击事件绑定-----begin------
$('#hotNews').click(function() {
	newsType = "hotNews";
	newsArraySize = hotNewsArry.length;
	getPageListButton(newsArraySize);
	$('#newsBlock2').hide();
	$('#newsBlock3').hide();
	$('#newsBlock1').fadeIn(3000);
});
$('#timeNews').click(function() {
	newsType = "timeNews";
	newsArraySize = timeNewsArray.length;
	getPageListButton(newsArraySize);
	$('#newsBlock1').hide();
	$('#newsBlock3').hide();
	$('#newsBlock2').fadeIn(3000);
});
$('#hangYeMove').click(function() {
	newsType = "hyNews";
	newsArraySize = hyNewsArray.length;
	getPageListButton(newsArraySize);
	$('#newsBlock1').hide();
	$('#newsBlock2').hide();
	$('#newsBlock3').fadeIn(3000);
});
//新闻分类点击事件绑定-----end------
// 新闻tab页点击事件绑定------begin
// 热点新闻点击事件绑定
$('#hotNewsd').click(function() {
	$('#hotNews').trigger("click");
});
// 实时资讯点击事件绑定
$('#qoutionnewsd').click(function() {
	$('#timeNews').trigger("click");
});
// 行情动向点击事件绑定
$('#trendnewsd').click(function() {
	$('#hangYeMove').trigger("click");
});
// 新闻tab页点击事件绑定------end
// 新闻详情查看------begin
function showDtail(id) {
	$('#myModalLabel').html("");
	$('#newabstract').html("");
	$('#author').html("");
	$('#newdate').html("");
	$('#myModalText').html("");
	var _url = '/psmc/login?username=query&ppassword=c4ca4238a0b923820dcc509a6f75849b&transmiturl=/website/backstage/tabNewsController.do?method=getNewsContent&uuid='
			+ id;
	$.ajax({
				type : "POST",
				url : _url,
				async : false,
				success : function(data) {
					var news = JSON.parse(data);
					var news = JSON.parse(data);
					$('#myModalLabeltitle').html(news.news_title);
					/* $('#myModalLabelsub').html(news.news_subtitle); */
					/* $('#newabstract').html("&nbsp;&nbsp;&nbsp;&nbsp;"+news.news_abstract); */
					$('#author').html(
							"&nbsp;&nbsp;&nbsp;&nbsp;" + news.news_author + "");
					$('#newdate')
							.html(
									"&nbsp;&nbsp;&nbsp;&nbsp;<span class='glyphicon glyphicon-time'></span>&nbsp;&nbsp;&nbsp;&nbsp;"
											+ news.news_date + "");
					$('#myModalText').html(news.news_content);
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					console.info(errorThrown);
				}
			});
}
// 新闻详情查看------end
//新闻列表内容展示------begin
//定义渲染新闻的方法
function printAllNewsList() {
	if(hotNewsArry){
		printNewsList(hotNewsArry,"热点新闻","newsBlock1","hotNews_");
	}
	if(timeNewsArray){
		printNewsList(timeNewsArray,"实时资讯","newsBlock2","timeNews_");
	}
	if(hyNewsArray){
		printNewsList(hyNewsArray,"行业动向","newsBlock3","hyNews_");
	}
	
}

/**
 * 打印新闻列表
 * @param newsArray 新闻列表的数组
 * @param newstype 新闻类型
 * @param newsBoockId 容器id
 * @param newsContentId 新闻标题id
 */
function printNewsList(newsArray,newstype,newsBoockId,newsContentId){
	if(newsArray){
		var arraySize = newsArray.length; //新闻列表长度
		for (var i = 0; i < arraySize; i++) {
			var uuid = newsArray[i].uuid;
			var news_author = newsArray[i].releaseAccName;
			var news_title = newsArray[i].news_title;
			var news_releaseDate = newsArray[i].release_date;
			if (i < 10) {
				$("#"+newsBoockId)
						.append(
								"<div id='"+newsContentId+
										+ (i + 1)
										+ "' class='panel panel-default'><div class='panel-heading panelGray'><span class='info-title' onclick='showDtail(\""
										+ uuid
										+ "\")' data-toggle='modal' data-target='#myModal'>"+newstype+">"
										+ news_title
										+ "</span></div><div class='panel-body'>发布者："
										+ news_author
										+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;发布时间："
										+ news_releaseDate + "</div></div>");
			} else {
				$("#"+newsBoockId)
						.append(
								"<div id='"+newsContentId+
										+ (i + 1)
										+ "' class='panel panel-default hidden'><div class='panel-heading panelGray'><span class='info-title' onclick='showDtail(\""
										+ uuid
										+ "\")' data-toggle='modal' data-target='#myModal' >"+newstype+">"
										+ news_title
										+ "</span></div><div class='panel-body'>发布者："
										+ news_author
										+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;发布时间："
										+ news_releaseDate + "</div></div>");
			}

		}
	}
}
	//新闻列表内容展示------end
	
//----------------------------新闻分页展示--------------begin--------
// 定义获取页数的方法
function getPageListButton(arraySize) {
	$('#pageList').empty();
	currentPageNum = 1;
	if (arraySize % 10 != 0) {
		pageNum = (arraySize - (arraySize % 10)) / 10 + 1;
	} else {
		pageNum = (arraySize - (arraySize % 10)) / 10;
	}
	$('#pageList').append(
					"<li><a aria-label='Previous' onclick='pervious();return false;'><span aria-hidden='true'>&laquo;</span></a></li>");
	$('#pageList').append(
			"<li><a onclick='firstPage();return false;'>首页</a></li>");
	for (var i = 0; i < pageNum; i++) {
		var currentPage = i + 1;
		if (i < 5) {
			$('#pageList').append(
					"<li id='tab_" + currentPage
							+ "'><a onclick='openTo(this);return false;'>"
							+ currentPage + "</a></li>");
		} else {
			$('#pageList')
					.append(
							"<li id='tab_"
									+ currentPage
									+ "' class='hidden'><a onclick='openTo(this);return false;'>"
									+ currentPage + "</a></li>");
		}
	}
	if (pageNum > 5) {
		$('#pageList').append("<li><a>...</a></li>");
	}
	$('#pageList').append(
			"<li><a onclick='lastPage();return false;'>末页</a></li>");
	$('#pageList')
			.append(
					"<li><a aria-label='Next' onclick='nextTo();return false;'><span aria-hidden='true'>&raquo;</span></a></li>");
	$("#tab_" + currentPageNum + "").addClass("active");
}
// 点击上一页按钮触发的方法
function pervious() {
	if (currentPageNum <= 1) {
		alert("已经到首页");
		return;
	}
	if ($("#tab_" + (currentPageNum - 1) + "").hasClass("hidden")) {
		$("#tab_" + (currentPageNum + 4) + "").addClass("hidden");
		$("#tab_" + (currentPageNum - 1) + "").removeClass("hidden");
		$("#tab_" + currentPageNum + "").removeClass("active");
		$("#tab_" + (currentPageNum - 1) + "").addClass("active");
	} else {
		$("#tab_" + currentPageNum + "").removeClass("active");
		$("#tab_" + (currentPageNum - 1) + "").addClass("active");
	}
	currentPageNum--
	// 根据页数展现新闻
	for (var i = 1; i < newsArraySize + 1; i++) {
		var begin = (currentPageNum * 10 - 9);
		var end = begin + 9;
		if (i >= begin && i <= end) {
			$("#" + newsType + "_" + i).removeClass("hidden");
		} else {
			$("#" + newsType + "_" + i).addClass("hidden");
		}
	}
	return;
}
// 点击下一页按钮触发的方法
function nextTo() {
	if (currentPageNum == pageNum) {
		alert("已经到末页");
		return;
	}
	if ($("#tab_" + (currentPageNum + 1) + "").hasClass("hidden")) {
		$("#tab_" + (currentPageNum - 4) + "").addClass("hidden");
		$("#tab_" + (currentPageNum + 1) + "").removeClass("hidden");
		$("#tab_" + currentPageNum + "").removeClass("active");
		$("#tab_" + (currentPageNum + 1) + "").addClass("active");
	} else {
		$("#tab_" + currentPageNum + "").removeClass("active");
		$("#tab_" + (currentPageNum + 1) + "").addClass("active");
	}
	currentPageNum++
	// 根据页数展现新闻
	for (var i = 1; i < newsArraySize + 1; i++) {
		var begin = (currentPageNum * 10 - 9);
		var end = begin + 9;
		if (i >= begin && i <= end) {
			$("#" + newsType + "_" + i).removeClass("hidden");
		} else {
			$("#" + newsType + "_" + i).addClass("hidden");
		}
	}
	return;
}
// 点击每一个标签页触发的方法
function openTo(target) {
	for (var i = 1; i < pageNum + 1; i++) {
		$("#tab_" + i + "").removeClass("active");
	}
	currentPageNum = $(target).text();
	$("#tab_" + currentPageNum + "").addClass("active");
	// 根据页数展现新闻
	for (var i = 1; i < newsArraySize + 1; i++) {
		var begin = (currentPageNum * 10 - 9);
		var end = begin + 9;
		if (i >= begin && i <= end) {
			$("#" + newsType + "_" + i).removeClass("hidden");
		} else {
			$("#" + newsType + "_" + i).addClass("hidden");
		}
	}
}
// 首页方法
function firstPage() {
	for (var i = 1; i < pageNum + 1; i++) {
		$("#tab_" + i + "").removeClass("active");
	}
	$("#tab_1").addClass("active");
	// 展示首页新闻列表
	for (var i = 1; i < newsArraySize + 1; i++) {
		var begin = 1;
		var end = begin + 9;
		if (i >= begin && i <= end) {
			$("#" + newsType + "_" + i).removeClass("hidden");
		} else {
			$("#" + newsType + "_" + i).addClass("hidden");
		}
	}
}
// 尾页方法
function lastPage() {
	for (var i = 1; i < pageNum + 1; i++) {
		$("#tab_" + i + "").removeClass("active");
	}
	$("#tab_" + pageNum + "").addClass("active");
	// 展示首页新闻列表
	for (var i = 1; i < newsArraySize + 1; i++) {
		var begin = (pageNum * 10 - 9);
		var end = begin + 9;
		if (i >= begin && i <= end) {
			$("#" + newsType + "_" + i).removeClass("hidden");
		} else {
			$("#" + newsType + "_" + i).addClass("hidden");
		}
	}
}

