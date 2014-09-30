function moreBeforeClick() {
	alert("Hello world");
	alert(getCookie('latestQuestionTime'));
	var result= {};
	result['type']="timestamp";
	result['number']=15;
	result['latestQuestionTime']=getCookie('latestQuestionTime');
	result['scroll']="after";
	alert(getCookie('latestQuestionTime'));
	
	jQuery.get( 
             "/qcorner/questions/timestamp",
			 result,
             function(data) {
				//console.log(data);
				alert("Girish");
				alert(JSON.stringify(data));
				var answers = new Array();
				for(var i=0;i<data.length;i++)
				{
					if(data[i].bestAnswer != null)
					{
					answers[i]=data[i].bestAnswer.string;
						alert(data[i]);
					}
					else
					{
						answers[i]="";
						alert("No answer");
					}
				}
				var answerString;
				//alert(data[0].question.bestAnswer);
				for (var j=9;j<19;j++)
				{
					$('#best_answer_' + j).after('<br><h4 class="entry-title"> <span class="title"><a href="single.html" id="question_' + (j+1) + '">'+data[j-9].question.string+'</a></span><span class="entry-commentsn"><a href="single.html#comments" title="Upvotes" class="poshytip">23</a></span><span class="entry-commentsq"><a href="single.html#comments" title="Downvotes" class="poshytip">23</a></span><span class="entry-commentsp"><a href="single.html#comments" title="Reported abuses: 23" class="poshytip">23</a></span></h4><div class="entry-excerpt" id="best_answer_'+(j+1)+'">'+answers[j-9]+'</div>');	
				}
				},
			 "json"
          );
	
}

function postQuestion() {
	var questionString = jQuery("textarea#questionString").val();
    //$("#tag_1").children("option").filter(":selected").text();
	var tag = new Array();
	var transferTag = new Array();
	
	transferTag[0]=$('#tag_1').val();
	transferTag[1]=$('#tag_2').val();
	transferTag[2]=$('#tag_3').val();
	
	
	for (var i=0;i<5;i++)
	{ 
		//alert($('#tag_'+(i+1)).val());
		tag[i]=$('#tag_'+(i+4)).val();
	}
	
	
	
	var count = 3;
	for (var j=0;j<5;j++)
	{ 
		if(!tag[j] || 0 === tag[j].length){ 
			;//alert(j + ' Skip!');
		}	
		else
		{
			transferTag[count++] = tag[j];
	//		alert(j + " First");
		}
	}
	
	alert(transferTag.length);
	alert(transferTag[0]);
		
		alert("Entering loop");
	
	for (var k=0;k<transferTag.length;k++)
	{ 
		//alert($('#tag_'+(i+1)).val());
		alert("Transfer Tag " + k + transferTag[k]);
	}
	
	
		
		
	var difficultyLevel = $('#difficultyLevel').val();
	alert(difficultyLevel);
	
	var dln;
	if(difficultyLevel === 'Very easy') {
		dln = 0;
	} else if (difficultyLevel === 'Easy') {
		dln = 1;
	} else if (difficultyLevel === 'Medium') {
		dln = 2;
	} else if (difficultyLevel === 'Hard') {
		dln = 3;
	} else if (difficultyLevel === 'Very hard') {
		dln = 4;
	} 
	
	var result= {};
	result['questionString']=questionString;
	result['tags']=transferTag;
	result['difficultyLevel']=dln;
	//result['scroll']="after";
	alert(JSON.stringify(result));
	
	$.post( 
             "/qcorner/question/post",
			 result,
             function(data) {
				console.log(data);
				//alert("Inside list");
				//alert(data.head.status + " I am in");
				alert(data);
				//alert(data.body[0].string);
				
				
			 },
			 "json"
	);
	
	
	
	
	
	
	/*
	if(tag_5 === "") {
		alert("Sahi mein");
	}*/
}

function editProfile() {
	window.location = 'editprofile.html';
}