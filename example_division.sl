function test(previous, divideBy){
  i = 0;
  sum = 0;
  while (i < 1000000) {
    sum = (sum + i) / divideBy; 
    i = i + 1;
  } 
  return sum;
}

function main() { 
  iteration = 0;
  value = 0;
  while (iteration < 20) {
    time = nanoTime();
    value = test(value, 1);
    diff = (nanoTime() - time);
    iteration = iteration + 1;
    println("iteration: " + iteration + " time:" + (diff / 1000000) + "ms");
  }
}