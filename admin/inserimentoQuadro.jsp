<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- saved from url=(0058)file:///Users/lucapannozzo/Desktop/galleriaHtml/index.html -->
<html lang="en">
<!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- Basic Page Needs
  ================================================== -->

<title>Galleria UniRoma3</title>
<meta name="description"
	content="Free Responsive Html5 Css3 Templates | zerotheme.com">
<meta name="author" content="http://www.zerotheme.com">

<!-- Mobile Specific Metas
	================================================== -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- CSS
	================================================== -->
<link rel="stylesheet" href="files/css/zerogrid.css">
<link rel="stylesheet" href="files/css/style.css">

<!-- Custom Fonts -->
<link href="files/font-awesome/font-awesome.min.css" rel="stylesheet"
	type="text/css">


<link rel="stylesheet" href="files/css/menu.css">
<script src="admin/files/js/jquery1111.min.js" type="text/javascript"></script>
<script src="admin/files/js/script.js"></script>

<!-- Owl Carousel Assets -->
<link href="files/owl-carousel/owl.carousel.css" rel="stylesheet">

<!--[if lt IE 8]>
       <div style=' clear: both; text-align:center; position: relative;'>
         <a href="http://windows.microsoft.com/en-US/internet-explorer/Items/ie/home?ocid=ie6_countdown_bannercode">
           <img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." />
        </a>
      </div>
    <![endif]-->
<!--[if lt IE 9]>
		<script src="js/html5.js"></script>
		<script src="js/css3-mediaqueries.js"></script>
	<![endif]-->

</head>

<body class="home-page">
	<div class="wrap-body">
		<header class="">
			<div class="logo">
				<a href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#">Galleria
					UniRoma3</a> <span>webapp per la gestione di entitÃ  autori e
					quadri</span>
			</div>
			<div id="cssmenu" class="align-center">
				<div id="menu-button">Menu</div>
				<div id="menu-button">Menu</div>
				<ul>
					<li class="active"><a href="index.html"><span>Home</span></a></li>
					<li><a href=""><span>admin page</span></a>
						<ul>
							<li class="has-sub"><form action="ControllerLogin"
									method="post">
									<input type="submit" value="Logout" name="logout" />
								</form>
						</ul></li>
					<li class="has-sub"><a href="visualizzaGalleria"><span>Galleria</span></a>
						<ul>
							<li class="has-sub"><a href="inserimentoAutore.jsp"><span>Gestisci
										Autori</span></a></li>
							<li class="has-sub"><a href="ControllerQuadri"><span>Gestisci
										Quadri</span></a></li>
						</ul></li>
					<li><a
						href="file:///Users/lucapannozzo/Documents/zVintauge/single.html"><span>About</span></a></li>
					<li class="last"><a
						href="file:///Users/lucapannozzo/Documents/zVintauge/contact.html"><span>Contact</span></a></li>
				</ul>
			</div>
			<div id="owl-slide" class="owl-carousel owl-theme"
				style="opacity: 1; display: block;">
				<div class="owl-wrapper-outer">
					<div class="owl-wrapper"
						style="width: 8850px; left: 0px; display: block; transition: all 800ms ease; transform: translate3d(-885px, 0px, 0px);">
						<div class="owl-item" style="width: 885px;">
							<div class="owl-wrapper-outer">
								<div class="owl-wrapper-outer">
									<div class="owl-wrapper"
										style="width: 8850px; left: 0px; display: block; transition: all 800ms ease; transform: translate3d(-885px, 0px, 0px);">
										<div class="owl-item" style="width: 885px;">
											<div class="item">
												<img src="./indexAdmin_files/slide1.jpg">
											</div>
										</div>
										<div class="owl-item" style="width: 885px;">
											<div class="item">
												<img src="./indexAdmin_files/slide2.jpg">
											</div>
										</div>
										<div class="owl-item" style="width: 885px;">
											<div class="item">
												<img src="./indexAdmin_files/slide3.jpg">

											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="owl-item" style="width: 885px;">
							<div class="owl-controls clickable">
								<div class="owl-buttons">
									<div class="owl-prev">
										<i class="fa fa-chevron-left fa-5x"></i>
									</div>
									<div class="owl-next">
										<i class="fa fa-chevron-right fa-5x"></i>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>


				<div class="owl-controls clickable">
					<div class="owl-buttons">
						<div class="owl-prev">
							<i class="fa fa-chevron-left fa-5x"></i>
						</div>
						<div class="owl-next">
							<i class="fa fa-chevron-right fa-5x"></i>
						</div>
					</div>
				</div>
			</div>
		</header>
		<!--////////////////////////////////////Container-->
		<section id="container">
			<div class="wrap-container">
				<!-----------------content-box-1-------------------->
				<section class="content-box box-1">
					<form method="POST" action="ControllerQuadri">
						<table>
							<tr>
								<td align="right">Titolo*:</td>
								<td><input type="text" name="titoloT" autofocus="autofocus"
									value="${quadro.titolo}" /></td>
								<td>${errTitolo}</td>
							</tr>
							<tr>
								<td align="right">Dimensione*:</td>
								<td><input type="text" name="dimensioneT"
									value="${quadro.dimensione}" /></td>
								<td>${errDimensione}</td>
							</tr>
							<tr>
								<td align="right">Tecnica* :</td>
								<td><input type="text" name="tecnicaT"
									value="${quadro.tecnica}" /></td>
								<td>${errTecnica}</td>
							</tr>
							<tr>
								<td align="right">Anno *:</td>
								<td><input type="number" name="annoT"
									value="${quadro.anno}" /></td>
								<td>${errAnno}</td>
							</tr>
							Autore del Quadro : 
							<tr>
								<select name="autoreQuadro">
									<c:forEach var="autore" items="${autori}">
										<option value="${autore.id}">
											${autore.nome}-${autore.cognome}</option>
									</c:forEach>
									<option value="n/a">autore sconosciuto</option>
								</select>
							</tr>

							<tr>
								<td colspan="3" align="center">(* = campo obbligatorio)</td>
							</tr>
						</table>
						<input type="submit" name="insert" value="INVIA" />
					</form>
					${QuadroInserito }
				</section>

				<!-- carousel -->
				<script src="./indexAdmin_files/owl.carousel.js"></script>
				<script>
					$(document)
							.ready(
									function() {
										$("#owl-slide")
												.owlCarousel(
														{
															autoPlay : 3000,
															items : 1,
															itemsDesktop : [
																	1199, 1 ],
															itemsDesktopSmall : [
																	979, 1 ],
															itemsTablet : [
																	768, 1 ],
															itemsMobile : [
																	479, 1 ],
															navigation : true,
															navigationText : [
																	'<i class="fa fa-chevron-left fa-5x"></i>',
																	'<i class="fa fa-chevron-right fa-5x"></i>' ],
															pagination : false
														});
									});
				</script>
			</div>
</body>
</html>