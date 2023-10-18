/**
 * All named functions will have the function keyword and
 * a name followed by parentheses.
 * 
 * @returns {number} 1
 */
function returnOne() {
  return 1;
}

// function f(x=1, y=1, z=1){
//   console.log(`${x} ${y} ${z}`);
// }

/**
 * Functions can also take parameters. These are just variables that are filled
 * in by whoever is calling the function.
 *
 * Also, we don't *have* to return anything from the actual function.
 *
 * @param {any} value the value to print to the console
 */
function printToConsole(value) {
  console.log(value);
}

/**
 * Write a function called multiplyTogether that multiplies two numbers together. But 
 * what happens if we don't pass a value in? What happens if the value is not a number?
 *
 * @param {number} firstParameter the first parameter to multiply
 * @param {number} secondParameter the second parameter to multiply
 */
function multiplyTogether(firstParameter, secondParameter){
  return firstParameter * secondParameter;
}

/**
 * This version makes sure that no parameters are ever missing. If
 * someone calls this function without parameters, we default the
 * values to 0. However, it is impossible in JavaScript to prevent
 * someone from calling this function with data that is not a number.
 * Call this function multiplyNoUndefined
 *
 * @param {number} [firstParameter=0] the first parameter to multiply
 * @param {number} [secondParameter=0] the second parameter to multiply
 */
 function multiplyNoUndefined(firstParameter=0, secondParameter=0){
  return firstParameter * secondParameter;
}

 
/**
 * Functions can return earlier before the end of the function. This could be useful
 * in circumstances where you may not need to perform additional instructions or have to
 * handle a particular situation.
 * In this example, if the firstParameter is equal to 0, we return secondParameter times 2.
 * Observe what's printed to the console in both situations.
 * 
 * @param {number} firstParameter the first parameter
 * @param {number} secondParameter the second parameter
 */
function returnBeforeEnd(firstParameter, secondParameter) {
  console.log("This will always fire.");

  if (firstParameter == 0) {
    console.log("Returning secondParameter times two.");
    return secondParameter * 2;
  }

  //this only runs if firstParameter is NOT 0
  console.log("Returning firstParameter + secondParameter.");
  return firstParameter + secondParameter;
}

/**
 * Scope is defined as where a variable is available to be used.
 *
 * If a variable is declare inside of a block, it will only exist in
 * that block and any block underneath it. Once the block that the
 * variable was defined in ends, the variable disappears.
 */
function scopeTest() {
  // This variable will always be in scope in this function
  let inScopeInScopeTest = true;

  {
    // this variable lives inside this block and doesn't
    // exist outside of the block
    let scopedToBlock = inScopeInScopeTest;
  }

  // scopedToBlock doesn't exist here so an error will be thrown
  if (inScopeInScopeTest && scopedToBlock) {
    console.log("This won't print!");
  }
}

function createSentenceFromUser(name, age, listOfQuirks = [], separator = ', ') {
  let description = `${name} is currently ${age} years old. Their quirks are: `;
  return description + listOfQuirks.join(separator);
}

/**
 * 
 * @param  {...any} values 
 */
function add(a, b, ...values){
  console.log(a);
  console.log(a);
  console.table(values);
}

function arrayCompare(){
  arr1 = [1, 2, 3];
  arr2 = [1, 2, 3];
  arr3 = ['1', '2', '3'];

  console.log(`arr1 ==  arr2 is: ${arr1 == arr2}`);
  console.log(`arr1 === arr2 is: ${arr1 === arr2}`);
  console.log(`arr1 ==  arr3 is: ${arr1 == arr3}`);
  console.log(`arr1 === arr3 is: ${arr1 === arr3}`);
}

function iterateOverArray(arr){

  const callbackFn = function(eachElement){

    // No return statement for a callbackFn used in forEach()
    console.log('The element is: ' + eachElement);
  };

  // Method 1: Using a callbackFn variable
  arr.forEach( callbackFn );

  // Method 2: Using an arrow function
  arr.forEach( (eachElement) => {
    console.log('ARROW The element is: ' + eachElement);
  });
}

function removeAllNegativeNumbers(arr){

  const callbackFn = function(eachElement){

    // Must return truthy or falsy to be used by filter()
    if(eachElement > 0){
      return true;
    }
    return false;

    // Shorthand version of above
    //return eachElement > 0;
  }

  // Method 1: Using a callbackFn variable
  //const arrPositiveNumbers = arr.filter( callbackFn );

  // Method 2: Using arrow function
  const arrPositiveNumbers = arr.filter( (eachElement) =>{
    return eachElement > 0;
  });

  console.table(arrPositiveNumbers);
  console.table(arr);
}

function makeNiceRequests(arr){

  // Assign callback function to callbackFn variable
  const callbackFn = function(eachElement){

    // Need to return the new, transformed element to be used in map()
    return `${eachElement}, please.`;
  }

  // Method 1: Using a callbackFn variable
  //const politeRequests = arr.map( callbackFn );

  // Method 2: Using arrow function
  const politeRequests = arr.map( (eachElement) => {

    // Need to return the new, transformed element
    return `${eachElement}, please.`;
  });

  console.table(politeRequests);
}


/**
 * Takes an array and, using the power of anonymous functions,
 * generates their sum.
 *
 * @param {number[]} numbersToSum numbers to add up
 * @returns {number} sum of all the numbers
 */
function sumAllNumbers(numbersToSum) {

  // Assign callback function to callbackFn variable
  const callbackFn = function(runningTotal, eachElement){

    console.log(`runningTotal: ${runningTotal}; eachElement: ${eachElement}`);

    // Function must return a single value to be used in .reduce()
    return runningTotal + eachElement;
  }

  // Method 1: Using a callbackFn variable
  //return numbersToSum.reduce( callbackFn, 0 );

  // Method 2: Using an arrow function
  return numbersToSum.reduce( (runningTotal, eachElement) => {
    return runningTotal + eachElement;
  }, 0);
}

/**
 * Takes an array and returns a new array of only numbers that are
 * multiples of 3
 *
 * @param {number[]} numbersToFilter numbers to filter through
 * @returns {number[]} a new array with only those numbers that are
 *   multiples of 3
 */
function allDivisibleByThree(numbersToFilter) {}
