var inputArray = [];
var size = 5; 
function inp() {
	for(var i=0; i<size; i++) {
		inputArray[i] = prompt('Enter name ' + (i+1));
	}
	for(var i=0; i<size; i++) {
		document.getElementById("q5").innerHTML = inputArray;
	}
}
function sort() {
	inputArray.sort();
	document.getElementById("q5").innerHTML = inputArray;
}