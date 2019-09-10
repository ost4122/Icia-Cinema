


$(document)
			.ready(
					function() {
						// 메뉴버튼클릭
						$(".menu-toggle")
								.click(
										function(e) {
											e.preventDefault();
											$("#sidebar-wrapper").toggleClass(
													"active");
											$(
													".menu-toggle > .fa-bars, .menu-toggle > .fa-times")
													.toggleClass(
															"fa-bars fa-times");
											$(this).toggleClass("active");
										});

						$('a.js-scroll-trigger[href*="#"]:not([href="#"])')
								.click(
										function() {
											if (location.pathname.replace(
													/^\//, '') == this.pathname
													.replace(/^\//, '')
													&& location.hostname == this.hostname) {
												var target = $(this.hash);
												target = target.length ? target
														: $('[name='
																+ this.hash
																		.slice(1)
																+ ']');
												if (target.length) {
													$('html, body')
															.animate(
																	{
																		scrollTop : target
																				.offset().top
																	}, 1000,
																	"easeInOutExpo");
													return false;
												}
											}
										});
						$('#sidebar-wrapper .js-scroll-trigger')
								.click(
										function() {
											$("#sidebar-wrapper").removeClass(
													"active");
											$(".menu-toggle").removeClass(
													"active");
											$(
													".menu-toggle > .fa-bars, .menu-toggle > .fa-times")
													.toggleClass(
															"fa-bars fa-times");
										});
					});(jQuery);
					