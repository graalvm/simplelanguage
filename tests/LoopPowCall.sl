function pow(a, b) {
  return a ^ b;
}

function loop(n) {
  i = 2;
  while (i < n) {  
    i = pow(i, 2);  
  }
  return i;
}

function main() {
  i = 0;
  while (i < 200) {
    loop(100000);
    i = i + 1;
  }
  println(loop(100000));  
}
