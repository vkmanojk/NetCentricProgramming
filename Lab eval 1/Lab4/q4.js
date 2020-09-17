function input() {
	pop = prompt("Enter the count of values in the series", " ");
	console.log(pop);
 	var var1=0, var2=1;
 	fib = "Here is the fibonacci series : " +var1+" "+var2+" ";
	var counter, sum;
	for(counter=2; counter<pop; counter++) {
		sum=var1+var2;
		fib = fib + sum + " ";
		var1=var2;
		var2=sum;
	}
	document.getElementById("q4").innerHTML = fib;
}
