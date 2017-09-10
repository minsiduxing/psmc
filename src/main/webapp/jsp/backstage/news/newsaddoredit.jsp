<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	.newsForm>ul>li{
			list-style: none;
			padding:0.5%;
			
		}
	.newsForm>ul>li>lable{
			margin:2%;
		}
	.newsForm>ul>li>span{
			width:100%;
			margin-top: 1%;
		}
		.newsForm>ul>li>input{
			width:40%;
			margin-top: 1%;
		}
	.operButon{
		 width:98%;
		 margin-left: 2.5%;
		}
	.operButon>input{
		 padding:5px 0px;
		 margin-right: 2%;
		 margin-left: 2%;
		 width:5%;
		}
      #container {
            width: 100%;
            margin: 0 auto;
        }
        #toolbar-container {
          margin-top: 1%;
            width:80%;
            border: 1px solid #ccc;
            background-color: #fff;
        }
        #toolbar-container:after {
            display: table;
            content: '';
            clear: both;
        }
        #editor-toolbar {
            float: left;
            
        }
        #btn-container {
            margin-top: 1%;
            float: right;
            text-align: right;
            margin-left:-2%;
        }
        #newsContent {
            width:80%;
            border: 1px solid #ccc;
            border-top: 0;
            height: 300px;
            background-color: #fff;
            margin-top: 1%;
        }
        #cover {
            display: none;
            position: fixed;
            z-index: 100000;
            top: 2px;
            left: 5px;
            right: 5px;
            bottom:2px;
            height: 98%;
            width:100%
            padding: 20px;
            background-color: #f1f1f1;
        }
        #picpreview{
        margin-top:1%;
        border: 1px solid #D4D4D4;
        width:80%;
        }
        #picpreview>img{
         margin:1%;
         border: 1px solid #D4D4D4;
        }
        .img-btn{
        	width:10%;
        	text-align: center;
        	float:right;
        }
</style>
  </head>
  <%@ include file="../../../common.jsp"%>
  <body id="body">
<form id="editForm" method="POST" class="newsForm">
		<ul >
			<li ><label>新闻标题</label><br>
				<input  id="newsTitle" name="newsTitle"></input>
			</li>
			 <li  ><label for="">新闻子标题</label><br>
				<input  id="newSubTitle" name="newSubTitle"></input>
			</li> 
			<li><label >内容摘要</label><br>
				<input id="newsAbstarct" name="newsAbstarct"></input></li>
			<li><label>新闻配图</label><br>
			<input type="hidden" id="hiddenfile" name="thumbnailImageUrl"/>
			<div id="picpreview" >
			<div id="thumbnailImageUrl"></div>
			
			</div>
			</li>
			<li ><label >新闻内容</label><br>
			 <!--非全屏模式-->
			    <div id="container">
			        <!--菜单栏-->
			        <div id="toolbar-container">
			            <div id="editor-toolbar"></div>
			            <div id="btn-container">
			                <button id="btn1">全屏</button>
			            </div>
			        </div>
			        <div id="newsContent" class="newsContent">
			        </div>
                </div>
                </li>
			<li ><label>新闻时间</label><br>
				<input id="newsDate" name="newsDate"></input></li>
			<li ><label >新闻作者：</label><br>
				<input  id="newAutor" name="newAutor"></input></li>
		</ul>
	  <div class="operButon">
			<input id="submitbtn" type="submit" class="easyui-linkbutton" onclick=" " value="提交"/>
			<input id="reset" type="reset" class="easyui-linkbutton" onclick=" "  value="重置"/>
	</div>
	</form>
	
        <!--全屏模式-->
    <div id="cover"></div>
        
  </body>
</html>
<script type="text/javascript">
    $(document).ready(function(){
    	wangEditorInit();
    	 formInint();
    });
    //用户离开页面删除临时文件
    window.onbeforeunload=function(){
    	return "\n确认离开该页面吗？离开后未上传图片将不被保存";
    }
    window.onunload=function(){
    	deleteFile();
    	return "";
    }
    var basePath = $("#basePath").val();
    var uploadUrl = basePath+"/website/backstage/tabNewsController.do";
    uploadUrl ='<c:url value="'+uploadUrl+'"/>?method=uploadPic';
    var newsPicWidth=0,newsPicHeight=0,imgWidth=0,imgHeight=0;
	var x,y,w,h;
	var pirSrc ;
	var getImag;
    $('#thumbnailImageUrl').Huploadify({
        auto:true,
        fileTypeExts:'*.jpg;*.png;*.JPG',
        multi:false,
        formData:{key:123456,key2:'vvvv'},
        fileSizeLimit:1024,
        fileObjName:'newsPic',
        showUploadedPercent:true,
        showUploadedSize:true,
        uploader:uploadUrl,
        buttonText:'选择图片',
        onUploadStart:function(){
            console.log('开始上传');
            $('.uploadify-queue').html('');
            },
        onInit:function(){
            console.log('初始化');
            $(".uploadify-queue ").hide();
            },
        onUploadComplete:function(file,data){
        	var ao = $.parseJSON(data);
        	if(ao.result=='1') {
        		deleteFile();
        		pirSrc = ao.picSrc;
        		newpic =$.parseJSON(ao.newsPic);
        		showPicpreview(ao.picSrc,"true");
        		newsPicWidth = newpic.newsPicWidth;
				newsPicHeight = newpic.newsPicHeight;
				imgWidth = ao.newsPic.imgWidth;
				imgHeight = ao.newsPic.imgHeight;
				getImag='<c:url value="/system/freamwork/fileUploadController"/>?method=getImage&filePath='+pirSrc;
				$("#picpreimg").before("<div id='pc' style='width:"+newsPicWidth+"px;height:"+newsPicHeight+"px;overflow:hidden;margin-bottom:5px;'><img id='preview' src='"+getImag+"'/></div>");
				$("#picpreimg ").Jcrop({
					aspectRatio:newsPicWidth/newsPicHeight,
					onChange: showPreview,
					onSelect: showPreview,
					allowResize:false ,
					setSelect: [0,0,newsPicWidth,newsPicHeight]
				});
				$("#confirmSelect").click(confirmSelect);
        	}else{
        		alert(ao.msg);
        	}
            },
        onCancel:function(file){
            console.log(file);
        }
    });
    //预览图片显示
    function showPicpreview(picSrc,showbtn){
        getImag='<c:url value="/system/freamwork/fileUploadController"/>?method=getImage&filePath='+picSrc;
    	var previewImg='<img alt="预览图片" id="picpreimg" src='+getImag+'>';
    	if(showbtn=="true"){
    		var imgBtn ='<input type="button" value="上传" id="confirmSelect" class="img-btn" id="confirmSelect"/>';
        	$("#picpreview").append(imgBtn+previewImg);
    	}else{
    		$("#picpreview").append(previewImg);
    	}
    }
    //重新上传时删除已经存在的图片
    function deleteFile(){
            var imgSrc = $("#picpreimg").attr("src");
            if(imgSrc!=undefined && imgSrc!=''){
            	imgSrc = imgSrc.replace('getImage','fileDelete');
            	var _url='<c:url value="'+imgSrc+'"/>';
            	$.ajax({
     				async:false,
     				cache:false,
     				type:'GET',
     				url:_url,
     				success:function(data){
     					var dataObj = JSON.parse(data);
     					console.info(dataObj.msg);
     				},
     				error:function (XMLHttpRequest, textStatus, errorThrown) {
     					alert(textStatus);
     					commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
     				}
     			});
            	$("#preview").remove();
				$("#picpreimg").remove();
				$(".jcrop-holder").remove();
				$("#pc").remove();
				$("#confirmSelect").remove();
            	$("#preview").remove();
            }
   };
   //修改图片预览
   function showPreview(coords)
	{
		if (parseInt(coords.w) > 0)
		{
			var rx = newsPicWidth / coords.w;
			var ry = newsPicHeight / coords.h;
			x = coords.x;
			y = coords.y;
			h = coords.h;
			w = coords.w;
			jQuery('#preview').css({
				width: Math.round(rx * imgWidth) + 'px',
				height: Math.round(ry * imgHeight) + 'px',
				marginLeft: '-' + Math.round(rx * coords.x) + 'px',
				marginTop: '-' + Math.round(ry * coords.y) + 'px'
			});
		}
	}
   //上传修改后的图片
   function confirmSelect() {
		//var tn = newName.replace("\.","#");
		//alert(tn);
		alert();
		var path = '<c:url value="'+ basePath+'/website/backstage/tabNewsController.do"/>?method=confirmPic';
		$.post(path,{w:w,h:h,x:x,y:y,pirSrc:pirSrc},function(data) {
				var ao = $.parseJSON(data);
				console.info(ao);
				if(ao.result=='1'){
					$("#preview").remove();
					$("#picpreimg").remove();
					$(".jcrop-holder").remove();
					$("#pc").remove();
					$("#confirmSelect").remove();
					showPicpreview(ao.newsrc,"false");
					$("#hiddenfile").val(ao.newsrc);
				}else{
					alert(ao.msg);
				}
				
		},"text")
	}
    //富文本编辑器初始化
    function  wangEditorInit(){
    	  var E = window.wangEditor
          var editor = new E('#editor-toolbar','#newsContent');
          editor.customConfig.uploadImgServer = '/upload';  // 上传图片到服务器
          editor.create();  
          // 获取使用到的元素
          var toolbarContaner = document.getElementById('toolbar-container');
          var editorText = document.getElementById('newsContent');
          var cover = document.getElementById('cover');
          var container = document.getElementById('container');

          // 全屏事件
          function doFullScreen() {
              cover.style.display = 'block';
              editorText.style.height = '90%';
              editorText.style.width = '100%';
              toolbarContaner.style.width = '100%';
              cover.appendChild(toolbarContaner);
              cover.appendChild(editorText);
              $('#btn1').text("退出全屏");
          }

          // 退出全屏事件
          function unDoFullScreen() {
              container.appendChild(toolbarContaner);
              container.appendChild(editorText);
              editorText.style.height = '100%';
            
              cover.style.display = 'none';
              $('#btn1').text("全屏");
          }

          // 是否是全屏的标志
          var isFullScreen = false

          // 点击事件
          var btn1 = document.getElementById('btn1');
          btn1.addEventListener('click', function () {
              if (isFullScreen) {
                  isFullScreen = false;
                  unDoFullScreen();
              } else {
                  isFullScreen = true;
                  doFullScreen();
              }
          }, false);
    }
    //表单数据初始化
    function formInint(isEdit){
    	if (isEdit) {
				$('#newsTitle').textbox({
					value : "${news.newsTitle}",
					type : "text",
					required : true
				});
				$('#newSubTitle').textbox({
					value : "${news.newSubTitle}",
					type : "text"
				});
				$('#newsAbstarct').textbox({
					value : "${news.newsAbstarct}",
					type : "text"
				});
				$('#newsDate').textbox({
					value : "${news.newsDate}",
					type : "date",
					required : true
				});
				$('#newAutor').textbox({
					value : "${news.newAutor}",
					type : "text",
					required : true
				});
		}
		else{
			$('#newsTitle').textbox({
				value : "",
				type : "text",
				required : true
			});
			$('#newSubTitle').textbox({
				value : "",
				type : "text"
			});
			$('#newsAbstarct').textbox({
				value : "",
				type : "text"
			});
			$('#newsDate').datetimebox({
				value : "",
				required : true
			});
			$('#newAutor').textbox({
				value : "",
				type : "text",
				required : true
			});
		}
    }
    </script>