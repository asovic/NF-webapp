document.getElementById("submit").addEventListener("click", getSelect);

function getSelect(event) {

    var obj = {
            bottle: []
        };

    for (var i = 0; i < document.getElementById("form").elements.length-2; i=i+2) {
    	if (!document.getElementById("form").elements[i].disabled) {
            var aromaName = document.getElementById("form").elements[i].name;
            var aromaValue = document.getElementById("form").elements[i].value;
            var nicName = document.getElementById("form").elements[i+1].name;
            var nicValue = document.getElementById("form").elements[i+1].value;
            
            var aroma = new Object();
            var nic = new Object();
            
            aroma[aromaName] = aromaValue;
            nic[nicName] = nicValue;
            
            var combined = { ...aroma, ...nic };
            obj.bottle.push(combined);
    	}
    }
    
    event.preventDefault();
    var json = JSON.stringify(obj);
	console.log(json);
	
	var xhr = new XMLHttpRequest();
    xhr.open("POST", "/order/");
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(json);
    window.location.href = "/order";
}