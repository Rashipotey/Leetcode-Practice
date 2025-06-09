/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    newArray=new Array();
    for(let i=0;i<arr.length;i++){
        newArray[i]=fn(arr[i],i);
    }
    return newArray;
};