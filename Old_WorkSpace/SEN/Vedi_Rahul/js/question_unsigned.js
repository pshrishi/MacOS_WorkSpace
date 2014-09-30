$(document).ready(function($){

	//##########################################
	// Accordion box
	//##########################################

	$('.accordion-container').hide(); 
	$('.accordion-trigger:first').addClass('active').next().show();
	$('.accordion-trigger').click(function(){
		if( $(this).next().is(':hidden') ) { 
			$('.accordion-trigger').removeClass('active').next().slideUp();
			$(this).toggleClass('active').next().slideDown();		}
		return false;
	});
	
	
	//##########################################
	// Tweet feed
	//##########################################
	
	$("#tweets").tweet({
        count: 3,
        username: "ansimuz"
    });


	//##########################################
	// Tabs
	//##########################################

    $(".tabs").tabs("div.panes > div", {effect: 'fade'});
    
    //##########################################
	// Slides
	//##########################################
	
	$(function(){
		$('.slides-js').slides({
			preload: true,
			preloadImage: 'img/loading.gif',
			play: 5000,
			pause: 2500,
			hoverPause: true
		});
	});
	
    
    //##########################################
	// PrettyPhoto
	//##########################################
	
	$("a[rel^='prettyPhoto']").prettyPhoto();

	//##########################################
	// Tool tips
	//##########################################
	
    $('.poshytip, #social-bar li a').poshytip({
    	className: 'tip-twitter',
		showTimeout: 1,
		alignTo: 'target',
		alignX: 'center',
		offsetY: 5,
		allowTipHover: false
    });
    
    $('.form-poshytip').poshytip({
		className: 'tip-twitter',
		showOn: 'focus',
		alignTo: 'target',
		alignX: 'right',
		alignY: 'center',
		offsetX: 5
	});
	
	
	//##########################################
	// Link button
	//##########################################

	$('.link-button').css( {backgroundPosition: "-776 0"} )
	.mouseover(function(){
		$(this).stop().animate(
			{backgroundPosition:"(0px 0px)"}, 
			{duration:300})
		})
	.mouseout(function(){
		$(this).stop().animate(
			{backgroundPosition:"(-776px 0px)"}, 
			{duration:300})
	});
	
	//##########################################
	// Expandable boxy
	//##########################################

	$('.boxy .more-info').click(function(){
		$(this).hide();
		$(this).parent().children(".less-info").show();
		$(this).parents().children(".boxy-content").slideDown();
		return false;
	});
	
	$('.boxy .less-info').click(function(){
		$(this).hide();
		$(this).parent().children(".more-info").show();
		$(this).parents().children(".boxy-content").slideUp();
		return false;
	});
	
	//##########################################
	// Nav menu
	//##########################################
	
	$("ul.sf-menu").superfish({ 
        animation: {height:'show'},   // slide-down effect without fade-in 
        delay:     500 ,              // 1.2 second delay on mouseout 
        autoArrows:  false,
        speed:         'fast'
    });
    
    //##########################################
	// Nav over
	//##########################################
	
	$("#nav>li>a").hover(function() {
		if( !$(this).parent().hasClass('current-menu-item') ){
			// on rollover	
			$(this).stop().animate({ 
				marginLeft: "7" 
			}, "fast");
		}
	} , function() { 
		// on out
		$(this).stop().animate({
			marginLeft: "0" 
		}, "fast");
	});
    
    
    //##########################################
	// sidebar over
	//##########################################
	
	// show/hide sidebar
	
	$("#sidebar-dock").hover(function(){
		$(this).children("#sidebar").stop().animate({
			marginLeft: 0
		}, 200);
		$("#sidebar-opener").stop().hide();
	} , function(){
		$(this).children("#sidebar").stop().animate({
			marginLeft: -220
		},200);	
		$("#sidebar-opener").stop().show();
	});
    
	
	// recent posts
	$('#sidebar .recent-posts .recent-thumb img').hover(function(){
		$(this).stop().animate({ opacity: "0.5"}, {duration: 300} ); 
			
		
	
	},function(){
		$(this).stop().animate({ opacity: "1"}, {duration: 300}); 
	});
	
	//##########################################
	// Work hover
	//##########################################
	
	$(".work a img").hover(function(){
		$(this).stop().animate({opacity: "0.7"}, 300);
	}, function(){
		$(this).stop().animate({opacity: "1"}, 300);
	});
	
	//##########################################
	// Entry hover
	//##########################################
	
	$("#posts .feature-image").hover(function(){
		$(this).children(".entry-buttons").stop().animate({
			height:'70px',
			marginTop: "-35"
		},100);
	},function(){
		$(this).children(".entry-buttons").stop().animate({
			height:'0px',
			marginTop: "0"
		},100);
	});
	
    //##########################################
	// Scroll to top
	//##########################################
	
	// default hidden
	$("#to-top").hide();

	
	$(window).scroll(function() {
    if ($(this).scrollTop() == 0) {
        $("#to-top:visible").fadeOut();
    }
    else {
        $("#to-top:hidden").fadeIn();
    }});
        
    $('#to-top').click(function(){
		$('html, body').animate({ scrollTop: 0 }, 300);
	});
	
	//##########################################
	// Comments switcher
	//##########################################

	var $comments_switcher1 = $(".show-comments1");
	var $comments_holder1 = $(".comments-switcher1");
	
	$comments_switcher1.click(function(){
		if($comments_holder1.css("display") == "block"){
			$comments_switcher1.children("span").text("click to show");		
		}else{
			$comments_switcher1.children("span").text("click to hide");
		}
		$comments_holder1.slideToggle();
	});
	
	
	var $comments_switcher2 = $(".show-comments2");
	var $comments_holder2 = $(".comments-switcher2");
	
	$comments_switcher2.click(function(){
		if($comments_holder2.css("display") == "block"){
			$comments_switcher2.children("span").text("click to show");		
		}else{
			$comments_switcher2.children("span").text("click to hide");
		}
		$comments_holder2.slideToggle();
	});
	
	var $comments_switcher3 = $(".show-comments3");
	var $comments_holder3 = $(".comments-switcher3");
	
	$comments_switcher3.click(function(){
		if($comments_holder3.css("display") == "block"){
			$comments_switcher3.children("span").text("click to show");		
		}else{
			$comments_switcher3.children("span").text("click to hide");
		}
		$comments_holder3.slideToggle();
	});
	
	var $comments_switcher4 = $(".show-comments4");
	var $comments_holder4 = $(".comments-switcher4");
	
	$comments_switcher4.click(function(){
		if($comments_holder4.css("display") == "block"){
			$comments_switcher4.children("span").text("click to show");		
		}else{
			$comments_switcher4.children("span").text("click to hide");
		}
		$comments_holder4.slideToggle();
	});
	
	//for comment on suggestion
	var $comments_sugg_switcher1 = $(".show-sugg-comments1");
	var $comments_sugg_holder1 = $(".comments-sugg-switcher1");
	
	$comments_sugg_switcher1.click(function(){
		if($comments_sugg_holder1.css("display") == "block"){
			$comments_sugg_switcher1.children("span").text("click to show");		
		}else{
			$comments_sugg_switcher1.children("span").text("click to hide");
		}
		$comments_sugg_holder1.slideToggle();
	});
	
	var $comments_sugg_switcher2 = $(".show-sugg-comments2");
	var $comments_sugg_holder2 = $(".comments-sugg-switcher2");
	
	$comments_sugg_switcher2.click(function(){
		if($comments_sugg_holder2.css("display") == "block"){
			$comments_sugg_switcher2.children("span").text("click to show");		
		}else{
			$comments_sugg_switcher2.children("span").text("click to hide");
		}
		$comments_sugg_holder2.slideToggle();
	});
	
	var $comments_sugg_switcher3 = $(".show-sugg-comments3");
	var $comments_sugg_holder3 = $(".comments-sugg-switcher3");
	
	$comments_sugg_switcher3.click(function(){
		if($comments_sugg_holder3.css("display") == "block"){
			$comments_sugg_switcher3.children("span").text("click to show");		
		}else{
			$comments_sugg_switcher3.children("span").text("click to hide");
		}
		$comments_sugg_holder3.slideToggle();
	});
	
	var $comments_sugg_switcher4 = $(".show-sugg-comments4");
	var $comments_sugg_holder4 = $(".comments-sugg-switcher4");
	
	$comments_sugg_switcher4.click(function(){
		if($comments_sugg_holder4.css("display") == "block"){
			$comments_sugg_switcher4.children("span").text("click to show");		
		}else{
			$comments_sugg_switcher4.children("span").text("click to hide");
		}
		$comments_sugg_holder4.slideToggle();
	});
	
	var $comments_sugg_switcher5 = $(".show-sugg-comments5");
	var $comments_sugg_holder5 = $(".comments-sugg-switcher5");
	
	$comments_sugg_switcher5.click(function(){
		if($comments_sugg_holder5.css("display") == "block"){
			$comments_sugg_switcher5.children("span").text("click to show");		
		}else{
			$comments_sugg_switcher5.children("span").text("click to hide");
		}
		$comments_sugg_holder5.slideToggle();
	});
	
	

}); // close jquery
