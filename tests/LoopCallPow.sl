function pow(a, b) {
  return a ^ b;
}

function loop(n) {
  i = 3;
  while (i < n) {  
    i = pow(i, 3);  
  }
  return i;
}

function main() {
  i = 0;
  while (i < 2000) {
    loop(1000000);
    i = i + 1;
  }
  println(loop(1000000));  
}
