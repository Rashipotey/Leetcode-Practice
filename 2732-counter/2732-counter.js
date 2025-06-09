/**
 * @param {number} n
 * @return {Function} counter
 */
var createCounter = function(n) {
    var counter=-1;
    return function() {
        return ++counter + n;
    };
};

/** 
 * const counter = createCounter(10)
 * counter() // 10
 * counter() // 11
 * counter() // 12
 */