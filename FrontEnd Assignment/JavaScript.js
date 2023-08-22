function clear(){   
    document.getElementById("tab1").reset();
 }
var list1 = [];
 var list2=[];
 var list3=[];
 var list4=[];
 var list5=[];
 var list6=[];
 var list7=[];
 var list8=[];

 var n=1;var x=0;
 function input(){
     var arow=document.getElementById("show");
     var nrow=arow.insertRow(n);

     var val='';
     if(document.getElementById('mk5').checked){
         val=document.getElementById('mk5').value
     }else if(document.getElementById('mk51').checked){
         val=document.getElementById('mk51').value
     }

     var box='';
     if(document.getElementById('mk5').checked){
         box=document.getElementById('mk5').value
     }else if(document.getElementById('mk51').checked){
         val=document.getElementById('mk51').value
     }

     var ele=[]
   var ele1 = document.getElementById("mk6")
   if(ele1.checked){
         ele.push(ele1.value);
  }
  var ele2 = document.getElementById("mk7")
   if(ele2.checked){
         ele.push(ele2.value);
  }
  var ele3 = document.getElementById("mk8")
   if(ele3.checked){
         ele.push(ele3.value);
  }

     list1[x]=document.getElementById("mk1").value;
     list2[x]=document.getElementById("mk2").value;
     list3[x]=document.getElementById("mk3").value;
     list4[x]=document.getElementById("mk4").value;
     list5[x]=val;
     list6[x]=ele;

     var cel1=nrow.insertCell(0);
     var cel2=nrow.insertCell(1);
     var cel3=nrow.insertCell(2);
     var cel4=nrow.insertCell(3);
     var cel5=nrow.insertCell(4);
     var cel6=nrow.insertCell(5);

     cel1.innerHTML=list1[x];
     cel2.innerHTML=list2[x];
     cel3.innerHTML=list3[x];
     cel4.innerHTML=list4[x];
     cel5.innerHTML=list5[x];
     cel6.innerHTML=list6[x];

     n++;
     x++;
 }
