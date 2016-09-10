<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>推荐信息</title>
	<%@ include file="/common/head.jsp" %>
</head>
<body>
	<header>
		<div class="head">
			<a class="logo" href="###">
				<img src="img/logo.png" alt="">
			</a>

			<!-- 立即使用btn start -->
			<a  class="ljsy_btn" href="###">立即推荐</a>
			<!-- 立即使用btn end -->

			<!-- 推荐人手册&关于香农 start -->
			<div class="tjrsc_gyxn">
				<a href="###">推荐人手册</a>
				<a href="###">关于香农</a>
			</div>
			<!-- 推荐人手册&关于香农 end -->
		</div>
	</header>
	
	<!-- main start -->
	<section class="main">
		<!-- 推荐信息 -->
		<h2 class="referral_title">推荐信息</h2>

		<!-- form start -->
		<div class="referral_form">
			<form action="" >
				<!-- 推荐信息 box start -->
				<div class="referral_information_box">
					<!-- 选择品类 start -->
					<div class="select_category">
						<span>*</span>
						<label for="">选择品类</label>
						<input id="select_category_input" type="hidden" name="select_category" value="shicai">
						<ul id="select_category_ul">
							<li data-value="shicai" class="selected">
								<span></span>
								食材
							</li>
							<li data-value="shouyi" class="">
								<span></span>
								手艺
							</li>
							<li data-value="xinnongren" class="">
								<span></span>
								新农人
							</li>
							<li data-value="shouyiren" class="">
								<span></span>
								手艺人
							</li>
							<li data-value="other" class="">
								<span></span>
								其他
							</li>
						</ul>
					</div>
					<!-- 选择品类 end -->

					<!-- 名称 start -->
					<div class="referral_name">
						<span>*</span>
						<label for="referral_name">名称</label>
						<input type="text" id="referral_name">
					</div>
					<!-- 名称 end -->

					<!-- 产地 start -->
					<div class="select_producer">
						<span>*</span>
						<label for="">产地</label>
						<select name="producer" id="">
							<option value="sichuan">四川</option>
							<option value="guizhou">贵州</option>
							<option value="beijing">北京</option>
							<option value="tianjin">天津</option>
							<option value="shanghai">上海</option>
						</select>
							
						<select name="city" id="">
							<option value="luzhou">泸州</option>
							<option value="guizhou">贵州</option>
							<option value="beijing">北京</option>
							<option value="tianjin">天津</option>
							<option value="shanghai">上海</option>
						</select>

						<select name="country" id="" style="margin-right: 0px;">
							<option value="luxian">泸县</option>
							<option value="guizhou">贵州</option>
							<option value="beijing">北京</option>
							<option value="tianjin">天津</option>
							<option value="shanghai">上海</option>
						</select>

						<input type="text" name="detailAddress" placeholder="老坡十字村">
					</div>
					<!-- 产地 end -->

					<!-- 关于推荐 start -->
					<div class="about_info">
						<span>*</span>
						<label for="">关于推荐</label>
						<textarea name="aboutInfo" id="" placeholder="关于您说推荐的人或物，请做简要的说明"></textarea>
					</div>
					<!-- 关于推荐 end -->

					<!-- 图片 start -->
					<div class="images">
						<label for="">图片</label>
						<div class="pic_box" id="pic_box">
							<img id="preview" class="img" src="img/empty.png">
							<span>上传图片，更有利于获得官方的关注</span>
							<span class="img_hint">您还可以添加<i>5</i>张</span>
							<input id="doc" name="pic" type="file" name="images" multiple="multiple" accept="jpg,png" onchange="javascript:setImagePreview();"> 
						</div>
					</div>
					<!-- 图片 end -->
				</div>
				<!-- 推荐信息 box end -->



				<!-- 推荐人信息 box start -->
				<div class="referral_person_box">
					<h2 class="referral_title">推荐人信息</h2>

					<!-- 选择单位 start -->
					<div class="select_company">
						<span>*</span>
						<label for="select_company_input">选择单位</label>
						<input type="hidden" name="selectCompany" id="select_company_input" value="personal">
						<ul id="select_company_ul">
							<li data-value="personal" class="selected">
								<span></span>
								个人
							</li>
							<li data-value="enterprise">
								<span></span>
								企业
							</li>
						</ul>
					</div>
					<!-- 选择单位 end -->

					<!-- 姓名 start -->
					<div class="person_name">
						<label for="">姓名</label>
						<input type="text" name="personName" placeholder="请输入您的姓名">
					</div>
					<!-- 姓名 end -->

					<div class="person_phone">
						<label for="person_phone">您的手机</label>
						<input name="personPhone" id="person_phone" type="text" placeholder="请输入您的手机号">
					</div>


				</div>
				<!-- 推荐人信息 box end -->
			
				<input class="submit_btn" type="submit" value="提&nbsp;&nbsp;交">
				
			</form>
		</div>
		<!-- form end -->
		
		<!-- 商务合作 -->
		<div class="business_cooperation_box">
			<h2 class="referral_title">商务合作</h2>
			<p>社址: 北京市朝阳区安外大屯路甲11号地理科学馆</p>	
			<p>邮编: 100101</p>
			<p>邮箱: bp@shanon.com</p>
		</div>
	</section>
	<!-- main end -->

	<footer>
		<h4>合作伙伴</h4>
		<ul>
			<li>
				<a href="###">中国渔业协会</a>
			</li>
			<li>
				<a href="###">途牛旅游网</a>
			</li>
			<li>
				<a href="###">广东广远渔业集团有限公司</a>
			</li>
			<li>
				<a href="###">上海水产(集团)总公司</a>
			</li>
			<li>
				<a href="###">中国摄影师协会</a>
			</li>
		</ul>

		<h4>联系我们</h4>
		<p>社址: 北京市朝阳区安外大屯路甲11号地理科学馆 &nbsp;&nbsp; 邮编: 100101</p>
		<p>总机：010-64865566 &nbsp;&nbsp; 热线：4006521360</p>

		<div class="rss">
			<div class="weChat">
				<img src="img/QRcode.jpg" alt="">
				<span>
					<i class="iconfont icon-weChat"></i>
				</span>
				微信 DiDaoJun
			</div>


			<div class="microblog">
				<span>
					<i class="iconfont icon-microblog"></i>
				</span>
				微博 DiDaoJun
			</div>
		</div>

		<p class="copyright">Copyright&copy; 2001-2014 Chinese National Geograpphy Press. All right reserved.</p>
	</footer>

	<script type="text/javascript" src="js/main.js"></script>
</body>
</html>