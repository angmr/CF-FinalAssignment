$(document).ready(function() {
    $('#btn').on('click', function() {
        fetchDoctorsFromJSON($('#searchInput').val().trim())
    })
})

function fetchDoctorsFromJSON(lastname) {
    let xhr = new XMLHttpRequest()

    xhr.open('GET', `/doctors-mvn/doctors?lastname=${lastname}`, true)

    xhr.timeout = 5000
    xhr.ontimeout = (e) => onAPIError()

    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) 
        {
            if (xhr.status === 200) {
                handleResults(JSON.parse(xhr.responseText))
            } else {
                onAPIError()
            }
        }
    }
    
    xhr.send()
}


function handleResults(response) {
    let doctorsList = response;
   
    if (jQuery.isEmptyObject(response)) {
    	$(".doctors-list").html("No doctor was found");
    } else {   
	    let output = "<tr><th>Id</th><th>Όνομα</th><th>Επώνυμο</th></tr>";
	
	    for (let doctor of doctorsList) {
	        output += "<tr><td>"
	        + doctor.id
	        + "</td><td>"
	        + doctor.fname
	        + "</td><td>"
	        + doctor.sname
	        + "</td></tr>";
	    }
	
	    $(".doctors-list").html(output);
    }
}


function onAPIError() {
    alert('API Error')
}