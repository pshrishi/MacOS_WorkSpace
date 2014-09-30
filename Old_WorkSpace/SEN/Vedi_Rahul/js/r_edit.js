function edit_button_click() {
	alert("Helllllll");
	var firstName = document.getElementById('fname').value;
	var lastName = document.getElementById('lname').value;
	var email = document.getElementById('email').value;
	var phone = document.getElementById('phone').value;
	var dob = document.getElementById('dob').value;
	var gender = document.getElementById('gender').value;
	
	var interests = document.getElementById('interest').value;
	var country	= document.getElementById('country').value;
	var city = 	document.getElementById('city').value;
	var state = document.getElementById('state').value;
	var qualification = document.getElementById('quali').value;
	var affiliation = document.getElementById('affili').value;
	var aoe = document.getElementById('aoe').value;
	var secQ = document.getElementById('scope').value;
	var sa = document.getElementById('sa').value;
	
	
	var result = {};
	result['firstName']=firstName;
	result['lastName']=lastName;
	result['email']=email;
	result['phone']=phone;
	result['DOB']=dob;
	result['gender']=gender;
	result['affiliation']=affiliation;
	result['areasOfExpertise']=aoe;
	result['country']=country;
	result['state']=state;
	result['city']=city;
	result['interests']=interests;
	result['qualification']=qualification;
	result['securityQuestionID']=secQ;
	result['securityAnswer']=sa;
	
	alert(JSON.stringify(result));
		jQuery.post( 
			"/qcorner/modifydetail",
			result,
			function(data) {
				alert(JSON.stringify(data));
				if(data.head.status == 200) 
					alert("User details successfully updated");
					//console.log(data);
					//alert(data);
				},
			"json"
		);
				
				
	//e.preventDefault();
				
}