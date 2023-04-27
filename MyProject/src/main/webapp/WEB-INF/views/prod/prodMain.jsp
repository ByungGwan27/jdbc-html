<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Header-->
<header class="bg-dark py-5">
	<div class="container px-4 px-lg-5 my-5">
		<div class="text-center text-white">
			<h1 class="display-4 fw-bolder">International Coffee Shop 입니당.</h1>
			<p class="lead fw-normal text-white-50 mb-0">Enjoy Your Coffee!</p>
		</div>
	</div>
</header>
<!-- Section-->
<section class="py-5">
	<div class="container px-4 px-lg-5 mt-5">
		<div
			class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
			
			<!-- 상품 목록 -->
			<c:forEach var="pl" items="${Alllist }">
			
			<div class="col mb-5">
				<div class="card h-100">
					<!-- Sale badge-->
					<div class="badge bg-dark text-white position-absolute"
						style="top: 0.5rem; right: 0.5rem">Sale</div>
					<!-- Product image-->
					<img class="card-img-top"
						src="images/${pl.prodName }.jpg" alt="대구 따라주라는건 없습니다..." />
					<!-- Product details-->
					<div class="card-body p-4">
						<div class="text-center">
							<!-- Product name-->
							<h5 class="fw-bolder"><a href="prodList.do?prodCode=${pl.prodCode }">${pl.prodName }</a></h5>
							<!-- Product reviews-->
							<div
								class="d-flex justify-content-center small text-warning mb-2">
								<c:forEach var="i" items="${Alllist }" end="${pl.starMark -1 }">
								<div class="bi-star-fill"></div>
								</c:forEach>
							</div>
							<!-- Product price-->
							<span class="text-muted text-decoration-line-through">${pl.prodPrice }$</span>
							${pl.discount }$
						</div>
					</div>
					<!-- Product actions-->
					<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
						<div class="text-center">
							<a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a>
						</div>
					</div>
				</div>
			</div>
			
			</c:forEach>
			
		</div>
	</div>
</section>