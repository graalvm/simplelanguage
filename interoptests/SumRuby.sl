function loop(n) {
  add = import("add");
 
  i = 0;  
  sum = 0;  
  while (i <= n) {  
    sum = add(sum, i);  
    i = add(i, 1);  
  }  
  return sum;  
}  

function main() {
  eval("application/x-ruby", "def add(a, b) a + b; end;");
  eval("application/x-ruby", "Truffle::Interop.export_method(:add);");
 
  i = 0;
  while (i < 20) {
    loop(10000);
    i = i + 1;
  }
  println(loop(10000));  
}  
