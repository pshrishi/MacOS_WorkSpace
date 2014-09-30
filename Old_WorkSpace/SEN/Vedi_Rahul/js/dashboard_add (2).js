function moreAfterClick() {

/*
for (var i=9;i<19;i++)
	{ 
		$('#best_answer_' + i).after('<br><h4 class="entry-title"> <span class="title"><a href="single.html" id="question_' + (i+1) + '">This is the question.</a></span><span class="entry-commentsn"><a href="single.html#comments" title="Upvotes" class="poshytip">23</a></span><span class="entry-commentsq"><a href="single.html#comments" title="Downvotes" class="poshytip">23</a></span><span class="entry-commentsp"><a href="single.html#comments" title="Reported abuses: 23" class="poshytip">23</a></span></h4><div class="entry-excerpt" id="best_answer_'+(i+1)+'">I want Nitin Sachdeva to join Arsenal? How do you suppose we should go about that?</div><br>');	
	}
*/
	alert(getCookie('latestQuestionTime'));
	var result= {};
	result['type']="timestamp";
	result['number']=10;
	result['latestQuestionTime']=getCookie('latestQuestionTime');
	result['scroll']="after";
	alert(getCookie('latestQuestionTime'));
	
	$.get( 
             "http://54.249.240.120/qcorner/questions",
			 result,
             function(data) {
				alert(data);
             },
			 "json"

          );
	
}