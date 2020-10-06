function change(index){
    var previous=current
    current=index
    document.getElementById("title").innerHTML=brand[current].getAttribute("brand")
    document.getElementById("product").innerHTML=""
    document.getElementById(`brand${previous}`).className="nav-item"
    document.getElementById(`brand${current}`).className="nav-item active"
    var product=brand[current]
    var allProds=product.getElementsByTagName("productDetails")
    var count=allProds.length
    console.log(count)
    let i=0
    while(i<count){
        var cur=allProds[i]
        var tags=['refNo','name','color','price','xchngPrice']
        var n=tags.length
        let j=0
        var toins=""
        while(j<n){
            let temp=cur.getElementsByTagName(tags[j])[0].innerHTML
            if(temp==""){
                temp="Not Applicable"
            }
            toins=toins+`<td>${temp}</td>`
            j+=1
        }
        document.getElementById("product").insertAdjacentHTML("beforeend",`<tr>${toins}</tr>`)
        i+=1
    }
}

function first(){
var xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
    	console.log(this.status);
      var data=this.responseXML
      brand=data.getElementsByTagName("brandWise")
      var total=brand.length
      let i=0
      while(i<total){
          var cur=brand[i]
          var bname=cur.getAttribute("brand")
          if(i==0){
              document.getElementById("brands").insertAdjacentHTML("beforeend",`
              <li class="nav-item active" id="brand${i}">
              <button class="nav-link" onclick="change(${i})">${bname}</button>
             </li>`
              )
          }
          else{
            document.getElementById("brands").insertAdjacentHTML("beforeend",`
              <li class="nav-item" id="brand${i}">
              <button class="nav-link" onclick="change(${i})">${bname}</button>
             </li>`
              )
          }
          i+=1
      }
current=0
change(0)
    }
};
xhttp.open("GET", "stores.xml", true);
xhttp.send(); 
}


first()