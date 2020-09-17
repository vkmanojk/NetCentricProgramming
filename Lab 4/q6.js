function simpl() {

    var p,r,t;
    p=parseFloat(prompt("Enter Principle Amount"));
    r=parseFloat(prompt("Enter Rate Amount"));
    t=parseFloat(prompt("Enter Time(year)"));
    var si=(p*r*t)/100;
    document.getElementById("q6").innerHTML = "Simple Interest (calculated anually) is: "+si;
}