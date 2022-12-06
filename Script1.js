
//var semente = 0

// Indica a execução da função poliglota R
var array = Polyglot.eval("R", "c(1,2,42,4)")
console.log()

// Verifica o resultado R
console.log("Resultado R -----> " + (array[2] + semente) );

console.log('---')

// Indica a execução da função poliglota Ruby
var array = Polyglot.eval("ruby", "[1,2,51,4]")

// Verifica o resultado R
console.log("Resultado Ruby --> " + (array[2] + semente) );
console.log()
