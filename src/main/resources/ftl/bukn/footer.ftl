<#import "../common/navbarfunction.ftl" as navf />
<style>
#ful>li{
 margin-top:-5%;
}
</style>
<!-- 网站底部导航菜单 -->
		<div class="fh5co-footer-style-3">
			<div class="container" style="width: 90%;margin-top:-60px;margin-bottom:-65px;">
				<div class="row p-b">
				<#list navbars as nav>
						<#if nav.menuLevel == 2>
						 <#if navf.haveSubMenu(navbars,nav.menuUuid)!=0>
				 <div class="col-md-2 col-sm-3 fh5co-footer-widget wow fadeInUp" style="margin-right:-5%;" data-wow-duration="1s" data-wow-delay=".8s" >
					<p style=" font-size: 16px !important;color:white;"">${nav.menuName!''}</p>
						<ul class="fh5co-links fh5co-social" id ="ful" style="font-size: 12px !important; margin-top:-20%;">
						<@navf.getSubNavbar navs=navbars  menuid=nav.menuUuid/>
						</ul>
				  </div>
						</#if>
					</#if>
					</#list>
					<div class="col-md-2 col-sm-3 fh5co-footer-widget wow fadeInUp" data-wow-duration="1s" style="margin-right:-5%;" data-wow-delay=".5s">
						<p style=" font-size: 16px !important; color:white;">联系我们</p>
						<!-- <p class="fh5co-copyright">
						联系地址:<br><a href="" target="_blank" title="模板之家">陕西省西安市科技路西段绿地鸿海大厦B座9层</a><br>
						联系电话:<br><a href="" target="_blank" title="模板之家">029-88315182</a><br><a href="" target="_blank" title="模板之家">029-84536670</a><br>
						电子邮箱:<br><a href="" target="_blank" title="模板之家">bhkn@bohuikangning.com</a><br>
						二维码:<br>
						<img src="images/1503125910(1).jpg">
						</p> -->
						<ul class="fh5co-links" id ="ful" style=" font-size: 12px !important; margin-top:-20%;>
							<li><a href="javasript:void(0)" class="index_colour">联系地址:</a></li>
							<li><a href="javasript:void(0)">陕西省西安市科技路西</a></li>
							<li><a href="javasript:void(0)">段绿地鸿海大厦B座9层</a></li>
							<li><a href="javasript:void(0)" class="index_colour">联系电话:</a></li>
							<li><a href="javasript:void(0)">029-88315182</a></li>
							<li><a href="javasript:void(0)">029-84536670</a></li>
							<li><a href="javasript:void(0)" class="index_colour">电子邮箱:</a></li>
							<li><a href="javasript:void(0)">bhkn@bohuikangning.com</a></li>
							<li><a href="javasript:void(0)" class="index_colour">二维码</a></li>
							<li><img src="images/1503125910(1).png"></li>
						</ul>
					</div>
					<div class="col-md-2 col-sm-3 fh5co-footer-widget wow fadeInUp" data-wow-duration="1s" style="margin-left:8%;" data-wow-delay=".5s">
						<p style=" font-size: 16px !important;color:white;"">公司简介</p>
						<p style="font-size: 12px !important; margin-top:-20%;">博汇康宁（深圳）投资基金管理有限公司是专业化投资基金管理公司，经深圳市市场监督管理局批准，在深圳注册成立。2016年1月获得中国证券投资基金业协会颁发的“私募投资基金管理人登记证书”（编号：P1030701 ），成为具有从事私募证券投资、股权投资、创业投资等私募基金投资管理业务资格的金融公司。</p>
						<p><a href="javasript:void(0)" class="btn btn-success btn-sm btn-outline" style="color:#fff; background-color: #58ca7e;">了解我们</a></p>
					</div>
					<div class="clearfix visible-sm-block"></div>
				</div>
				
				<div class="row text-center">
					<div class="col-md-12 wow fadeInUp" data-wow-duration="1s"style=" font-size: 12px !important; margin-top:-40px;" data-wow-delay=".5s">
					<!--<img src="images/police.png">&nbsp;深公网安备&nbsp;44010202000381&nbsp;|&nbsp; ;股票代码&nbsp;888888-->
						<p>Copyright&nbsp;&copy; 2017-2018 博汇康宁（深圳）投资基金管理有限公司&nbsp;</p>
						<p>技术支持 | 西安敏思笃行信息技术有限公司</p>
					</div>
				</div>
			</div>
		</div>
		<!-- END footer -->