function foo(){
  i = 0;
  while (i < 10000) {
     i = i + 1; 
  } 
  return i;
}

function main() { 
  i = 0;
  while (i < 10000) {
     foo();
     i = i + 1; 
  } 
  println(i);  
}  
