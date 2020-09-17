var color = [, "#3C9EE7", "#E7993C", "#E73C99", "#3CE746", "#E7993C"]; 
if(document.images) {
	var image1 = new Image();     
    image1.src = "klematis_big.jpg";
    var image2 = new Image();     
    image2.src = "klematis3_big.jpg";
}
document.querySelector("#q2").addEventListener(
	"mouseover", function () {
		document.querySelector("div").style.background = color[Math.floor(Math.random() * color.length)];
	}); 