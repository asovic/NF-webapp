document.getElementById("myBtn").addEventListener("click", showDD);
document.getElementById("myBtn-remove").addEventListener("click", removeDD);

var remove_button = document.getElementById("myBtn-remove");
var counter = 1;

function showDD() {
	var div = "dd" + counter.toString();
	var dd = document.getElementsByClassName(div);
   dd[0].style.display = "";
   dd[1].removeAttribute("disabled");
   dd[2].removeAttribute("disabled");
   counter++;
   if (remove_button.style.display == "none") {
	   remove_button.style.display = "";
   }
   
}

function removeDD() {
		var remove_counter = counter - 1;
		var div = "dd" + remove_counter.toString();
		var dd = document.getElementsByClassName(div);
		if (counter > 1) {
			dd[0].style.display = "none";
			dd[1].disabled = true;
			dd[2].disabled = true;
			counter--;
		}
		if (counter == 1) {
			remove_button.style.display = "none";
		}
}