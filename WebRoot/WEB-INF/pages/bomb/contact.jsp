<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>


<layout:Default>
	<section class="container page-single">
		<div class="wrap-container zerogrid" >
			<div class="col-2-3">
				<div id="main-content" class="wrap-col">
					<article>
						<div class="art-header">
							<h2>Contact Us</h2>
							<div class="line"></div>
						</div>
						<div class="art-content">
							<div id="contact_form">
								<form name="form1" id="ff" method="post" action="contact.php">
									<h3>Hello !! You can send message to us.</h3>
									<p>[Ready to use] Hi Everyone !! Visitor can use this
										contact form to send message to you. Open file contact.php and
										modify your email.</p>

									<label> <span>Name*:</span> <input type="text"
										placeholder="Please enter your name" name="name" id="name"
										required>
									</label> <label> <span>Email*:</span> <input type="email"
										placeholder="youremail@gmail.com" name="email" id="email"
										required>
									</label> <label> <span>Message*:</span> <textarea
											name="message" id="message">Please enter your message</textarea>
									</label> <input class="sendButton" type="submit" name="Submit"
										value="Send">

								</form>
							</div>
						</div>
					</article>
				</div>
			</div>
			<jsp:include page="../../pages/bomb/sidebar.jsp" />
		</div>
	</section>
</layout:Default>