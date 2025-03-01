/**
 * @return {null|boolean|number|string|Array|Object}
 */
Array.prototype.last = function() {
    console.log(this) // we can ascess array with this
    if(this.length){
        return this[this.length - 1];
    }
    return -1;
};

/**
 * const arr = [1, 2, 3];
 * arr.last(); // 3
 */