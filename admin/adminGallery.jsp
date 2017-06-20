<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
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
<link rel="stylesheet" href="admin/files/css/zerogrid.css">
<link rel="stylesheet" href="admin/files/css//style.css">

<!-- Custom Fonts -->
<link href="admin/files/font-awesome/font-awesome.min.css"
	rel="stylesheet" type="text/css">


<link rel="stylesheet" href="admin/files/css/menu.css">
<script src="admin/files/js/jquery1111.min.js"
	type="text/javascript"></script>
<script src="admin/files/js/script.js"></script>

<!-- Owl Carousel Assets -->
<link href="admin/files/owl-carousel/owl.carousel.css" rel="stylesheet">

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
					UniRoma3</a> <span>webapp per la gestione di entità  autori e
					quadri</span>
			</div>
			<div id="cssmenu" class="align-center">
				<div id="menu-button">Menu</div>
				<div id="menu-button">Menu</div>
				<ul>
					<li class="active"><a href="index.jsp"><span>Home</span></a></li>
					<li><a href=""><span>admin page</span></a>
						<ul>
							<li class="has-sub"><form action="ControllerLogin"
									method="post">
									<input type="submit" value="Logout" name="logout" />
								</form>
						</ul></li>
					<li class="has-sub"><a href="visualizzaGalleria"><span>Galleria</span></a>
						<ul>
							<li class="has-sub"><a href="admin/inserimentoAutore.jsp"><span>Gestisci
										Autori</span></a></li>
							<li class="has-sub"><a href="admin/ControllerQuadri"><span>Gestisci
										Quadri</span></a></li>
						</ul></li>
					<li><a
						href=""><span>About</span></a></li>
					<li class="last"><a
						href=""><span>Contact</span></a></li>
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
					<style>
table, td, th {
	border: 1px solid black;
}

table {
	border-collapse: collapse;
	width: 100%;
}

th {
	height: 50px;
}
</style>
					AUTORI <br>
					<form action="admin/ControllerAutori" method="post">
						<input type="submit" value="cancellatutto" name="deleteAll" />
					</form>
					<br> Ordina per :
					<form action="visualizzaGalleria" method="get">
						<select name="ordineAutori" onchange='this.form.submit()'>
							<option value="nome">Nome</option>
							<option value="cognome">Cognome</option>
							<option value="nazione">Nazione</option>
							<option value="dataNascita">Data di nascita</option>
							<option value="dataMorte">Data di morte</option>
							<option value="dataInserimento">Data di inserimento</option>
						</select>
					</form>
					<br>
					<table>
						<tr><th>Id</th>
							<th>Nome</th>
							<th>Cognome</th>
							<th>Nazione</th>
							<th>Data di Nascita</th>
							<th>Data di morte</th>
							<th>Data inserimento</th>
							<th>Command</th>
						</tr>
						<c:forEach var="autore" items="${autori}">
							<tr><th>${autore.id}</th>
								<th>${autore.nome}</th>
								<th>${autore.cognome}</th>
								<th>${autore.nazione}</th>
								<th>${autore.dataNascita}</th>
								<th>${autore.dataMorte}</th>
								<th>${autore.dataInserimento}</th>
								<th><form action="admin/ControllerAutori" method=post>
										<input type="hidden" value="${autore.id}" name="id" /> <input
											type="submit" value="cancella" name="delete" />
									</form></th>
							</tr>
						</c:forEach>
					</table>
					<br> ${cancellatoTutto } <br>
				</section>
				<!-----------------content-box-2-------------------->
				<section class="content-box box-1">
					QUADRI <br>
					<form action="admin/ControllerQuadri" method="post">
						<input type="submit" value="cancellatutto" name="deleteAll" />
					</form>
					<br> <br> Ordina per :
					<form action="visualizzaGalleria" method="get">
						<select name="ordineQuadri" onchange='this.form.submit()'>
							<option value="titolo">Titolo</option>
							<option value="anno">Anno</option>
							<option value="dimensione">Dimensione</option>
							<option value="tecnica">Tecnica</option>

						</select>
					</form>
					<table>
						<tr>
						
							<th>Titolo</th>
							<th>Descrizione</th>
							<th>Tecnica</th>
							<th>Anno</th>
							<th>Id Autore</th>
							<th>Data inserimento</th>
							<th>Command</th>

						</tr>
						<c:forEach var="quadro" items="${quadri}">
							<tr>
								
								<th>${quadro.titolo}</th>
								<th>${quadro.dimensione}</th>
								<th>${quadro.tecnica}</th>
								<th>${quadro.anno}</th>
								<th>${quadro.autore.id}</th>
								<th>${quadro.dataInserimento}</th>
								<th><form action="admin/ControllerQuadri" method=post>
										<input type="hidden" value="${quadro.id}" name="id" /> <input
											type="submit" value="cancella" name="Commanddelete" />
									</form></th>
							</tr>
						</c:forEach>
					</table>
					<br>
				</section>



				<!--////////////////////////////////////Footer-->
				<footer>
					<div class="zerogrid wrap-footer">
						<div class="row">
							<div class="col-1-4 col-footer-1">
								<div class="wrap-col">
									<h3 class="widget-title">About Us</h3>
									<p>Ut volutpat consectetur aliquam. Curabitur auctor in nis
										ulum ornare. Metus elit vehicula dui. Curabitur auctor in nis
										ulum ornare. Sed consequat, augue condimentum fermentum</p>
									<p>Sed ut perspiciatis unde omnis iste natus error sit
										voluptatem accusantium doloremque la udantium</p>
								</div>
							</div>
							<div class="col-1-4 col-footer-2">
								<div class="wrap-col">
									<h3 class="widget-title">Recent Post</h3>
									<ul>
										<li><a
											href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#">MOST
												VISITED COUNTRIES</a></li>
										<li><a
											href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#">5
												PLACES THAT MAKE A GREAT HOLIDAY</a></li>
										<li><a
											href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#">PEBBLE
												TIME STEEL IS ON TRACK TO SHIP IN JULY</a></li>
										<li><a
											href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#">STARTUP
												COMPANYâS CO-FOUNDER TALKS ON HIS NEW PRODUCT</a></li>
									</ul>
								</div>
							</div>
							<div class="col-1-4 col-footer-3">
								<div class="wrap-col">
									<h3 class="widget-title">Tag Cloud</h3>
									<a
										href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#">animals</a>
									<a
										href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#">cooking</a>
									<a
										href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#">countries</a>
									<a
										href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#">city</a>
									<a
										href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#">children</a>
									<a
										href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#">home</a>
									<a
										href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#">likes</a>
									<a
										href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#">photo</a>
									<a
										href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#">link</a>
									<a
										href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#">law</a>
									<a
										href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#">shopping</a>
									<a
										href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#">skate</a>
									<a
										href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#">scholl</a>
									<a
										href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#">video</a>
									<a
										href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#">travel</a>
									<a
										href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#">images</a>
									<a
										href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#">love</a>
									<a
										href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#">lists</a>
									<a
										href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#">makeup</a>
									<a
										href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#">media</a>
									<a
										href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#">password</a>
									<a
										href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#">pagination</a>
									<a
										href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#">wildlife</a>
								</div>
							</div>
							<div class="col-1-4 col-footer-4">
								<div class="wrap-col">
									<h3 class="widget-title">Gallery</h3>
									<div class="row">
										<div class="col-1-3">
											<div class="wrap-col">
												<a
													href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#"><img
													src="./indexAdmin_files/11.jpg"></a> <a
													href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#"><img
													src="./indexAdmin_files/1.jpg"></a> <a
													href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#"><img
													src="./indexAdmin_files/13.jpg"></a>
											</div>
										</div>
										<div class="col-1-3">
											<div class="wrap-col">
												<a
													href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#"><img
													src="./indexAdmin_files/10.jpg"></a> <a
													href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#"><img
													src="./indexAdmin_files/9.jpg"></a> <a
													href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#"><img
													src="./indexAdmin_files/4.jpg"></a>
											</div>
										</div>
										<div class="col-1-3">
											<div class="wrap-col">
												<a
													href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#"><img
													src="./indexAdmin_files/2.jpg"></a> <a
													href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#"><img
													src="./indexAdmin_files/6.jpg"></a> <a
													href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#"><img
													src="./indexAdmin_files/5.jpg"></a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="zerogrid bottom-footer">
						<div class="row">
							<div class="bottom-social">
								<a
									href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#"><i
									class="fa fa-facebook"></i></a> <a
									href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#"><i
									class="fa fa-instagram"></i></a> <a
									href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#"><i
									class="fa fa-twitter"></i></a> <a
									href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#"><i
									class="fa fa-google-plus"></i></a> <a
									href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#"><i
									class="fa fa-pinterest"></i></a> <a
									href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#"><i
									class="fa fa-vimeo"></i></a> <a
									href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#"><i
									class="fa fa-linkedin"></i></a> <a
									href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#"><i
									class="fa fa-youtube"></i></a>
							</div>
						</div>
						<div class="copyright">
							Copyright @ - <a href="http://www.zerotheme.com/" target="_blank"
								rel="nofollow">Free Html5 Templates</a> Designed by <a
								href="http://www.zerotheme.com/" target="_blank" rel="nofollow">ZEROTHEME</a>
						</div>
					</div>
				</footer>
				<!-- carousel -->
				<script src="./indexAdmin_files/owl.carousel.js"></script>
				<script>
		$(document).ready(function() {
		  $("#owl-slide").owlCarousel({
			autoPlay: 3000,
			items : 1,
			itemsDesktop : [1199,1],
			itemsDesktopSmall : [979,1],
			itemsTablet : [768, 1],
			itemsMobile : [479, 1],
			navigation: true,
			navigationText: ['<i class="fa fa-chevron-left fa-5x"></i>', '<i class="fa fa-chevron-right fa-5x"></i>'],
			pagination: false
		  });
		});
		</script>
			</div>
</body>
</html>