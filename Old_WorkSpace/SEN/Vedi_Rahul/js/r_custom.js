// Custom jquery without conflict
$.noConflict();
jQuery(document).ready(function($){

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

	var $comments_switcher = $(".show-comments");
	var $comments_holder = $(".comments-switcher");
	
	$comments_switcher.click(function(){
		if($comments_holder.css("display") == "block"){
			$comments_switcher.children("span").text("click to show");		
		}else{
			$comments_switcher.children("span").text("click to hide");
		}
		$comments_holder.slideToggle();
	});

	

	alert("Here");
	var result= {};
	result['type']="timestamp";
	result['number']=10;
	result['latestQuestionTime']=-1;
	result['scroll']="after";
	$.get( 
             "/qcorner/questions",
			 result,
             function(data) {
				document.getElementById('questions_world').innerHTML="<strong>Questions for the world</strong>";
				console.log(data);
				for (var i=0;i<10;i++)
				{ 
					
					document.getElementById('question_' + i).innerHTML=data[i].question.string;
					
					if(data[i].bestAnswer == null)
						document.getElementById('best_answer_' + i).innerHTML="Answer not available.";
					else
						document.getElementById('best_answer_' + i).innerHTML=data[i].bestAnswer.string;
					
					//alert(i);
				}
				//alert(data[9].question.timeStamp);
				setCookie('latestQuestionTime', data[0].question.timeStamp, 1);
				setCookie('latestQuestionTime', data[9].question.timeStamp, 1);
			 },
			 "json"
	);
	//alert(data[9].question.timeStamp);
	//alert(getCookie('latestQuestionTime'));
	$.get( 
             "/qcorner/list/favourite/timestamp",
             function(data) {
				console.log(data);
				alert("Inside list");
				alert(data.head.status + " I am in");
				alert(data.body.length);
				alert(data.body[0].string);
				
				if(data.body.length != 0)
				{
					document.getElementById('favorite_0').innerHTML=data.body[0].string;
					for (var i=1;i<data.body.length;i++)
					{ 
						jQuery('#fav_list').append('<li><a href="#" id="favorite_'+(i)+'">'+data.body[i].string+'</a></li>');
					}
				}
				else
				{
						;//jQuery('#fav_list').append('<li><p id="favorite_default">No questions available</p></li>');
				}
			 },
			 "json"
	);




$.get( 
             "/qcorner/notifications",
             function(data) {
				console.log(data);
				alert(data);
				document.getElementById('notif_number').innerHTML=data.body.length;
				//alert("Notifications");
				//alert(data.head.status + " I am in");
				//alert(data.body.length);
				//alert(data.body[0].string);
				if(data.body.length != 0)
				{
					document.getElementById('notif_0').innerHTML=data.body[0].string;
					for (var i=1;i<data.body.length;i++)
					{ 
						jQuery('#notifications').append('<li><a href="#"><span class="notifon" id="notif_'+(i)+'">'+data.body[i].string+'</span></a></li>');
					}
				}
				else
				{
						;//jQuery('#fav_list').append('<li><p id="favorite_default">No questions available</p></li>');
				}
				
			 },
			 "json"
	);



$.get( 
             "/qcorner/list/subscriptionList",
             function(data) {
				console.log(data);
				alert("Inside subscriptions " + data.body[0]);
				if(data.body.length!=0)
				{	
					document.getElementById('subtag_0').innerHTML=data.body[0];
					
					for (var i=1;i<data.body.length;i++)
					{ 
						//jQuery('#notifications').append('<li><a href="#" id="notif_'+(i)+'">'+data.body[i]+'</a></li>');
						jQuery('#sub_list').append('<li><a href="#" id="subtag_'+i+'">'+ data.body[i] +'</a></li>');	
					}
				}
				
				//alert(data.head.status + " I am in");
				//alert(data.body.length);
				//alert(data.body[0].string);
				
				
			 },
			 "json"
	);



$.get( 
             "/qcorner/list/myContributions",
             function(data) {
				console.log(data);
				//alert("Inside contributions " + data.body[0]);
				if(data.body.length!=0)
				{	
					document.getElementById('contributed_0').innerHTML=data.body[0].string;
					
					for (var i=1;i<data.body.length;i++)
					{ 
						//jQuery('#notifications').append('<li><a href="#" id="notif_'+(i)+'">'+data.body[i]+'</a></li>');
						jQuery('#contributed').append('<li><a href="#" id="contributed_'+i+'">'+ data.body[i].string +'</a></li>');	
					}
				}
				
				//alert(data.head.status + " I am in");
				//alert(data.body.length);
				//alert(data.body[0].string);
				
				
			 },
			 "json"
	);


	$.get( 
             "/qcorner/list/myQuestions",
             function(data) {
				console.log(data);
				//alert("Inside contributions " + data.body[0]);
				if(data.body.length!=0)
				{	
					document.getElementById('myquestions_0').innerHTML=data.body[0].string;
					
					for (var i=1;i<data.body.length;i++)
					{ 
						//jQuery('#notifications').append('<li><a href="#" id="notif_'+(i)+'">'+data.body[i]+'</a></li>');
						jQuery('#myquestions').append('<li><a href="#" id="myquestions_'+i+'">'+ data.body[i].string +'</a></li>');	
					}
				}
				
				//alert(data.head.status + " I am in");
				//alert(data.body.length);
				//alert(data.body[0].string);
				
				
			 },
			 "json"
	);


	
	
	$.get( 
             "/qcorner/list/watchLater/timestamp",
             function(data) {
				console.log(data);
				alert("Inside list");
				alert(data.head.status + " I am in");
				alert(data.body.length);
				alert(data.body[0].string);
				
				if(data.body.length != 0)
				{
					document.getElementById('wl_0').innerHTML=data.body[0].string;
					for (var i=1;i<data.body.length;i++)
					{ 
						jQuery('#wl_list').append('<li><a href="#" id="wl_'+(i)+'">'+data.body[i].string+'</a></li>');
					}
				}
				else
				{
						;//jQuery('#fav_list').append('<li><p id="favorite_default">No questions available</p></li>');
				}
			 },
			 "json"
	);
	
	
	$.get( 
             "/qcorner/list/history/timestamp",
             function(data) {
				console.log(data);
				alert("Inside list");
				alert(data.head.status + " I am in");
				alert(data.body.length);
				alert(data.body[0].string);
				
				if(data.body.length != 0)
				{
					document.getElementById('history_0').innerHTML=data.body[0].string;
					for (var i=1;i<data.body.length;i++)
					{ 
						jQuery('#view_history').append('<li><a href="#" id="history_'+(i)+'">'+data.body[i].string+'</a></li>');
					}
				}
				else
				{
						;//jQuery('#fav_list').append('<li><p id="favorite_default">No questions available</p></li>');
				}
			 },
			 "json"
	);

	var firstName=getCookie('firstName');
	var lastName=getCookie('lastName');
	var affiliation=getCookie('affiliation');
	var city=getCookie('city');
	var reputation=getCookie('reputation');
	
	document.getElementById('firstName_lastName').innerHTML=firstName+lastName;
	document.getElementById('city').innerHTML=city;
	document.getElementById('affiliation').innerHTML=affiliation;
	document.getElementById('reputation').innerHTML="Reputation: " + reputation;
					

}); // close jquery

// create HTML 5 elements
document.createElement("article");
document.createElement("footer");
document.createElement("header");
document.createElement("hgroup");
document.createElement("nav");

// search clearance	

function defaultInput(target, string){
	if((target).value == string){(target).value=''}
}

function clearInput(target, string){
	if((target).value == ''){(target).value=string}
}

