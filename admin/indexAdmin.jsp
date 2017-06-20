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
<link rel="stylesheet" href="admin/files/css/style.css">

<!-- Custom Fonts -->
<link href="admin/files/font-awesome/font-awesome.min.css"
	rel="stylesheet" type="text/css">


<link rel="stylesheet" href="admin/files/css/menu.css">
<script src="admin/files/js/jquery1111.min.js" type="text/javascript"></script>
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
		<header>
			<div class="logo">
				<a href="file:///Users/lucapannozzo/Documents/zVintauge/index.html#">Galleria
					UniRoma3</a> <span>webapp per la gestione di entità autori e
					quadri</span>
			</div>
			<div id="cssmenu" class="align-center">
				<div id="menu-button">Menu</div>
				<div id="menu-button">Menu</div>
				<ul>
					<li class="active"><a href="ControllerLogin"><span>Home</span></a></li>
					<li><a href="ControllerLogin"><span>admin page</span></a>
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



			

		</header>
		<!--////////////////////////////////////Container-->
		<section id="container">
			<div class="wrap-container">
				<!-----------------content-box-1-------------------->
				<section class="content-box box-1">
					<div class="zerogrid">
						<div class="wrap-box">
							<!--Start Box-->
							<div class="box-header">
								<h2>ISTRUZIONI</h2>
							</div>
							<div class="box-content">
								<p>
									1.Per gestire gli Autori e i Quadri selezionare Galleria <br>
								<p>2.Admin Page per effettuare il Logout</p>
							</div>
						</div>
					</div>
				</section>
			</div>
		</section>


		<!--////////////////////////////////////Footer-->
		<footer>
			<div class="copyright">
				Copyright @ - <a href="http://www.zerotheme.com/" target="_blank"
					rel="nofollow">Free Html5 Templates</a> Designed by <a
					href="http://www.zerotheme.com/" target="_blank" rel="nofollow">ZEROTHEME</a>
			</div>

		</footer>
		<!-- carousel -->
		<script src="files/owl-carousel/owl.carousel.js"></script>
		<script>
			$(document)
					.ready(
							function() {
								$("#owl-slide")
										.owlCarousel(
												{
													autoPlay : 3000,
													items : 1,
													itemsDesktop : [ 1199, 1 ],
													itemsDesktopSmall : [ 979,
															1 ],
													itemsTablet : [ 768, 1 ],
													itemsMobile : [ 479, 1 ],
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