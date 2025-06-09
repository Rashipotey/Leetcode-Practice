/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
    newArray=new Array();
    for(let i=0;i<arr.length;i++){
        if(fn(arr[i],i)){
            newArray.push(arr[i]);
        }
    }
    return newArray;
};