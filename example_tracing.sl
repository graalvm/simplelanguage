function test(previous){
  i = 0;
  sum = 0;
  while (i < 1000000) {
    sum = (sum + i); 
    i = i + 1;
  } 
  return sum;
}

function main() { 
  iteration = 0;
  value = 0;
  while (iteration < 20) {
    time = nanoTime();
    value = test(value);
    diff = (nanoTime() - time);
    iteration = iteration + 1;
    println("iteration: " + iteration + " time:" + (diff / 1000000) + "ms");
	if (iteration == 10) {
	  enableTracing();
	}
  }
}