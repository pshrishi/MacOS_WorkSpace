
$(document).ready(function(){  
var uName, pWord, eMail, secQ, secQA;
	  $("#login_button").click(function(event){
		uName = $('#login_username').val();
		pWord = $('#login_password').val();
		var result = {};
		result['userName']=uName;
		result['password']=pWord;
		$.post( 
             "../qcorner/login",
			 result,
             function(data) {
				if(data.head.status==200)
				{
				
					setCookie('username', uName, 1);
					alert("Success");
					console.log(data);
					window.location = 'dashboard.html';
					alert(data.body.affiliation);
					setCookie('affiliation', data.body.affiliation, 1);
					//setCookie('latestQuestionTime', data[9].question.timeStamp, 1);
					//setCookie('latestQuestionTime', data[9].question.timeStamp, 1);
				}
				else
					alert("Wrong username or password");
             },
			 "json"

          );
      });
	  $("#forgotp_un_button").click(function(event){
		uName = $('#forgotp_username').val();
		var result = {};
		result['username']=uName;
		$.post( 
             "http://54.249.240.120/qcorner/",
			 result,
             function(data) {
				/*if(data.head.status==200)
				{
					setCookie('username', uName, 1);
					window.location = 'file:///E:/Workspace/Vedi/login.html#torp';
				}
				else
					alert("Username doesn't exist!");*/
					alert(JSON.stringify(data));
             },
			 "json"

          );
	  });
	  $("#resetp_button").click(function(event){
		uName = getCookie("username");
		pWord = $('#newPassword').val();
		//secQuesID
		secQA = $('#securityQA').val();
		var result = {};
		result['username']=uName;
		result['password']=pWord;
		//"securityQuestionID":"",
		result['securityAnswer']=secQA;
		$.post( 
             "http://54.249.240.120/qcorner/",
			 result,
             function(data) {
				/*if(data.head.status==200)
				{
					window.location = 'file:///E:/Workspace/Vedi/dashboard.html';
				}
				else
					alert("Incorrect answer for the security question. Try again!");*/
					alert(JSON.stringify(data));
             },
			 "json"

          );
	  });
	  $("#forgotusername_button").click(function(event){
		eMail = $('#forgotusername_email').val();
		//secQuesID
		var result = {};
		result['email']=eMail;
		$.post( 
             "http://54.249.240.120/qcorner/",
			 result,
             function(data) {
				/*if(data.head.status==200)
				{
					alert("An email with the password reset link has been sent to you!");
					window.location = 'file:///E:/Workspace/Vedi/login.html';
				}
				else
					alert("There is no username associated with the email id. Try again!");*/
					alert(JSON.stringify(data));
             },
			 "json"

          );
	  });
	  $("#signup_button").click(function(event){
		var fName = $('#su_fname').val();
		var lName = $('#su_lname').val();
		var uName = $('#su_uname').val();
		var pWord = $('#su_pass').val();
		var eMail = $('#su_email').val();
		var phone = $('#su_phone').val();
		var dob = $('#su_dob').val();
		var gender = $('#su_gender').val();
		var intrsts = $('#su_intrst').val();
		var newIntrst = intrsts.split(",");
		var country = $('#su_country').val();
		var city = $('#su_city').val();
		var state = $('#su_state').val();
		var qual = $('#su_qual').val();
		var affili = $('#su_affili').val();
		var aoe = $('#su_aoe').val();
		var newAOE = aoe.split(",");
		var secQues = $('#su_secques').val();
		var secA = $('#su_secA').val();
		var rKey = $('#su_rkey').val();
		if(rKey==NULL)
			rKey = -1;
		var result = {};
		result['firstName']=fName;
		result['lastName']=lName;
		result['userName']=uName;
		result['password']=pWord;
		result['email']=eMail;
		result['phone']=phone;
		result['dob']=dob;
		result['gender']=gender;
		result['interest']=newIntrst;
		result['country']=country;
		result['city']=city;
		result['state']=state;
		result['qualification']=qual;
		result['affiliation']=affili;
		result['areasOfExpertise']=newAOE;
		result['securityQuestionID']=secQues;
		result['securityAnswer']=secA;
		result['reviewerKey']=rKey;
		$.post( 
             "http://54.249.240.120/qcorner/",
			 result,
             function(data) {
				/*if(data.head.status==200)
				{
					window.location = 'file:///E:/Workspace/Vedi/login.html';
				}
				else
					alert("There was some error. Please check your data and try again!");*/
					alert(JSON.stringify(data));
             },
			 "json"

          );
	  });
});