<%@ page language="java" pageEncoding="UTF-8"%>
<div class="col-1-3">
	<div id="sidebar" class="wrap-col">
		<div class="widget">
			<div class="wid-header">
				<h4>有趣应用</h4>
			</div>
			<div class="wid-content">
				<a href="#" target="_blank"><h1>日历</h1></a>
				<p>
					<input type="text"  class="calendar"/>

				</p>
			</div>
		</div>
		<div class="widget wid-menu">
			<div class="wid-header">
				<h4>Categories</h4>
			</div>
			<div class="wid-content">
				<ul>
					<li><a href="#">Free Html5 Templates</a></li>
					<li><a href="#">Free Responsive Themes</a></li>
					<li><a href="#">Free Html5 and Css3 Themes</a></li>
				</ul>
			</div>
		</div>
		<div class="widget wid-posts">
			<div class="wid-header">
				<h4>Popular Post</h4>
			</div>
			<div class="wid-content">
				<div class="post">
					<a href="#"><img src="${path}/images/img02.jpg" /></a>
					<h6>
						<a href="#">Lorem ipsum dolor sit amet</a>
					</h6>
					<p>November 11 ,2015</p>
				</div>
				<div class="post">
					<a href="#"><img src="${path}/images/img03.jpg" /></a>
					<h6>
						<a href="#">Lorem ipsum dolor sit amet</a>
					</h6>
					<p>November 11 ,2015</p>
				</div>
				<div class="post">
					<a href="#"><img src="${path}/images/img04.jpg" /></a>
					<h6>
						<a href="#">Lorem ipsum dolor sit amet</a>
					</h6>
					<p>November 11 ,2015</p>
				</div>
			</div>
		</div>
		<div class="widget wid-label">
			<div class="wid-header">
				<h4>Labels</h4>
			</div>
			<div class="wid-content">
				<a href="#">Design</a> <a href="#">Technology</a> <a href="#">Animal</a>
				<a href="#">People</a> <a href="#">House</a> <a href="#">Natural</a>
				<a href="#">Photoshop</a>
			</div>
		</div>
	</div>
</div>
<script>
$(function(){
	
	$(".calendar").datepicker({
		autoclose:true,
		language:"zh-CN",
		format:"yyyy-mm-dd"
	});

});
</script>
>
