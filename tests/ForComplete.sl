function e(a, b) {
  return a == b;
}

function main() {  
    for(j = 0;j < 10;j = j + 5)
    {
        println("This is a for");
        j = j + 1;
    }
    // j is still accessible outside outside for
    println(e(j, 40));
}  
