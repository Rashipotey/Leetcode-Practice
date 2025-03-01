/**
 * @param {string} val
 * @return {Object}
 */
var expect = function(val) {
    return {
        toBe: function(otherVal) {
            if (val === otherVal) return true;
            else throw new Error("Not Equal");
        },
        notToBe: function(otherVal) {
            if (val !== otherVal) return true;
            else throw new Error("Equal");
        }
    };
};

/**
 * expect(5).toBe(5); // true
 * expect(5).notToBe(5); // throws "Equal"
 */